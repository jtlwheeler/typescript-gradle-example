import com.moowork.gradle.node.yarn.YarnTask

plugins {
    id("com.github.node-gradle.node")
}

tasks {
    register<Delete>("clean") {
        delete("build", "node_modules")
    }

    val javascriptRuntime = arrayOf(
            fileTree("node_modules"),
            "package.json",
            "tsconfig.json",
            "yarn.lock")

    register<YarnTask>("build") {
        dependsOn("yarn", "copyClientToServer")

        inputs.files(javascriptRuntime)
        inputs.dir("src")
        outputs.dir("dist")

        args = listOf("run", "build")
    }

    register<YarnTask>("testServer") {
        dependsOn("yarn")

        inputs.files(javascriptRuntime)
        inputs.dir("src")
        outputs.dir("dist")

        args = listOf("run", "test")
    }

    register("test") {
        dependsOn("testServer")
    }

    register("check") {
        dependsOn("test")
    }

    register<YarnTask>("startServer") {
        dependsOn("yarn", "build")

        inputs.files(javascriptRuntime)
        inputs.dir("src")
        outputs.dir("dist")
        outputs.upToDateWhen { false }

        args = listOf("run", "startServerDaemon")
    }

    register<YarnTask>("stopServer") {
        dependsOn("yarn")

        inputs.files(javascriptRuntime)
        inputs.dir("src")
        outputs.dir("dist")
        outputs.upToDateWhen { false }
        mustRunAfter(":e2e:e2e")

        args = listOf("run", "stopServerDaemon")
    }

    register<Copy>("copyClientToServer") {
        dependsOn(":client:build")

        from("../client/build")
        into("dist/assets")
        outputs.upToDateWhen { false }
    }
}


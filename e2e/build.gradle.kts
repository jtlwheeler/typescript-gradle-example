import com.moowork.gradle.node.yarn.YarnTask

plugins {
    id("com.github.node-gradle.node")
}

node {
    version = "10.15.0"
    yarnVersion = "1.13.0"
    download = true
}

tasks {
    register<Delete>("clean") {
        delete("build", "node_modules")
    }

    val javascriptRuntime = arrayOf(
            fileTree("node_modules"),
            "package.json",
            "yarn.lock")

    register<YarnTask>("e2e") {
        dependsOn("yarn", ":server:startServer")

        inputs.files(javascriptRuntime)
        inputs.dir("src")

        args = listOf("run", "e2e")

        finalizedBy(":server:stopServer")
    }
}
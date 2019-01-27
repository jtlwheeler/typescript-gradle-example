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
            "yarn.lock")

    register<YarnTask>("e2e") {
        dependsOn("yarn", ":server:startServer")

        inputs.files(javascriptRuntime)
        inputs.dir("src")

        args = listOf("run", "e2e")

        finalizedBy(":server:stopServer")
    }
}
plugins {
    id("com.github.node-gradle.node") version "1.3.0"
}

apply {
    plugin("com.github.node-gradle.node")
}

node {
    version = "10.15.0"
    npmVersion = "6.1.0"
    yarnVersion = "1.13.0"
    download = true
}
plugins {
    id("io.papermc.paperweight.userdev") version "1.3.9-SNAPSHOT"
    id("xyz.jpenilla.run-paper") version "1.0.6"
    id("java")
}

group = "me.obsilabor"
version = "1.0.1+mc.1.19.2"

dependencies {
    paperDevBundle("1.19.2-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
}
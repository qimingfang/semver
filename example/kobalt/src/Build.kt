import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.NumberFormatException
import java.util.Properties

import com.beust.kobalt.*
import com.beust.kobalt.api.annotation.Task
import com.beust.kobalt.api.Project
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.apt.*
import com.beust.kobalt.plugin.java.*
import com.beust.kobalt.plugin.packaging.*

val repos = repos()

val p = project {

    name = "example"

    fun getVersion(isIncrement: Boolean = false): String {
        val propsFile = "version.properties"
        val majorKey = "version.major"
        val minorKey = "version.minor"
        val patchKey = "version.patch"
        val metaKey = "version.buildmeta"
        val preKey = "version.prerelease"

        val p = Properties().apply {
            FileInputStream(propsFile).use { fis -> load(fis) }
        }

        val metadata = StringBuilder(p.getProperty(metaKey, ""))
        if (metadata.length > 0) {
            metadata.insert(0, '-');
        }
        val prerelease = StringBuilder(p.getProperty(preKey, ""))
        if (prerelease.length > 0) {
            prerelease.insert(0, "+");
        }

        return (p.getProperty(majorKey, "1") + "." + p.getProperty(minorKey, "0") + "." + p.getProperty(patchKey, "0") + prerelease + metadata)
    }

    version = getVersion()

    val mainClassName = "net.thauvin.erik.semver.example.Example"
    val processorJar = "net.thauvin.erik:semver:0.9.5-beta"

    sourceDirectories {
        path("src/main/java")
    }

    sourceDirectoriesTest {
        path("src/test/java")
    }

    dependencies {
        apt(processorJar)
        compile(processorJar)
    }

    dependenciesTest {

    }

    assemble {
        jar {
            manifest {
                attributes("Main-Class", mainClassName)
            }
        }
    }

    application {
        mainClass = mainClassName
    }
}
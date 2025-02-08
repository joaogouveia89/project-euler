import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

plugins {
    kotlin("jvm") version "1.7.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        showStandardStreams = true
        exceptionFormat = TestExceptionFormat.FULL
        events("skipped", "failed", "passed")
    }

    addTestListener(object : TestListener {
        override fun beforeTest(p0: TestDescriptor?) = Unit
        override fun beforeSuite(p0: TestDescriptor?) = Unit
        override fun afterTest(desc: TestDescriptor, result: TestResult){
            if(result.resultType == TestResult.ResultType.SUCCESS){
                println("${desc.className} elapsed ${result.endTime - result.startTime} ms")
            }
        }
        override fun afterSuite(desc: TestDescriptor, result: TestResult) = Unit
    })
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.register("updateReadme") {
    group = "custom"
    description = "Updates the README.md file with the latest test execution times."

    doLast {
        val lineRegex = Regex("^(problems\\.|helpers\\.)")
        val srcsPath = "src/main/kotlin"
        val solutions = mutableListOf<Solution>()

        // Executa os testes e captura a saída
        val testsOutput = ByteArrayOutputStream().use { testsOutputStream ->
            project.exec {
                commandLine("./gradlew", "clean", "test", "-i")
                standardOutput = testsOutputStream
            }
            testsOutputStream.toString().trim()
        }.split("\n")
            .filter { lineRegex.containsMatchIn(it) }


        // Lista os arquivos de solução
        val files = File(srcsPath).listFiles { file -> file.extension == "kt" }?.map { it.path }
        files?. forEach { file ->
            val gitOutput = ByteArrayOutputStream().use { gitOutputStream ->
                project.exec {
                    commandLine("git", "log", "-1", "--format=%cd", file)
                    standardOutput = gitOutputStream
                }
                gitOutputStream.toString().trim()
            }
            val fileName = file.split("/").last().let { it.substring(0, it.length - 3) }

            val date = SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy Z", Locale.ENGLISH).parse(gitOutput)
            val elapsedTime = testsOutput.find { it.contains(fileName) }?.split(" ")?.get(2) ?: "N/A"
            val humanizedName = fileName.split(Regex("(?=\\p{Upper})")).joinToString(" ").trim()

            solutions.add(Solution(humanizedName, file, date, elapsedTime))
        }
        val sortedSolutions = solutions.sortedBy { it.file }
        val lastSolution = solutions.maxByOrNull { it.solutionDate }

//
//        files?.forEach { file ->

//            }.output.toString().trim()
//            val date = SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy Z", Locale.ENGLISH).parse(gitResult)
//            val elapsedTime = testResults.find { it.contains(fileName) }?.split(" ")?.get(2) ?: "N/A"
//            solutions.add(Solution(fileName, file.absolutePath, date, elapsedTime))
//        }
//
//        // Ordena as soluções
//        val sortedSolutions = solutions.sortedBy { it.file }
//
        // Gera o conteúdo do README.md
        val readmeContent = buildString {
            appendLine("# [Project Euler](https://projecteuler.net) Solutions in Kotlin\n")
            appendLine("## Description:")
            appendLine("### My solutions for the problems proposed in the platform, Kotlin programming language, object-oriented approach, and Coroutines for parallel tasks\n")
            appendLine("## Goal:")
            appendLine("### Explore Kotlin and algorithms solving skills\n")
            appendLine("## Compile & Run")
            appendLine("- Open IntelliJ IDEA")
            appendLine("- On Project window, expand src folder")
            appendLine("- Right click on test folder")
            appendLine("- Click on Run\n")
            appendLine("## Last Solution: [${lastSolution?.name}](${lastSolution?.file})\n")
            appendLine("### Solved problems (Alphabetical order):\n")
            appendLine("> The times below were reached on a PC with the settings: <br/>")
            appendLine("> Processor model: ${System.getProperty("os.arch")} <br/>")
            appendLine("> Number of cores: ${Runtime.getRuntime().availableProcessors()} <br/>")
            appendLine("> RAM: ${Runtime.getRuntime().maxMemory() / 1024 / 1024} MB <br/>\n")
            appendLine("Problem | Last update | Last execution time")
            appendLine("--- | --- | ---")
            sortedSolutions.forEach { solution ->
                appendLine("[${solution.name}](${solution.file}) | ${SimpleDateFormat("yyyy, MMM dd").format(solution.solutionDate)} | ${solution.elapsedTime} ms")
            }
        }
//
//        // Escreve o conteúdo no README.md
            File("README.md").writeText(readmeContent)
    }
}

data class Solution(
    val name: String,
    val file: String,
    val solutionDate: Date,
    val elapsedTime: String
)
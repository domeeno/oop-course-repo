package oop.practice

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    // Initialize ObjectMapper with Scala module registered
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    // Load the input file (ensure the path is correct for your setup)
    val inputFile = new File("src/main/resources/test-input.json")

    // Read the JSON data
    val rootNode: JsonNode = mapper.readTree(inputFile)
    val data = rootNode.get("data")  // Assuming "data" is a JSON array

    // Define Universes
    val starWars = Universe("Star Wars", ListBuffer.empty[JsonNode])
    val hitchhikers = Universe("Hitchhiker", ListBuffer.empty[JsonNode])
    val marvel = Universe("Marvel", ListBuffer.empty[JsonNode])
    val rings = Universe("Rings", ListBuffer.empty[JsonNode])

    // Ensure data is iterable
    if (data.isArray) {
      for (entry <- data.elements().asScala) {  // Convert iterator to Scala
        println(entry.toString)
        val userInput = StdIn.readLine("Choose a universe (1=Star Wars, 2=Hitchhiker, 3=Marvel, 4=Rings): ")

        userInput match {
          case "1" => starWars.individuals += entry
          case "2" => hitchhikers.individuals += entry
          case "3" => marvel.individuals += entry
          case "4" => rings.individuals += entry
          case _   => println("Invalid input, please try again.")
        }
      }
    } else {
      println("Expected an array for 'data', but got a different JSON structure.")
    }

    // Ensure output directory exists
    val outputDir = new File("src/main/resources/output")
    if (!outputDir.exists()) {
      outputDir.mkdirs()  // Create the output directory if it doesn't exist
    }

    // Write each Universe instance to separate files
    mapper.writeValue(new File(outputDir, "starwars.json"), starWars)
    mapper.writeValue(new File(outputDir, "hitchhiker.json"), hitchhikers)
    mapper.writeValue(new File(outputDir, "rings.json"), rings)
    mapper.writeValue(new File(outputDir, "marvel.json"), marvel)
  }
}

case class Universe(
                     name: String,
                     individuals: ListBuffer[JsonNode]
                   )

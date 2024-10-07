package oop.practice

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

fun main() {
  val objectMapper = ObjectMapper()
  val input = objectMapper.readTree(File("src/main/resources/test-input.json"))
  val data = input["data"]

  val starWars = mutableListOf<String>()
  val hitchHicker = mutableListOf<String>()
  val rings = mutableListOf<String>()
  val marvel = mutableListOf<String>()

  data.forEach {
    val node = it.toString()
    println(node)

    when (readlnOrNull()) {
      "1" -> starWars.add(node)
      "2" -> hitchHicker.add(node)
      "3" -> rings.add(node)
      "4" -> marvel.add(node)
    }
  }

  File("src/main/resources/output/starwars.json").writeText(objectMapper.writeValueAsString(starWars))
  File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writeValueAsString(hitchHicker))
  File("src/main/resources/output/rings.json").writeText(objectMapper.writeValueAsString(rings))
  File("src/main/resources/output/marvel").writeText(objectMapper.writeValueAsString(starWars))
}

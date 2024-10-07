package oop.practice

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

fun main() {
  val objectMapper = ObjectMapper()
  val input = objectMapper.readTree(File("src/main/resources/test-input.json"))
  val data = input["data"]

  val starWars = mutableListOf<String>()
  val hitchHiker = mutableListOf<String>()
  val rings = mutableListOf<String>()
  val marvel = mutableListOf<String>()

  data.forEach {
    val node = it
    println(node)

    when (readlnOrNull()) {
      "1" -> starWars.add(node.asText())
      "2" -> hitchHiker.add(node.asText())
      "3" -> rings.add(node.asText())
      "4" -> marvel.add(node.asText())
    }
  }

  File("src/main/resources/output/starwars.json").writeText(objectMapper.writeValueAsString(starWars))
  File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writeValueAsString(hitchHiker))
  File("src/main/resources/output/rings.json").writeText(objectMapper.writeValueAsString(rings))
  File("src/main/resources/output/marvel.json").writeText(objectMapper.writeValueAsString(starWars))
}

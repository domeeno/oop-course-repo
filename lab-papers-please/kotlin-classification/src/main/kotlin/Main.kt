package oop.practice

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.io.File

fun main() {
  val objectMapper = ObjectMapper()
  val input = objectMapper.readTree(File("src/main/resources/test-input.json"))
  val data = input["data"]

  val starWars = Universe("starwars", mutableListOf())
  val hitchHiker = Universe("hitchHiker", mutableListOf())
  val rings = Universe("rings", mutableListOf())
  val marvel = Universe("marvel", mutableListOf())

  data.forEach {
    val node = it
    println(node)

    when (readlnOrNull()) {
      "1" -> starWars.individuals.add(node)
      "2" -> hitchHiker.individuals.add(node)
      "3" -> rings.individuals.add(node)
      "4" -> marvel.individuals.add(node)
    }
  }

  File("src/main/resources/output/starwars.json").writeText(objectMapper.writeValueAsString(starWars))
  File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writeValueAsString(hitchHiker))
  File("src/main/resources/output/rings.json").writeText(objectMapper.writeValueAsString(rings))
  File("src/main/resources/output/marvel.json").writeText(objectMapper.writeValueAsString(starWars))
}

data class Universe(
  val name: String,
  val individuals: MutableList<JsonNode>
)

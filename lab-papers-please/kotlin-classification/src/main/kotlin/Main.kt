package oop.practice

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

fun main() {
  val objectMapper = jacksonObjectMapper()
  val input: UniverseWithIndividuals =
    objectMapper.readValue(File("src/main/resources/test-input.json"), UniverseWithIndividuals::class.java)

  val starWars = Universe("starWars", mutableListOf())
  val hitchHiker = Universe("hitchHiker", mutableListOf())
  val rings = Universe("rings", mutableListOf())
  val marvel = Universe("marvel", mutableListOf())

  input.data.forEach {
    println(it)
    when (readlnOrNull()) {
      "1" -> starWars.individuals.add(it)
      "2" -> hitchHiker.individuals.add(it)
      "3" -> rings.individuals.add(it)
      "4" -> marvel.individuals.add(it)
    }
  }

  File("src/main/resources/output/starwars.json").writeText(objectMapper.writeValueAsString(starWars))
  File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writeValueAsString(hitchHiker))
  File("src/main/resources/output/rings.json").writeText(objectMapper.writeValueAsString(rings))
  File("src/main/resources/output/marvel.json").writeText(objectMapper.writeValueAsString(marvel))
}

data class Universe(
  val name: String,
  val individuals: MutableList<Individual>
)

data class Individual(
  val id: String,
  val planet: String? = null,
  val traits: List<String>? = null,
  val age: Int? = null,
  val isHumanoid: Boolean? = null,
)

data class UniverseWithIndividuals(
  val data: List<Individual>,
)

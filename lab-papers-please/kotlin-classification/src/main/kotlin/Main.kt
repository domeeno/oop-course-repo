package oop.practice

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

fun main() {
  val objectMapper = jacksonObjectMapper()
  val input = objectMapper.readTree(File("src/main/resources/test-input.json"))
  val data = input["data"]

  val universes = buildList {
    add(Universe("starWars", mutableListOf()))
    add(Universe("hitchHiker", mutableListOf()))
    add(Universe("rings", mutableListOf()))
    add(Universe("marvel", mutableListOf()))
  }

  universes.forEachIndexed(::printUniverse)

  data.forEach { node ->
    println(node)
    when (readlnOrNull()) {
      "1" -> universes[0].individuals.add(node)
      "2" -> universes[1].individuals.add(node)
      "3" -> universes[2].individuals.add(node)
      "4" -> universes[3].individuals.add(node)
    }
  }

  universes.forEach { universe ->
    universeToFileOutput(universe, objectMapper)
  }
}

fun printUniverse(index: Int, universe: Universe) {
  println("${1 + index}: ${universe.name}")
}

fun universeToFileOutput(universe: Universe, objectMapper: ObjectMapper) =
  File("src/main/resources/output/${universe.name}.json")
    .writeText(objectMapper.writeValueAsString(universe))

data class Universe(
  val name: String,
  val individuals: MutableList<JsonNode>
)

package oop.practice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Individual(
    @JsonProperty("id") int id,
    @JsonProperty("isHumanoid") Boolean isHumanoid,
    @JsonProperty("planet") Planet planet,
    @JsonProperty("age") Integer age,
    @JsonProperty("traits") List<AlienTraits> traits
) {
}

enum AlienTraits {
  TALL,
  HAIRY,
  BLONDE
}

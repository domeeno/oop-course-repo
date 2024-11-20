package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import oop.practice.entity.FileOperations;
import oop.practice.entity.IndividualInput;
import oop.practice.entity.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ClassifierTest {

  private String indivudalJsons = """
      
{
  "data": [
    {
      "id": 0,
      "isHumanoid": true,
      "planet": "Asgard",
      "age": 2034,
      "traits": [
        "BLONDE",
        "TALL"
      ]
    },
    {
      "id": 1,
      "isHumanoid": false,
      "planet": "Endor",
      "age": 22
    }
  ]
}
      """;

  @Test
  void testReadFromJson() throws IOException {
    var indivudals = FileOperations.readJsonStringIntoClass(indivudalJsons, IndividualInput.class);
    Assertions.assertEquals(indivudals.data().size(), 2);
    Assertions.assertEquals(indivudals.data().get(0).planet(), Planet.Asgard);
  }
}

package oop.practice.entity;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileOperations {
  private static final ObjectMapper objectMapper = new ObjectMapper()
      .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);

  public static <T> T readIntoClass(
      String path, Class<T> clazz
  ) throws IOException {
    File file = new File(path);
    return objectMapper.readValue(file, clazz);
  }

  public static <T> T readJsonStringIntoClass(
      String jsonObjects, Class<T> clazz
  ) throws IOException {
    return objectMapper.readValue(jsonObjects, clazz);
  }

  public static <T> void write(String path, T object) {
    try {
      File file = new File(path);
      objectMapper.writeValue(file, object);
    } catch (IOException e) {
      System.out.println("Error writing to file: " + e.getMessage());
    }
  }
}

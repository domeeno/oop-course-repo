cmake_minimum_required(VERSION 4.1.2)

project(CarLabs)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/build)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/build)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/build)

file(MAKE_DIRECTORY ${CMAKE_SOURCE_DIR}/build)

set(CMAKE_CXX_STANDARD 17)

include(FetchContent)

FetchContent_Declare(
  json
  URL https://github.com/nlohmann/json/releases/download/v3.12.0/json.tar.xz)

FetchContent_MakeAvailable(json)

add_executable(generator generator.cpp)
target_link_libraries(generator PRIVATE nlohmann_json::nlohmann_json)

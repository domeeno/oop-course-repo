ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.15.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.15.1"
)

lazy val root = (project in file("."))
  .settings(
    name := "Scalaa-classification"
  )

//import Dependencies._

ThisBuild / scalaVersion     := "2.13.5"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.mases"
ThisBuild / organizationName := "mscorlib"

lazy val root = (project in file("."))
  .settings(
    name := "sbt"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

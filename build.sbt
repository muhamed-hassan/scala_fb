ThisBuild / version      := "1.0"
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.assignments"

lazy val projectConfigs = (project in file("."))
  .settings(
    name := "Scala_FB_Assignments",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )

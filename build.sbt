name := "scala-helpers"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.1.0",
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.mockito" % "mockito-core" % "2.13.0" % Test
)

logBuffered in Test := false
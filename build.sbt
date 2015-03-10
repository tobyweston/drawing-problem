name := "springer"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.0" % "test",
  "org.scalamock" %% "scalamock-specs2-support" % "3.2" % "test",
  "bad.robot" % "unicorn-hat-java" % "1.0"
)

resolvers ++= Seq(
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "bad.robot" at "http://robotooling.com/maven/"
)
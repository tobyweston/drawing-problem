name := "drawing-program"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.9.5" % "test",
  "org.scalamock" %% "scalamock-specs2-support" % "3.6.0" % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions := Seq("-Xlint", "-Xfatal-warnings", "-deprecation", "-feature", "-language:implicitConversions,reflectiveCalls,higherKinds")
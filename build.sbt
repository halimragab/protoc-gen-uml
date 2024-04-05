enablePlugins(JavaAppPackaging)

scalaVersion := "2.12.19"

crossScalaVersions := Seq("2.12.19", "2.11.12")

name := "protoc-gen-uml"

organization := "io.coding-me"

resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "com.thesamet.scalapb"   %% "compilerplugin" % "0.11.15",
  "com.github.os72"        %  "protoc-jar"     % "3.11.4",
  "com.typesafe"           %  "config"         % "1.3.4",
  "com.github.pureconfig"  %% "pureconfig"     % "0.10.2" excludeAll(ExclusionRule(organization = "com.typesafe", name = "config")),
  "org.scalatest"          %% "scalatest"      % "3.0.7" % "test"
)

scalafmtConfig in ThisBuild := file(".scalafmt")

mainClass in Compile := Some("io.coding.me.protoc.uml.Main")

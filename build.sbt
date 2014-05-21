name := """SerialTester"""

version := "1.0"

scalaVersion := "2.10.2"

// Change this to another test framework if you prefer
libraryDependencies ++= List( 
    "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test",
    "com.typesafe.akka" %% "akka-actor" % "2.3.2",
    "com.typesafe.akka" %% "akka-testkit" % "2.3.2",
    "com.github.jodersky" %% "flow" % "2.0.1",
    "com.github.jodersky" %% "flow-native" % "2.0.1"
    )

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.2.3"


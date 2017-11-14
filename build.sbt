name := "refined-guava"

version := "0.0.1"

scalaVersion := "2.12.4"

lazy val root = project in file(".")

libraryDependencies ++= {
  Seq(
    "com.google.guava"    %  "guava"            % "23.4-jre"  % Compile,
    "eu.timepit"          %% "refined"          % "0.8.4"     % Compile,
    "org.scalatest"       %% "scalatest"      	% "3.0.1"     % Test,
    "org.pegdown"         %  "pegdown"        	% "1.6.0"     % Test
  )
}

scalacOptions ++= Seq(
  "-feature", "-unchecked", "-deprecation", "-Xfuture", "-Xlint",
  "-Xfatal-warnings", "-Yno-adapted-args", "-Ywarn-dead-code", "-Ywarn-numeric-widen")


// don't let Ctrl-C exit
cancelable in Global := true

autoAPIMappings := true

// generate HTML reports for tests
(testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report")

// show test durations
(testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

// run tests in parallel
parallelExecution in Test := true

// cache dependency resolution information
updateOptions := updateOptions.value.withCachedResolution(true)

scapegoatVersion in ThisBuild := "1.3.3"

enablePlugins(TutPlugin)
tutTargetDirectory := file(".")

import org.ensime.EnsimeCoursierKeys._

scalaVersion := "2.11.8"
scalaOrganization := "org.typelevel"

ensimeServerVersion in ThisBuild := "2.0.0-SNAPSHOT"

initialCommands in (Test, console) :="ammonite.Main().run()"

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.2",
  "com.lihaoyi" % "ammonite" % "0.8.1" % "test" cross CrossVersion.full
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation"
//  "-Xlog-implicits",
//  "-Ytyper-debug"
)
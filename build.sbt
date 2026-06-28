import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val liteflow = (project in file("."))
  .settings(name := "liteflow")
  .aggregate(liteflowDemo.projectRefs *)

lazy val liteflowDemo = (projectMatrix in file("liteflow-demo"))
  .settings(name := "liteflow-demo")
  .settings(libraryDependencies ++= testDependencies(scalaTest.flatSpec))
  .jvmPlatform(
    scalaVersions = Seq(scala.scala3.version),
    settings = libraryDependencies ++= Seq(
      jvmDependency(yomahub.liteflow),
      jvmRuntimeDependency(logback.classic),
    )
  )
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))

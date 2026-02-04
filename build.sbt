import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val liteflow = (project in file("."))
  .settings(name := "liteflow")
  .aggregate(
    liteflowDemo.jvm,
    liteflowDemo.js,
    liteflowDemo.native,
  )

lazy val liteflowDemo = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("liteflow-demo"))
  .settings(name := "liteflow-demo")
  .settings(crossTestDependencies(scalaTest.flatSpec))
  .jvmSettings(libraryDependencies ++= Seq(
    jvmDependency(yomahub.liteflow),
    jvmRuntimeDependency(logback.classic),
  ))

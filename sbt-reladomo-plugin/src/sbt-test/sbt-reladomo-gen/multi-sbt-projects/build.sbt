import com.folio_sec.reladomo.generator.sbtplugin.ReladomoPlugin

lazy val reladomoV           = "17.0.2"
lazy val twitterUtilCoreBinV = "18.7"
lazy val theOrganization     = "com.folio-sec"

lazy val common = (project in file("common"))
  .settings(
    scalaVersion := "2.12.6",
    reladomoScalaApiFutureType in Compile := "twitter",
    libraryDependencies ++= Seq(
      theOrganization             %% "reladomo-scala-common"                                 % System.getProperty("reladomoScalaCommonVersion"),
      theOrganization             %% s"reladomo-scala-twitter-${twitterUtilCoreBinV}-common" % System.getProperty("reladomoScalaCommonVersion"),
      "com.goldmansachs.reladomo" % "reladomo"                                               % reladomoV
    )
  )
  .dependsOn(other)
  .enablePlugins(ReladomoPlugin)

lazy val other = (project in file("other")).settings(scalaVersion := "2.12.6")

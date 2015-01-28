libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.2.2",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,compile",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" artifacts Artifact("javax.servlet", "jar", "jar"),
  "org.scalatra" %% "scalatra-scalatest" % "2.2.2" % "test",
  "org.scalatest" % "scalatest_2.10" % "2.1.7" % "test"
)

Seq(webSettings :_*)

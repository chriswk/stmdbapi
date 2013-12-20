addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

resolvers += Resolver.url("bintray-sbt-plugin-releases",
             url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Opts.resolver.sonatypeReleases
)

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8")

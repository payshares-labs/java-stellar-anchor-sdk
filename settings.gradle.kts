rootProject.name = "java-stellar-anchor-sdk"

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      alias("apache.commons.lang3").to("org.apache.commons:commons-lang3:3.12.0")
      alias("commons.codec").to("commons-codec:commons-codec:1.15")
      alias("commons.validator").to("commons-validator:commons-validator:1.7")
      alias("google.gson").to("com.google.code.gson:gson:2.8.9")
      alias("httpclient").to("org.apache.httpcomponents:httpclient:4.5.13")
      alias("java.stellar.sdk").to("com.github.stellar:java-stellar-sdk:0.29.0")
      alias("javax.jaxb.api").to("javax.xml.bind:jaxb-api:2.3.1")
      alias("jjwt").to("io.jsonwebtoken:jjwt:0.9.1")
      alias("log4j.core").to("org.apache.logging.log4j:log4j-core:2.17.1")
      alias("lombok").to("org.projectlombok:lombok:1.18.22")
      alias("okhttp3").to("com.squareup.okhttp3:okhttp:4.9.3")
      alias("okhttp3.mockserver").to("com.squareup.okhttp3:mockwebserver:4.9.3")
      alias("reactor.core").to("io.projectreactor:reactor-core:3.4.14")
      alias("reactor.netty").to("io.projectreactor.netty:reactor-netty:1.0.15")
      alias("servlet.api").to("javax.servlet:servlet-api:2.5")
      alias("sqlite.jdbc").to("org.xerial:sqlite-jdbc:3.16.1")
      alias("slf4j.api").to("org.slf4j:slf4j-api:1.7.35")
      alias("slf4j.log4j12").to("org.slf4j:slf4j-log4j12:1.7.33")
      alias("toml4j").to("com.moandjiezana.toml:toml4j:0.7.2")
    }
  }
}

include("core")

/** Configuration management subprojects */
include("config-spring-property")
// TODO: include("config-consul")

/** Data access subprojects */
include("data-spring-jdbc")
// TODO: include("data-spring-mongo")
// TODO: include("data-spring-couchbase")

/** Payment subprojects */
include("payment-circle")
// TODO: include("payment-stellar")

/** Anchor Platform */
include("platform")

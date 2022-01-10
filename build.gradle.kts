plugins {
  java
}

group = "pr.chenziqi"
version = "1.0"

repositories {
  mavenLocal()
  maven {
    setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
  }
}

dependencies {
  implementation("org.slf4j:slf4j-api:1.7.32")
  implementation("org.yaml:snakeyaml:1.30")
  implementation("ch.qos.logback:logback-classic:1.2.10")
  implementation("io.netty:netty-all:4.1.72.Final")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
}
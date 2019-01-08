# Serenity course

*
## Development environment setup

git repository tag: 01_env_setup

1. Create standard maven project
2. Add following dependencies:
```xml
    <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-screenplay -->
    <dependency>
      <groupId>net.serenity-bdd</groupId>
      <artifactId>serenity-screenplay</artifactId>
      <version>${serenity.version}</version>
    </dependency>


    <!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-cucumber -->
    <dependency>
      <groupId>net.serenity-bdd</groupId>
      <artifactId>serenity-cucumber</artifactId>
      <version>${serenity.cucumber.version}</version>
    </dependency>
    
    <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
    <dependency>
      <groupId>com.github.javafaker</groupId>
      <artifactId>javafaker</artifactId>
      <version>${javafaker.version}</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.mock-server/mockserver-netty -->
    <dependency>
      <groupId>org.mock-server</groupId>
      <artifactId>mockserver-netty</artifactId>
      <version>${mock-server.version}</version>
    </dependency>
    
    
    
```
```xml
    <serenity.version>2.0.30</serenity.version>
    <serenity.cucumber.version>1.9.22</serenity.cucumber.version>
    <javafaker.version>0.16</javafaker.version>
    <mock-server.version>5.5.1</mock-server.version>
```
3. Report generation - add following plugin in build section:
```xml
        <plugin>
          <groupId>net.serenity-bdd.maven.plugins</groupId>
          <artifactId>serenity-maven-plugin</artifactId>
          <version>${serenity.version}</version>
          <executions>
            <execution>
              <id>serenity-reports</id>
              <phase>post-integration-test</phase>
              <goals>
                <goal>aggregate</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
```
4.  In command line execute: `mvn verify` - to run sample test scenario from `src/test/resources/features` 
5.  In command line execute:  `mvn serenity:aggregate` - to generate serenity report `target/site/serenity/index.html`
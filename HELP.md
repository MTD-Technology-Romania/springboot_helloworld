# Read Me First
The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Jersey, Okta, Flyway Migration'. As a result, your application may not work as expected.
* The original package name 'ro.sorin.pocs.java.springframework.springboot-helloworld' is invalid and this project uses 'ro.sorin.pocs.java.springframework.usermanagement' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/#build-image)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-jersey)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-security-oauth2-client)
* [Okta Spring Boot documentation](https://github.com/okta/okta-spring-boot#readme)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Okta-Hosted Login Page Example](https://github.com/okta/samples-java-spring/tree/master/okta-hosted-login)
* [Custom Login Page Example](https://github.com/okta/samples-java-spring/tree/master/custom-login)
* [Okta Spring Security Resource Server Example](https://github.com/okta/samples-java-spring/tree/master/resource-server)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.10.1/reference/htmlsingle/#spring-aot-maven)

## OAuth 2.0 and OIDC with Okta

If you don't have a free Okta developer account, you can create one with [the Okta CLI](https://cli.okta.com):

```bash
$ okta register
```

Then, register your Spring Boot app on Okta using:

```bash
$ okta apps create
```

Select **Web** > **Okta Spring Boot Starter** and accept the default redirect URIs.

## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started with Spring Native.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.10.1/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm springboot-helloworld:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM native-image compiler should be installed and configured on your machine, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.10.1/reference/htmlsingle/#getting-started-native-build-tools).

To create the executable, run the following goal:

```
$ ./mvnw package -Pnative
```

Then, you can run the app as follows:
```
$ target/springboot-helloworld
```

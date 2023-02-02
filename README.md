Refer [reference manual](https://docs.spring.io/spring-boot/docs/current/reference/html/configuration-metadata.html)
to understand more about META-INF/additional-spring-configuration-metadata.json
 
### Improving Startup time

For each auto-configuration class on the classpath, Spring Boot has to evaluate the conditions encoded within the @Conditional... annotations to decide whether to load the auto-configuration and all the classes it needs. Depending on the size and number of starters in a Spring Boot application, this can be a very expensive operation and affect startup time.

There is yet another annotation processor that generates metadata about the conditions of all auto-configurations. Spring Boot reads this metadata during startup and can filter out configurations whose conditions are not met without actually having to inspect those classes.

For this metadata to be generated, we simply need to add the annotation processor to our starter module:

`
dependencies {
...
annotationProcessor 'org.springframework.boot:spring-boot-autoconfigure-processor'
}
`

During the build, the metadata will be generated into the META-INF/spring-autoconfigure-metadata.properties file, which will look something like this:

io.reflectoring.starter.EventAutoConfiguration=
io.reflectoring.starter.EventAutoConfiguration.ConditionalOnClass=io.reflectoring.KafkaConnector
io.reflectoring.starter.EventAutoConfiguration.Configuration=
I’m not sure why the metadata contains the @ConditionalOnClass condition but not the @ConditionalOnProperty condition. If you know why, please let me know in the comments.For each auto-configuration class on the classpath, Spring Boot has to evaluate the conditions encoded within the @Conditional... annotations to decide whether to load the auto-configuration and all the classes it needs. Depending on the size and number of starters in a Spring Boot application, this can be a very expensive operation and affect startup time.

There is yet another annotation processor that generates metadata about the conditions of all auto-configurations. Spring Boot reads this metadata during startup and can filter out configurations whose conditions are not met without actually having to inspect those classes.

For this metadata to be generated, we simply need to add the annotation processor to our starter module:

dependencies {
...
annotationProcessor 'org.springframework.boot:spring-boot-autoconfigure-processor'
}
During the build, the metadata will be generated into the META-INF/spring-autoconfigure-metadata.properties file, which will look something like this:

io.reflectoring.starter.EventAutoConfiguration=
io.reflectoring.starter.EventAutoConfiguration.ConditionalOnClass=io.reflectoring.KafkaConnector
io.reflectoring.starter.EventAutoConfiguration.Configuration=
I’m not sure why the metadata contains the @ConditionalOnClass condition but not the @ConditionalOnProperty condition.
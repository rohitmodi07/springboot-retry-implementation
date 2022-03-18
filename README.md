# springboot-retry-implementation

Spring boot with Retry implementation :--

This project gives an idea how to implement Retry logic in spring boot without having any issue.

while implementing Retry logic we have to follow certain steps :---

STEP 1 :---

include following dependency in build.gradle (gradle based) or pom.xml (maven based)

gradle based dependency :---

implementation 'org.springframework.boot:spring-boot-starter-aop'

implementation 'org.springframework.retry:spring-retry'

maven based dependency in pom.xml :---

<dependency>
    
    <groupId>org.springframework.retry</groupId>
    
    <artifactId>spring-retry</artifactId>
    
    <version>1.2.5.RELEASE</version>
    
</dependency>

<dependency>
    
    <groupId>org.springframework.boot</groupId>
    
    <artifactId>spring-boot-starter-aop</artifactId>
    
    <version>2.6.4.RELEASE</version>
    
</dependency>




STEP 2 :---


class which has main method, along with @SpringBootApplication, we have to put another annotation @EnableRetry to enable retry functionality.
then
put @Retryable annotation on the method which we want to execute multiple times and when it reaches maxAttempt, control should go to the method which is annotated with @Recover


while using @Retryable and @Recover, we have to consider two below factors which can break this setup and we end up with issues such as, mwethod which is annotated
with @Recover doesnt execute, method which is annotated with @Retryable will execute only once instead of attempting multiple times as mentioned in @Retryable.


 --- if a method throw exception e then we have to throw same exception e from catch block else retryable will not attempt multiple times (if we have 
     mentioned more than 1 attempt in retryable maxAttempt parameter)

 --- return same object type from the recover method else it will not get called and it will throw Recover method not found exception 

Project Requirements

JDK 1.11 or higher Gradle 7.3.2 or higher spring boot 2.5 or higher

Note :- 

In this project, i have intentionally used wrong api url so that call will fail and then control will go to recover method and try to fetch the data from another api url.

We can relate this scenario in real time project where we call a database to fetch the details but at that time primary database is down and returned failure, after

few attempt, request autometically forward to recover method and fetch the data from another database and return the result to user.

This is one example i have mentioned, there are plenty of real time scenarios where we can avoid downtime or exception by implementing retry logic.


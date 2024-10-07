# Spring Boot and Redis Configuration 

## Overview
Setting up a Spring Boot application with Redis to handle a simple GET request. (simple example for Redis config)

## Prerequisites

- Java 8 or higher
- Redis installed and running
- Spring Boot application setup

## Step 1: Create a Spring Boot Application

1. **Initialize a new Spring Boot project** using [Spring Initializr](https://start.spring.io/).
2. **Select Dependencies**:
    - Spring Web
    - Spring Data Redis

## Step 2: Add Dependencies

### Maven

In your `pom.xml`, add the following dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
</dependency>
```
## Redis config in application properties

```application.properties
# Redis Configuration
spring.redis.host=localhost
spring.redis.port=6379
```
## Enable caching
Enable caching in your Spring Boot application by adding the @EnableCaching annotation to your main application class

## Run application
Run your Spring Boot application. When you access the endpoint (e.g., `http://localhost:8080/data/{userId}`), the first request will take some time to respond (due to the processing). Subsequent requests with the same ID will return the cached result instantly.

## Using Caching in Your Services
Adding annotation on method @Cacheable(value = "myCache", key = "#id")

## Testing the Catch
Create simple REST controller to test the Catch.
Run your Spring Boot application. When you access the endpoint (e.g., http://localhost:8080/data/1), the first request will take some time to respond (due to the simulated delay). Subsequent requests with the same ID will return the cached result instantly.

 
## Step 7: Managing the Cache

You can customize the cache management with annotations like `@CachePut`, `@CacheEvict`, etc. Here’s a brief overview:

- @CachePut: Updates the cache without interfering with the method execution.

- @CacheEvict: Removes entries from the cache.

### Example Usage

```java
@CachePut(value = "cacheName", key = "#id")
public String updateData(String id, String data) {
    // Logic to update data
}

@CacheEvict(value = "cacheName", key = "#id")
public void clearCache(String id) {
    // Logic to clear the cache for the specified ID
}

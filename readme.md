# API for JWT authentication

![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white) ![](https://camo.githubusercontent.com/6eff46a364eba690cb91a9f40084d97f96bf95699f3cb7722125dc1dc324fde1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73)

# Technologies

* Java
* H2 Database
* Spring Boot
* Spring Security
* JDBC Client
The project used best programming practices such as layered development and dependency injection.

## How to run:

* Clone the repository:
* ``` git clone https://github.com/Tiago-Fernandes-Avila/SpringSecurityWithJdbcClient ``` 
* Update Maven dependencies.
* Use an IDE that supports the Java ecosystem, such as IntelliJ or VScode, with the extension: Extension Pack for Java provided by Microsoft.
or run the Maven wrapper script with the commands:

* Linux/Mac - Unix-like
``` ./mvnw spring-boot:run ```

* Windows
``` mvnw.cmd spring-boot:run ```

## Demonstrative Endpoints
```
POST | localhost:8080/auth/register
POST | localhost:8080/auth/login
GET | localhost:8080/private/hello
```

**In this case, the GET endpoint /hello will only be accessed if the user sends the Token received after logging in.**

*Tiago Fernandes Ávila*


```

In this case, the GET endpoint **/hello will only be accessed if the user sends the Token received after logging in.

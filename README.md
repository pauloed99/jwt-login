# JWT Login API

# Sobre o projeto

Sistema de Login desenvolvido com o Framework Spring Boot. 

Ademais, para o desenvolvimento dele foi utlizado o JWT (Json Web Token) como método de autenticação e autorização e o banco de dados MySQL para armazenar os dados dos usuários criados na API REST.

## Modelo conceitual
![Modelo_Conceitual](https://github.com/pauloed99/jwt-login/blob/master/src/main/resources/static/readme/database-representation.png)

## Documentação dos endpoints pelo Swagger
![Swagger_1](https://github.com/pauloed99/jwt-login/blob/master/src/main/resources/static/readme/swagger-1.png)
![Swagger_2](https://github.com/pauloed99/jwt-login/blob/master/src/main/resources/static/readme/swagger-2.png)

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- JWT
- ModelMapper
- MySQL
- Swagger

# Como executar o projeto

Pré-requisitos: Java 21

```bash
# clonar repositório
git clone https://github.com/pauloed99/jwt-login

# executar o projeto
./mvnw spring-boot:run

# link para acessar o Swagger
http://localhost:8080/swagger-ui/index.html
```

# Autor

Paulo Eduardo Dutra

https://www.linkedin.com/in/paulo-eduardo-dutra
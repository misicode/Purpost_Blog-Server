<h1 align="center">📰 EggNews</h1>

## 📚 Acerca del repositorio
API REST de la aplicación EggNews desarrollada con Spring Boot para la gestión de noticias y autenticación de usuarios. Integra Spring Security para el control de acceso a la aplicación y JWT para la creación de tokens.


## 💻 Configuración
- **Sobre las variables de entorno**:<br>
  En el archivo `application.properties` se deberá modificar los siguientes campos para definir la URL de los origenes que consumirán nuestra API, la configuración de nuestra base de datos en MongoDB, la configuración de JWT y la configuración del servicio de Cloudinary.

```properties
# Allowed origins configuration
eggnews.origin=${eggnews_origin}
# Database configuration
spring.data.mongodb.uri=${mongodb_uri}
# JWT configuration
jwt.secret_key=${jwt_secret_key}
jwt.expiration_time=${jwt_expiration_time}
# Cloudinary configuration
cloudinary.cloud_name=${cloudinary_cloud_name}
cloudinary.api_key=${cloudinary_api_key}
cloudinary.api_secret=${cloudinary_api_secret}
```

- **Sobre el análisis de código**:<br>
  En el archivo `pom.xml` se deberá modificar los siguientes campos con nuestra configuración de acceso a Sonarqube.

```xml
<sonar.host.url>http://localhost:9000</sonar.host.url>
<sonar.login>admin</sonar.login>
<sonar.password>admin</sonar.password>
```

- **Sobre la documentación**:<br>
  En el archivo `application.properties` se deberá mantener los siguientes campos en `true` para visualizar la documentación con Open API. Por el contrario, se deberá mantener los campos en `false` para desactivarla.

```properties
# Open API configuration
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
```


## 📄 Documentación
- Para visualizar la documentación en la interfaz gráfica de Swagger: `{URL_BASE}/swagger-ui/index.html`
- Para visualizar la documentación en formato JSON: `{URL_BASE}/v3/api-docs`

<img src="https://github.com/misicode/Server-EggNews/assets/88341114/a590ddfb-76e4-4c40-a409-36a9f530b198" width=740px />


## 🛠️ Herramientas utilizadas

| Herramienta    | Uso                                                                                                                  | Versión |
| -------------- | -------------------------------------------------------------------------------------------------------------------- | ------- |
| [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/download/) | Entorno de desarrollo para el proyecto | 2023.2 Ultimate Edition
| [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://dev.java)                                              | Lenguaje de programación utilizado | 17.0.1
| [![Apache Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org)                             | Herramienta para la gestión de dependencias | 3.9.2
| [![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot/)                            | Framework para el desarrollo de aplicaciones | 3.2.1
| [![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)](https://spring.io/projects/spring-security/) | Framework para la seguridad de acceso | 6.2.1
| [![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)](https://jwt.io)                                                              | Estándar para la creación de tokens de acceso | 0.11.5
| [![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/specification/)                         | Estándar para la especificación de APIs | 3.0
| [![Sonarqube](https://img.shields.io/badge/SonarQube-black?style=for-the-badge&logo=sonarqube&logoColor=4E9BCD)](https://docs.sonarsource.com/sonarqube/9.9/)              | Plataforma para evaluar código fuente | 9.9 LTS
| [![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)](https://www.mongodb.com/es/what-is-mongodb)                     | Base de datos NoSQL | 4.2.1


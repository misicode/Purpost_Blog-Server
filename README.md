<!-- PROJECT PRESENTATION -->
<div align="center">
  <a href="https://github.com/misicode/PurPost_Blog-Server">
    <img src="https://cdn-icons-png.freepik.com/256/9611/9611314.png" alt="Logo Icon" width="80" height="80">
  </a>

  <h1 align="center">Purpost Server</h1>

  <p align="center">
    <span>Microservicios de Purpost Blog</span><br>
    <a href="https://github.com/misicode/Purpost_Blog-Server/issues">Reportar Bug</a>
    |
    <a href="https://github.com/misicode/Purpost_Blog-Server/issues">Solicitar Feature</a>
  </p>
</div><br>


<!-- ABOUT THE PROJECT -->
## 📖 Acerca del repositorio

Aplicación de microservicios desarrollado con Spring Boot del proyecto Purpost Blog para la gestión de publicaciones y autenticación de usuarios.

### Arquitectura
<img src="https://github.com/user-attachments/assets/964f8c7f-4a7d-4aff-a3ea-2b546dd1f417" width=800 />

### Construido con

| Herramienta                                                    | Descripción                                   | Versión                 |
|----------------------------------------------------------------|-----------------------------------------------|-------------------------|
| [![Java][java-badge]][java-url]                                | Lenguaje de programación utilizado            | 17.0.1                  |
| [![Spring Boot][springboot-badge]][springboot-url]             | Framework para el desarrollo de aplicaciones  | 3.2.4                   |
| [![Spring Security][springsecurity-badge]][springsecurity-url] | Framework para la seguridad de acceso         | 6.2.3                   |
| [![JWT][jwt-badge]][jwt-url]                                   | Estándar para la creación de tokens de acceso | 0.11.5                  |
| [![MongoDB][mongodb-badge]][mongodb-url]                       | Base de datos NoSQL                           | 4.2.1                   |
| [![Swagger][swagger-badge]][swagger-url]                       | Estándar para la especificación de APIs       | 3.0                     |
| [![Sonarqube][sonarqube-badge]][sonarqube-url]                 | Plataforma para evaluar código fuente         | 10.5                    |
| [![Docker][docker-badge]][docker-url]                          | Plataforma para desplegar contenedores        | 27.0.3                  |
| [![Apache Maven][maven-badge]][maven-url]                      | Herramienta para la gestión de dependencias   | 3.9.2                   |
| [![IntelliJ IDEA][intellijidea-badge]][intellijidea-url]       | Entorno de desarrollo del proyecto            | 2023.2 Ultimate Edition |


<!-- GETTING STARTED -->
## 🚀 Iniciando el proyecto

Para poner en funcionamiento una copia local de este repositorio, siga los siguientes pasos.

### Requisitos previos

Obligatorio
```txt
JDK >= 17.X
Maven >= 3.X
```

Opcional
```txt
Git
IntelliJ IDEA
Docker
```

### Instalación y configuración

1. Descargue o clone este repositorio.

   ```sh
   git clone https://github.com/misicode/Purpost_Blog-Server
   ```

2. Instale todas las dependencias de cada microservicio.

   ```sh
   cd [microservice-name]
   mvn install
   ```

3. Descargue o clone el repositorio de configuración.

   ```sh
   git clone https://github.com/misicode/PurPostBlog-ConfigServer
   ```

### Despliegue

**Manual**
1. En el microservicio `config-server-service`, declare la variable de entorno de ubicación de su repositorio de configuración. Por ejemplo:
   1. Si el repositorio es local:

      ```env
      CONFIG_SERVER_GIT_URI=file:///C:\Users\Usuario\Documents\purpost-config-server
      ```
      
   2. Si el repositorio es remoto:
   
      ```env
      CONFIG_SERVER_GIT_URI=https://github.com/misicode/PurPostBlog-ConfigServer
      ```

2. En su repositorio de configuración, reemplace las siguientes variables de entorno de los archivos `.yml` con sus credenciales respectivas.

      ```env
      ${JWT_SECRET_KEY} = your_jwt_secret_key
      
      ${IMAGE_MONGODB_URI} = your_image_mongodb_uri
      ${POST_MONGODB_URI} = your_post_mongodb_uri
      ${USER_MONGODB_URI} = your_user_mongodb_uri
      
      ${CLOUDINARY_CLOUD_NAME} = your_cloudinary_cloud_name
      ${CLOUDINARY_API_KEY} = your_cloudinary_api_key
      ${CLOUDINARY_API_SECRET} = your_cloudinary_api_secret
      ```

3. Levante cada microservicio.


**Con Docker**
1. Cree el archivo `.env` como copia del archivo `.env.template` e ingrese sus credenciales respectivas.

   ```env
   # Config Server Repository
   CONFIG_SERVER_GIT_URI=your_config_server_git_uri
   CONFIG_SERVER_GIT_PATH=your_config_server_git_path    # only if your ConfigServer repository is local
   # JWT
   JWT_SECRET_KEY=your_jwt_secret_key
   # MongoDB
   IMAGE_MONGODB_URI=your_image_mongodb_uri
   POST_MONGODB_URI=your_post_mongodb_uri
   USER_MONGODB_URI=your_user_mongodb_uri
   # Cloudinary
   CLOUDINARY_CLOUD_NAME=your_cloudinary_cloud_name
   CLOUDINARY_API_KEY=your_cloudinary_api_key
   CLOUDINARY_API_SECRET=your_cloudinary_api_secret
   ```

2. Construya el ejecutable de cada microservicio.

   ```sh
   cd [microservice-name]
   mvn clean package -DskipTests
   ```

3. Construya y levante los contenedores de los microservicios.

   ```sh
   docker compose up -d --build
   ```


<!-- LICENSE -->
## 💼 Licencia

Distribuido bajo la licencia MIT. Consulte [LICENSE.txt][license-url] para obtener más información.


<!-- CONTACT -->
## 🌸 Contacto

_Desarrollado por_ **Alessandra Mincia**

[![Misicode][misicode-badge]][misicode-url]
[![GitHub][github-badge]][github-url]
[![LinkedIn][linkedin-badge]][linkedin-url]


<!-- MARKDOWN LINKS -->
[java-badge]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://dev.java
[springboot-badge]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[springboot-url]: https://spring.io/projects/spring-boot/
[springsecurity-badge]: https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white
[springsecurity-url]: https://spring.io/projects/spring-security/
[jwt-badge]: https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens
[jwt-url]: https://jwt.io
[mongodb-badge]: https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white
[mongodb-url]: https://www.mongodb.com/es/what-is-mongodb
[swagger-badge]: https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white
[swagger-url]: https://swagger.io/specification/
[sonarqube-badge]: https://img.shields.io/badge/SonarQube-black?style=for-the-badge&logo=sonarqube&logoColor=4E9BCD
[sonarqube-url]: https://docs.sonarqube.org/latest/
[docker-badge]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[docker-url]: https://www.docker.com/blog/kickstart-your-spring-boot-application-development/
[maven-badge]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[maven-url]: https://maven.apache.org
[intellijidea-badge]: https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[intellijidea-url]: https://www.jetbrains.com/idea/download/
[license-url]: ./LICENSE.txt
[misicode-badge]: https://img.shields.io/badge/misicode-C020FF?logo=githubsponsors&logoColor=fff
[misicode-url]: https://misicode.netlify.app/
[github-badge]: https://img.shields.io/badge/Github-272727?logo=github&logoColor=fff
[github-url]: https://github.com/misicode
[linkedin-badge]: https://img.shields.io/badge/LinkedIn-0A66C2?logo=linkedin&logoColor=fff
[linkedin-url]: https://www.linkedin.com/in/misicode
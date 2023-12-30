<h1 align="center">📰 EggNews</h1>

## 📚 Acerca del repositorio
Aplicación desarrollada con Spring Boot para la gestión de noticias y el registro de usuarios. Implementa Spring Security para el control de sesiones de usuario y Thymeleaf para la creación de las vistas.


## 📸 Captura
![egg_news](https://github.com/misicode/BC-EggNews/assets/88341114/743fa23d-2dad-4a4b-95fc-4535b3ff67ce)


## 💻 Configuración
- **Sobre el esquema de base de datos**: Deberá ejecutar el script [`eggnews.sql`](https://github.com/misicode/BC-EggNews/blob/main/eggnews.sql) en MySQL para crear la base de datos.

- **Sobre las variables de entorno**: En el archivo `application.properties` se deberá modificar los siguientes campos con las credenciales de acceso a la base de datos y al servicio de Cloudinary.

```properties
# Database configuration
spring.datasource.url=${db_url}
spring.datasource.username=${db_username}
spring.datasource.password=${db_password}
# Cloudinary configuration
cloudinary.cloud_name=${cloudinary_cloud_name}
cloudinary.api_key=${cloudinary_api_key}
cloudinary.api_secret=${cloudinary_api_secret}
```

## 🛠️ Herramientas utilizadas

| Herramienta    | Uso                                                                                                                  | Versión |
| -------------- | -------------------------------------------------------------------------------------------------------------------- | ------- |
| [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/download/) | Entorno de desarrollo para el proyecto | 2023.2 Ultimate Edition
| [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://dev.java)                                              | Lenguaje de programación utilizado | 17.0.1
| [![Apache Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org)                             | Herramienta para la gestión de dependencias | 3.9.2
| [![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot/)                            | Framework para el desarrollo de aplicaciones | 3.2.1
| [![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)](https://spring.io/projects/spring-security/) | Framework para la seguridad de acceso | 6.2.1
| [![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)](https://www.thymeleaf.org)                         | Motor de plantillas HTML | 3.1.2.RELEASE
| [![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://dev.mysql.com/doc/)                                           | Gestor para el manejo de bases de datos relacional | 8.0.34 Community


## 📝 Agradecimientos
Este proyecto surgió como parte del bootcamp "Back-end con Java" gracias a la convocatoria de becas "Code your Future", organizado por Globant University. Para obtener más información al respecto y estar atento a próximas convocatorias visite el siguiente [enlace](https://more.globant.com/becas-cyf-globant-university).

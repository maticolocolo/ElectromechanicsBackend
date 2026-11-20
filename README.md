# Electromechanics Backend

## Descripción

Backend del proyecto **Electromechanics**, desarrollado con Java y Spring Boot.

Proporciona una API REST que permite gestionar servicios técnicos, solicitudes de clientes y operaciones relacionadas con el sistema.

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- Oracle Database
- Spring Data JPA
- API REST

## Estructura del proyecto

```text
ElectromechanicsBackend/
├── src/
│   ├── main/
│   │   ├── java/com/electromechanics/backend/
│   │   │   ├── BackendApplication.java
│   │   │   ├── ClienteController.java
│   │   │   ├── EstadoController.java
│   │   │   ├── InformesController.java
│   │   │   ├── ServiciosController.java
│   │   │   ├── Entity/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application-example.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## Requisitos

- Java compatible con la versión configurada en `pom.xml`.
- Maven.
- Oracle Database.
- Wallet de Oracle para la conexión a la base de datos.

## Configuración

1. Clonar este repositorio.
2. Configurar las credenciales de Oracle.
3. Utilizar `application-example.properties` como referencia para crear el archivo `application.properties`.
4. Configurar la conexión a Oracle y la ruta correspondiente de la Wallet.
5. Mantener las credenciales privadas fuera del repositorio.

**Importante:** No publicar la Wallet ni las contraseñas de la base de datos.

## Ejecución

Desde la carpeta principal del proyecto, ejecutar en Windows:

```bash
mvnw.cmd spring-boot:run
```

El servidor se ejecuta en:

```text
http://localhost:8080
```

## Endpoints principales

| Método | Endpoint | Función |
|---|---|---|
| GET | `/api/servicios` | Obtener servicios |
| PUT | `/api/servicios/{id}/estado` | Actualizar estado |
| GET | `/api/clientes/solicitudes` | Consultar solicitudes |
| POST | `/api/clientes/solicitudes` | Crear solicitud |

## Pruebas

Los endpoints pueden probarse mediante Postman.

## Proyecto

**Nombre:** Electromechanics

**Componente:** Backend REST API

**Repositorio:** GitHub - ElectromechanicsBackend

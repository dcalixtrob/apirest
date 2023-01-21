# apirest
API Rest Technical Test Backend - UTP
## Acerca de
Proyecto Maven, usando Sprint Boot y JWT
IDE: Eclipse

## Iniciar proyecto
Iniciar la aplicacion con el pluggin de maven build (`mvn spring-boot:run`).
La aplicacion se ejecuta en la siguiente url [http://localhost:8090](http://localhost:8090).
```
Paths: 
http://localhost:8090/user/signup
http://localhost:8090/user/login
http://localhost:8090/notas/registrar
http://localhost:8090/notas/listar/{idAlumno}
http://localhost:8090/notas/listar
```

Se usa la BD H2, la consola se carga en la siguiente ruta [http://localhost:8090/h2-console](http://localhost:8090/h2-console)
```
Url: jdbc:h2:mem:notasdb
Usuario : sa
Password: password
```

![Consola login H2](document/Consola_login_H2.png)

## Patron de diseño  - 

Se utiliza el Patron Repositoy en la capa de persistencia de modelo de dominio, para aislar el origen de datos del resto de la aplicacion.


## Modelo de BD

![Modelo de BD](document/ModeloBD.png)


## SWAGGER - Documentacion de APIS
La documentacion se encuentra en la siguiente ruta:
[http://localhost:8090/swagger-ui/#/](http://localhost:8090/swagger-ui/#/)

![Swagger](document/DocumentacionAPISwagger.png)

## Caso de Usos


#### Autenticacion

La autenticacion se realiza usando JWT, generando un token que sera requerido en los demas servicios.

![Autenticacion](document/CU_Autenticacion.png)


#### Registrar Notas

Para registrar notas  se debe generar el token y este sera enviado al servicio que validara los datos enviados, registrará la nota y devolvera el mensaje de confirmacion o de validacion.
![Registrar Notas](document/CU_Registrar_Notas.png)

#### Listar Notas
Para obtener las notas de un alumno se debe generar el token del usuario del alumno y este sera enviado al servicio que validara los datos enviados, obtendra el alumno relacionado al usuario y devolvera las notas o los mensajes de validacion.

![Listar Notas](document/CU_Listar_Notas.png)

 
 
 
## Screenshot evidencias

#### Registro de usuario
![Registro de usuario](document/Screenshot_001.png)

#### Login de usuario usralumno 
idalumno = A001
![Login de usuario](document/Screenshot_002.png)

#### Registro de notas
![Registro de notas](document/Screenshot_003.png)
![Registro de notas](document/Screenshot_004.png)
Se registra nota para otro alumno A002
![Registro de notas](document/Screenshot_005.png)

#### Consulta de notas del idAlumno A001 con el token del usuario usralumno

El usuario "usralumno", que corresponde al alumno A001 solo puede ver sus notas.

![Login de usuario](document/Screenshot_007.png)
 


## Pruebas funcionales 

Se uso Cucumber con JUnit.

![Pruebas funcionales ](document/PruebasCucumberJunit.png)


Se genera un reporte en la ruta: /build/reports/tests/cucumber/cucumber-report.html

![eporte cucumber ](document/reporteCucumber.png)


## Docker

#### Build

`mvnw install dockerfile:build`

#### Mostrar docker images

`docker images`

#### Run
`docker run --name apirest -p 8090:8090 -t darkdavid/apirest`




## Docker Hub 

### Ruta de la imagen
[https://hub.docker.com/r/darkdavid/apirest](https://hub.docker.com/r/darkdavid/apirest)

### Ejecutarlo local

`docker pull darkdavid/apirest:1.0`

`docker run --name apirest -p 8090:8090 -t darkdavid/apirest:1.0`

![Contenedor inicado](document/DockerContainer.png)

## Author
 
**David M. Calixtro Bustamante**


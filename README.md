# apirest
API Rest Technical Test Backend - UTP
## Acerca de
Proyecto Maven, usando Sprint Boot y JWT

## Iniciar proyecto
Inicial la aplicacion con el pluggin de maven build (`mvn spring-boot:run`).
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
Usuario : sa
Password: password
```

![Consola login H2](/document/Consola_login_H2.png)

## Screenshot evidencias

### Registro de usuario]
![Registro de usuario](/document/Screenshot_001.png)

### Login de usuario prueba idalumno 0001
![Login de usuario](/document/Screenshot_002.png)

### Registro de notas
![Registro de notas](/document/Screenshot_003.png)
![Registro de notas](/document/Screenshot_004.png)
![Registro de notas](/document/Screenshot_005.png)
![Registro de notas](/document/Screenshot_006.png)

### Consulta de notas del idAlumno 0001
![Login de usuario](/document/Screenshot_007.png)


## Author

**David M. Calixtro Bustamante**


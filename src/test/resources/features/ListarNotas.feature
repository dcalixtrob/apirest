Feature: Feature del servicio de notas

  Scenario Outline: Listar notas de alumno
    Given se necesita listar notas
    When Se invoque al servicio de notas con las credenciales del usuario <usuario> con el password <password>
    Then validamos el estado de ejecucion <statusCode> y mensaje <mensajeRespuesta>

    Examples: 
      | usuario 			| password		| statusCode	| mensajeRespuesta 	 |
      |  "usralumno"  | "prueba" 		|  200				| "Consulta exitosa" |
      |  "usralumno2" | "prueba" 		|  404				| "No existen registros para idAlumno: A002" |


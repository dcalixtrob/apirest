Feature: Feature del servicio de notas

  Scenario Outline: Registrar notas
    Given el usuario necesite registrar notas
    And enviamos el idCurso <idCurso>, el idAlumno <idAlumno> y el valor de nota <nota>
    When Se invoque al servicio de notas
    Then valida el estado de ejecucion <statusCode>, el codigo de respuesta <codRespuesta> y mensaje <mensajeRespuesta>

    Examples: 
      | idCurso | idAlumno | nota | statusCode	| codRespuesta 	| mensajeRespuesta 	|
      |  "0001" |  "00001" | 15.0 |  200				|          1		| "Registro exitoso" |
      |  "0002" |  "00001" | 15.0 |  200				|          1		| "Registro exitoso" |

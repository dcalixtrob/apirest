Feature: Feature del servicio de notas

  Scenario Outline: Registrar notas
    Given el usuario necesite registrar notas
    And enviamos el periodo <periodo>, idCurso <idCurso>, el idAlumno <idAlumno>, idSeccion <idSeccion>, tipoNota <tipoNota> y el valor de nota <nota>
    When Se invoque al servicio de notas con las credenciales
    Then valida el estado de ejecucion <statusCode> y mensaje <mensajeRespuesta>

    Examples: 
      | periodo 	| idCurso | idAlumno	| idSeccion	|	tipoNota	| nota | statusCode	| mensajeRespuesta 	 |
      | "20230"		| "0001"  |  "A001" 	| "S001"		| "P1"			|	15.0 |  400				| "[periodo debe ser de 6 caracteres]" |
      | "202301"	| "001"  	|  "A001" 	| "S001"		| "P1"			|	15.0 |  400				| "[IdCurso debe ser de 4 caracteres]" |
      | "202301"	| "0001" 	|  "001" 		| "S001"		| "P1"			|	15.0 |  400				| "[IdAlumno debe ser de 4 caracteres]" |
      | "202301"	| "0001" 	|  "A001" 	| "001"			| "P1"			|	15.0 |  400				| "[idSeccion debe ser de 4 caracteres]" |
      | "202301"	| "0001" 	|  "A001" 	| "S001"		| ""				|	15.0 |  400				| "[tipoNota debe ser de 2 caracteres]" |
      | "202301"	| "0001" 	|  "A001" 	| "S001"		| "P1"			|	15.0 |  200				| "Registro exitoso" |
      | "202301"	| "0002" 	|  "A001" 	| "S001"		| "P1"			|	15.0 |  200				| "Registro exitoso" |


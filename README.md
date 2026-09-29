# TP-1-IyCSW

## Registro de tareas

Se solicita implementar el directorio .github en el cual hay que crear el archivo CODEOWNERS y el directorio workflows con un archivo ci.yml. Se añadio un archivo pull_request_template para agregar un formato a respetar en la solicitud de PRs.

Para dicha implementacion, se realizo un pequeño simulacro por parte del grupo para el analisis y compresion tanto de git y github como de git worflows. Se simulo en un principio la creacion de develop a partir de master, con 2 feat correspondientes al codeowners y al ci en workflows como lo solicita el enunciad. Aprovechando un codewoners incompleto, se realizo un hotfix en master luego de haber hecho pr y merge de develop a master, luego se hizo la feat de ci.

Se discutio grupalmente la idea de que proyecto hacer y se decidio hacer una calculadora basica con java y un frontend en react.

Se creó un backlog para poder distribuir tareas aunque no se pondero las tareas con story points dado que es un programa super sencillo y la unica finalidad del backlog es dividir tareas y asignar responsabilidades para que cada uno aproveche a usar ramas para los feat y las releases.
Luego se genero el proyecto en java con spring initializr para colocarlo en /backend y se genero en /frontend un proyecto con react. 
Cabe aclarar que para estas 3 ramas se hizo merge directo a develop sin PR ya que eran las que sentaban las bases de proyecto acordadas proeviamente en grupo y para las tecnologias no habia nada que agregar.

Para la V1.0.0 se crearon una rama por suma, otra por resta y una para el frontend, en la de la resta se creo el controller y el service y luego se agrego a esas clases la operacion suma en otra rama, por ultimo se genero el frontend en una ultima rama.

Se hizo una rama release desde develop con todas las ramas anteriormente mencionadas ya mergeadas en develop. En ella se modifico el pom.xml y el package.json para agregar que version es y se corroboro que todo funcione corriendo los comandos:
en /backend: .\mvnw.cmd verify
en /frontend: npm run lint y npm run build
ambos dieron exito por lo que procedimos a hacer algunas pruebas manuales y funciona todo como se esperaba. Por lo que podemos hacer el pr de la release a master y luego a develop para continuar con la V2.
Para hacer el PR de release a master por consola como solicita el enunciado, se utiliza el siguiente comando:
gh pr create --base master --head release/1.0.0 --title "Release 1.0.0" --body "Lleva la versión 1.0.0 a producción: suma, resta y pantalla de la calculadora."
lo mismo par actualizar develop
gh pr create --base develop --head release/1.0.0 --title "Merge release/1.0.0 en develop" --body "Integra a develop los cambios de la release 1.0.0."

## Notas importanes
Hubo un error en el commit a6efb9a en el nombre dice que es el hotfix 1.0.1, cuadno deberia decir 0.1.1, solucionarlo suponia vovler a ese commit y hacer la modificacion del titulo pero dado que estabamos probando y es un error que todo el equipo vio tarde, se lo deja como esta y se lo aclara aca.

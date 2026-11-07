- Diseño de Software - Módulo 2
- Ejercitación 2.2
Ejercicio 6: Configuración General de un Hospital
Contexto del problema:
Un hospital utiliza una aplicación administrativa con módulos de recepción y consultorios. Ambos necesitan consultar el nombre de la institución, el horario de atención y la duración predeterminada de los turnos. Las configuraciones independientes provocan diferencias entre las pantallas.

Objetivo de aprendizaje:
Aplicar Singleton con inicialización diferida para compartir parámetros generales de una aplicación.

Requisitos funcionales:

Consultar y modificar el nombre del hospital, el horario de apertura y cierre y la duración de los turnos.

Acceder a los parámetros desde recepción y consultorios.

Reflejar los cambios inmediatamente en ambos módulos.

Restricciones técnicas:

La instancia debe crearse únicamente cuando se solicite por primera vez.

La clase debe impedir su instanciación directa desde los módulos.

La duración de los turnos debe ser positiva y el horario de cierre posterior al de apertura.

Se debe demostrar que las consultas posteriores no construyen nuevas instancias.
***
# Lógica y Funcionamiento del Programa:
    Para este ejercicio apliqué el patrón Singleton con inicialización diferida (Lazy Initialization) para asegurar que toda la configuración del hospital se centralice en un solo lugar y se cargue en memoria recién cuando un módulo lo solicite.

- Clase ConfiguracionHospital: Se diseñó con un constructor privado para evitar que desde cualquier otra clase se pueda usar new. El método estático getInstancia() es el encargado de verificar si la variable instancia es nula; si lo es, crea el objeto, de lo contrario devuelve el que ya existe. Para manejar las reglas de negocio sobre el tiempo utilicé la clase LocalTime, lo que me permitió usar el método .isAfter() en los setters para evitar que el horario de cierre sea anterior al de apertura. También agregué validaciones simples para que la duración de los turnos no pueda ser un número negativo ni el nombre quede vacío.

- Clase Main: En la prueba simulé los módulos instanciando las variables recepcion y consultorios. Hice una validación con un if (recepcion == consultorios) para comprobar que ambas variables apuntan exactamente al mismo espacio en memoria (son la misma instancia). Luego, alteré los datos desde la recepción (incluyendo valores inválidos para ver cómo los filtraban los setters) y, al consultar desde los consultorios, los datos impresos en consola reflejaron los cambios correctos y actualizados al instante.
***
# Ejecucion por consola
![Captura de pantalla 2026-11-07 121344.png](Captura%20de%20pantalla%202026-11-07%20121344.png)
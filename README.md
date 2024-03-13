## CRUD en Java

Diseño y desarrollo de un programa en Java que implemente un CRUD (Create, Read, Update, Delete) para gestionar los datos de alumnos. El programa utiliza la biblioteca Swing para la interfaz gráfica y almacena los datos en un archivo de texto.

El programa tiene las siguientes funcionalidades:

1.	Crear un nuevo alumno: El usuario podrá ingresar el nombre, apellido, email, DNI del alumno a través de campos de texto en la interfaz gráfica.

Al seleccionar la opción "Agregar", se crea un nuevo objeto Alumno con los datos ingresados y se guardarán en el archivo de texto.

2.	Mostrar lista de alumnos: Al seleccionar una opción en un menú, se deberá mostrar la lista de alumnos existentes. Cada fila representará a un alumno y mostrará su nombre, apellido, email, DNI y comisión.

3.	Actualizar información del alumno: El usuario puede indicar que numero de registro que quiere modificar y los datos que se modificaran. Al seleccionar la opción  "Actualizar", se guardan los cambios realizados en el archivo de texto.

4.	Eliminar alumno: El usuario indicar que numero de registro eliminar y al seleccionar la opción "Eliminar", se elimina el alumno del archivo de texto y se muestra la lista de alumnos actualizada

5.	Buscar alumno: Se proporciona un campo de texto donde el usuario puede ingresar el nombre o DNI de un alumno para buscarlo en la lista. Al seleccionar la opcion "Buscar", se mostrarán los alumnos que coincidan con el criterio de búsqueda.

El programa valida la entrada de datos para asegurar que se ingresen valores válidos y proporcionar mensajes de error cuando corresponda.

Código en clases y métodos apropiados para mantener una estructura clara y código legible. También, se manejan las excepciones que puedan ocurrir al leer y escribir en el archivo de texto.

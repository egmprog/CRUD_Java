package Principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Comentarios de documentación
 * Título del programa
 * 
 * @autor: Grupo 1
 * @version 1.5.
 */

public class Main {
    // MAIN
    public static void main(String[] args) {

        // declaración de variables

        String nombre = "", apellido = "", email = "";
        int menu = 0, dni = 0, comision = 0;
        ArrayList<Alumno> listaDeAlumnos = new ArrayList<Alumno>();
        GestionAlumno miGestion = new GestionAlumno();

        // menu principal de opciones

        while (menu != 6) {
            menu = Integer.parseInt(JOptionPane.showInputDialog("     MENU PRINCIPAL    " + "\n" +
                    "1.- Ingresar Alumno" + "\n" +
                    "2.- Listar Alumno " + "\n" +
                    "3.- Quitar Alumno " + "\n" +
                    "4.- Modificar Alumnos " + "\n" +
                    "5.- Buscar Alumnos " + "\n" +
                    "6.- Salir"));

            switch (menu) {
                case 1:
                    // Sub menu ingresar alumno

                    // para cargar los datos se recurre al método addAlumno de la clase
                    // GestionAlumno.java
                    miGestion.addAlumno(nombre, apellido, email, dni, comision);
                    break;
                case 2:
                    // Sub menu listar alumno
                    // para listar los datos se recurre al método listarAlumno de la clase
                    // GestionAlumno.java

                    miGestion.listarAlumno();
                    break;
                case 3:
                    // Sub menu quitar alumno
                    // para eliminar los datos se recurre al método eliminarAlumno de la clase
                    // GestionAlumno.java

                    miGestion.eliminarAlumno();
                    break;
                case 4:
                    // Sub menu modificar alumno
                    // para modificar los datos se recurre al método modificarAlumno de la clase
                    // GestionAlumno.java

                    System.out.println(listaDeAlumnos);

                    // Mostrar el contenido en una ventana emergente con indicaciones del
                    // procedimiento
                    JOptionPane.showMessageDialog(null, "Para modificar un registro:    " + "\n"
                            +
                            "1.- Se despliega una lista de los registros" + "\n" +
                            "2.- Se elimina el registro por modificar" + "\n" +
                            "3.- Se ingresa nuevamente los nuevos datos" + "\n",
                            "Procedimiento para modificar un registro", JOptionPane.ERROR_MESSAGE);

                    miGestion.eliminarAlumno();
                    miGestion.addAlumno(nombre, apellido, email, dni, comision);

                    break;
                case 5:
                    // Sub menu buscar alumno
                    // para buscar los datos se recurre al método buscarAlumno de la clase
                    // GestionAlumno

                    miGestion.buscarAlumno();
                    break;
                case 6:
                    // Sub menú salida
                    JOptionPane.showMessageDialog(null, "Fin del programa", "Aviso", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}

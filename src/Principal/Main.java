package Principal;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

        // Crear un panel personalizado para incluir la imagen y el mensaje
        JPanel panel = new JPanel();
        ImageIcon icon = new ImageIcon("..\\TF_CaCinicial_v02\\src\\Principal\\logo.png");
        JLabel label = new JLabel("SISTEMA DE GESTIÓN DE ALUMNOS", icon, JLabel.CENTER);
        panel.add(label);
        
        //pantalla inicial de bienvenida
        JOptionPane.showMessageDialog(null, panel, "B i e n v e n i d o s", JOptionPane.PLAIN_MESSAGE);
                
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
                    
                    miGestion.modificarAlumno();
                    
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

package Principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestionArchivo {
   
    private static final String FILE_PATH = "alumnos.txt";
    

    public void altaAlumno(String nombre, String apellido, int dni, String email, int comision) {
          try (BufferedWriter buffer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {               
               buffer.write(nombre + ", " + apellido + ", " + dni + ", "+email+", "+comision);
               buffer.newLine();
          } catch (IOException e) {
               System.out.println("No se pudo grabar en el archivo" + e.getMessage());
          }
     }
     
}

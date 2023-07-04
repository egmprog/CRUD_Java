package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     
     // Leer el archivo de texto y almacenar los datos en una estructura de datos
        

        public List<Alumno> leerArchivo(String nombre, String apellido,int dni,String email,int comision){
          ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea + "\n");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
     return null;
     }
}

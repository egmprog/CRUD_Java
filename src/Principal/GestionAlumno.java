package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestionAlumno {

    ArrayList<Alumno> listaDeAlumnos;
    GestionArchivo miArchivo = new GestionArchivo();

    // método para escribir los datos ingresados por teclado en un arryList
    public GestionAlumno(ArrayList<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = new ArrayList<>();
        this.listaDeAlumnos = listaDeAlumnos;

    }

    public GestionAlumno() {
        this.listaDeAlumnos = new ArrayList<>();
    }

    // --------------------------------------------------------------------------------------------------
    // método para AGREGAR alumno
    public void addAlumno(String nombre, String apellido, String email, int dni, int comision) {

        // cargar y validar appellidos y nombres
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
        if (nombre.length() > 1 && nombre.length() < 61) {
        } else {
            JOptionPane.showMessageDialog(null, "El nombre no es válido  (entre 1 y 60 caracteres)",
                    "Error en la carga", JOptionPane.ERROR_MESSAGE);
        }

        apellido = JOptionPane.showInputDialog("Ingrese el apellido del alumno");
        if (apellido.length() > 1 && apellido.length() < 61) {
        } else {
            JOptionPane.showMessageDialog(null, "El apellido no es válido  (entre 1 y 60 caracteres)",
                    "Error en la carga", JOptionPane.ERROR_MESSAGE);
        }
        // cargar y validar DNI
        // en este caso try + catch se usa para evitar que el programa se rompa si no se
        // ingresan números
        try {
            dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del alumno"));

            // Validacion del dni (número de 8 dígitos)
            DniValidator verificadorDni = new DniValidator();
            int digitosCuenta = 8;
            if (verificadorDni.validacionDni(dni, digitosCuenta)) {
                System.out.println("El DNI tiene la cantidad correcta de dígitos.");
            } else {
                System.out.println("El DNI no tiene la cantidad correcta de dígitos.");
                JOptionPane.showMessageDialog(null, "El DNI no es válido  (Número de 8 dígitos)", "Error en la carga",
                        JOptionPane.ERROR_MESSAGE);
                dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente el DNI"));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El DNI no es válido. Debe ingresar número de 8 dígitos",
                    "Error en la carga", JOptionPane.ERROR_MESSAGE);
            dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente el DNI"));
            // aquí hay un problema... si el ingreso del dni es por esta línea... no se
            // realiza la verificación del formato de 8 dígitos...
        }

        // cargar y verificar email
        email = JOptionPane.showInputDialog("Ingrese el correo electrónico del alumno");

        // validación del email (formato de mail valido, texto alfanum, arroba, texto
        // alfanum, punto, tres letras)
        EmailValidator validator = new EmailValidator();
        if (validator.validateEmail(email)) {
            System.out.println("La dirección de correo electrónico es válida.");
        } else {
            System.out.println("La dirección de correo electrónico no es válida.");
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido", "Error en la carga",
                    JOptionPane.ERROR_MESSAGE);
            email = JOptionPane.showInputDialog("Ingrese nuevamente el correo electrónico del alumno");
        }

        // cargar y validar comisión
        // en este caso try + catch se usa para evitar que el programa se rompa si no se
        // ingresan números
        try {
            comision = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la comision"));

            // Validacion de la comision (número de 5 dígitos)
            ComisionValidator verificadorCom = new ComisionValidator();
            int digitosCuentaC = 5;
            if (verificadorCom.validacionComision(comision, digitosCuentaC)) {
                System.out.println("La Comisión es correcta.");
            } else {
                System.out.println("La Comisión ingresada NO es correcta.");
                JOptionPane.showMessageDialog(null, "La comisión ingresada es inválida (Número de 5 dígitos)",
                        "Error en la carga", JOptionPane.ERROR_MESSAGE);
                comision = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente la comision"));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La comisión ingresada es inválida Ingrese un número de 5 dígitos)",
                    "Error en la carga", JOptionPane.ERROR_MESSAGE);
            comision = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente la comisión"));
            // aquí hay un problema... si el ingreso de la comision es por esta línea... no
            // se realiza la verificación del formato de 5 dígitos...
        }

        // se escriben los datos ingresados en el arryList
        listaDeAlumnos.add(new Alumno(nombre, apellido, dni, email, comision));
        System.out.println(listaDeAlumnos);
        // se vuelcan los datos ingresados en el archivo de texto (utilizando la clase
        // GestionArchivo.java)
        miArchivo.altaAlumno(nombre, apellido, dni, email, comision);

    }

    // --------------------------------------------------------------------------------------------------
    // método para LISTAR alumnos
    public void listarAlumno() {
        // Leer el archivo de texto y almacenar los datos en una estructura de datos
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
            return;
        }

        System.out.println(lineas);

        // mostrar el listado en una ventana emergente, con cada línea enumerada en forma sucesiva.
        // Crear una cadena con el contenido del ArrayList

        StringBuilder contenido = new StringBuilder();
        int a=0;
        for (String elemento : lineas) {

            contenido.append(a+"- "+elemento).append("\n");
            a++;
        }

        // Mostrar el contenido en una ventana emergente
        JOptionPane.showMessageDialog(null, contenido.toString(), "Listado de alumnos cargados",
                JOptionPane.INFORMATION_MESSAGE);

    }

    // --------------------------------------------------------------------------------------------------
    // método para MODIFICAR alumno
        public void modificarAlumno() {
        // Leer el archivo de texto y almacenar los datos en una estructura de datos
        ArrayList<String> lineas3 = new ArrayList<>();
        try {
            BufferedReader br3 = new BufferedReader(new FileReader("alumnos.txt"));
            String linea3;

            while ((linea3 = br3.readLine()) != null) {
                lineas3.add(linea3 + "\n");
            }

            br3.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // se define una variable booleana para manejar el hallazgo de la busqueda
        boolean encontrado = false;

        // ingreso el término a buscar
        String aBuscar;
        aBuscar = JOptionPane.showInputDialog("Ingrese el nombre o apellido o email o DNI a buscar");

        // recorro el arrayList identificando lineas
        for (int a = 0; a < lineas3.size(); a++) {
            //System.out.println("Linea: " + a + " - " + lineas3.get(a));

            // transformo el contenido de 'linea3' en una secuencia de elementos
            String oracion = lineas3.get(a).toString();
            //se borran los espacios en blanco
            oracion = oracion.replaceAll(" ", "");

            // separo los elementos de la cadena en elementos individuales para buscarlos,
            // ubicandolos dentro de un arrayList
            String[] terminos = oracion.split(",");
            System.out.println("terminos: "+terminos);
            System.out.println("oracion: "+oracion);

            // vuelvo a false el elemento de busqueda antes de cada ciclo
            encontrado = false;

            // comparo el término de búsqueda con los elementos del arrayList anterior
            
            for(int b=0; b<=4;b++){
                if(terminos[b].equals(aBuscar)){
                    encontrado=true;
                    System.out.println("terminos ["+b+"] "+terminos[b]);
                    System.out.println("encontrado "+encontrado);
                }
                    
                    // si el elemento buscado se encuentra: se notifica, se muestra el registro completo.
                    // Luego se sigue recorriendo otros registros buscando nuevas coincidencias.
            
                if (encontrado) {
                    System.out.println("El término " + aBuscar + " se ha encontrado");
                    JOptionPane.showMessageDialog(null, "El término " + aBuscar + " se ha encontrado", "Fin de la búsqueda",
                            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Los datos del registro son " + "\n" + "(El número inicial es el «registro»)" + "\n"+a+"- "+ lineas3.get(a),
                            "Fin de la búsqueda",
                            JOptionPane.INFORMATION_MESSAGE);

                    //ingreso del texto que a modificar 
                    String loNuevo=JOptionPane.showInputDialog("Aquí se puede modificar el elemento encontrado «"+aBuscar+"» por uno nuevo");
                    //System.out.println(lineas3);
                    
                    //System.out.println("terminos antes "+terminos[b]);
                    //se reemplaza el término hallado por su nuevo valor
                    terminos[b] = loNuevo;
                    //System.out.println("terminos despues "+terminos[b]);
                    //System.out.println("lonuevo "+loNuevo);
                    //se agrega la nueva linea modificada al arrayList para guardarlo en el archivo
                    lineas3.set(a, String.join(",", terminos));

                    System.out.println(lineas3);

                    
                    }
                    break;
            }
            

        }
        // Si se completó toda la busqueda sin ninguna coincidencia, se muestra un
        // mensaje
        if (encontrado) {

        } 
        else {
            JOptionPane.showMessageDialog(null, "El término " + aBuscar + " NO se ha encontrado", "Fin de la búsqueda",
                    JOptionPane.ERROR_MESSAGE);
        }

            // Escribir las líneas restantes de vuelta al archivo de texto
            try {
                BufferedWriter bw3 = new BufferedWriter(new FileWriter("alumnos.txt"));

                for (String linea : lineas3) {
                    bw3.write(linea);
                }

                bw3.close();

                System.out.println("La línea ha sido modificada en el archivo.");
                JOptionPane.showMessageDialog(null, "La linea ha sido modificada en el archivo.", "Acción realizada",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            //}
        }

    }


    // --------------------------------------------------------------------------------------------------
    // método para BUSCAR alumno

    private void set(int a, String loNuevo) {
        }

    public void buscarAlumno() {
        // Leer el archivo de texto y almacenar los datos en una estructura de datos
        ArrayList<String> lineas3 = new ArrayList<>();
        try {
            BufferedReader br3 = new BufferedReader(new FileReader("alumnos.txt"));
            String linea3;

            while ((linea3 = br3.readLine()) != null) {
                lineas3.add(linea3 + "\n");
            }

            br3.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // se define una variable booleana para manejar el hallazgo de la busqueda
        boolean encontrado = false;

        // ingreso el término a buscar
        String aBuscar;
        aBuscar = JOptionPane.showInputDialog("Ingrese el nombre o apellido o email o DNI a buscar");

        // recorro el arroyList identificando lineas
        for (int a = 0; a < lineas3.size(); a++) {
            System.out.println("Linea: " + a + " - " + lineas3.get(a));

            // transformo el contenido de 'linea3' en una secuencia de elementos
            String oracion = lineas3.get(a).toString();
            //se borran los espacios en blanco
            oracion = oracion.replaceAll(" ", "");

            // separo los elementos de la cadena en elementos individuales para buscarlos,
            // ubicandolos dentro de un arrayList
            String[] terminos = oracion.split(",");

            // vuelvo a false el elemento de busqueda antes de cada ciclo
            encontrado = false;

            // comparo el término de búsqueda con los elementos del arrayList anterior
            for (String elemento : terminos) {
                if (elemento.equals(aBuscar)) {
                    encontrado = true;
                }
            }
            // si el elemento buscado se encuentra: se notifica, se muestra el registro
            // completo. Luego se sigue recorriendo otros registros buscando nuevas
            // coincidencias
            if (encontrado) {
                System.out.println("El término " + aBuscar + " se ha encontrado");
                JOptionPane.showMessageDialog(null, "El término " + aBuscar + " se ha encontrado", "Fin de la búsqueda",
                        JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Los datos del registro son " + "\n" + "(El número inicial es el «registro»)" + "\n"+a+"- "+ lineas3.get(a),
                        "Fin de la búsqueda",
                        JOptionPane.ERROR_MESSAGE);

            }

        }
        // Si se completó toda la busqueda sin ninguna coincidencia, se muestra un
        // mensaje
        if (encontrado) {

        } else {
            JOptionPane.showMessageDialog(null, "El término " + aBuscar + " NO se ha encontrado", "Fin de la búsqueda",
                    JOptionPane.ERROR_MESSAGE);
        }

        
    }

    // --------------------------------------------------------------------------------------------------
    // método para ELIMINAR alumno
    public void eliminarAlumno() {

        // definición de un arrayList
        ArrayList<String> lineas2 = new ArrayList<>();

        // Leer el archivo de texto y almacenar los datos en una estructura de datos
        // dentro del arryList creado lineas2

        try {
            BufferedReader br2 = new BufferedReader(new FileReader("alumnos.txt"));
            String linea2;

            while ((linea2 = br2.readLine()) != null) {
                lineas2.add(linea2 + "\n");
            }

            br2.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(lineas2);

        // mostrar el listado en una ventana emergente
        // Crear una cadena con el contenido del ArrayList
        int b=0;
        StringBuilder contenido2 = new StringBuilder();
        for (String elemento2 : lineas2) {
            contenido2.append(b+"- "+elemento2).append("\n");
            b++;
        }

        // Ventana emergente que muestra los registros actuales del archivo de texto
        JOptionPane.showMessageDialog(null,
                "Para eliminar un registro, fíjese el número de línea que ocupa" + "\n" + contenido2.toString(),
                "Listado de alumnos cargados", JOptionPane.INFORMATION_MESSAGE);

        // indicar el número de línea a eliminar
        int lineaE;
        lineaE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de registro (línea) a eliminar"));

        // Verificar si el número de línea a eliminar es válido
        if (lineaE >= 0 && lineaE < lineas2.size()) {
            // Eliminar la línea de la estructura de datos
            lineas2.remove(lineaE);

            // Escribir las líneas restantes de vuelta al archivo de texto
            try {
                BufferedWriter bw2 = new BufferedWriter(new FileWriter("alumnos.txt"));

                for (String linea : lineas2) {
                    bw2.write(linea);
                }

                bw2.close();

                System.out.println("La línea ha sido eliminada del archivo.");
                JOptionPane.showMessageDialog(null, "La l\u00EDnea ha sido eliminada del archivo.", "Acción realizada",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El número de línea a eliminar es inválido.");
            JOptionPane.showMessageDialog(null, "El número de registro a eliminar es inválido", "Error en la carga",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}

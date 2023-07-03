package Principal;

public class Alumno {
    // atributos
    private String nombre;
    private String apellido;
    private Integer dni;
    private String email;
    private Integer comision;

    // constructor
    public Alumno(String nombre, String apellido, Integer dni, String email, Integer comision) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.comision = comision;
    }

    // métodos get y set

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return this.dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getComision() {
        return this.comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    // metodo to String

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", apellido='" + getApellido() + "'" +
                ", dni='" + getDni() + "'" +
                ", email='" + getEmail() + "'" +
                ", comision='" + getComision() + "'" +
                "}";
    }

}

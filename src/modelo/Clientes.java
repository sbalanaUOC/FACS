
package modelo;

public class Clientes {

    //  Atributos 
    private String email;     
    private String nombre;
    private String domicilio;
    private String nif;

    //  Constructores 
    public Clientes() { // constructor vacío 
    }

    public Clientes(String email, String nombre, String domicilio, String nif) {
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
    }

    //  Getters y Setters 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    //  toString 
    @Override
    public String toString() {
        return "Clientes{" +
            "email='" + email + '\'' +
            ", nombre='" + nombre + '\'' +
            ", domicilio='" + domicilio + '\'' +
            ", nif='" + nif + '\'' +
            '}';
    }
}
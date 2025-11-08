package modelo;

public class Cliente {

    //  Atributos 
    private String email;
    private String nombre;
    private String domicilio;
    private String nif;
    private Integer tipo;

    //  Constructores 
    public Cliente() { // constructor vacío
    }


    public Cliente(String email, String nombre, String domicilio, String nif, Integer tipo) {
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.tipo =tipo;
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

    public Integer getTipo() {return tipo;}
    public void setTipo(Integer tipo) {this.tipo = tipo;}





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
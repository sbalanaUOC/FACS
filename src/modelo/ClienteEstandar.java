package modelo;

public class ClienteEstandar extends Cliente {

    public ClienteEstandar() {
        super();
    }

    public ClienteEstandar(String email, String nombre, String domicilio, String nif,Integer tipo) {
        super(email, nombre, domicilio, nif,tipo);
    }

  //  @Override
  //  public String toString() {
  //      return "ClienteEstandar{" + super.toString() + "}";
  //  }
}

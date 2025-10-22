package modelo;

public class ClienteEstandar extends Cliente {

    public ClienteEstandar() {
        super();
    }

    public ClienteEstandar(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
    }

    public float calcularDescuentoEnvio(float gastosEnvio) {
        return 0.0f;
    }

    @Override
    public String toString() {
        return "ClienteEstandar{" + super.toString() + "}";
    }
}

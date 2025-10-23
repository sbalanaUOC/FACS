package modelo;


public class ClientePremium extends Cliente {

    private float cuota;        // a 30.0 €
    private float descuento;    // al 0.20 (20% sobre gastos de envío)

  // public ClientePremium() {
  //      super();
  //      this.cuota = 30.0f;
  //      this.descuento = 0.20f;
  //  }

    public ClientePremium(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
        this.cuota = 30.0f;
        this.descuento = 0.20f;
    }

    public ClientePremium(String email, String nombre, String domicilio, String nif,
                        float cuota, float descuento) {
        super(email, nombre, domicilio, nif);
        this.cuota = cuota;
        this.descuento = descuento;
    }

    // Getters & Setters
    public float getCuota() { return cuota; }
    public void setCuota(float cuota) { this.cuota = cuota; }

    public float getDescuento() { return descuento; }
    public void setDescuento(float descuento) { this.descuento = descuento; }

    public float calcularDescuentoEnvio(float gastosEnvio) {
        return gastosEnvio * descuento;
    }

  //  @Override
  //  public String toString() {
  //      return "ClientePremium{" +
  //              "cuota=" + cuota +
  //              ", descuento=" + descuento +
  //              ", " + super.toString() +
  //              '}';
  //  }
}

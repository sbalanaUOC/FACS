package modelo;

import java.time.LocalDateTime;

public class Tablapedido {

    private int numpedido;
    private String nombrecliente;
    private String nombrearticulo;
    private int cantidad;
    private String fecha;
    private String estado;




    public Tablapedido( Integer numeropedido,
                   String nombrecliente, String nombrearticulo , int cantidad, String fecha, String estado) {
        this.numpedido = numeropedido;            //automatico
        this.nombrecliente = nombrecliente;
        this.nombrearticulo = nombrearticulo;
        this.cantidad = cantidad;
        this.fecha = fecha;       //automatico
        this.estado = estado;   //automatico
    }

    public int getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(int numpedido) {
        this.numpedido = numpedido;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}

package Caso;

public class Distribuidor extends Thread {
    private Tipo_Producto tipo_Producto;
    private Buffer depositoDistribucion;

    public enum Tipo_Producto {
        A, B, FIN_A, FIN_B
    }

    public Distribuidor(Tipo_Producto producto, Buffer depositoDistribucion) {
        this.tipo_Producto = producto;
        this.depositoDistribucion = depositoDistribucion;
    }

    public Tipo_Producto getTipo_Producto() {
        return tipo_Producto;
    }

    public void setTipo_Producto(Tipo_Producto producto) {
        this.tipo_Producto = producto;
    }

    public Buffer getDepositoDistribucion() {
        return depositoDistribucion;
    }

    public void setDepositoDistribucion(Buffer depositoDistribucion) {
        this.depositoDistribucion = depositoDistribucion;
    }
}
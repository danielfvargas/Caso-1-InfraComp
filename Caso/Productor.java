package Caso;

public class Productor {
    private Tipo_Producto tipo_Producto;
    private int numProductos;
    private Buffer depositoProduccion;

    public enum Tipo_Producto{
        A, B
    }

    public Productor(Tipo_Producto tipo_Producto, int numProductos, Buffer depositoProduccion) {
        this.tipo_Producto = tipo_Producto;
        this.numProductos = numProductos;
        this.depositoProduccion = depositoProduccion;
    }

    public Tipo_Producto getTipo_Producto() {
        return tipo_Producto;
    }

    public void setTipo_Producto(Tipo_Producto tipo_Producto) {
        this.tipo_Producto = tipo_Producto;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public Buffer getDepositoProduccion() {
        return depositoProduccion;
    }

    public void setDepositoProduccion(Buffer depositoProduccion) {
        this.depositoProduccion = depositoProduccion;
    }
 
}
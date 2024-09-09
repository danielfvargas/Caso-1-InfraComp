package Caso;
import Caso.Producto.Tipo;

class Productor extends Thread {
    private Buffer buffer;
    private Tipo tipoProducto;
    private int numProductos;

    public Productor(Tipo tipoProducto, int numProductos, Buffer buffer) {
        this.buffer = buffer;
        this.tipoProducto = tipoProducto;
        this.numProductos = numProductos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numProductos; i++) {
                Producto producto = new Producto(tipoProducto); 
                buffer.almacenar(producto);
            }
            Producto productoFin = new Producto(tipoProducto == Producto.Tipo.A ? Producto.Tipo.FIN_A : Producto.Tipo.FIN_B);
            buffer.almacenar(productoFin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
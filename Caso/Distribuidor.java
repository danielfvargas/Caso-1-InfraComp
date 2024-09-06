package Caso;

public class Distribuidor extends Thread {
    private Producto Tipo_producto;
    private Buffer depositoDistribucion;

    public enum Producto {
        A, B, FIN_A, FIN_B
    }

    public Distribuidor(Producto producto, Buffer depositoDistribucion) {
        this.Tipo_producto = producto;
        this.depositoDistribucion = depositoDistribucion;
    }

    @Override
    public void run() {
        try {
            while (true) {
                depositoDistribucion.retirarProducto();
                System.out.println("Distribuidor de producto " + Tipo_producto + " retiró un producto.");

                if (Tipo_producto == Producto.FIN_A || Tipo_producto == Producto.FIN_B) {
                    System.out.println("Distribuidor de " + Tipo_producto + " ha terminado.");
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Distribuidor ha sido interrumpido.");
        }
    }

    public Producto getTipo_producto() {
        return Tipo_producto;
    }

    public void setTipo_producto(Producto producto) {
        this.Tipo_producto = producto;
    }
}

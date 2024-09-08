package Caso;
import Caso.Producto.Tipo;

class Distribuidor extends Thread {
    private Buffer buffer;
    private Tipo tipoDistribuidor;
    private boolean finaliza = false;

    public Distribuidor(Tipo tipoDistribuidor, Buffer buffer) {
        this.buffer = buffer;
        this.tipoDistribuidor = tipoDistribuidor;
    }

    @Override
    public void run() {
        try {
            while (!finaliza) {
                synchronized (buffer) {
                    if (buffer.productos.isEmpty()) {
                        buffer.wait(); // Espera si el buffer está vacío
                    } else {
                        Producto primerProducto = buffer.productos.peek(); // Obtiene el primer producto del buffer
                        if ((tipoDistribuidor == Producto.Tipo.A && (primerProducto.getTipo() == Producto.Tipo.A || primerProducto.getTipo() == Producto.Tipo.FIN_A)) ||
                            (tipoDistribuidor == Producto.Tipo.B && (primerProducto.getTipo() == Producto.Tipo.B || primerProducto.getTipo() == Producto.Tipo.FIN_B))) {
                            
                            Producto producto = buffer.retirar();  // Retira el producto del buffer
                            buffer.notifyAll(); // Notifica a los hilos en espera
    
                            if (producto.getTipo() == Producto.Tipo.FIN_A || producto.getTipo() == Producto.Tipo.FIN_B) {
                                finaliza = true; // Finaliza si se retira el producot final
                            }
                        } else {
                            buffer.wait(); // Espera si el producto no es del tipo del distribuidor
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public boolean isFinaliza() {
        return finaliza;
    }

    public void setFinaliza(boolean finaliza) {
        this.finaliza = finaliza;
    }
}


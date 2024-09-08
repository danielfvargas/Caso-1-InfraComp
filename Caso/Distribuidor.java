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
                        buffer.wait(); 
                    } else {
                        Producto primerProducto = buffer.productos.peek();
                        if ((tipoDistribuidor == Producto.Tipo.A && (primerProducto.getTipo() == Producto.Tipo.A || primerProducto.getTipo() == Producto.Tipo.FIN_A)) ||
                            (tipoDistribuidor == Producto.Tipo.B && (primerProducto.getTipo() == Producto.Tipo.B || primerProducto.getTipo() == Producto.Tipo.FIN_B))) {
                            
                            Producto producto = buffer.retirar(); 
                            buffer.notifyAll(); 
    
                            if (producto.getTipo() == Producto.Tipo.FIN_A || producto.getTipo() == Producto.Tipo.FIN_B) {
                                finaliza = true;
                            }
                        } else {
                            buffer.wait();
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


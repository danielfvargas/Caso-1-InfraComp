package Caso;
import Caso.Producto.Tipo;

class Distribuidor implements Runnable {
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
                Producto producto = buffer.retirar();

                if ((tipoDistribuidor == Producto.Tipo.A && (producto.getTipo() == Producto.Tipo.A || producto.getTipo() == Producto.Tipo.FIN_A)) ||
                    (tipoDistribuidor == Producto.Tipo.B && (producto.getTipo() == Producto.Tipo.B || producto.getTipo() == Producto.Tipo.FIN_B))) {
                    if (producto.getTipo() == Producto.Tipo.FIN_A || producto.getTipo() == Producto.Tipo.FIN_B) {
                        finaliza = true;
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

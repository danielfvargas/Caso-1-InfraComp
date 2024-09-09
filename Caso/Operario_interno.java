package Caso;

class Operario_interno extends Thread {
    private Buffer bufferInicio;
    private Buffer bufferFin;
    private boolean finaliza = false;

    public Operario_interno(Buffer bufferInicio, Buffer bufferFin) {
        this.bufferInicio = bufferInicio;
        this.bufferFin = bufferFin;
    }

    @Override
    public void run() {
        try {
            int contadorFin = 0;
            while (!finaliza) { 
                Producto producto = bufferInicio.retirar();
                bufferFin.almacenar(producto);
                if (producto.getTipo() == Producto.Tipo.FIN_A || producto.getTipo() == Producto.Tipo.FIN_B) {
                    contadorFin++;
                    if (contadorFin == 4){
                        finaliza = true;
                    }
                } else {
                Thread.yield();  
                }
            }
        }
            catch (Exception e) {
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

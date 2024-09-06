package Caso;

public class Buffer {

    public enum Especial {
        DEPOSITO_PRODUCCION, DEPOSITO_DISTRIBUCION, CINTA_TRANSPORTADORA
    }

    private int capacidad;
    private Especial especializacion;
    private int productosActuales = 0;

    public Buffer(int capacidad, Especial especializacion) {
        this.capacidad = capacidad;
        this.especializacion = especializacion;
    }


    public synchronized void retirarProducto() throws InterruptedException {
        while (productosActuales == 0) {
            wait();
        }
        productosActuales--;
        notifyAll(); 
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Especial getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especial especializacion) {
        this.especializacion = especializacion;
    }

    public synchronized void almacenar(int cantidad) {
        try {
            while (cantidad == capacidad) {
                wait();
            }
            cantidad++;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void retirar(int cantidad) {
        try {
            while (cantidad == 0) {
                wait(); 
            }
            cantidad--;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Caso;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    public enum Especial {
        DEPOSITO_PRODUCCION, DEPOSITO_DISTRIBUCION, CINTA_TRANSPORTADORA
    }
    
    public Queue<Producto> productos;
    private int capacidad;
    private Especial especializacion; 
    
    public Buffer(int capacidad, Especial especializacion) {
        this.capacidad = capacidad;
        this.especializacion = especializacion;
        this.productos = new LinkedList<>();
    }
    public synchronized void almacenar(Producto producto) {
        try {
            while (productos.size() == capacidad) {
                wait();
            }
            productos.add(producto);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Producto retirar() {
        try {
            while (productos.isEmpty()) {
                wait();
            }
            Producto producto = productos.poll();
            notifyAll();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Especial getEspecializacion() {
        return especializacion;
    }

    public Queue<Producto> getProductos(){
        return productos;
    }
}
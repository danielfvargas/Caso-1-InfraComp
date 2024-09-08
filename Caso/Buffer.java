package Caso;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    public enum Especial {
        DEPOSITO_PRODUCCION, DEPOSITO_DISTRIBUCION, CINTA_TRANSPORTADORA
    }
    
    private Queue<Producto> productos;
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
                System.out.println(especializacion + " lleno. Esperando para almacenar...");
                wait();
            }
            productos.add(producto);
            System.out.println("Producto " + producto.getTipo() + " almacenado en " + especializacion + ". Total: " + productos.size());
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Producto retirar() {
        try {
            while (productos.isEmpty()) {
                System.out.println(especializacion + " vacío. Esperando para retirar...");
                wait();
            }
            Producto producto = productos.poll();
            System.out.println("Producto " + producto.getTipo() + " retirado de " + especializacion + ". Total: " + productos.size());
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
}
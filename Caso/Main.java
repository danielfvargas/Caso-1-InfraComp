package Caso;

import java.util.Scanner;
import Caso.Buffer.Especial;
import Caso.Producto.Tipo;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese la capacidad del depósito de producción:");
            int capDepProd = scanner.nextInt();

            System.out.println("Ingrese la capacidad del depósito de distribución:");
            int capDepDist = scanner.nextInt();

            if (capDepProd <= 0 || capDepDist <= 0) {
                throw new IllegalArgumentException("Capacidad de los depósitos debe ser positiva");
            }

            System.out.println("Ingrese el número de productos que cada productor generará:");
            int numProductos = scanner.nextInt();
            
            Buffer deposito_produccion = new Buffer(capDepProd, Especial.DEPOSITO_PRODUCCION);
            Buffer cinta_transportadora = new Buffer(1, Especial.CINTA_TRANSPORTADORA);
            Buffer deposito_distribucion = new Buffer(capDepDist, Especial.DEPOSITO_DISTRIBUCION);

            Distribuidor distribuidor_a1 = new Distribuidor(Tipo.A, deposito_distribucion);
            Distribuidor distribuidor_a2 = new Distribuidor(Tipo.A, deposito_distribucion);
            Distribuidor distribuidor_b1 = new Distribuidor(Tipo.B, deposito_distribucion);
            Distribuidor distribuidor_b2 = new Distribuidor(Tipo.B, deposito_distribucion);

            Operario_interno opin_Dprod_cinta = new Operario_interno(deposito_produccion, cinta_transportadora);
            Operario_interno opin_cinta_Ddis = new Operario_interno(cinta_transportadora, deposito_distribucion);

            Productor productor_a1 = new Productor(Tipo.A, numProductos, deposito_produccion);
            Productor productor_a2 = new Productor(Tipo.A, numProductos, deposito_produccion);
            Productor productor_b1 = new Productor(Tipo.B, numProductos, deposito_produccion);
            Productor productor_b2 = new Productor(Tipo.B, numProductos, deposito_produccion);

            Thread[] threads = new Thread[] {
                new Thread(productor_a1),
                new Thread(productor_a2),
                new Thread(productor_b1),
                new Thread(productor_b2),
                new Thread(distribuidor_a1),
                new Thread(distribuidor_a2),
                new Thread(distribuidor_b1),
                new Thread(distribuidor_b2),
                new Thread(opin_Dprod_cinta),
                new Thread(opin_cinta_Ddis)
            };

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Todos los hilos han terminado. El programa finaliza.");
        }
    }
}

package Caso;
import java.util.Scanner;
import Caso.Buffer.Especial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese la capacidad del depósito de producción:");
            int capDepProd = scanner.nextInt();

            System.out.println("Ingrese la capacidad del depósito de distribución:");
            int capDepDist = scanner.nextInt();

            System.out.println("Ingrese el número de productos que cada productor generará:");
            int numProductos = scanner.nextInt();

            Buffer deposito_produccion = new Buffer(capDepProd, Especial.DEPOSITO_PRODUCCION);
            Buffer cinta_transportadora = new Buffer(1, Especial.CINTA_TRANSPORTADORA);
            Buffer deposito_distribucion = new Buffer(capDepDist, Especial.DEPOSITO_DISTRIBUCION);

            Distribuidor distribuidor_a1 = new Distribuidor(Producto.Tipo.A, deposito_distribucion);
            Distribuidor distribuidor_a2 = new Distribuidor(Producto.Tipo.A, deposito_distribucion);
            Distribuidor distribuidor_b1 = new Distribuidor(Producto.Tipo.B, deposito_distribucion);
            Distribuidor distribuidor_b2 = new Distribuidor(Producto.Tipo.B, deposito_distribucion);

            Operario_interno opin_Dprod_cinta = new Operario_interno(deposito_produccion, cinta_transportadora);
            Operario_interno opin_cinta_Ddis = new Operario_interno(cinta_transportadora, deposito_distribucion);

            Productor productor_a1 = new Productor(Producto.Tipo.A, numProductos, deposito_produccion);
            Productor productor_a2 = new Productor(Producto.Tipo.A, numProductos, deposito_produccion);
            Productor productor_b1 = new Productor(Producto.Tipo.B, numProductos, deposito_produccion);
            Productor productor_b2 = new Productor(Producto.Tipo.B, numProductos, deposito_produccion);

            new Thread(productor_a1).start();
            new Thread(productor_a2).start();
            new Thread(productor_b1).start();
            new Thread(productor_b2).start();
            new Thread(distribuidor_a1).start();
            new Thread(distribuidor_a2).start();
            new Thread(distribuidor_b1).start();
            new Thread(distribuidor_b2).start();
            new Thread(opin_Dprod_cinta).start();
            new Thread(opin_cinta_Ddis).start();
        }
    }
}

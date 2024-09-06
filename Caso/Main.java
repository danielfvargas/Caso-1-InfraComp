package Caso;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el número de productos: ");
        int numProductos = scanner.nextInt();

        System.out.print("Introduzca la capacidad del depósito de producción: ");
        int capDepProd = scanner.nextInt();

        System.out.print("Introduzca la capacidad del depósito de distribución: ");
        int capDepDist = scanner.nextInt();

        scanner.close();

        Buffer deposito_produccion = new Buffer(capDepProd, Buffer.Especial.DEPOSITO_PRODUCCION);
        Buffer deposito_distribucion = new Buffer(capDepDist, Buffer.Especial.DEPOSITO_DISTRIBUCION);
        Buffer cinta_transportadora = new Buffer(1, Buffer.Especial.CINTA_TRANSPORTADORA);

        Productor productor_a1 = new Productor(Productor.Tipo_Producto.A,0, deposito_produccion);
        Productor productor_a2 = new Productor(Productor.Tipo_Producto.A,0, deposito_produccion);
        Productor productor_b1 = new Productor(Productor.Tipo_Producto.B,0, deposito_produccion);
        Productor productor_b2 = new Productor(Productor.Tipo_Producto.B,0, deposito_produccion);

        Distribuidor distribuidor_a1 = new Distribuidor(Distribuidor.Producto.A, deposito_distribucion);
        Distribuidor distribuidor_a2 = new Distribuidor(Distribuidor.Producto.A, deposito_distribucion);
        Distribuidor distribuidor_b1 = new Distribuidor(Distribuidor.Producto.B, deposito_distribucion);
        Distribuidor distribuidor_b2 = new Distribuidor(Distribuidor.Producto.B, deposito_distribucion);

        Operario_interno opin_Dprod_cinta = new Operario_interno(false, deposito_produccion, cinta_transportadora);
        Operario_interno opin_cinta_Ddis = new Operario_interno(false, cinta_transportadora, deposito_distribucion);

    
    }
    
}
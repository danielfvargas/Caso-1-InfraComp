package Caso;

public class Main {

    public static void main(String[] args) {

        Buffer deposito_distribucion = new Buffer(0, null);
        Buffer deposito_produccion = new Buffer(0, null);
        Buffer cinta_transportadora = new Buffer(0, null);

        Distribuidor distribuidor_a1 = new Distribuidor(Distribuidor.Tipo_Producto.A, deposito_produccion);
        Distribuidor distribuidor_a2 = new Distribuidor(Distribuidor.Tipo_Producto.A, deposito_produccion);
        Distribuidor distribuidor_b1 = new Distribuidor(Distribuidor.Tipo_Producto.B, deposito_produccion);
        Distribuidor distribuidor_b2 = new Distribuidor(Distribuidor.Tipo_Producto.B, deposito_produccion);

        Operario_interno opin_Dprod_cinta = new Operario_interno(false, deposito_produccion, cinta_transportadora);
        Operario_interno opin_cinta_Ddis = new Operario_interno(false, cinta_transportadora, deposito_distribucion);

        Productor productor_a1 = new Productor(Productor.Tipo_Producto.A,0, deposito_produccion);
        Productor productor_a2 = new Productor(Productor.Tipo_Producto.A,0, deposito_produccion);
        Productor productor_b1 = new Productor(Productor.Tipo_Producto.B,0, deposito_produccion);
        Productor productor_b2 = new Productor(Productor.Tipo_Producto.B,0, deposito_produccion);
    }
    
}
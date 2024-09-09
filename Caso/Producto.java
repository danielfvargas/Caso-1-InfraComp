package Caso;

public class Producto {

    enum Tipo {
        A, B, FIN_A, FIN_B
    }

    private Tipo tipo;

    public Producto(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public enum tipo {
    }
}

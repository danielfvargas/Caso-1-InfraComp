package Caso;

public class Operario_interno{
    private boolean finaliza;
    private Buffer inicio;
    private Buffer fin;

    public Operario_interno(boolean finaliza, Buffer inicio, Buffer fin) {
        this.finaliza = finaliza;
        this.inicio = inicio;
        this.fin = fin;

    }

    public boolean isFinaliza() {
        return finaliza;
    }

    public void setFinaliza(boolean finaliza) {
        this.finaliza = finaliza;
    }

    public Buffer getinicial() {
        return inicio;
    }

    public void setinicial(Buffer inicio) {
        this.inicio = inicio;
    }

    public Buffer getfinal() {
        return fin;
    }

    public void setfinal(Buffer fin) {
        this.fin = fin;
    }

    
    
    
}
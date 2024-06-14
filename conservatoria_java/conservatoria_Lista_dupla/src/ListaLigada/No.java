package listaLigada;


public class No {
    private No proximo;
    private Object elemento;
    private No anterior;

    public No(No anterior, Object elemento, No proximo) {
        this.proximo = proximo;
        this.elemento = elemento;
        this.anterior = anterior;
    }

    public No(Object elemento, No proximo) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public No(No anterior, Object elemento) {
        this.elemento = elemento;
        this.anterior = anterior;
    }

    public No(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}

package listaLigada;

import javax.swing.JOptionPane;

import interfaceGeral.InterfaceGeral;

public class ListaLigada implements InterfaceGeral{

    private No primeiro;
    private No ultimo;
    private int totalElem;

    @Override
    public void adicionaInicio(Object elemento) {
        if (this.eVazia()) {
            primeiro = new No(elemento);
            ultimo = primeiro;
        } else {
            primeiro = new No(elemento, primeiro);
            primeiro.getProximo().setAnterior(primeiro);
        }
        totalElem++;
    }

    @Override
    public void adicionaPosicao(int posicao, Object elemento) {            
        if (!posicaoValida(posicao))
            throw new IllegalArgumentException("A posição inserida não é válida.");
        if (posicao == 0) {
            adicionaInicio(elemento);
        } else if (posicao == totalElem) {
            adicionaFim(elemento);
        } else {
            No proximo = pegaNo(posicao);
            No novo = new No(proximo.getAnterior(), elemento, proximo);
            novo.getAnterior().setProximo(novo);
            proximo.setAnterior(novo);
            totalElem++;
        }
    }

    @Override
    public void adicionaFim(Object elemento) {
        if (this.eVazia()) {
            this.adicionaInicio(elemento);
        } else {
            ultimo = new No(ultimo, elemento);
            ultimo.getAnterior().setProximo(ultimo);
            totalElem++;
        }
    }

    @Override
    public Object pega(int posicao) {
        if (!posicaoOcupada(posicao))
            throw new IllegalArgumentException
                    ("Posição não ocupada.");
        return pegaNo(posicao).getElemento();
    }

    @Override
    public void removeInicio() {
        if (this.eVazia())
            throw new IllegalArgumentException("Lista Vazia");
        primeiro = primeiro.getProximo();
        totalElem--;
        if (totalElem == 0)
            ultimo = null;
        else
            primeiro.setAnterior(null);
    }

    @Override
    public void removePosicao(int posicao) {
        if (!posicaoOcupada(posicao))
            throw new IllegalArgumentException("Posição não ocupada.");
        if (posicao == 0) {
            removeInicio();
        } else if (posicao == totalElem - 1) {
            removeFim();
        } else {
            No anterior = pegaNo(posicao - 1);
            anterior.setProximo(anterior.getProximo().getProximo());
            anterior.getProximo().setAnterior(anterior);
            totalElem--;
        }
    }

    @Override
    public void removeFim() {
        if (totalElem <= 1) {
            removeInicio();
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
            totalElem--;
        }
    }

    @Override
    public boolean contem(Object elemento) {
        No no = primeiro;
        for (int i = 0; i < totalElem; i++) {
            if (no.getElemento().equals(elemento))
                return true;
            no = no.getProximo();
        }
        return false;
    }

    @Override
    public int tamanho() {
        return totalElem;
    }

    private No pegaNo(int posicao) {
    	if (!this.posicaoOcupada(posicao)) {
			JOptionPane.showMessageDialog(null,"Posição não existe");
			throw new IllegalArgumentException("Posicao não existe");
		}

		No actual = primeiro;
		for (int i = 0; i < posicao; i++) {
			actual = actual.getProximo();
		}
		return actual;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao < totalElem && posicao >= 0;
    }

    private boolean posicaoValida(int posicao) {
        return posicao <= totalElem && posicao >= 0;
    }

    public boolean eVazia() {
        return totalElem == 0;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("|");
        No no = primeiro;
        for (int i = 0; i < totalElem; i++) {
            sB.append(no.getElemento());
            if (i != totalElem - 1)
                sB.append(", ");
            no = no.getProximo();
        }
        sB.append("|");
        return sB.toString();
    }

}

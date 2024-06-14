package interfaceGeral;

public interface InterfaceGeral {
	public void adicionaInicio(Object elemento);
	public void adicionaPosicao(int posicao, Object elemento);
	public void adicionaFim(Object elemento);
	public Object pega(int posicao);
	public void removeInicio();
	public void removeFim();
	public void removePosicao(int posicao);
	public boolean contem(Object elemento);
	public int tamanho();
}

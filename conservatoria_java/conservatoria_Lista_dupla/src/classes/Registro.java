package classes;

//  codigo, apelido, outros nomes, sexo, raça, cor dos
// cabelos, cor dos olhos, format de nariz, bi do pai, bi 
// da mae, nacionalidade, residência
public class Registro {

	private String codigo;
	private String nome;
	private String apelido;
	private String outrosNomes;
	private int idade;
	private String sexo;
	private String raca;
	private String corDosCabelos;
	private String corDosOlhos;
	private String formatoDoNariz;
	private String BIdoPai;
	private String BIdaMae;
	private String nacionalidade;
	private String residencia;
	
	public Registro(String codigo,String nome, String apelido, String outrosNomes,int idade,
			String sexo, String raca, String corDosCabelos, String corDosOlhos,
			String formatoDoNariz, String bIdoPai, String bIdaMae,
			String nacionalidade, String residencia) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.apelido = apelido;
		this.outrosNomes = outrosNomes;
		this.idade = idade;
		this.sexo = sexo;
		this.raca = raca;
		this.corDosCabelos = corDosCabelos;
		this.corDosOlhos = corDosOlhos;
		this.formatoDoNariz = formatoDoNariz;
		BIdoPai = bIdoPai;
		BIdaMae = bIdaMae;
		this.nacionalidade = nacionalidade;
		this.residencia = residencia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getOutrosNomes() {
		return outrosNomes;
	}

	public void setOutrosNomes(String outrosNomes) {
		this.outrosNomes = outrosNomes;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCorDosCabelos() {
		return corDosCabelos;
	}

	public void setCorDosCabelos(String corDosCabelos) {
		this.corDosCabelos = corDosCabelos;
	}

	public String getCorDosOlhos() {
		return corDosOlhos;
	}

	public void setCorDosOlhos(String corDosOlhos) {
		this.corDosOlhos = corDosOlhos;
	}

	public String getFormatoDoNariz() {
		return formatoDoNariz;
	}

	public void setFormatoDoNariz(String formatoDoNariz) {
		this.formatoDoNariz = formatoDoNariz;
	}

	public String getBIdoPai() {
		return BIdoPai;
	}

	public void setBIdoPai(String bIdoPai) {
		BIdoPai = bIdoPai;
	}

	public String getBIdaMae() {
		return BIdaMae;
	}

	public void setBIdaMae(String bIdaMae) {
		BIdaMae = bIdaMae;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	@Override
	public String toString() {
		return "Registro [codigo=" + codigo + ", nome=" + nome + ", apelido=" + apelido + ", outrosNomes=" + outrosNomes
				+ ", idade="+idade+", sexo=" + sexo + ", raca=" + raca + ", corDosCabelos=" + corDosCabelos + ", corDosOlhos="
				+ corDosOlhos + ", formatoDoNariz=" + formatoDoNariz + ", BIdoPai=" + BIdoPai + ", BIdaMae=" + BIdaMae
				+ ", nacionalidade=" + nacionalidade + ", residencia=" + residencia + "]";
	}
	


}

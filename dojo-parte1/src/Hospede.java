import java.sql.Date;

public class Hospede {
	private Integer id;
	private String nome;
	private String sobrenome;
	private Date data_nascimento;
	private String nacionalidade;
	private String telefone;
	
	public Hospede(Integer id, String nome, String sobrenome, Date data_nascimento, String nacionalidade,
			String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_nascimento = data_nascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}
	
	public Hospede(String nome, String sobrenome, Date data_nascimento, String nacionalidade,
			String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_nascimento = data_nascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Hospede [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", data_nascimento="
				+ data_nascimento + ", nacionalidade=" + nacionalidade + ", telefone=" + telefone + "]";
	}	

}



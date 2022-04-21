import java.io.Serializable;

public class Soci implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codFis;
	private String cognome;
	private String nome;
	private String email;
	
	public Soci(String codFis, String cognome, String nome, String email) {
		this.codFis = codFis;
		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
	}
	
	public Soci(Soci s) {
		this.codFis = s.codFis;
		this.cognome = s.cognome;
		this.nome = s.nome;
		this.email = s.email;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Soci [codFis=" + codFis + ", cognome=" + cognome + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	
}

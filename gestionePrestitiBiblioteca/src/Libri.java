import java.io.Serializable;

public class Libri implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String titolo;
	private String autore;
	
	public Libri(String isbn, String titolo, String autore) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.autore = autore;
	}
	
	public Libri(Libri l) {
		this.isbn = l.isbn;
		this.titolo = l.titolo;
		this.autore = l.autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libri [isbn=" + isbn + ", titolo=" + titolo + ", autore=" + autore + "]";
	}	
	
	
	
}

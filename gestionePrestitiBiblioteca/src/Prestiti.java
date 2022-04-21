import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Prestiti implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String codFis;
	
	public Prestiti(String isbn, String codFis) {
		this.isbn = isbn;
		this.codFis = codFis;
	}
	
	public Prestiti(Prestiti p) {
		this.isbn = p.isbn;
		this.codFis = p.codFis;
	}
	
	public Prestiti() {}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCodFis() {
		return codFis;
	}

	public void setCodFis(String codFis) {
		this.codFis = codFis;
	}

	@Override
	public String toString() {
		return "Prestiti [isbn=" + isbn + ", codFis=" + codFis + "]";
	}
	
	
	
}

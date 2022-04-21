import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Registro {
	private Map<String, Libri> libri;
	private Map<String, Soci> soci;
	private List<Prestiti> prestiti;
	
	public Registro() {
		this.libri = new HashMap<>();
		this.soci = new TreeMap<>();
		this.prestiti = new ArrayList<>();
	}
	
	public void aggiungiLibro(Libri l) {
		this.libri.put(l.getIsbn(), l);
	}
	
	public void aggiungiSocio(Soci s) {
		this.soci.put(s.getCodFis(), s);
	}
	
	public Libri ricercaLibro(String isbn) {
			return libri.get(isbn);
	}
	
	public Soci ricercaSocio(String codFis) {
		if (soci.containsKey(codFis))
			return soci.get(codFis);
		else
			return null;
	}
	
	public Soci verificaPrestito(String isbn) {
		for (Prestiti p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn))
				return soci.get(p.getCodFis());
		}
		return null;
	}
	
	public void aggiungiPrestito(Prestiti p) {
		if (verificaPrestito(p.getIsbn()) == null)
			prestiti.add(p);
	}

	public void restituzione(String isbn) {
		for (Prestiti p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn)) {
				prestiti.remove(p);
				break;
			}
		}
	}
	
	public void salva() {
		ObjectOutputStream oos = null;
		try {
			// APRO IL FILE IN SCRITTURA
			oos = new ObjectOutputStream(new FileOutputStream("libri.bin"));
			oos.writeObject(this.libri);
			oos.close();
			oos = new ObjectOutputStream(new FileOutputStream("soci.bin"));
			oos.writeObject(this.soci);
			oos.close();
			oos = new ObjectOutputStream(new FileOutputStream("prestiti.bin"));
			oos.writeObject(this.prestiti);
			oos.close();
			System.out.println("Dati salvati nel file");
		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file");
		}
	}
	
	public void carica() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("libri.bin"));
			this.libri = (Map<String, Libri>) ois.readObject();
			ois.close();
			System.out.println("Lettura dati dal file libri.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file libri.bin");
		}
		try {
			ois = new ObjectInputStream(new FileInputStream("soci.bin"));
			this.soci = (Map<String, Soci>) ois.readObject();
			ois.close();
			System.out.println("Lettura dati dal file soci.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file soci.bin");
		}
		try {
			ois = new ObjectInputStream(new FileInputStream("prestiti.bin"));
			this.prestiti = (List<Prestiti>) ois.readObject();
			ois.close();
			System.out.println("Lettura dati dal file prestiti.bin");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file prestiti.bin");
		}

	}
	
	
}

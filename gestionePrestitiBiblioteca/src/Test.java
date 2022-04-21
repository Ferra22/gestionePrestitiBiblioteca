import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Registro registro = new Registro();
		Scanner in = new Scanner(System.in);
		int var = 0;
		registro.carica();
		
		do {
			
			String x = null;
			String y = null;
			String z = null;
			String w = null;
			
			System.out.println("1)Ricerca dati libro");
			System.out.println("2)Ricerca dati socio");
			System.out.println("3)Verifica prestito di un libro");
			System.out.println("4)Nuovo prestito");
			System.out.println("5)Restituzione prestito");
			System.out.println("6)Aggiungi libro");
			System.out.println("7)Aggiungi socio");
			System.out.println("0)Termina programma");

			var = in.nextInt();
			
			

			switch (var) {

			case 1:		
				System.out.println("Inserire il codice ISBN del libro:");
				in.nextLine();
				x = in.nextLine();
				if(registro.ricercaLibro(x) == null) {
					System.out.println("Il libro cercato non è presente nel registro.");
				}else 
					System.out.println(registro.ricercaLibro(x).toString());						
				break;
				
			case 2:
				System.out.println("Inserire il codice fiscale del socio:");
				in.nextLine();
				x = in.nextLine();
				if(registro.ricercaSocio(x) == null) {
					System.out.println("Il socio cercato non è presente nel registro.");
				}else 
					System.out.println(registro.ricercaSocio(x).toString());
				break;
				
			case 3:
				System.out.println("Inserire il codice ISBN del libro:");
				in.nextLine();
				x = in.nextLine();
				if(registro.verificaPrestito(x) == null) {
					System.out.println("Il prestito non è presente nel registro.");
				}else 
					System.out.println(registro.verificaPrestito(x).toString());						
				break;
				
			case 4:
				System.out.println("Inserire il codice ISBN del libro da prestare:");
				in.nextLine();
				x = in.nextLine();
				if (registro.ricercaLibro(x) == null || registro.verificaPrestito(x) != null)
					System.out.println("Il libro è in prestito");
				else {
					System.out.println("Inserire il codice fiscale del socio:");
					y = in.nextLine();
					if (registro.ricercaSocio(y) != null) {
						registro.aggiungiPrestito(new Prestiti(x, y));
						System.out.println("Il prestito è stato effettuato correttamente.");
					}
					else
						System.out.println("Il codice fiscale è errato.");
				}
				break;
				
			case 5:
				System.out.println("Inserire il codice ISBN del libro da restituire:");
				in.nextLine();
				x = in.nextLine();
				if (registro.verificaPrestito(x) == null) {
					System.out.println("Il libro non è stato correttamente restituito.");
				} else {
					registro.restituzione(x);
					System.out.println("Il libro è stato correttamento restituito.");
				}
				break;
				
			case 6:
				System.out.println("Inserire il codice ISBN del libro da aggiungere:");
				in.nextLine();
				x = in.nextLine();
				System.out.println("Inserire il titolo del libro da aggiungere:");
				y = in.nextLine();
				System.out.println("Inserire l'autore del libro da aggiungere:");
				z = in.nextLine();
				Libri l = new Libri(x, y, z);
				registro.aggiungiLibro(l);
				break;
				
			case 7:
				System.out.println("Inserire il codice fiscale del socio da aggiungere:");
				in.nextLine();
				x = in.nextLine();
				System.out.println("Inserire il cognome del socio da aggiungere:");
				y = in.nextLine();
				System.out.println("Inserire il nome del socio da aggiungere:");
				z = in.nextLine();
				System.out.println("Inserire l'email del socio da aggiungere:");
				w = in.nextLine();
				
				Soci s = new Soci(x, y, z, w);
				registro.aggiungiSocio(s);
				break;
				
			}
		} while (var != 0);
		
		registro.salva();
	}

}

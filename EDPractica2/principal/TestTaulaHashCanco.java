package principal;

import java.io.*;
import java.util.Scanner;

import TAD.*;
import TAD.Alumne;

public class TestTaulaHashCanco {

	public static void main(String[] args) {
		TaulaHashEncadenadaIndirecta<String, Integer> t = new TaulaHashEncadenadaIndirecta<String, Integer>(10000);
		LlistaGenerica<Alumne> llista=new LlistaGenerica<Alumne>(10000);
		
		// llegim les cançons del fitxer i les afegim a la llista
		Scanner entrada;
		String frase;
		String[] frasePartida;
		int codi, pos;
		String autor, nom, data;
		Alumne c;
		try {
			entrada=new Scanner(new File("cancons.txt"));
		
			//llegirem frase a frase i llavors partirem per ,
		  
			while (entrada.hasNextLine()) {
				frase=entrada.nextLine().toUpperCase();
				// tractem la frase
				frasePartida=frase.split(";");
				// codi assignatura; nom assignatura; crèdits; curs; quadrimestre; codi alumne; nom alumne
				codi=Integer.parseInt(frasePartida[0]);
				autor=frasePartida[1];
				nom=frasePartida[2];
				data=frasePartida[3];
				c=new Alumne(codi,nom,autor,data);
				llista.afegirElement(c);
		  }
		  entrada.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fitxer de lectura no existeix");
		} catch(IOException e) {
			System.out.println("Altres problemes amb l'arxiu");
		}
		
		// ara les afegim a la taula de hash
		
		for (int i=0; i<llista.getNum(); i++)
			t.afegir(llista.consultarIessim(i).getNom(), i);


		System.out.println("Mostro informacio de les colisions de t");
		//t.mostrarTaula();
		t.mostrarColisions();
		/*
		System.out.println("Mostro la llista de cancons ordenades per autor");
		for(Canco canco:llista) {
			System.out.println("\t"+canco);
		}
	*/
		
	
		
	}

}

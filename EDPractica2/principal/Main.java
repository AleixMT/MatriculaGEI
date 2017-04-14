package principal;

import java.io.*;
import java.util.*;
import Exceptions.*;
import Interfaces.*;
import TAD.*;
import tipus.Alumne;
import tipus.Assignatura;


public class Main {

	static Scanner teclat=new Scanner(System.in); //Scanner del main
	/**
	 * Metode per a interaccionar amb l'usuari sobre si vol encriptar o desencriptar
	 * @return opcio escollida (1-encriptar, 2-desencriptar)
	 */
	public static void consultes(){ //mostra les consultes
		boolean exit=false;
		int opt=0;
		while (!exit) //mentre que el usuari no indiqui l'estructura iterarem
		{
			System.out.println("Quina consulta vols fer?");
			System.out.println("1.- Mostrar matricula d'un alumne a partir del seu codi");
			System.out.println("2.- Mostrar estat de l'assignatura a partir del seu codi");
			System.out.println("3.- Mostrar alumnes amb tants o menys nombre de credits especificats");
			System.out.println("4.- Mostrar assignatures amb tants o mÃ©s nombre d'alumnes especificats");
			System.out.println("5.- Reinicia el programa");
			try
			{
				opt=teclat.nextInt();
				switch(opt) {
				case 1: 
					// Creem llistes i dades necessaries per a construir la multillista
					break;
				case 2: 
					// Creem llistes i dades necessaries per a construir la multillista
					break; 
				case 3: 
					// Creem llistes i dades necessaries per a construir la multillista
					break;
				case 4: 
					// Creem llistes i dades necessaries per a construir la multillista
					break;
				case 5: 
					exit=true;
					break;
				default: System.out.println("Aquesta opcio no esta a la llista... \n");
				break;	//Funciona com una excepcio per a un valor numeric no acceptat
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una opció incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
	}

	/**
	 * Metode per a llegir el fitxer i afegir el contingut a les EDs
	 * @param <E>
	 * @param file -- fitxer a llegir
	 * @throws LlistaPlena 
	 */
	public static void llegirFitxer(TADLlistaGenerica tad) throws LlistaPlena{
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		teclat.nextLine(); //flush
		String aux = "";
		String fitxer = null;
		try{
			System.out.println("Quin es el nom del fitxer de dades?");
			fitxer = teclat.nextLine();
		}catch (InputMismatchException e){
			System.out.println("El nom del fitxer es incorrecte, torna-ho a intentar:");
			fitxer = teclat.nextLine();
		}
		try
		{
			BufferedReader buffer = new BufferedReader(new FileReader(fitxer)); //Inicialitzem el buffer de fitxer
			ti=System.nanoTime();
			while((aux = buffer.readLine()) != null) 
			{
				String[] content = aux.split(";");
				//codi assignatura;nom assignatura;credits;curs;quadrimestre;codi alumne;nom alumne
				//crear instancia d'assignatura		
				Assignatura ass = new Assignatura(Integer.parseInt(content[0]), content[1], Integer.parseInt(content[2]), Integer.parseInt(content[3]), Integer.parseInt(content[4]));
				
				//crear instancia d'alumne
				Alumne a = new Alumne(content[5], content[6]);
				
				//Anar afegint relacions a la multillista
				//tad.afegir(ass, a);
	           } 
			buffer.close();
			tf=System.nanoTime();
			System.out.println("Ha tardat "+ (tf-ti)+ " segons");
		}
		catch (IOException e) //Problema general de IO
		{
			System.out.println("ERROR: Problema d'entrada/sortida");
		}
	}
	
	public static TADLlistaGenerica menu(){ //mostra el menu i inicialitza el TAD
		int opt=0;
		TADLlistaGenerica tad = null;
		while (tad==null) //mentre que el usuari no indiqui l'estructura iterarem
		{
			System.out.println("Quina versio vols utilitzar?");
			System.out.println("1.- Multillista amb llistes estatiques");
			System.out.println("2.- Multillista amb llistes dinamiques");
			System.out.println("3.- Multillista de les java collection");
			try
			{
				opt=teclat.nextInt();
				switch(opt) {
				case 1: 
					// Creem llistes i dades necessaries per a construir la multillista
					tad = new LlistaEstatica(10000);
					break;
				case 2: 
					// Creem llistes i dades necessaries per a construir la multillista
					tad = new LlistaDinamica(); 
					break; 
				case 3: 
					// Creem llistes i dades necessaries per a construir la multillista
					tad = new LlistaJavaUtil(10000);
					break;
				default: System.out.println("Aquesta opcio no esta a la llista... \n");
				break;	//Funciona com una excepcio per a un valor numeric no acceptat
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una opció incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
		return tad; 
	}
	/**
	 * Funcio principal del programa
	 * @param args arguments d'entrada
	 * @throws LlistaPlena 
	 */
	public static void main(String[] args) throws LlistaPlena {
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		while (true)
		{
			TADLlistaGenerica tad = menu(); //preguntem al usuari quina estructura vol i la inicialitzem
			llegirFitxer(tad); //Passem el tad multillista per a que llegir fitxer llegeixi el fitxer i ho pleni de relacions
			consultes();
		}

}}

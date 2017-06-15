package principal;

import java.io.*;
import java.util.*;
import Exceptions.*;
import Interfaces.*;
import TAD.*;
import tipus.Alumne;
import tipus.Assignatura;
import tipus.Matricula;
/**
 * Classe principal per a provar el funcionament del programa
 * @author Cristina Izquierdo i Aleix Marine
 *
 */
public class Main {

	/**
	 * Menu amb les diferents consultes disponibles al programa
	 */
	static Scanner teclat=new Scanner(System.in); //Scanner del main
	public static void consultes(Multillista tad){ //mostra les consultes
		int opt=0;
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		boolean exit = false;
		String entry = "";
		int entryint = 0;
		while (!exit) //mentre que el usuari no indiqui l'estructura iterarem
		{
			System.out.println("Quina consulta vols fer?");
			System.out.println("1.- Mostrar matricula d'un alumne a partir del seu codi");
			System.out.println("2.- Mostrar estat de l'assignatura a partir del seu codi");
			System.out.println("3.- Mostrar alumnes amb tants o menys nombre de credits especificats");
			System.out.println("4.- Mostrar assignatures amb tants o mes nombre d'alumnes especificats");
			System.out.println("5.- Reinicia el programa");
			System.out.println("6.- Sortir del programa");
			try
			{
				ti=System.nanoTime();
				opt=teclat.nextInt();
				switch(opt) {
				case 1: 
					System.out.print("Introdueix el codi de l'alumne: ");
					entry = teclat.next();
					ti=System.nanoTime();
					if 	(!tad.sumariAlumne(entry)){
						System.out.print("Sembla que no s'ha trobat cap alumne amb aquest codi...");
					}
					break;
				case 2: 
					System.out.print("Introdueix el codi de l'assignatura: ");
					entryint = teclat.nextInt();
					ti=System.nanoTime();
					if (!tad.sumariAssignatura(entryint)){
						System.out.print("No s'ha trobat cap assignatura amb aquest codi...");
					}
					break; 
				case 3: 
					System.out.print("Introdueix el nombre de credits avaluats: ");
					entryint = teclat.nextInt();
					ti=System.nanoTime();
					if (!tad.AlumnesNumCredits(entryint)){
						System.out.print("No hi ha cap element coincident...");
					}
					break;
				case 4: 
					System.out.print("Introdueix el nombre d'alumnes avaluats: ");
					entryint = teclat.nextInt();
					ti=System.nanoTime();
					if (!tad.AssignaturesNumAlumnes(entryint)){
						System.out.print("No hi ha cap element coincident...");
					}					
					break;
				case 5: 
					exit=true;
					break;
				case 6: //apagar la consola
					for (int i = 0; i < 100; ++i) System.out.println();//netejem la pantalla omplint-la d'espais
					System.exit(0); break; //termina l'aplicacio que s'esta executant al moment
				default: System.out.println("Aquesta opcio no esta a la llista... \n");
				break;	//Funciona com una excepcio per a un valor numeric no acceptat
				}
				tf = System.nanoTime();
				System.out.println("Ha tardat "+ (tf-ti)/Math.pow(10, 9)+ " segons");
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una opcio incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
	}

	/**
	 * Metode per a llegir el fitxer i afegir el contingut a les EDs
	 * @param tad - estructura
	 * @throws LlistaPlena - llista plena
	 */
	public static void llegirFitxer(Multillista tad) throws LlistaPlena{
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		teclat.nextLine(); //flush
		String aux = "";
		String fitxer = null;
		boolean correcte = false;
		while (!correcte)//mentre que quedin dades per llegir
		{
			while (!correcte)
			{
				try{
					System.out.println("Quin es el nom del fitxer de dades?");
					fitxer = teclat.nextLine();
					correcte = true;
				}catch (InputMismatchException e){
					System.out.println("El nom del fitxer es incorrecte, torna-ho a intentar:");
					fitxer = teclat.nextLine();
				}
			}
			correcte = false;
			try
			{
				BufferedReader buffer = new BufferedReader(new FileReader(fitxer)); //Inicialitzem el buffer de fitxer
				ti=System.nanoTime();
				while((aux = buffer.readLine()) != null) 
				{
					String[] content = aux.split(";");
					//codi assignatura;nom assignatura;credits;curs;quadrimestre;codi alumne;nom alumne
					//crear instancia d'assignatura		
					Assignatura ass = new Assignatura(Integer.parseInt(content[0]), content[1], Integer.parseInt(content[2]), Integer.parseInt(content[3]), Integer.parseInt(content[4].substring(content[4].length()-2, content[4].length()-1)));
					tad.getAs().afegir(ass);
					//crear instancia d'alumne
					Alumne a = new Alumne(content[5], content[6]);
					tad.getA().afegir(a);
					//Anar afegint relacions a la multillista
					tad.afegir(new Matricula(a, ass, null, null)) ;
		        } 
				buffer.close();
				correcte = true; //ja s'han acabat d'afegir les dades
				tf=System.nanoTime();
				System.out.println("Ha trigat "+ (tf-ti)+ " segons.");
				
				System.out.println(tad.getA());
				System.out.println(tad.getAs());

			}
			catch (IOException e) //Problema general de IO
			{
				System.out.println("ERROR: No existeix aquest fitxer!");
			}
		}
		
	}
	
	/**
	 * Menu per a crear les multillistes amb les diferents implementacions
	 * @return tad
	 */
	public static Multillista menu(){ //mostra el menu i inicialitza el TAD
		int opt=0;
		Multillista tad = null;
		while (tad==null) //iterarem mentre que el usuari no indiqui l'estructura
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
					tad = new Multillista (((TADLlistaGenerica<Assignatura>) new LlistaEstatica<Assignatura>(100)), ((TADLlistaGenerica<Alumne>)new LlistaEstatica<Alumne>(200)));	// Creem la multillista amb llistes estatiques
					break;
				case 2: 
					tad = new Multillista (((TADLlistaGenerica<Assignatura>) new LlistaDinamica<Assignatura>()), ((TADLlistaGenerica<Alumne>)new LlistaDinamica<Alumne>()));	// Creem la multillista amb llistes dinamiques
					break; 
				case 3: 
					tad = new Multillista (((TADLlistaGenerica<Assignatura>) new LlistaJavaUtil<Assignatura>()), ((TADLlistaGenerica<Alumne>)new LlistaJavaUtil<Alumne>()));	// Creem la multillista amb llistes javautil
					break;
				default: System.out.println("Aquesta opcio no esta a la llista... \n");
				break;	//Funciona com una excepcio per a un valor numeric no acceptat
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una opci� incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
		return tad; 
	}
	/**
	 * Funcio principal del programa
	 * @param args arguments d'entrada
	 * @throws LlistaPlena - llista plena
	 */
	public static void main(String[] args) throws LlistaPlena{
		while (true) //bucle infinit del menu
		{
			Multillista tad = menu(); //preguntem al usuari quina estructura vol i la inicialitzem
			llegirFitxer(tad); //Passem el tad multillista per a que llegir fitxer llegeixi el fitxer i ho pleni de relacions
			consultes(tad);	// menu d'opcions
		}

}}

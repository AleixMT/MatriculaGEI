package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Dades.Cua;
import Dades.CuaCircular;
import Dades.CuaDinamica;
import Dades.JavaUtil;
import Exceptions.Cadenabuida;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Exceptions.valorImpossible;
import Interface.TADCua;

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
			System.out.println("Quina consulta vols fer vols utilitzar?");
			System.out.println("1.- Mostrar matrícula d'un alumne a partir del seu codi");
			System.out.println("2.- Mostrar estat de l'assignatura a partir del seu codi");
			System.out.println("3.- Mostrar alumnes amb tants o menys nombre de credits especificats");
			System.out.println("4.- Mostrar assignatures amb tants o més nombre d'alumnes especificats");
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
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
	}

	/**
	 * Metode per a llegir el fitxer i afegir el contingut a les EDs
	 * @param file -- fitxer a llegir
	 * @return contingut del fitxer 
	 */
	public static String[] llegirFitxer(TADMultillista tad){
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		teclat.nextLine(); //flush
		try
		{
			BufferedReader buffer = new BufferedReader(new FileReader("DadesMatricula.csv")); //Inicialitzem el buffer de fitxer
			ti=System.nanoTime();
			while((aux = buffer.readLine()) != null) 
			{
				String[] content = aux.split(";");
				//Anar afegint alumnes a la llista d'alumnes
				//Anar afegint assignatures a la llista d'asssignatures
				//Anar afegint relacions a la multillista
	           } 
			buffer.close();
			tf=System.nanoTime();
			System.out.println("Ha tardat "+ (tf-ti)+ " segons");
		}
		catch (IOException e) //Problema general de IO
		{
			System.out.println("ERROR: Problema d'entrada sortida");
		}
	}
	
	public static TADMultillista menu(){ //mostra el menu i inicialitza el TAD
		boolean correct=false;
		String clau="";	
		int num=0;
		int opt=0;
		TADMultillista tad = null;
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
					tad=new MultillistaEstatica(new LlistaEstatica(), new Llistadinamica());
					break;
				case 2: 
					// Creem llistes i dades necessaries per a construir la multillista
					tad=new MultillistaDinamica(); 
					break; 
				case 3: 
					// Creem llistes i dades necessaries per a construir la multillista
					tad=new MultillistaJavautil();
					break;
				default: System.out.println("Aquesta opcio no esta a la llista... \n");
				break;	//Funciona com una excepcio per a un valor numeric no acceptat
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
                teclat.nextLine(); 
			}
		}
		return tad; 
	}
	/**
	 * Funcio principal del programa
	 * @param args arguments d'entrada
	 */
	public static void main(String[] args) {
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		while (true)
		{
			TADMultillista tad = menu(); //preguntem al usuari quina estructura vol i la inicialitzem
			llegirFitxer(tad); //Passem el tad multillista per a que llegir fitxer llegeixi el fitxer i ho pleni de relacions
			consultes(tad);
		}

}

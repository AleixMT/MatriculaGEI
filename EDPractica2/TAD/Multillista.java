package TAD;
import tipus.Alumne;
import tipus.Assignatura;
import tipus.Matricula;
import tipus.Obj;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;


/**
 * Classe per a crear la multillista
 * Aquesta classe crear la multillista, que no será més que un "contenidor" per a dues llistes genériques
 * @author Cristina Izquierdo i Aleix Marin�
 * @param <E>
 *
 */
public class Multillista implements TADMultillista{

	private TADLlistaGenerica<Assignatura> as;
	private TADLlistaGenerica<Alumne> a;

	public Multillista(TADLlistaGenerica<Assignatura> as, TADLlistaGenerica<Alumne> a)
	{
		this.a = a;
		this.as = as;
	}
	
	/**
	 * R
	 * @param m
	 * @return
	 * @throws LlistaPlena
	 */
	public boolean afegir(Matricula m) throws LlistaPlena {
		Iterator<Alumne> als = this.a.Iterator();	// Creem dos iteradors: un de la llista d'alumnes...
		Iterator<Assignatura> ass = this.as.Iterator(); // ... i un de la llista d'assignatures
		Obj<Alumne> auxal = null;	// Inicialitzem variables auxiliars per a un Obj parametritzat amb alumne... 
		Obj<Assignatura> auxas = null; // i el mateix amb Assignatura
		while (als.hasNext())	// Iterem sobre l'iterator de llista d'alumnes
		{
			auxal = als.next();	// Obtenim següent
			if (auxal.equals(m.getAlumne())) break;	// comparem amb l'alumne de la matricula rebuda per parametre i sortim si es el mateix
		}
		while (ass.hasNext())
		{
			auxas = ass.next();
			if (auxas.equals(m.getAssignatura())) break;
		}
		// Després d'aquests passos hauríem de fer diverses comprovcions: Comprovar que la variable no fos null, que no s'hagués
		// trobat Alumne i Assignatura de la Matrícula, etc. Però segons la especificació això no pot passar
		Matricula mAl = auxal.getNode();	// Obte els nodes següents d'alumne
		Matricula mAs = auxas.getNode();	// i assignatura
		Matricula mat = new Matricula(auxal.getObj(), auxas.getObj(), mAl, mAs ); // crea una nova matricula
		auxal.setNode(mat);	// fes que l'objecte d'alumne apunti a la nova matricula
		auxas.setNode(mat);	// fes que l'objecte d'assignatura apunti a la nova matricula
		return true;	// retorna cert
	}
	
	public boolean sumariAlumne(String codi){
		Iterator<Alumne> aux = this.a.Iterator();	// Creem un iterador per a la llista d'alumnes
		int credits = 0;
		boolean trobat = false;	// boolea de trobat
		Obj<Alumne> al = null;	// Inicialitzem una instancia de la classe alumne
		while (aux.hasNext() && !trobat) // iterem mentre no trobem l'element i hi hagi un element disponible
		{
			al = aux.next();	// assignem l'alumne a un element auxiliar
			if (al.getObj().compareTo(codi) == 0) trobat = true;	// si trobem que el compareTo retorna 0 (es el mateix) pugem la bandera
		}
		if (trobat == false) return false;	// Si el sortir del bucle ha sigut degut a acabar la llista vol dir que no existeix tal element, per tant retornem null i sortim
		/*
		 *  Iterarem sobre el nodes de matricula i els anem acumulant a una llista. 
		 *  Hem implementat alguns constructors extra a la classe iterator per a poder utilitzar-ho per a poder
		 *  reduir codi.
		 */
		Iterator<Assignatura> matr = new Iterator<Assignatura>(al, al.getObj());	// Creem un nou iterador parametritzat amb la classe assignatura
		while (matr.hasNext())	// mentre tingui més matricules penjant d'alumne
		{
			Assignatura asaux = matr.next().getObj(); // Iterem i les acumulem a la llista
			credits+=asaux.getCredits();
			System.out.print(asaux);
		}
		System.out.println(credits + " en total.");
		return true;
	}
	
	public Matricula esborrar(Matricula e) throws LlistaBuida {
		return null;
	}

	public Matricula consultar(Matricula c) throws LlistaBuida {
		return null;
	}
	/**
	 * Getters i setters per als atributs de la classe
	 */
	public TADLlistaGenerica<Assignatura> getAs() {
		return as;
	}

	public void setAs(TADLlistaGenerica<Assignatura> as1) {
		as = as1;
	}

	public TADLlistaGenerica<Alumne> getA() {
		return a;
	}

	public void setA(TADLlistaGenerica<Alumne> a) {
		this.a = a;
	}

	
	
	
}

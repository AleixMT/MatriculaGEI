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
 * no sera mes que un "contenidor" per a dues llistes generiques
 * @author Cristina Izquierdo i Aleix Marine
 * @param <E> tipus generic
 *
 */
public class Multillista implements TADMultillista{

	private TADLlistaGenerica<Assignatura> as;
	private TADLlistaGenerica<Alumne> a;

	/**
	 * Metode constructor
	 * @param as - assignatura
	 * @param a - alumne
	 */
	public Multillista(TADLlistaGenerica<Assignatura> as, TADLlistaGenerica<Alumne> a)
	{
		this.a = a;
		this.as = as;
	}
	
	/**
	 * metode per afegir una relacio (matricula) entre les dues llistes generiques
	 */
	public boolean afegir(Matricula m) throws LlistaPlena {
		Iterator<Alumne> als = this.a.Iterator();	// Creem dos iteradors: un de la llista d'alumnes...
		Iterator<Assignatura> ass = this.as.Iterator(); // ... i un de la llista d'assignatures
		Obj<Alumne> auxal = null;	// Inicialitzem variables auxiliars per a un Obj parametritzat amb alumne... 
		Obj<Assignatura> auxas = null; // i el mateix amb Assignatura
		while (als.hasNext())	// Iterem sobre l'iterator de llista d'alumnes
		{
			auxal = als.next();	// Obtenim seguent a cada iteracio
			if (auxal.getObj().equals(m.getAlumne())) break;	// comparem amb l'alumne de la matricula rebuda per parametre i sortim si es el mateix
		}
		while (ass.hasNext())	// Iterem sobre la llista d'assignatures
		{
			auxas = ass.next();	// Obtenim el seguent a cada iteracio
			if (auxas.getObj().equals(m.getAssignatura())) break; // comparem amb l'alumne de la matricula rebuda per parametre i sortim si es el mateix
		}
		/*Despres d'aquests passos haurem de fer diverses comprovacions: Comprovar que la variable no fos null, que no s'hagues
		 trobat Alumne i Assignatura de la Matricula, etc. Pero segons la especificacio aixo no pot passar. Per tant ho ignorem.
		 El programa SEMPRE troba l'alumne i la assignatura, i cada matricula nomes es llegeix un cop, per tant no cal que es 
		 comprovi que es repeteix.*/
		Matricula mAl = auxal.getNode();	// Obte els nodes matricula seguents d'alumne 
		Matricula mAs = auxas.getNode();	// i assignatura
		Matricula mat = new Matricula(auxal.getObj(), auxas.getObj(), mAl, mAs ); // crea una nova matricula
		// Aquesta matricula apunta als alumnes i assignatures que hem trobat i apunta a les matricules seguents de l'alumne i la assignatura
		// Per últim connectem l'alumne i la assignatura a aquesta matricula
		auxal.setNode(mat);	// fes que l'objecte d'alumne apunti a la nova matricula
		auxas.setNode(mat);	// fes que l'objecte d'assignatura apunti a la nova matricula
		return true;	// retorna cert
	}
	
	/**
	 * metode sumari alumne
	 * mostra les dades de l'alumne especificat pel codi i les assignatures on s'ha matriculat
	 * tambe mostra el numero de credits totals
	 * @param codi - identificador de l'alumne
	 * @return False - no existeix l'alumne. True - existeix
	 */
	public boolean sumariAlumne(String codi){
		Iterator<Alumne> aux = this.a.Iterator();	// Creem un iterador per a la llista d'alumnes
		int credits = 0;	// Inicialitzem el nombre de credits
		boolean trobat = false;	// boolea de trobat
		Obj<Alumne> al = null;	// Inicialitzem una instancia de la classe alumne, continut dins d'un objecte Obj
		while (aux.hasNext() && !trobat) // iterem mentre no trobem l'element i hi hagi un element disponible
		{
			al = aux.next();	// assignem l'alumne a un element auxiliar
			if (al.getObj().compareTo(codi) == 0) trobat = true;	// si trobem que el compareTo retorna 0 (es el mateix) pugem la bandera
		}
		if (trobat == false) return false;	// Si el sortir del bucle ha sigut degut a acabar la llista vol dir que no existeix tal element, per tant retornem fals i sortim
		/*Iterarem sobre el nodes de matricula i els anem acumulant a una llista. 
		 Hem implementat alguns constructors extra a la classe iterator per a poder utilitzar-ho per a poder
		 reduir codi.*/
		Iterator<Matricula> matr = new Iterator<Matricula>(al, al.getObj());	// Creem un nou iterador parametritzat amb la classe assignatura
		while (matr.hasNext())	// mentre tingui mes matricules penjant d'alumne
		{
			Assignatura asaux = matr.next().getObj().getAssignatura(); // Iterem i les acumulem a la llista
			credits+=asaux.getCredits(); // Obtenim el nombre total de credits
			System.out.print(asaux);	// Motrem per pantalla les dades de l'alumne actual
		}
		System.out.println("\n"+credits + " en total.");	// Mostrem el nombre de credits en total
		return true;	// retornem cert
	}
	
	/**
	 * Metode que mostra les dades dels alumnes matriculats a una assignatura especificada segons un String (codi d'assignatura)
	 * rebut per parametre. Tambe mostra el nombre de matriculats
	 * @param codi codi d'assinatura
	 * @return retorna cert si ha trobat una assignatura amb aquest codi, fals si no la ha trobat
	 */
	public boolean sumariAssignatura(int codi){
		Iterator<Assignatura> aux = this.as.Iterator();	// Creem un iterador per a la llista d'assignatures
		int nummatriculats = 0;	// Inicialitzem el comptador
		boolean trobat = false;	// boolea de trobat
		Obj<Assignatura> as = null;	// Inicialitzem una instancia Obj de la classe assignatura
		while (aux.hasNext() && !trobat) // iterem mentre no trobem l'element i hi hagi un element disponible
		{
			as = aux.next();	// assignem l'assignatura a un element auxiliar
			if (as.getObj().compareTo(codi) == 0) trobat = true;	// si trobem que el compareTo retorna 0 (es el mateix) pugem la bandera
		}
		if (trobat == false) return false;	// Si el sortir del bucle ha sigut degut a acabar la llista vol dir que no existeix tal element, per tant retornem null i sortim
		/*Iterarem sobre el nodes de matricula i els anem acumulant a una llista. 
		 Hem implementat alguns constructors extra a la classe iterator per a poder utilitzar-ho per a poder
		 reduir codi.*/
		Iterator<Matricula> matr = new Iterator<Matricula>(as, as.getObj());	// Creem un nou iterador parametritzat amb la classe matricula
		while (matr.hasNext())	// mentre tingui mes matricules penjant de l'assignatura
		{
			Alumne alaux = matr.next().getObj().getAlumne(); // iterem i guardem el seguent element
			nummatriculats++;	// incrementem el nombre de matriculats
			System.out.print(alaux); 	// mostrem per pantalla les dades de l'alumne
		}
		System.out.println("\n"+nummatriculats + " matriculats en total.");	// mostrem el nombre total de matriculats
		return true;	// retornem cert
	}
	
	/**
	 * Metode per a buscar alumnes matriculats amb igual o menys credits del numero que es passa per parametre
	 * @param credits - numero de credits maxim
	 * @return True - element existeix. False - element no existeix
	 */
	public boolean AlumnesNumCredits( int credits){
		Iterator<Alumne> aux = this.a.Iterator();	// Creem un iterador de la llista d'alumnes
		int numcredits = 0;	// inicialitzem el nombre de credits a 0
		boolean trobat = false;
		while (aux.hasNext()){	// mentre existeixin elements en la llista d'alumnes
			Obj<Alumne> auxal = aux.next();		// guarda el seguent element Obj<Alumne>
			Iterator<Matricula> auxmat = new Iterator<Matricula>(auxal, auxal.getObj());	
			// Fes un iterador de matricules sobre l'alumne obtingut
			while (auxmat.hasNext()){	// mentre l'alumne tingui matricules
				numcredits += auxmat.next().getObj().getAs().getCredits();	
				// Obtenim el credits de cada assignatura matriculada i els acumulem
			}
			if (numcredits <= credits){	// Si el nombre de credits es menor o igual que els rebuts per parametre 
				System.out.print(auxal.getObj());	// Mostrem l'alumne en concret
				trobat = true;	// Serveix per a mostrar l'error de si no hi han alumnes amb aquests credits
			}
			numcredits = 0;	// reiniciem el comptador
		}
		return trobat;	// D'aquesta manera es retornara cert o fals segons si hi ha algun element coincidident o no.
	}
	
	/**
	 * Metode per a mostrar per pantalla les dades de les assignatures amb igual o mes alumnes dels que es passen per parametre
	 * @param alumnes - maxim alumnes
	 * @return True - existeix. False - no existeix.
	 */
	public boolean AssignaturesNumAlumnes(int alumnes)  {
		Iterator<Assignatura> aux = this.as.Iterator();	// Creem un iterador de la llista d'assignatures
		int numalumnes= 0;	// inicialitzem el nombre d'alumnes 0
		boolean trobat = false;
		while (aux.hasNext()){	// mentre existeixin elements en la llista d'alumnes
			Obj<Assignatura> auxas = aux.next();		// guarda el seguent element Obj<Assignatura>
			Iterator<Matricula> auxmat = new Iterator<Matricula>(auxas, auxas.getObj());	
			// Fes un iterador de matricules sobre l'assignatura obtinguda
			numalumnes = auxmat.getNumElem();	// Obtenim el nombre d'elements que hi ha al iterador
			if (numalumnes >= alumnes){	// Si el nombre d'alumnes matriculats es major o igual que els rebuts per parametre 
				System.out.print(auxas.getObj());	// Mostrem l'alumne en concret
				trobat = true;	// Serveix per a mostrar l'error de si no hi han assignatures amb aquests matriculats
			}
			numalumnes = 0;	// reiniciem el comptador
		}
		return trobat;	// D'aquesta manera es retornara cert o fals segons si hi ha algun element coincidident o no.
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

	//el metode esborrar no es fa servir pel problema que ens demanen
	public Matricula esborrar(Matricula e) throws LlistaBuida {
		return null;
	}

	public Matricula consultar(Matricula c) throws LlistaBuida {
		return null;
	}

	
	
	
}

package TAD;


import tipus.Obj;
import tipus.ObjCursor;
import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.*;

public class LlistaEstatica<T extends Comparable<T>> implements TADLlistaGenerica<T> {
	private ObjCursor<T>[] llista;
	private int numElem;
	private int primer;
	
	private int[] buits;
	private int numElemsbuits;
	
	@SuppressWarnings("unchecked")
	public LlistaEstatica(int dim) {
		this.llista = (ObjCursor<T>[]) new ObjCursor[dim];
		this.primer = -1;
		this.numElem = 0;
		
		this.buits = new int[dim];
		
		//Anem carregant les posicions buides. Desapilarem a la posicio numElemsBuits, de tal manera que les carregarem
		//a la inversa, tenint les posicions buides amb menor index en les posicions de major index en buits[]
		for (int i=buits.length-1; i>-1; i--)
		{
			this.buits[i] = i;
		}
		this.numElemsbuits=dim;
	}

	public boolean afegir(T a) throws LlistaPlena {
		int posicio;
		int preaux = -1; // preaux fara referencia a l'element just anterior. Inicialitzem en -1 de manera arbitraria		
		int aux = this.primer;	// aux salvara la posicio del primer		
		if (!this.esPlena())	//Si no esta plena, afegim un element
		{
			if (this.esBuida()) //si la llista esta buida procedirem diferent
			{
				posicio = this.desapilarBuits();	// Treiem un enter de la llista de buits
				this.primer = posicio;				//Fem que el primer apunti a aquesta posicio (ja que sera la primera)
				this.llista[posicio] = new ObjCursor<T>(a, -1);		// En aquesta posicio creem un nou objecte ObjCursor, passantli l'objecte
				// rebut per parametre i com a referencia posarem -1, ja que sera l'ultim element
				this.numElem++; // modifiquem el nombre d'elements en consecuencia
				return true; // Com hem afegit, sortim
			}
			else
			{
				while (aux!=-1)	// mentre aux (ultim element consultat) no sigui l'ultim element (no apunti a -1)
				{
					int res = this.llista[aux].getObj().compareTo(a);	// Comparem l'element rebut per parametre amb el de la posicio actual
					if (res == 0 )	// Si retorna 0 vol dir que es el mateix element
					{
						return false; //per tant sortim i retornem fals perque no hem d'afegir res
					}
					else if (res > 0) break;//si retorna major que 0 vol dir que l'element al que apunta aux va alfabeticament despres de l'objecte rebut per parametre
					{
						preaux = aux;	//ara preaux apunta al seguent (aux)
						aux = this.llista[aux].getCursor();	// ara aux apunta a l'element seguent, aquest cursor 
						// l'obtenim preguntant-li el seu cursor a l'element al que apuntava aux abans d'actualitzar-se.
					}
				}
			}
			/**
			 *  Ja hem trobat l'element. Hem de conectar les referencies de tal manera que: preaux -> a -> aux
			 * 	També pot passar que sigui la primera iteració i per tant calgui actualitzar el primer element. 
			 * 	Per tant actualitzarem segons: primer -> a -> aux (l'antic primer)
			 */
			posicio = this.desapilarBuits();	// Obtenim la nova posicio on posarem el nou element
			if (preaux == -1)	// Si preaux == -1, vol dir que es la primera iteracio , per tant cal actualitzar el primer.
			{
				this.primer = posicio;	// i fem que el primer sigui la posicio on hem d'inserir el primer element
			}
			else
			{
				this.llista[preaux].setCursor(posicio);	// Assignem el cursor, que apuntara a la nova posicio
			}
			this.llista[posicio] = new ObjCursor<T>(a, aux);	// En la nova posicio buida creem un nou objecte. La referencia sera 
			//a aux llavors el cicle esta tancat. aux pot ser el seguent element o bé pot ser -1, si s'ha arribat al final de la taula
			this.numElem++;	// incrementem el nombre d'elements
			return true;	// Sortim
		}
		else
		{
			throw new LlistaPlena();
		}
		
	}
	/**
	 * Aquest es un metode que s'hauria d'implementar seguint la idea de la llista, però pell problema que s'ens planteja no
	 * ecessitem necessariament aquest métode
	 */
	public T esborrar(T e) throws LlistaBuida {

		return null;
	}

	/**
	 * Serveix per a obtenir una nova posició lliure de la taula per a emmagatzemar un nou element.
	 * També decrementa el nombre d'elements en la pila de buits 
	 * @return retorna un int, que es la posicio on pot ser inserit l'element
	 */
	public int desapilarBuits(){
		this.numElemsbuits--;
		return this.buits[this.numElemsbuits];
	}
	
	/**
	 * Serveix per a guardar una posició lliure de la taula per a emmagatzemar un nou element.
	 * També augmenta el nombre d'elements disponibles en la pila de buits 
	 */
	public void apilarBuits(int n){
		this.buits[this.numElemsbuits]=n;
		this.numElemsbuits++;
	}
	
	/**
	 * Serveix per a comprovar que la taula de buits estigui plena.
	 * Si ho está retornem un boolea que ho indica
	 * @return true si esta plena, false si esta buida
	 */
	public boolean buitsEsPlena()
	{
		return this.buits.length == this.numElemsbuits;
	}
	
	/**
	 * Serveix per a comprovar que la taula de buits estigui buida
	 * @return true si esta buida, false si esta buida
	 */
	public boolean buitsEsBuida()
	{
		return this.numElemsbuits==0;
	}
	
	/**
	 * comprova que la taula principal d'elements genérics estigui plena
	 * @return true si esta plena, sinó false
	 */
	public boolean esPlena()
	{
		return this.llista.length == this.numElem;
	}
	
	/**
	 * comprova que la taula principal d'elements genérics estigui buida
	 * @return true si esta buida, sinó false
	 */
	public boolean esBuida()
	{
		return this.numElem == 0;
	}
	
	/**
	 * Crea un nou iterador per a la propia classe i ho retorna
	 * @return objecte iterable de la llista
	 */
	public Iterator<T> Iterator()
	{
		return new Iterator<T>(this);
	}

	/**
	 * Rep un objecte generic per parametre i el busca al llarg de tota la llista.
	 * Si el troba el retorna, sino retorna null.
	 */
	public Obj<T> consultar(T c) {
		int aux = this.primer;
		while (aux!=-1)
		{
			if (this.llista[aux].getObj().equals(c)) return (Obj<T>)this.llista[aux];
			else aux = llista[aux].getCursor();
		}
		return null;
	}
	
	/**
	 * Getter del nombre d'elements a la llista
	 */
	public int getNumElem(){
		return this.numElem;
	}
	
	/*
	 * Getters dels diferents antributs de la classe
	 */
	public ObjCursor<T>[] getLlista() {
		return llista;
	}

	public void setLlista(ObjCursor<T>[] llista) {
		this.llista = llista;
	}

	public int getPrimer() {
		return primer;
	}

	public void setPrimer(int primer) {
		this.primer = primer;
	}

	public int[] getBuits() {
		return buits;
	}

	public void setBuits(int[] buits) {
		this.buits = buits;
	}

	public int getNumElemsbuits() {
		return numElemsbuits;
	}

	public void setNumElemsbuits(int numElemsbuits) {
		this.numElemsbuits = numElemsbuits;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}
	
}

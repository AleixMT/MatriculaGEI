package TAD;

import tipus.*;


public class Iterator<T extends Comparable<T>> {
	private T[] llista;	//nou atribut per guardar objectes
	private int posicioIterator; //Posicio de l'iterador
	private int numElem=0;	//nombre d'elements
	
	public Iterator(LlistaEstatica<T> ll) {
		int aux = ll.getPrimer();	// aux sera el nostre cursor temporal
		this.posicioIterator=0;		// reaprofitem la variable de la posicio de l'iterador
		while (aux!=-1)	// mentre la referencia no sigui -1, iterarem sobre la llista
		{
			this.llista[this.posicioIterator] = ll.getLlista()[aux].getObj();	// assignem a la posicio actual de l'index l'objecte de la seguent posicio
			this.posicioIterator++;		// Incrementem l'index
			aux = ll.getLlista()[aux].getCursor();	// actualitzem el cursor
		}
		this.posicioIterator = 0;	// reiniciem l'iterador
		this.numElem = ll.getNumElem();		// Actualitzem el nombre d'elements, que sera el mateix nombre d'elements que a la llista
	}
	
	@SuppressWarnings("unchecked")
	public Iterator(Alumne a)
	{
		Matricula aux = a.getRef();
		while (aux!=null)
		{
			this.llista[this.numElem] = (T)aux;
			aux = aux.getSeguentH();
			this.numElem++;
		}
		this.posicioIterator=0;
	}
	
	@SuppressWarnings("unchecked")
	public Iterator(Assignatura as)
	{
		Matricula aux = as.getRef();
		while (aux!=null)
		{
			this.llista[this.numElem] = (T)aux;
			aux = aux.getSeguentV();
			this.numElem++;
		}
		this.posicioIterator=0;
	}
	/**
	 * retorna cert si encara no hem arribat a l'últim element, és a dir, si hi ha "next"
	 * @return true si hi ha un altre element, false si no.
	 */
	public boolean hasNext() {
		return (posicioIterator<this.numElem);	
	}
	
	/**
	 * Retornem el següent element T i incrementem la posicio de l'iterador
	 * @return segent element T
	 */
	public T next() {
		T aux = this.llista[posicioIterator];
		posicioIterator++;
		return aux;
	}
	
	/**
	 * métode extra que serveix per a reiniciar la posicio de l'index en l'iterador 
	 */
	public void reset(){
		this.posicioIterator=0;
	}
	

}

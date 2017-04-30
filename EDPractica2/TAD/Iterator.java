package TAD;

import tipus.*;

public class Iterator<T extends Comparable<T>> {
	private Obj<T>[] llista;	//nou atribut per guardar objectes
	private int posicioIterator; //Posicio de l'iterador
	private int numElem=0;	//nombre d'elements
	
	
	@SuppressWarnings("unchecked")
	public Iterator(LlistaEstatica<T> ll) {
		int aux = ll.getPrimer();	// aux sera el nostre cursor temporal
		int i = 0;
		this.llista = (Obj<T>[]) new Obj[10000];
		while (aux!=-1)	// mentre la referencia no sigui -1, iterarem sobre la llista
		{
			this.llista[i] = ll.getLlista()[aux];	// assignem a la posicio actual de l'index l'objecte de la seguent posicio
			i++;		// Incrementem l'index
			aux = ll.getLlista()[aux].getCursor();	// actualitzem el cursor
		}
		this.posicioIterator = 0;	// iniciem l'iterador
		this.numElem = ll.getNumElem();		// Actualitzem el nombre d'elements, que sera el mateix nombre d'elements que a la llista
	}
	
	public Iterator (LlistaDinamica<T> ll){
		
	}
	
	public Iterator (LlistaJavaUtil<T> ll){
		
	}
	/**
	 * Els sseguent metodes no funcionen
	 * @param a
	 **/
	@SuppressWarnings("unchecked")
	public Iterator(Obj<Alumne> a, Alumne identificatiudelconstructor)
	{
			Matricula aux = a.getNode();
			while (aux!=null)
			{
				this.llista[this.numElem] = (Obj<T>)new Obj<Matricula>(aux);
				aux = aux.getSeguentV();
				this.numElem++;
			}
			this.posicioIterator=0;
			
			
	}	
	
	@SuppressWarnings("unchecked")
	public Iterator(Obj<Assignatura> a, Assignatura identificatiudelconstructor)
	{ 
		Matricula auxx = a.getNode();
		while (auxx!=null)
		{
			this.llista[this.numElem] = (Obj<T>)new Obj<Matricula>(auxx);
			auxx = auxx.getSeguentH();
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
	public Obj<T> next() {
		Obj<T> aux = this.llista[posicioIterator];
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

package TAD;



public class Iterator<T extends Comparable<T>> {
	private NodeEstatic<T>[] llista;	//nou atribut que ens guardar� una copia de la llista actual de punts
	private int posicioIterator;
	private int numElem;
	
	public Iterator(LlistaEstatica<T> ll) {
		int aux = ll.getPrimer();
		this.posicioIterator=0;
		while (aux!=-1)
		{
			this.llista[this.posicioIterator] = new NodeEstatic<T>(ll.getLlista()[aux].getObj(), ll.getLlista()[aux].getNode(), ll.getLlista()[aux].getRef());
			this.posicioIterator++;
			aux = ll.getLlista()[aux].getRef();
		}
		this.posicioIterator = 0;
		this.numElem = ll.getNumElem();
	}
	
	public boolean hasNext() {
		return (posicioIterator<this.numElem);
	}

	public NodeEstatic<T> next() {
		NodeEstatic<T> aux = this.llista[posicioIterator];
		posicioIterator++;
		return aux;
	}

	

}

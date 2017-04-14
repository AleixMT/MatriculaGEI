package TAD;

import java.util.Arrays;
import java.util.Iterator;

import Exceptions.LlistaBuida;
import Exceptions.LlistaPlena;
import Interfaces.TADLlistaGenerica;

public class LlistaJavaUtil<T extends Comparable<T>> implements TADLlistaGenerica<NodeEstatic<T>> {
	private T[] llista;
	private int numElem;
	
	public LlistaJavaUtil(int dim) {
		llista=(T[])new Comparable[dim];
		numElem=0;
	}

	public boolean afegir(NodeEstatic<T> a) throws LlistaPlena {
		return false;
	}

	public NodeEstatic<T> esborrar(NodeEstatic<T> e) throws LlistaBuida {
		return null;
	}

	public int getNumElem() throws LlistaBuida {
		return numElem;
	}

	public T[] getLlista() {
		return llista;
	}

	public void setLlista(T[] llista) {
		this.llista = llista;
	}

	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	@Override
	public String toString() {
		return "LlistaJavaUtil [llista=" + Arrays.toString(llista) + ", numElem=" + numElem + "]";
	}

	
	
}

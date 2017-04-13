package TAD;

import java.util.Arrays;
import java.util.Iterator;

public class LlistaJavaUtil<T extends Comparable<T>> implements Iterable<T> {
	private T[] llista;
	private int num;
	
	public LlistaJavaUtil(int dim) {
		llista=(T[])new Comparable[dim];
		num=0;
	}

	public void afegirElement(T p) {
		if (num>=llista.length) {
			// amplio
			T[] nova=(T[]) new Comparable[llista.length*2];
			for (int i=0; i<llista.length; i++)
				nova[i]=llista[i];
			llista=nova;
		}
		// segur que tinc espai
		int pos=num-1;
		while ((pos>=0) && (p.compareTo(llista[pos])<0)) {
			llista[pos+1]=llista[pos];
			pos--;
		}
		llista[pos+1]=p;
		num++;
	}
	
	public T consultarIessim(int i) {
		if (i<num) return(llista[i]);
		else return(null);
	}
	
	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "LlistaPunts [llista=" + Arrays.toString(llista) + ", num=" + num + "]";
	}

	@Override
	public Iterator<T> iterator() {
		MeuIterator<T> pI=new MeuIterator<T>(this);
		return pI;
	}
	
}

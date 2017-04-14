package TAD;

import tipus.Matricula;

public class NodeEstatic<T extends Comparable<T>> {
	private int ref;
	private Matricula node;
	private T obj;
	
	
	public NodeEstatic(T t, Matricula n, int ref){
		this.obj = t;
		this.node = n;
		this.ref = ref;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Matricula getNode() {
		return node;
	}

	public void setNode(Matricula node) {
		this.node = node;
	}
	
	
}

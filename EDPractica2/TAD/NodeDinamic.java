package TAD;

import tipus.Matricula;

public class NodeDinamic<T extends Comparable<T>> {

	private Matricula node;
	private T obj;
	
	
	public NodeDinamic(T t, Matricula n){
		this.obj = t;
		this.node = n;
	}


	public Matricula getNode() {
		return node;
	}


	public void setNode(Matricula node) {
		this.node = node;
	}


	public T getObj() {
		return obj;
	}


	public void setObj(T obj) {
		this.obj = obj;
	}
	
	
}

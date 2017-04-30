package tipus;

public class Obj <T extends Comparable<T>> implements Comparable<T> {
	private Matricula Node;
	private T obj;
	
	public Obj(T obj) {
		Node = null;
		this.setObj(obj);
	}

	public Matricula getNode() {
		return Node;
	}

	public void setNode(Matricula node) {
		Node = node;
	}

	public int compareTo(T o) {
		return this.obj.compareTo(o);
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}

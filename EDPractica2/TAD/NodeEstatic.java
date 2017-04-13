package TAD;

public class NodeEstatic<T extends Comparable<T>> {
	private int ref;
	private T obj;
	
	public NodeEstatic(T t){
		this.obj = t;
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
	
	
}

package tipus;

public class ObjReferencia <T extends Comparable<T>>{
	private T obj;
	private ObjReferencia<T> ref;
	
	public ObjReferencia(T obj, ObjReferencia<T> ref){
		this.obj = obj;
		this.ref = ref;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public ObjReferencia<T> getRef() {
		return ref;
	}

	public void setRef(ObjReferencia<T> ref) {
		this.ref = ref;
	}
	
	
}

package tipus;

public class ObjReferencia <T extends Comparable<T>> extends Obj<T>{
	private ObjReferencia<T> ref;
	
	public ObjReferencia(T obj, ObjReferencia<T> ref){
		super(obj);
		this.ref = ref;
	}

	public ObjReferencia<T> getRef() {
		return ref;
	}

	public void setRef(ObjReferencia<T> ref) {
		this.ref = ref;
	}

	
	
}

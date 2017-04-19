package tipus;

public class ObjCursor <T extends Comparable<T>>{
	private T Obj;
	private int cursor;
	
	public ObjCursor (T Obj, int cursor){
		this.Obj = Obj;
		this.cursor = cursor;
	}

	public T getObj() {
		return Obj;
	}

	public void setObj(T obj) {
		Obj = obj;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
	
	
}

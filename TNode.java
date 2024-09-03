package application;

public class TNode<T extends Comparable<T>>{
	private T data;
	private TNode<T> right;
	private TNode<T> left;
	
	
	public TNode(T data) {
		super();
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TNode<T> getRight() {
		return right;
	}
	public void setRight(TNode<T> right) {
		this.right = right;
	}
	public TNode<T> getLeft() {
		return left;
	}
	public void setLeft(TNode<T> left) {
		this.left = left;
	}
	
	public boolean isLeaf() {
		if(this.getLeft() == null && this.getRight() == null) return true;
		return false;
	}
	
	
	public boolean hasLeft() {
		if(this.getLeft() != null) return true;
		return false;
	}
	
	
	public boolean hasRight() {
		if(this.getRight() != null) return true ;
		return false;
	}
	@Override
	public String toString() {
		return data + " \n";
	}

	
	
	
}








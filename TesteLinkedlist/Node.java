package teste;

public class Node {
	private int data;
	private Node prox;
	
	public Node(int data, Node prox) {
		this.data = data;
		this.prox = prox;
	}
	
	public Node() {
		this(-1,null);
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getProx() {
		return prox;
	}
	
	public void setProx(Node prox) {
		this.prox = prox;
	}
	
}

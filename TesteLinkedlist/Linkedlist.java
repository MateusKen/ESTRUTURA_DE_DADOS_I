package teste;

public class Linkedlist {
	private Node head;
	
	public Linkedlist() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		Node aux = new Node();
		if (aux != null) {

			aux = null;
			return false;
		}
	else return true;
	}
	
	public void insertHead(int data) {
		if (!isFull()) {
			Node aux = new Node(data, null);
			if (isEmpty()) head = aux;
			else {
				aux.setProx(head);
				head = aux;
			}
		}
		else System.out.print("out of memory");
	}
	
	public void print() {
		if (isEmpty()) System.out.print("L = []");
		else {
			System.out.print("L = [");
			Node pAnda = head;
			while (pAnda != null) {
				System.out.print(" " + pAnda.getData());
				pAnda = pAnda.getProx();
			}
			System.out.print(" ]");
		}
	}
	
}

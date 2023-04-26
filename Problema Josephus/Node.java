package TesteListaCircular;

public class Node {
	private int id;
  private char nome[];
	private Node prox;
	
	public Node() {
		this(0, "",null);
	}
	
	public Node(int id, char nome, Node prox) {
		this.id = id;
		this.prox = prox;
	}

	public Node getProx() { return prox; };
	public int getId(){ return id; };
  public char getNome(){ return nome; }
	
	public void setProx(Node prox) { this.prox = prox; };
	public void setId(int id) { this.id = id;	};	
  public void setNome(char nome){ this.nome = nome;}
	
}

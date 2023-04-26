public class Node {
	private int id;
  private String nome;
	private Node prox;
	
	public Node() {
		this(0, null ,null);
	}
	
	public Node(int id, String nome, Node prox) {
		this.id = id;
    this.nome = nome;
		this.prox = prox;
	}

	public Node getProx() { return prox; };
	public int getId(){ return id; };
  public String getNome(){ return nome; }
	
	public void setProx(Node prox) { this.prox = prox; };
	public void setId(int id) { this.id = id;	};	
  public void setNome(String nome){ this.nome = nome;}
	
}

package exercicio3;

public class Pilha{
	  private static int TAM_DEFAULT = 100;
	  private int topoPilha;
	  private char e[];
	  
	  //CONSTRUTOR COM PARÂMETRO
	  public Pilha(int tamanho){
	    this.e = new char [tamanho];
	    this.topoPilha = -1; 
	  }
	  //CONSTRUTOR VAZIO
	  public Pilha(){
	    this(TAM_DEFAULT);
	  }
	  
	  //VERIFICA SE A PILHA ESTÁ VAZIA
	  public boolean isEmpty(){
	    if (this.topoPilha == -1)
	      return true;
	    else
	      return false;
	  }
	  
	  //VERIFICA SE A PILHA ESTÁ CHEIA
	  public boolean isFull(){
	    if (this.topoPilha == this.e.length-1)
	      return true;
	    else
	      return false;
	  }
	  
	  //INSERE UM ELEMENTO NO TOPO DA PILHA
	  public void push(char e){
	    if (!this.isFull())
	      this.e[++this.topoPilha] = e;
	    else
	      System.out.println("Stack Overflow");
	  }  

	  //REMOVE O ELEMENTO DO TOPO DA PILHA
	  public char pop(){
	    if (!this.isEmpty())
	      return this.e[this.topoPilha--];
	    else{
	      System.out.println("Stack Underflow");
	      return 'n';
	    }
	  }

	  //OBTÉM O ELEMENTO DO TOPO DA PILHA
	  public char top(){
	    if (! this.isEmpty())
	      return this.e[this.topoPilha];
	    else{
	      System.out.println("Stack Underflow");
	      return 'n';
	    }
	  }

	  //OBTÉM A QUANTIDADE DE ELEMENTOS NA PILHA
	  public int sizeElements(){
	    return topoPilha+1;
	  }
	}
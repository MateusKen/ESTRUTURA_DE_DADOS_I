public class Pilha<T>{
  private static int TAM_DEFAULT = 100;
  private int topoPilha;
  private T[] e;

  //CONSTRUTOR COM PARÂMETRO
  public Pilha(int tamanho){
    this.e = (T[]) new Object[tamanho];
    this.topoPilha = -1; 
  }
  //CONSTRUTOR VAZIO
  public Pilha(){
    this(TAM_DEFAULT);
  }
  
  //VERIFICA SE A PILHA ESTÁ VAZIA
  public boolean isEmpty(){
    return this.topoPilha == -1;
  }
  
  //VERIFICA SE A PILHA ESTÁ CHEIA
  public boolean isFull(){
    return this.topoPilha == this.e.length - 1;
  }
  
  public void push(char c){
    if (!this.isFull())
      this.e[++this.topoPilha] = (T) Character.valueOf(c);
    else
      System.out.println("Stack Overflow");
  }  

  //REMOVE O ELEMENTO DO TOPO DA PILHA
  public T pop(){
    if (!this.isEmpty())
      return this.e[this.topoPilha--];
    else{
      System.out.println("Stack Underflow");
      return null;
    }
  }

  //OBTÉM O ELEMENTO DO TOPO DA PILHA
  public char top(){
    if (! this.isEmpty())
      return (char) this.e[this.topoPilha];
    else{
      System.out.println("Stack Underflow");
      return '\0';
    }
  }

  //OBTÉM A QUANTIDADE DE ELEMENTOS NA PILHA
  public int sizeElements(){
    return topoPilha+1;
  }
}

/* 
NOME: ERIK SAMUEL VIANA HSU - TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO - TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA - TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA - TIA: 32210744 
*/
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
  
  //INSERE UM ELEMENTO NO TOPO DA PILHA
  public void push(T elem){
    if (!this.isFull())
      this.e[++this.topoPilha] = elem;
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
  public T top(){
    if (! this.isEmpty())
      return this.e[this.topoPilha];
    else{
      System.out.println("Stack Underflow");
      return null;
    }
  }

  //OBTÉM A QUANTIDADE DE ELEMENTOS NA PILHA
  public int sizeElements(){
    return topoPilha+1;
  }
}

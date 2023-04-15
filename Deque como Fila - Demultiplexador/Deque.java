/* 
NOME: ERIK SAMUEL VIANA HSU - TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO - TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA - TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA - TIA: 32210744 
*/

public class Deque {
	private static final int TAM_DEQUE = 100;
	private	int inicio, fim, qtde;
	private int e[ ];	
	// Construtor que Inicia o Deque d
	// como vazio e tamanho padrão
	public	Deque() {
		this(TAM_DEQUE);
	}
	// Construtor que Inicia o Deque d
	// como vazio e tamanho informado
	// pelo usuário da classe
	public Deque(int tamanho) {
		this.inicio = 0;
		this.fim = 0;
		this.qtde = 0;
		this.e = new int [tamanho];
	}
	// Verifica se o Deque d está vazio
	// retornando true (se vazio)
	// e false (caso contrário)
	public boolean isEmpty( ) {
		return qtde == 0;
	}
	// Verifica se o Deque d está cheio
	// retornando true (se cheio)
	// e false (caso contrário)

	public boolean isFull( ) {
		return qtde == TAM_DEQUE;
	}
	// Obtém o elemento do início do Deque
	public int getLeft ( ) {
		if (! isEmpty( )){
		    return e[inicio];
		} else {
		    System.out.println("deque empty");
		    return -1;
		} 		
	}
	// Obtém o elemento do fim do deque D
	public int getRight ( ) {
		if (! isEmpty( )){
		    if (fim == 0)
		      return e[TAM_DEQUE-1];
		    else
		      return e[fim-1];
		} else {
			System.out.println("deque empty");
		    return -1;
		} 
	}
	// Insere no “início-1” do Deque D
	public void enqueueLeft ( int e ) {
		if (! isFull( )){
		    if (inicio == 0){
		      this.e[TAM_DEQUE-1] = e;
		      inicio = TAM_DEQUE-1;
		    } else this.e[--inicio] = e;
		    qtde++;
		  } else 
			  System.out.println("deque overflow");		
	}
	// Insere no “fim” do Deque D
	public void enqueueRight ( int e ) {
		if (! isFull( )){
		    this.e[fim++] = e;
		    fim = fim % TAM_DEQUE;
		    qtde++;
		} else 
		    System.out.println("deque overflow");
		
	}
	// Remove e retorna um elemento do início do Deque d
	public int dequeueLeft( ) {
		int aux;
		if (! isEmpty( )){
		   aux = e[inicio];
		   inicio = ++inicio % TAM_DEQUE;
		   qtde--;
		   return aux;
		}else{
			System.out.println("deque underflow");
		    return -1;
		}
	}	
	// Remove e retorna um elemento  do final do Deque d
	public int dequeueRight( ) {
		  int aux;
		  if (! isEmpty( )){
		    if (fim == 0) {
		      aux = e[TAM_DEQUE-1];
		      fim = TAM_DEQUE-1;
		    } else {
		      aux = e[fim-1];
		      fim--;
		    }
		    qtde--;
		    return aux;
		  }else{
			  System.out.println("deque underflow");
		    return -1; } 		
	}	
	// Retorna o total de elementos
	// armazenados no deque
	public int size() {
		return qtde;
	}
	
	@Override
	public String toString() {
		
		int indiceNovo = (inicio + qtde) % e.length;
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Deque] quantidade: ")
			.append(qtde)
			.append(", capacidade: ")
			.append(e.length);
		if (qtde != 0) {
			sb.append(", primeiro (Esquerda): ")
				.append(getLeft())
				.append(", último (Direita): ")
				.append(getRight());
		} 
		
		sb.append("\nConteudo do Deque': [ ");
		if (qtde != 0) {
			if (indiceNovo <= inicio) {
				for (int i = inicio; i < e.length; ++i)
					sb.append("[" + e[i] + "]");
				for (int i = 0; i < indiceNovo; ++i)
					sb.append("[" + e[i] + "]");
			} else {
				for (int i = inicio; i < indiceNovo; ++i)
					sb.append("[" + e[i] + "]");
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
}

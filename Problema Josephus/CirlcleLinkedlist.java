package TesteListaCircular;

public class CircleLinkedList {
	private Node head;
	private Node tail;
	private int count;
	
	public CircleLinkedList() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public boolean isFull() {
		Node aux = new Node();
		return aux == null;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean insertTail(int id){
		Node aux;
	    if (!isFull()){ // Não há espaço de memória
	      aux = new Node(id, null);
	      if (isEmpty()){ // Lista está vazia insere no cabeça
	    	aux.setProx(head);
	        head = tail = aux;
	      }else { // Insere no final e atualiza os ponteiros
	    	tail.setProx(aux);
	    	aux.setProx(head);
	    	tail = aux;
	      }
	      count++;
		  return true;
	    }
	    else return false; 
	};
	
	public boolean insertHead(int id){
		Node aux;
	    if (!isFull()){
	      aux = new Node(id, null);
	      if (isEmpty()){ // Lista está vazia
		    aux.setProx(head);
		    head = tail = aux;
	      }else { // Insere no começo e atualiza os ponteiros
	      	aux.setProx(head);
	      	head = aux;
	      	tail.setProx(head);
	      }
	      count++;
	      return true;
	    }
	    else return false; 
	};
	
	public Node search(int id){
		Node pAnda;
		
	    if (isEmpty()) {
			return null; // Lista vazia
	    }else{
	      pAnda = head;
	      // procura a posição do elemento na lista
	      while ((pAnda.getProx() != head) && (pAnda.getId() != id))
	        pAnda = pAnda.getProx();
	      if (pAnda.getId() == id)
	    	  return pAnda; // Retorna a referência para o No 
	      return null; // elemento não encontrado
	    }
	}
	
	
	public boolean remove(int id){
		Node pAnt = null, pAnda;
	    if (isEmpty()) return false; // Lista vazia
	    else{
	      pAnda = head;
	      int contador = 0;
	      // procura a posição do elemento na lista
	      while ((contador != count) && (pAnda.getId() != id)){
	        pAnt = pAnda;
	        pAnda = pAnda.getProx();
	    	contador++;
	      }
	      if ((contador == count) && (pAnda.getId() != id)) 
	    	  return false; // Se não encontrou o elemento
	      // Se elemento encontrado remove da lista
	      else {
	      	// se o elemento encontrado está na cabeça da lista
	    	// e tem somente um elemento
	      	if ((head == pAnda && count == 1)) {
			  head = null;
			  tail = null;
			 // está no cabeça e tem mais elementos
		    } else if ((head == pAnda && count != 1)){ 
		      head = head.getProx();
		      tail.setProx(head);
		    }else {// remove elemento do meio/fim
		    	// Se o elemento estiver no fim
		    	if (pAnda == tail)
		    		tail = pAnt; // Atualiza o fim
		    	pAnt.setProx(pAnda.getProx());
			}
	      	count--;
	      	return true;   
	      }
	    }
	}
	
	public void print(){
		Node pAnda; 
	    System.out.print("L: [ ");
	    if (!isEmpty()) {
	    	pAnda = head;
	    	while (pAnda.getProx() != head) {
	    		System.out.print(pAnda.getId()+" ");
	    		pAnda = pAnda.getProx();
	    	}
	    	System.out.print(pAnda.getId()+" ");
	    }
	    System.out.print("], Qtde.: " + count + ".\n");
	}

	
	public void clear(){
		Node pAnt, pAnda = head;
		
		while(pAnda.getProx() != head){
			pAnt = pAnda;  // Libera o nó
			pAnda = pAnda.getProx();
			pAnt.setProx(null);
			pAnt = null;
		}
		count = 0;
		tail = head = null;	
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		int qtde = 0;
		sb.append("\n[Lista]\n");
	
	    sb.append("L: [ ");
	    Node pAnda = head;
	    while (qtde != count) {
	      sb.append(pAnda.getId()+" ");
	      qtde++;
	      pAnda = pAnda.getProx();
	    }
	    sb.append("]\n");
	    
	    sb.append("Qtde.: " + count);
	    if (count != 0) {
	    	sb.append("\nPrimeiro: " + head.getId() + 
	    			", Ultimo: " + tail.getId());
	    }

	    sb.append("\n");	    
	    return sb.toString();
	}
	
}

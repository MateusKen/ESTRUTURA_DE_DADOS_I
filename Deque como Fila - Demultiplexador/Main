import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Deque d = new Deque();
    String opcoes = "\nMenu de Opções\n\n1 - Lê canal compartilhado\n2 - Imprime canal compartilhado\n3 - Desefileira canal compartilhado\n4 - Imprime as filas geradas\n5 - Encerra\n\n Opção:";
    Scanner ent = new Scanner(System.in);
    String canal = "[";
    int opcao = 0;
    do{
      System.out.print(opcoes);
      opcao = ent.nextInt();
      switch(opcao){
        case 1:
          System.out.println("Lê canal compartilhado: ");
          //Parte inicial da opção 1
          Scanner s = new Scanner(System.in);
          //Receber o valor inicial dos identificadores:
          System.out.print("Digite o número do identificador: ");
          int id = s.nextInt();
          if (id == -1) {
        	  System.out.println("Leituras e inserções finalizadas");
        	  break;
          }
          else if (id < 1 || id > 3) {
        	  System.out.println("Erro: Os números dos identificadores vão apenas de 1 a 3");
        	  break;
          }
          else
        	  d.enqueueLeft(id);
          //Receber o valor inicial dos valores:
          System.out.print("Digite o valor: ");
          int valor = s.nextInt();
          d.enqueueLeft(valor);
          //Loop de leitura e inserção na fila até que o usuário digite -1
    	  while (id > 0 && id <= 3 && id != -1) {
    		  System.out.print("Digite o número do identificador: ");
    		  id = s.nextInt();
    		  if (id == -1) {
    			  System.out.println("Leituras e inserções finalizadas");
    			  break;
    		  }
    		  else if (id < 1 || id > 3) { // tratamento de erro caso o identificador digitado seja menor que 1 ou maior que 3
    			  System.out.println("Erro: Os números dos identificadores vão apenas de 1 a 3");
    			  break;
    		  }
    		  d.enqueueLeft(id);
    		  System.out.print("Digite o valor: ");
    		  valor = s.nextInt();
    		  d.enqueueLeft(valor);
    	  }
          break;
        case 2:
          if (d.isEmpty() == true) {
        	  System.out.println("Erro: A fila correspondente está vazia!");
        	  break;
          }
          else
        	  System.out.println("Imprime canal compartilhado: ");
          	  int tam = d.size(); // variável guarda o size() para usar o valor no for
              for (int i = 0; i < tam; i++){
            	  if (i%2 == 0)
            		  canal += "["+d.dequeueRight()+",";
            	  if (i%2 != 0)
            		  canal += d.dequeueRight()+"],";
              }
              canal += "]";
              System.out.print(canal);
              break;
        case 3:
          System.out.println("Desenfileira canal compartilhado: ");
          break;
        case 4:
          System.out.println("Imprime as filas geradas: ");
          break;
        case 5:
          System.out.println("Encerra o programa");
          ent.close();
          break;
      }
    }while (opcao != 5);
   
  } // fim da primeira função
  
 
} //fim da Main

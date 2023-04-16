/* 
NOME: ERIK SAMUEL VIANA HSU - TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO - TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA - TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA - TIA: 32210744 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Deque d = new Deque();
    String opcoes = "\nMenu de Opções\n\n1 - Lê canal compartilhado\n2 - Imprime canal compartilhado\n3 - Desefileira canal compartilhado\n4 - Imprime as filas geradas\n5 - Encerra\n\n Opção:";
    Scanner ent = new Scanner(System.in);
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
          int id = 0;
          //Tratamento de erro caso a entrada digitada seja de algum tipo primitivo sem ser inteiro
          try {
        	  	id = s.nextInt();
        	  }
          catch(InputMismatchException e) {
        	  System.out.println("Erro: Digite um valor do tipo inteiro!");
        	  break;
          }
          //Caso o identificador seja -1, finaliza as leituras e inserções na fila
          if (id == -1) {
        	  System.out.println("Leituras e inserções finalizadas");
        	  break;
          }
          //Caso o identificador tenha valor < que 1 ou maior que 3, visto que trabalhamos com apenas 3 fluxos numerados de 1 a 3
          else if (id < 1 || id > 3) {
        	  System.out.println("Erro: Os números dos identificadores vão apenas de 1 a 3. A lista será zerada.");
        	  while (d.isEmpty() == false) {
        		  d.dequeueLeft();
        		  d.dequeueRight();
        	  }
        	  break;
          }
          //Caso não haja erros, o número do identificador é enfileirado
          else
        	  d.enqueueLeft(id);
          //Receber o valor inicial dos valores:
          System.out.print("Digite o valor: ");
          int valor = 0;
          //Tratamento de erro caso a entrada do valor digitado seja de algum tipo primitivo sem ser inteiro
          try{
        	  valor = s.nextInt();
          }
          catch(InputMismatchException e){
        	  System.out.println("Erro: Digite um valor do tipo inteiro!");
        	  break;
          }
          //Caso não haja erros, o valor digitado é enfileirado
          d.enqueueLeft(valor);
          //Loop de leitura e inserção na fila até que o usuário digite -1
    	  while (id > 0 && id <= 3 && id != -1) {
    		  System.out.print("Digite o número do identificador: ");
    		  //Tratamento de erro caso a entrada do valor digitado seja de algum tipo primitivo sem ser inteiro
              try{
            	  id = s.nextInt();
              }
              catch(InputMismatchException e){
            	  System.out.println("Erro: Digite um valor do tipo inteiro!");
            	  break;
              }
              //Caso o identificador seja -1, finaliza as leituras e inserções na fila
    		  if (id == -1) {
    			  System.out.println("Leituras e inserções finalizadas");
    			  break;
    		  }
    		  //Tratamento de erro caso o identificador digitado seja menor que 1 ou maior que 3
    		  else if (id < 1 || id > 3) { 
    			  System.out.println("Erro: Os números dos identificadores vão apenas de 1 a 3. A lista será zerada.");
    			  while (d.isEmpty() == false) {
    				  d.dequeueLeft();
    				  d.dequeueRight();
    			  }
    			  break;
    		  }
    		  //Caso não haja erros, o número do identificador é enfileirado
    		  d.enqueueLeft(id);
    		  System.out.print("Digite o valor: ");
    		  //Tratamento de erro caso a entrada do valor digitado seja de algum tipo primitivo sem ser inteiro
    		  try{
    			  valor = s.nextInt();
    		  }
    		  catch(InputMismatchException e) {
    			  System.out.println("Erro: Digite um valor do tipo inteiro!");
            	  break;
    		  }
    		//Caso não haja erros, o valor digitado é enfileirado
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
              String canal = "[";
              Deque temp = new Deque();
              for (int i = 0; i < tam; i++){
                temp.enqueueRight(d.dequeueRight());
            	  if (i%2 == 0)
            		  canal += "["+temp.getRight()+",";
            	  if (i%2 != 0)
            		  canal += temp.getRight()+"],";
              }
              System.out.print(canal);
              for (int i = 0; i < tam; i++){
                d.enqueueRight(temp.dequeueRight());
              }
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
   
  }
 
} //fim da Main

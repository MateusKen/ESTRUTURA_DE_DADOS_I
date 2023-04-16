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
    Deque f1 = new Deque();
    Deque f2 = new Deque();
    Deque f3 = new Deque();
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
              Deque temp = new Deque(); //deque temporario para guardar os valores do dequeue do deque principal
              for (int i = 0; i < tam; i++){
                temp.enqueueRight(d.dequeueRight()); //guarda o valor
            	  if (i%2 == 0)
            		  canal += "["+temp.getRight()+","; //guarda na string o valor guardado no deque temporario
            	  if (i%2 != 0)
                  if (i == tam-1){
                    canal += temp.getRight()+"]"; 
                  }  
                  else{
            		  canal += temp.getRight()+"],";
                  }
              }
              canal += "]";
              System.out.print(canal); //printa a string com os valores do deque
              for (int i = 0; i < tam; i++){
                d.enqueueRight(temp.dequeueRight()); //guarda os valores de volta do deque principal
              }
              break;
        case 3:
          System.out.println("Desefileira canal compartilhado: ");
          if (d.isEmpty() == true) {
        	  System.out.println("Canal compartilhado vazio ");
        	  break;
          }
          else {
          int j = 0;
          int tamD = d.size(); // variável guarda o size() para usar o valor no while
          while ( j < tamD) {
        	  if (d.getRight() == 1) {
        		  d.dequeueRight();
        		  f1.enqueueLeft(d.dequeueRight());       		  
        	  }
        	  else if (d.getRight() == 2) {
        		  d.dequeueRight();
        			  f2.enqueueLeft(d.dequeueRight());       		  
        		  }
        	  
        	  else if (d.getRight() == 3) {
        		  d.dequeueRight();
        		  f3.enqueueLeft(d.dequeueRight());       		  
        	  }
        	  j+=2;
          }
          break;
          }
        case 4:
          System.out.println("Imprime as filas geradas: ");
          if (f1.isEmpty() && f2.isEmpty() && f3.isEmpty()) {
        	  System.out.println("Filas vazias");
        	  break;
          }
          else {
        	  if(f1.isEmpty()) {
        		  System.out.println("Fluxo 1 vazio");
        	  }
        	  else {
        		  System.out.print("Fluxo 1:");
        		  System.out.print("[");
        		  while(f1.isEmpty() == false) {
        			  if (f1.size()!= 1) {
        				  System.out.print(f1.dequeueRight()+"|");
        			  }
        			  else {
        				  System.out.println(f1.dequeueRight()+"]");
        			  }
        		  }

        	 }
        	  if(f2.isEmpty()) {
        		  System.out.println("Fluxo 2 vazio");
        	  }
        	  else {
        		  System.out.print("Fluxo 2:");
        		  System.out.print("[");
        		  while(f2.isEmpty() == false) {
        			  if (f2.size()!= 1) {
        				  System.out.print(f2.dequeueRight()+"|");
        			  }
        			  else {
        				  System.out.println(f2.dequeueRight()+"]");
        			  }
        		  }

        	 }
        	  if(f3.isEmpty()) {
        		  System.out.println("Fluxo 3 vazio");
        	  }
        	  else {
        		  System.out.print("Fluxo 3:");
        		  System.out.print("[");
        		  while(f3.isEmpty() == false) {
        			  if (f3.size()!= 1) {
        				  System.out.print(f3.dequeueRight()+"|");
        			  }
        			  else {
        				  System.out.println(f3.dequeueRight()+"]");
        			  }
        		  }

        	 }
          }
          
          break;
        case 5:
          System.out.println("Encerra o programa");
          ent.close();
          break;
      }
    }while (opcao != 5);
   
  }
 
} //fim da Main

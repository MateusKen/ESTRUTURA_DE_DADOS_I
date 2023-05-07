import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    String opcoes = "\nMenu de Opções\n\n1 - Iniciar: cria uma lista vazia;\n2 - Inserir soldado\n3 - Sortear número\n4 - Retirar soldado\n5 - Mostrar os soldados\n6 - Encerra\n Opção:";
    Scanner ent = new Scanner(System.in);
    int num_sorteado = -1;// Se num_sorteado == -1 --> erro
    
    CircleLinkedlist lista = null;
    int opcao = 0;
    boolean flag = false;
    do{
      System.out.print(opcoes);
      opcao = ent.nextInt();
      switch(opcao){
        case 1:
          System.out.println("Iniciar: cria uma lista vazia");
          lista = new CircleLinkedlist();
          if (lista != null) System.out.print("Lista criada com sucesso.");
          else System.out.print("Problema na criação da lista. ");
          break;
        case 2:
          if (lista == null)
          {
            System.out.print("Crie uma lista antes!\n");
            break;
          }
          else
          {
          System.out.println("Inserir soldado\n");
          Scanner inputStr = new Scanner(System.in);
          Scanner inputInt = new Scanner(System.in);
          int codigo;
          String nome;
          while (true)
          {
          System.out.println("Digite o código do soldado (digitar -1 vai parar o loop): ");
          codigo = inputInt.nextInt();
          if (codigo == -1) break;
          System.out.println("Digite o nome do soldado: ");
          nome = inputStr.nextLine();
            
          lista.insertTail(codigo, nome);
          }}
          break;
          
        case 3:
          System.out.println("Sortear número");
          Random r = new Random();
          int low = 1;
          int high = 101;
          num_sorteado = r.nextInt(high-low) + low;
          System.out.println("Número sorteado:"+num_sorteado);
          break;
        case 4:
          System.out.println("Retirar soldado");
          break;
        case 5:
          System.out.println("Mostrar os soldados");
          lista.print();
          if (lista.getCount() == 1) {
        	  System.out.print("O soldado ganhador é o: ");
        	  lista.print();
          }
          else {
        	  System.out.println("Ainda não temos um soldado ganhador.");
          }
          break;
        case 6:
          System.out.println("Encerra o programa");
          break;
      }
    }while (opcao != 6);
  }
}

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Deque d = new Deque();
    d.enqueueLeft(1); // fluxo
    d.enqueueLeft(4); // valor
    d.enqueueLeft(2); // fluxo
    d.enqueueLeft(5); //valor // d = [5,2,4,1] 
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
          break;
        case 2:
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
          System.out.println("Desefileira canal compartilhado: ");
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
}

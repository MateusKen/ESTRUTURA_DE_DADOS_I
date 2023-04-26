import java.util.scanner
  
class ProblemaJosephus {
  public static void main(String[] args) {
    String opcoes = "\nMenu de Opções\n\n1 - Iniciar: cria uma lista vazia;\n2 - Inserir soldado\n3 - Sortear número\n4 - Retirar soldado\n5 - Mostrar os soldados\n6 - Encerra\n Opção:";
    Scanner ent = new Scanner(System.in);
    int opcao = 0;
    do{
      System.out.print(opcoes);
      opcao = ent.nextInt();
      switch(opcao){
        case 1:
          System.out.println("Iniciar: cria uma lista vazia");
          break;
        case 2:
          System.out.println("Inserir soldado");
          break;
        case 3:
          System.out.println("Sortear número");
          break;
        case 4:
          System.out.println("Retirar soldado");
          break;
        case 5:
          System.out.println("Mostrar os soldados");
          break;
        case 6:
          System.out.println("Encerra o programa");
          break;
      }
    }while (opcao != 6);
  }
}
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Map<Character, Integer> valorVariaveis = new HashMap<>();
    //char[] operacoes = {'+','-','*','/','^'}; 
    //char[] parenteses = {'(', ')'};
    String operacoes = "+-*/^";
    String parenteses = "()";
  
    Scanner s = new Scanner(System.in);
    System.out.print("\nDigite a expressão matemática em notação infixa: ");
    String expressao = s.nextLine();
    
    for (int i = 0; i < expressao.length(); i++){ // for que percorre cada char da expressao 
      if (operacoes.indexOf(expressao.charAt(i)) == -1){ // "se o char não estiver em operacoes" 
        if (valorVariaveis.containsKey(expressao.charAt(i))) // "se o char estiver no dicionário" pule a iteração
          continue;
        System.out.printf("\nQual o valor de %c? ", expressao.charAt(i));
        int valor = s.nextInt();
        valorVariaveis.put(expressao.charAt(i), valor);
      }
        // input do valor da variável, se possível guardar esse valor em algum lugar
      else // "se o char estiver em operacoes"
        op.push(expressao.charAt(i));
  }
        
  }
}}

//NOME: Mateus Kenzo Iochimoto TIA: 32216289

import java.lang.Math;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Map<Character, Integer> valorVariaveis = new HashMap<>();
    Pilha<Character> op = new Pilha<Character>(); // pilha para operações
    Pilha<Integer> variaveis = new Pilha<Integer>();
    Scanner s = new Scanner(System.in);
    String expressao = "";
    String posfixa = "";
    int aux;
    String operacoes = "+-*/^()";

  String opcoes = "\nMenu de Opções\n\n1 - Leitura infixa\n2 - Entrada Variáveis\n3 - Converte pósfixa\n4 - Calcula Resultado\n5 - Encerra\n\n Opção:";
  Scanner ent = new Scanner(System.in);
  int opcao = 0;
  do{
    System.out.print(opcoes);
    opcao = ent.nextInt();
    switch(opcao){
      case 1:
        System.out.println("Leitura infixa");
        System.out.print("\nDigite a expressão matemática em notação infixa: ");
        //expressao = s.nextLine();
        expressao = "(A+B)/(C-D)*E";
        
        break;
        
      case 2:
        System.out.println("Entrada de Variáveis");
          for (int i = 0; i < expressao.length(); i++){ // for que percorre cada char da expressao 
          if (operacoes.indexOf(expressao.charAt(i)) == -1){ // "se o char não estiver em operacoes" 
            if (valorVariaveis.containsKey(expressao.charAt(i))) // "se o char estiver no dicionário" pule a iteração
              continue;
            System.out.printf("\nQual o valor de %c? ", expressao.charAt(i));
            int valor = s.nextInt();
            valorVariaveis.put(expressao.charAt(i), valor);
            //{A=7, B=3, C=6, D=4, E=9}
          }
        }
          break;
      
      case 3:
        System.out.println("Converte Pósfixa");
        break;
              
      case 4:
        System.out.println("Calcula Resultado");
        posfixa = "AB+CD-/E*";
        
        for (int i=0; i<posfixa.length(); i++){
          if (operacoes.indexOf(posfixa.charAt(i)) == -1)
            variaveis.push(valorVariaveis.get(posfixa.charAt(i)));
            
          else{
            if (posfixa.charAt(i) == '+')
              variaveis.push(variaveis.pop()+variaveis.pop());
            if (posfixa.charAt(i) == '-'){
            
              aux = variaveis.pop();
              variaveis.push(variaveis.pop()-aux);
            }
            if (posfixa.charAt(i) == '/'){
              aux =variaveis.pop();
              variaveis.push(variaveis.pop()/aux);
            }
            if (posfixa.charAt(i) == '*')
              variaveis.push(variaveis.pop()*variaveis.pop());
            
            if (posfixa.charAt(i) == '^'){
              aux = variaveis.pop();
              variaveis.push((int) Math.pow(variaveis.pop(), aux));
            }
          }
          
        
        }
        System.out.printf("\nresultado = %d", variaveis.pop()); // print do resultado da operação
        System.out.printf("\nposfixa = %s", posfixa);
        System.out.println("\nvariávis = "+valorVariaveis);
        break;
          
      case 5:
        System.out.println("Encerra o programa");
        break;
      }
    }while (opcao != 5);
    
      
}}

// TODO: criar uma pilha para os valores das variáveis
// opcional^  TODO: dicionário que recebe as variáveis inputadas pelo usuário
// TODO: fazer a string da expressão em notação posfixa e dar um print dela
// TODO: fazer o cálculo da expressão pela string em notação posfixa (printar o passo a passo do cálculo?)
// obs: a classe pilha está configurada para char, será necessário configurar ela para int também, mas se possível procurar um jeito fácil sem ter que criar outro arquivo

/* 
NOME: ERIK SAMUEL VIANA HSU - TIA: 32265921
NOME: MATEUS KENZO IOCHIMOTO - TIA: 32216289
NOME: RODRIGO MACHADO DE ASSIS OLIVEIRA DE LIMA - TIA: 32234678
NOME: THIAGO SHIHAN CARDOSO TOMA - TIA: 32210744 
*/

import java.lang.Math;
import java.util.*;

class Main {
  public static boolean validaExp(String exp) {
		char[] opValidos = new char[5]; 
		opValidos[0] = '+';
		opValidos[1] = '-';
		opValidos[2] = '*';
		opValidos[3] = '/';
		opValidos[4] = '^';
		
		int contAbre = 0;
		int contFecha = 0;
		int contVariavel = 0;
		
		for(int i=0; i < exp.length();i++) {
			if (exp.charAt(i) == '(')
				contAbre++;
			if (exp.charAt(i) == ')')
				contFecha++;
			if (contFecha > contAbre) {
				System.out.print("Parênteses incorretos, expressão inválida.");
				return false;
			}
			if(Character.isLetter(exp.charAt(i)))
					contVariavel++;
			if (i!= exp.length()-1 && Character.isLetter(exp.charAt(i)) && Character.isLetter(exp.charAt(i+1))) {
				System.out.print("Apenas variáveis de 1 são letra aceitas, expressão inválida.");
				return false;
			}
			if(Character.isLetter(exp.charAt(i)) == false && exp.charAt(i) != '(' && exp.charAt(i)!= ')') {
				int valido = 0;
				for (int j=0; j < 5;j++) {
					if (exp.charAt(i) == opValidos[j])
						valido = 1;
				}
			if (valido == 0) {
				System.out.print("Operando ou operador não reconhecido, expressão inválida.");
				return false;
			}
			else {
				if(valido == 1 && i < exp.length()-1) {
					for(int k = 0;k < 5; k++) {
						if((exp.charAt(i+1))== opValidos[k]) {
							System.out.print("Dois operadores seguidos, expressão inválida.");
							return false;	
						}
						
					}
				}
			}
			}
		}
		if (contVariavel == 0) {
			System.out.print("Nenhuma variável detectada, expressão inválida.");
			return false;
		}
		if (contAbre != contFecha) {
			System.out.print("Parênteses incorretos, expressão inválida.");
			return false;
		}
		System.out.print("Expressão válida.");
		return true;
	}
  //Etapa de Parentização da expressão
	public static String ConvertePosfixa(String exp) {
		Pilha<Character> pilha1 = new Pilha<Character>();
		String expConvertida = "";
	
		for (int i = 0; i < exp.length(); i++) { 
			char c = exp.charAt(i); 
			//Se for '(', sempre deve ser empilhado
			if (exp.charAt(i) == '(') {
				pilha1.push(exp.charAt(i));
			}
			//Se for operando (letra), copiá-lo para a expressão pósfixa
			else if (Character.isLetter(exp.charAt(i)) == true) {
				expConvertida += exp.charAt(i);
			}
			//Se for operador, fazê-lo aguardar
			else if(exp.charAt(i) == '+' ||exp.charAt(i) == '-' ||exp.charAt(i) == '*' ||exp.charAt(i) == '/' ||exp.charAt(i) == '^') {
				while(pilha1.isEmpty() == false && pilha1.top() != '(' && precedencia(pilha1.top()) >= precedencia(c)) {
					expConvertida += pilha1.pop();
				}
				pilha1.push(exp.charAt(i));
			}
			//Se for ')', adicionar o último operador (topo da pilha) na expressão
			else if(exp.charAt(i) == ')') {
				while(pilha1.isEmpty() == false && pilha1.top() != '(') {
					expConvertida += pilha1.pop();
				}
				if (pilha1.isEmpty() == false && pilha1.top() == '(') {
					pilha1.pop();
				}
				else {
					System.out.println("Expressão inválida");
					return null;
				}
			}
		}
		while(pilha1.isEmpty() == false) {
			if (pilha1.top() == '(') {
				System.out.println("Expressão inválida");
				return null;
			}
			expConvertida += pilha1.pop();
		} 
		return expConvertida;
	 // Final da função ParentizaExp
}
	//Função que determina precedência dos operadores matemáticos
		public static int precedencia(char c) {
			if (c == '^') { //Operador de potencialização é o com maior precedência
				return 4;
			}
			else if(c == '*' || c == '/') { //Em seguida os operadores de multiplicação e divisão
				return 3;
			}
			else if(c == '+' || c == '-') {//Em seguida os operadores de soma e subtração
				return 2;
			}
			else {
				return 1;
			}
		}

  public static void main(String[] args) {
    Map<Character, Integer> valorVariaveis = new HashMap<>();
    Pilha<Character> op = new Pilha<Character>(); // pilha para operações
    Pilha<Integer> variaveis = new Pilha<Integer>();
    Scanner s = new Scanner(System.in);
    String expressao = "";
    String posfixa = "";
    int aux;
    String operacoes = "+-*/^()";
    boolean flag = false;

  String opcoes = "\n\nMenu de Opções\n\n1 - Leitura infixa\n2 - Entrada Variáveis\n3 - Converte pósfixa\n4 - Calcula Resultado\n5 - Encerra\n\n Opção:";
    
  Scanner ent = new Scanner(System.in);
  int opcao = 0;
  do{
    System.out.print(opcoes);
    opcao = ent.nextInt();
    switch(opcao){
      case 1:
        System.out.println("Leitura infixa");
        System.out.print("\nDigite a expressão matemática em notação infixa: ");
        expressao = s.nextLine();
        flag = validaExp(expressao);
        valorVariaveis.clear(); //limpa o dicionário
        //op.clear();  //limpa a pilha
        //variaveis.clear();  //limpa a pilha
        
        break;
        
      case 2:
        if (flag != false){
        System.out.println("Entrada de Variáveis");
          for (int i = 0; i < expressao.length(); i++){ // for que percorre cada char da expressao 
          if (operacoes.indexOf(expressao.charAt(i)) == -1){ // "se o char não estiver em operacoes" 
            if (valorVariaveis.containsKey(expressao.charAt(i))) // "se o char estiver no dicionário" pule a iteração
              continue;
            System.out.printf("\nQual o valor de %c? ", expressao.charAt(i));
            int valor = s.nextInt();
            valorVariaveis.put(expressao.charAt(i), valor);
            //  (A+B)/(C-D)*E
            //{A=7, B=3, C=6, D=4, E=9}
          }
        }}
          break;
      
      case 3:
        if (flag != false){
        System.out.println("Converte Pósfixa");
        posfixa = ConvertePosfixa(expressao);
        System.out.printf("posfixa = %s",posfixa);
        }
        break;
              
      case 4:
        System.out.println("Calcula Resultado");
        
        
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
        System.out.println("\nvariáveis = "+valorVariaveis);
        break;
          
      case 5:
        System.out.println("Encerra o programa");
        break;
      }
    }while (opcao != 5);
    
      
}}

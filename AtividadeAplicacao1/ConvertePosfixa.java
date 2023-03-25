//Etapa de Parentização da expressão
	public static <T> String ConvertePosfixa(String exp) {
		Pilha<T> pilha1 = new Pilha<T>();
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

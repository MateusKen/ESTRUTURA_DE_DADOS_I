//Etapa de Parentização da expressão
	public static String ConvertePosfixa(String exp) {
		Pilha<Character> pilha1 = new Pilha<Character>();
		String expConvertida = "";
	
		for (int i = 0; i < exp.length(); i++) { 
			char c = exp.charAt(i); 
			//Se for '(', sempre deve ser empilhado, pois indica o início de uma operação matemática
			if (exp.charAt(i) == '(') {
				pilha1.push(exp.charAt(i));
			}
			//Se for operando (letra), copiá-lo diretamente para a expressão pósfixa
			else if (Character.isLetter(exp.charAt(i)) == true) {
				expConvertida += exp.charAt(i);
			}
			//Se for operador, fazê-lo aguardar
			else if(exp.charAt(i) == '+' ||exp.charAt(i) == '-' ||exp.charAt(i) == '*' ||exp.charAt(i) == '/' ||exp.charAt(i) == '^') {
				
				while(pilha1.isEmpty() == false && pilha1.top() != '(' && precedencia(pilha1.top()) >= precedencia(c)) {
					//Enquanto for verdadeiro, o topo da pilha é removido e adicionado à string expConvertida
					expConvertida += pilha1.pop();
				}
				//Quando a pilha estiver vazia, o operador atual é empilhado na pilha.
				pilha1.push(exp.charAt(i));
			}
			//Se for ')', adicionar o último operador (topo da pilha) na expressão
			//Essa etapa garante que a expressão dentro dos parênteses seja calculada antes do restante da expressão
			else if(exp.charAt(i) == ')') {
				//Loop para remover os operadores da pilha até que encontre '('
				while(pilha1.isEmpty() == false && pilha1.top() != '(') {
					expConvertida += pilha1.pop();
				}
				//Se for encontrado, ele é removido da pilha e o loop é encerrado
				if (pilha1.isEmpty() == false && pilha1.top() == '(') {
					pilha1.pop();
				}
				//Se não, a expressão é inválida e retorna null
				else {
					System.out.println("Expressão inválida");
					return null;
				}
			}
		}
		//Desempilhar operadores e operandos que restaram na pilha
		//Garantindo que todos os caracteres sejam processados e que a expressão seja válida
		while(pilha1.isEmpty() == false) {
			//Se for '(', a expressão é inválida e retorna null
			if (pilha1.top() == '(') {
				System.out.println("Expressão inválida");
				return null;
			}
			//Caso contrário, o operador ou operando é adicionado à expConvertida
			expConvertida += pilha1.pop();
		} 
		//Retorna a expressão pósfixa
		return expConvertida;
	 // Final da função ParentizaExp
}
	//Função que determina precedência dos operadores matemáticos
	//Quanto maior for o número retornado, maior a precedência do caracter
	//Operadores com a mesma precedência serão avaliados da esquerda para a direita
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

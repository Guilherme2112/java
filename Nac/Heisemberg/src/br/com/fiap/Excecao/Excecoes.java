package br.com.fiap.Excecao;

public class Excecoes extends Exception{
	
	private static final long serialVersionUID = 1L;

	public Excecoes (String msg){
		System.out.println(msg);
	}
	
	public Excecoes(Exception e){
		if(e.getClass().toString().equals("class java.lang.ArithmeticException")){
			System.out.println("Cálculo inválido.");
		}
		else if(e.getClass().toString().equals("class java.lang.NumberFormatException")){
			System.out.println("Número inválido.");
		}
		else if(e.getClass().toString().equals("class java.lang.NullPointerException")){
			System.out.println("Referência a valor nulo.");
		}
		else if(e.getClass().toString().equals("class java.lang.ArrayIndexOutOfBoundsException")){
			System.out.println("Vetor Estourado.");
		}
		else if(e.getClass().toString().equals("class java.lang.FileNotFoundException")){
			System.out.println("Arquivo não Encontrado.");
		}
		else if(e.getClass().toString().equals("class java.lang.IllegalArgumentsException")){
			System.out.println("Argumento inválido;");
		}else{
			e.printStackTrace();
			System.out.println("Erro desconhecido.Contate os Desenvolvedores.");
			
		}
	}

}

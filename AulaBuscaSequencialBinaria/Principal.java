package AulaBuscaSequencialBinaria;

public class Principal {

	public static void main(String[] args) {
		
		Colecao colecao = new Colecao();
		
		
		System.out.println("------------Busca Sequencial-----------------");
		System.out.println("Posicao do elemento 23 = " + colecao.buscaSequencial(23));
		System.out.println("Posicao do elemento 12 = " + colecao.buscaSequencial(12));
		System.out.println("Posicao do elemento 76 = " + colecao.buscaSequencial(76));
		System.out.println("Posicao do elemento 99 = " + colecao.buscaSequencial(99));
		System.out.println("");
		System.out.println("------------Busca Binária-----------------");
		
		System.out.println("Posicao do elemento 23 = " + colecao.buscaBinaria(23));
		System.out.println("Posicao do elemento 12 = " + colecao.buscaBinaria(12));
		System.out.println("Posicao do elemento 76 = " + colecao.buscaBinaria(76));
		System.out.println("Posicao do elemento 99 = " + colecao.buscaBinaria(99));

	}

}

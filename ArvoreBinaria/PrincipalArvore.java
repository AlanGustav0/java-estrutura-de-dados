package ArvoreBinaria;

public class PrincipalArvore {

	public static void main(String[] args) {
		
		Elemento elemento = new Elemento(0);

		
		Arvore arvore = new Arvore(new Elemento(12));
		arvore.inserir(new Elemento(16));
		arvore.inserir(new Elemento(4));
		arvore.inserir(new Elemento(2));
		arvore.inserir(new Elemento(8));
		arvore.inserir(new Elemento(6));
	
		
		
	
		
		/*
		arvore.imprimeInOrdem();
		System.out.println("");
		
		//elemento.setValor(38);
		//arvore = arvore.remover(elemento);
		
		System.out.println("---Nova árvore---");
		arvore.imprimeInOrdem();
		System.out.println("");
	
		
		arvore.imprimeInOrdem();
		System.out.println("");
		arvore.imprimePosOrdem();
		System.out.println("");
		arvore.ImprimeInOdermInvertida();
		System.out.println("");
		*/
		
		
		arvore.imprimePreOrdem();
		System.out.println("");
		arvore.imprimePosOrdem();
		
		

		/*
		System.out.println("O elemento 5 " + (arvore.busca(5) ? "existe" : "não existe"));
		System.out.println("O elemento 5 " + (arvore.busca(12) ? "existe" : "não existe"));
		System.out.println("O elemento 5 " + (arvore.busca(18) ? "existe" : "não existe"));
		System.out.println("O elemento 5 " + (arvore.busca(34) ? "existe" : "não existe"));
		*/

	}

}


public class ArvoreBinariaBusca {

	private No raiz;
	
	public ArvoreBinariaBusca() {
		this.raiz = null;
		
	}
	
	
	
	private No inserirNoRecursivo(No no, Aluno aluno) {
		
		//recebe um nó da árvore (no) e um aluno a ser inserido 
		
		if (no == null) {
			return new No(aluno);
			
		}
		
		//verifica se o nó é nulo se for nulo cria um novo nó
		
		if( aluno.rgm < no.aluno.rgm) {
			no.esquerda = inserirNoRecursivo(no.esquerda, aluno);
			
		}
		//compara  o rgm com o no atual , se for menor vai ser colocado a esquerda 
		else if( aluno.rgm > no.aluno.rgm) {
			no.direita = inserirNoRecursivo(no.direita, aluno);
		}
		// se for maior vai ser colocado a direita
		
		return no;
			
		
	}
	
	public void  inserir(Aluno aluno) {
		this.raiz = inserirNoRecursivo(this.raiz , aluno);
		
	}
	//chama o metodo inserir recursivo passando a raiz e o aluno a ser inserido
	
	
	 private void buscarNoRecursivo(No no, int rgm) {
		 // recebe um no da arvore e o rgm da busca
		 
	        if (no == null) {
	            System.out.println("Aluno não encontrado.");
	            return;
	        }
	        
	        //verifica se o rgm existe na arvore, senao volta uma mensagem

	        if (rgm == no.aluno.rgm) {
	        	
	            System.out.println("Aluno encontrado: " + no.aluno.nome);
	            
	            //se o rgm buscado for igual ao encontrado volta uma mensagem
	            
	        } else if (rgm < no.aluno.rgm) {
	        	
	            buscarNoRecursivo(no.esquerda, rgm);
	            
	            // se nao for encontrado , e o rgm for menor do que o comparado , comeca a busca a esquerda
	        } else {
	            buscarNoRecursivo(no.direita, rgm);
	            
	            //se nao estiver a esquerda comeca a busca a direita
	        }
	        
	        
	    }
	 
	 public void buscar(int rgm) {
		 
	        buscarNoRecursivo(this.raiz, rgm);
	    }
	 
		//chama o metodo buscar recursivo passando a raiz e o aluno a ser procurado

}



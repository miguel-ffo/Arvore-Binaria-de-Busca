import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca {

	private No raiz;

	public ArvoreBinariaBusca() {
		this.raiz = null;

	}
	


	public void esvaziar() {
		// TODO Auto-generated method stub
		this.raiz = null;
	}

	private No inserirNoRecursivo(No no, Aluno aluno) {

		// recebe um nó da árvore (no) e um aluno a ser inserido

		if (no == null) {
			return new No(aluno);

		}

		// verifica se o nó é nulo se for nulo cria um novo nó

		if (aluno.rgm < no.aluno.rgm) {
			no.esquerda = inserirNoRecursivo(no.esquerda, aluno);

		}
		// compara o rgm com o no atual , se for menor vai ser colocado a esquerda
		else if (aluno.rgm > no.aluno.rgm) {
			no.direita = inserirNoRecursivo(no.direita, aluno);
		}
		// se for maior vai ser colocado a direita

		return no;

	}

	public void inserir(Aluno aluno) {
		this.raiz = inserirNoRecursivo(this.raiz, aluno);

	}
	// chama o metodo inserir recursivo passando a raiz e o aluno a ser inserido

	private void buscarNoRecursivo(No no, int rgm) {
		// recebe um no da arvore e o rgm da busca

		if (no == null) {
			System.out.println("Aluno não encontrado.");
			return;
		}

		// verifica se o nó existe na arvore, senao volta uma mensagem

		if (rgm == no.aluno.rgm) {

			System.out.println("Aluno encontrado: " + no.aluno.nome);

			// se o rgm buscado for igual ao encontrado volta uma mensagem

		} else if (rgm < no.aluno.rgm) {

			buscarNoRecursivo(no.esquerda, rgm);

			// se nao for encontrado , e o rgm for menor do que o comparado , comeca a busca
			// a esquerda
		} else {
			buscarNoRecursivo(no.direita, rgm);

			// se nao estiver a esquerda comeca a busca a direita
		}

	}

	public void buscar(int rgm) {

		buscarNoRecursivo(this.raiz, rgm);
	}

	// chama o metodo buscar recursivo passando a raiz e o aluno a ser procurado

	// Esta função realiza a remoção recursiva de um nó em uma árvore binária de
	// busca.
	private No deletarRecursivo(No no, int rgm) {

		// Verifica se o nó atual é nulo (fim da árvore) e retorna null.

		if (no == null) {
			return null;
		}

		// Verifica se o RGM do nó atual é igual ao RGM que queremos remover.

		if (rgm == no.aluno.rgm) {

			// Se o nó não tem filho à esquerda, retorna o filho à direita para "substituir"
			// o nó a ser removido.

			if (no.esquerda == null) {

				return no.direita;

			} else if (no.direita == null) {

				// Se o nó não tem filho à direita, retorna o filho à esquerda para "substituir"
				// o nó a ser removido.

				return no.esquerda;

			}

			// Encontra o menor nó na subárvore à direita para substituir o nó a ser
			// removido.

			No temp = encontrarMenorNo(no.direita);

			no.aluno = temp.aluno;

			// Substitui o aluno do nó a ser removido pelo aluno do menor nó encontrado.

			no.direita = deletarRecursivo(no.direita, temp.aluno.rgm);

			// Remove recursivamente o nó duplicado da subárvore à direita.

		} else if (rgm < no.aluno.rgm) {

			// Se o RGM que queremos remover é menor que o RGM do nó atual, avança para a
			// subárvore esquerda.

			no.esquerda = deletarRecursivo(no.esquerda, rgm);

		} else {

			// Se o RGM que queremos remover é maior que o RGM do nó atual, avança para a
			// subárvore direita.

			no.direita = deletarRecursivo(no.direita, rgm);
		}

		// Retorna o nó atual após as operações de remoção.

		return no;
	}

	// Este método encontra o nó com o menor valor na subárvore cuja raiz é o nó
	// passado como argumento.
	

    public void deletar(int rgm) {
        this.raiz = deletarRecursivo(this.raiz, rgm);
    }

	private No encontrarMenorNo(No no) {

		// Inicia o nó atual como o nó passado como argumento.

		No atual = no;

		// Enquanto houver um filho à esquerda, avança para esse filho (que tem um valor
		// menor).

		while (atual.esquerda != null) {

			atual = atual.esquerda;
		}
		// Retorna o nó atual, que é o nó com o menor valor na subárvore.

		return atual;
	}

	// Este método altera recursivamente o nome de um aluno com um RGM específico na
	// árvore binária de busca.

	private void alterarRecursivo(No no, int rgm, String novoNome) {

		// Verifica se o nó atual é nulo, indicando que o aluno com o RGM especificado
		// não foi encontrado.

		if (no == null) {

			return; // Retorna sem fazer nada, pois o aluno não está presente na árvore.
		}

		// Verifica se o RGM do nó atual é igual ao RGM do aluno que queremos alterar.

		if (rgm == no.aluno.rgm) {
			no.aluno.nome = novoNome;

			// Altera o nome do aluno para o novo nome especificado.

			return;

			// Retorna após a alteração, pois já realizou o que era necessário.
		}

		// Se o RGM que queremos alterar é menor que o RGM do nó atual, avança para a
		// subárvore esquerda.

		if (rgm < no.aluno.rgm) {

			alterarRecursivo(no.esquerda, rgm, novoNome);

		} else {

			// Caso contrário, avança para a subárvore direita.

			alterarRecursivo(no.direita, rgm, novoNome);
		}

	}

	// Este método público serve como uma interface para a operação de alteração de
	// nome de um aluno na árvore.

	public void alterar(int rgm, String novoNome) {

		// Chama o método alterarRecursivo, passando a raiz da árvore, o RGM e o novo
		// nome.

		alterarRecursivo(this.raiz, rgm, novoNome);

	}

	// Este método público inicia o processo de listagem de todos os alunos na
	// árvore.

	
	public List<Aluno> listarPreOrdem() {
	    List<Aluno> alunos = new ArrayList<>();
	    listarPreOrdemRecursivo(this.raiz, alunos);
	    return alunos;
	}
	
	private void listarPreOrdemRecursivo(No no, List<Aluno> alunos) {
		if (no != null) {
			alunos.add(no.aluno); // Adiciona o nó atual à lista antes de visitar as subárvores.
			listarPreOrdemRecursivo(no.esquerda, alunos);
			listarPreOrdemRecursivo(no.direita, alunos);
		}
	}

	public List<Aluno> listarInOrdem() {
		List<Aluno> alunos = new ArrayList<>();
		listarInOrdemRecursivo(this.raiz, alunos);
		return alunos;
	}

	private void listarInOrdemRecursivo(No no, List<Aluno> alunos) {
		if (no != null) {
			listarInOrdemRecursivo(no.esquerda, alunos);
			alunos.add(no.aluno); // Adiciona o nó atual à lista após visitar a subárvore esquerda.
			listarInOrdemRecursivo(no.direita, alunos);
		}
	}

	public List<Aluno> listarPosOrdem() {
		List<Aluno> alunos = new ArrayList<>();
		listarPosOrdemRecursivo(this.raiz, alunos);
		return alunos;
	}

	private void listarPosOrdemRecursivo(No no, List<Aluno> alunos) {
		if (no != null) {
			listarPosOrdemRecursivo(no.esquerda, alunos);
			listarPosOrdemRecursivo(no.direita, alunos);
			alunos.add(no.aluno); // Adiciona o nó atual à lista após visitar as subárvores.
		}
	}
	
	


}

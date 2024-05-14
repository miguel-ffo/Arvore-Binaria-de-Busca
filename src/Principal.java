import java.util.List;
import java.util.Scanner;

public class Principal {
	 public static void main(String[] args) {
	        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	        Scanner scanner = new Scanner(System.in);
	        int opcao;
	        
	        System.out.println("\nGRUPO: ");
            System.out.println("1. Anna Maria");
            System.out.println("2. Anthonny");
            System.out.println("3. Maria Eduarda");
            System.out.println("4. Miguel Figueiredo");
            System.out.println("5. Milena Alves");
            System.out.println("6. Rafael Almeida");

            System.out.println("\nDISCIPLINA: ESTRUTURA DE DADOS I");
            System.out.println("PROFESSOR: WALACE BONFIM");
            System.out.println("EDITOR DE ÁRVORE");

	     
	      
	        do {
	           
	            System.out.println("\n1 – INSERIR ALUNO");
	            System.out.println("2 – REMOVER ALUNO");
	            System.out.println("3 – PESQUISAR ALUNO");
	            System.out.println("4 – ESVAZIAR A ÁRVORE");
	            System.out.println("5 – EXIBIR A ÁRVORE");
	            System.out.println("0 – SAIR");

	            System.out.println("\nDIGITE SUA OPÇÃO:");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.println("Digite o RGM do aluno:");
	                    int rgmInsere = scanner.nextInt();
	                    System.out.println("Digite o nome do aluno:");
	                    String nomeInsere = scanner.next();
	                    arvore.inserir(new Aluno(rgmInsere, nomeInsere));
	                    break;
	                case 2:
	                    System.out.println("Digite o RGM do aluno a remover:");
	                    int rgmRemove = scanner.nextInt();
	                    arvore.deletar(rgmRemove);
	                    break;
	                case 3:
	                    System.out.println("Digite o RGM do aluno a buscar:");
	                    int rgmBusca = scanner.nextInt();
	                    
	                    arvore.buscar(rgmBusca);
	                    
	                    
	                    break;
	                case 4:
	                	
	                    arvore.esvaziar();
	                    System.out.println("Árvore esvaziada.");
	                    break;
	                case 5:
	                    System.out.println("Escolha a ordem de listagem:");
	                    System.out.println("    a) PRÉ-ORDEM");
	                    System.out.println("    b) IN-ORDEM");
	                    System.out.println("    c) PÓS-ORDEM");
	                    char ordem = scanner.next().charAt(0);
	                    List<Aluno> listaAlunos;
	                    switch (ordem) {
	                        case 'a':
	                            listaAlunos = arvore.listarPreOrdem();
	                            System.out.println("Lista de Alunos em Pré-ordem:");
	                            arvore.listarPreOrdem();
	                            for (Aluno aluno : listaAlunos) {
	                                System.out.println("RGM: " + aluno.rgm + ", Nome: " + aluno.nome);
	                            }
	                            break;
	                        case 'b':
	                            listaAlunos = arvore.listarInOrdem();
	                            
	                            System.out.println("Lista de Alunos em In-ordem:");
	                            arvore.listarInOrdem();
	                            for (Aluno aluno : listaAlunos) {
	                                System.out.println("RGM: " + aluno.rgm + ", Nome: " + aluno.nome);
	                            }
	                            break;
	                        case 'c':
	                            listaAlunos = arvore.listarPosOrdem();
	                            System.out.println("Lista de Alunos em Pós-ordem:");
	                            arvore.listarPosOrdem();
	                            for (Aluno aluno : listaAlunos) {
	                                System.out.println("RGM: " + aluno.rgm + ", Nome: " + aluno.nome);
	                            }
	                            break;
	                        default:
	                            System.out.println("Opção de ordem inválida!");
	                            continue;
	                    }
	                    
	                    break;
	                case 0:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            }

	        } while (opcao != 0);

	        scanner.close();
	    }

}



package calculadora;

import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o valor de investimento : ");
		double valor = scan.nextDouble();

		int compartilha = 0;
		int visualizacaoOriginal = 0;
		int visualizacao = 0;
		int totalVisualizacao = 0;
		int totalCompartilha = 0;
		int totalAnuncio = 0;

		while (totalCompartilha <= 4) {
			int cliques = 0;

			if (compartilha == 0) {
				// primeira vez que entrou no loop,incializando visualização.

				visualizacaoOriginal = (int) Math.round(valor * 30);

				visualizacao = obterVisualizacoes(valor);
			}

			if (totalVisualizacao == 0) {

				cliques = obterCliques(visualizacaoOriginal);

			} else {

				cliques = obterCliques(visualizacao);
			}

			compartilha = obterCompartilhamento(cliques);
			totalCompartilha += compartilha;

			visualizacao = obterVisualizacoesPorCompartilhamento(compartilha);
			totalVisualizacao += obterVisualizacoesPorCompartilhamento(compartilha);

			/**
			 * Se compartilha == 4 sai do loop e imprime os resultados Se nao ...continua
			 **/

			if (totalCompartilha == 0 || totalCompartilha == 4) {

				break;
			}

		}

		totalAnuncio = totalVisualizacao + visualizacaoOriginal;

		System.out.println("Visualizações anuncio compartilhado  : " + totalVisualizacao);
		System.out.println("Visualizações de anuncio original: " + visualizacaoOriginal);
		System.out.println("Projeção aproximada de total de visualizações do anuncio : " + totalAnuncio);

	}

	/**
	 * Metodo que obtem quantidades de cliques atraves de visualizaçoes
	 * 
	 * @param visualizacoes
	 * @return quantidades de cliques de acordo com visualizaçoes
	 */
	private static int obterCliques(int visualizacoes) {
		return (int) Math.round(visualizacoes * 0.12);
	}

	/**
	 * Metodo que calcula visualizacoes
	 * 
	 * @param valor
	 * @return quantidade de anuncios de acordo com o valor investido
	 */
	private static int obterVisualizacoes(double valor) {
		return (int) Math.round(valor * 30);
	}

	/**
	 * Metodo que calcula os compartilhamentos atraves de cliques
	 * 
	 * @param cliques
	 * @return quantidade de compartilhamento
	 */
	private static int obterCompartilhamento(int cliques) {
		return (int) Math.round(cliques * 0.15);
	}

	/**
	 * Metodo que obtem o numero de visualizacao por compartilhamento
	 * 
	 * @param compartilha
	 * @return quantidade de novas visualizacao atravez do compartilhamento
	 */

	private static int obterVisualizacoesPorCompartilhamento(int compartilha) {
		return compartilha * 40;
	}

}

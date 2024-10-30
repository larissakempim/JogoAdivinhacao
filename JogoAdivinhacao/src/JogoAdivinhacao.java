import java.util.Random;
import java.util.Scanner;
//O import java.util.Random serve para gerar números aleatórios. 
//Já o import java.util.Scanner serve para ler as entradas do usuário.
//Primeiro foi criado uma public class, onde é organizado e rodado todo o código. 
public class JogoAdivinhacao{
	//Método para rodar o jogo.
	public static void main(String[] args) {
		//Criado para armazenar a entrada de dados do usuário.
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //O System.out.println imprime para o usuário as boas vindas e instruções. 
        System.out.println("Bem-vindo ao jogo de Adivinhação de Números!");
        System.out.println("Por favor, siga os passos abaixo para jogar");
        //Uma try para executar um conjunto de instruções, entre essas instruções o intervalo de números a ser decidido pelo usuário. 
        try {
            System.out.print("1 - Defina o número mínimo do intervalo: ");
            int min = Integer.parseInt(scanner.nextLine());
            System.out.print("2 - Defina o número máximo do intervalo: ");
            int max = Integer.parseInt(scanner.nextLine());
            //Caso o usuário insira um número mínimo menor que o máximo, o jogo será encerrado e ele será alertado, para isso serve o if.
            if (min >= max) {
                System.out.println(""
                		+ "!!Jogo encerrado!!");
                System.out.println("Obs: O valor máximo deve ser maior que o valor mínimo.");
                return;
            }
            //Gera o número aleatório do intervalo definido.
            int numeroSecreto = random.nextInt(max - min + 1) + min;
            //Contador das tentativas do usuário para acertar o número. 
            int tentativas = 0;
            boolean acertou = false;
            //Mensagem para o usuário dizendo que o número foi gerado.
            System.out.println("Um número foi gerado entre " + min + " e " + max + ". Agora é a sua vez, tente adivinhar!");
            //Inicia o loop do jogo, a estrutura while serve para criar uma repetição, onde o bloco será executado repetidamente enquanto a condição for verdadeira.
            while (!acertou) {
                System.out.print("Ou digite sua tentativa ou 'sair' para encerrar o jogo: ");
                String entrada = scanner.nextLine();
                //Caso o usuário queira sair o if será execultado.
                if (entrada.equalsIgnoreCase("sair")) {
                    System.out.println("Jogo encerrado. O número era " + numeroSecreto);
                    break;
                }
                //Se não o try será excultado
                try {
                	//Ler as tentativas do usuário
                    int palpite = Integer.parseInt(entrada);
                    tentativas++;
                    //Se o usuário acertar o númeoro, mensagem de Parabéns.
                    if (palpite == numeroSecreto) {
                        System.out.println("Parabéns! Você ganhou! Acertou o número em " + tentativas + " tentativas.");
                        acertou = true;
                    //Se não acertar o programa segue rodando e informa dicas para o usuário.
                    } else if (palpite < numeroSecreto) {
                        System.out.println("O número é MAIOR. Tente novamente.");
                    } else {
                        System.out.println("O número é MENOR. Tente novamente.");
                    }
                //Caso o usuário insira algo fora do contexto do jogo, o catch é execultad, já que serve para tratar de erros.
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número ou 'sair' para encerrar.");
                }
            }
        //Caso o usuário insira números fora do intervalo.
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite números válidos para o intervalo.");
        //Será execultado toda vez, independente do que foi excultado anteriormente. 
        //O finally é usado em conjunto com try e catch para executar um código que deve rodar de forma independente. 
        } finally {
            scanner.close();
            System.out.println("Obrigado por jogar! Até mais!.");
        }
    }
}
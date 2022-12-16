import java.util.Arrays;

public class Jogo {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        boolean opcao;
        tabuleiro = preencheTabuleiro(tabuleiro);

    }

    public static char[][] preencheTabuleiro(char[][] tabuleiro) {

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                tabuleiro[i][j] = '_';
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
        return tabuleiro;
    }

    public static char[][] preencherPosicao(char[][] tabuleiro, int linha, int coluna) {

        boolean podePreencher = false;

        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            System.out.println("POSIÇÃO INEXISTENTE!");
        } else if (tabuleiro[linha][coluna] != '_') {
            System.out.println("POSIÇÃO JÁ PREENCHIDA!");
        } else {
            podePreencher = true;
        }

        if (podePreencher) {
            if(opcaoJogador.opcao == false){
                tabuleiro[linha][coluna] = 'X';
                opcaoJogador.opcao = !opcaoJogador.opcao;
            }else{
                tabuleiro[linha][coluna] = 'O';
                opcaoJogador.opcao = !opcaoJogador.opcao;
            }
        }
        printaTabuleiro(tabuleiro);
        return tabuleiro;
    }

    public static void printaTabuleiro(char[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }

    }

}

class opcaoJogador{
    public static boolean opcao;
}

import java.util.Arrays;

public class Jogo {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];

        tabuleiro = preencheTabuleiro(tabuleiro);

        //System.out.println(Arrays.deepToString(tabuleiro));
    }

    public static char[][] preencheTabuleiro(char[][] tabuleiro){

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                tabuleiro[i][j] = '_';
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
        return tabuleiro;
    }

}

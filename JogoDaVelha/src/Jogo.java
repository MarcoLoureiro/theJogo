import java.util.Arrays;
import javax.swing.JOptionPane;

public class Jogo {
    public static void main(String[] args) {
        jogarTheJogo();
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
            if (opcaoJogador.opcao == false) {
                tabuleiro[linha][coluna] = 'X';
                opcaoJogador.opcao = !opcaoJogador.opcao;
            } else {
                tabuleiro[linha][coluna] = 'O';
                opcaoJogador.opcao = !opcaoJogador.opcao;
            }
            opcaoJogador.contadorJogadas++;
        }
        printaTabuleiro(tabuleiro);
        return tabuleiro;
    }

    public static void printaTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }

    }

    public static void verificaVelhaOuFim(char[][] tabuleiro) {
        VerificarFimOuVelha:
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][0] == 'X' && tabuleiro[i][1] == 'X' && tabuleiro[i][2] == 'X') {
                    System.out.println("Jogador X GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if (tabuleiro[0][j] == 'X' && tabuleiro[1][j] == 'X' && tabuleiro[2][j] == 'X') {
                    System.out.println("Jogador X GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if ((tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X' ||
                        tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[0][0] == 'X')) {
                    System.out.println("Jogador X GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if (tabuleiro[i][0] == 'O' && tabuleiro[i][1] == 'O' && tabuleiro[i][2] == 'O') {
                    System.out.println("Jogador O GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if (tabuleiro[0][j] == 'O' && tabuleiro[1][j] == 'O' && tabuleiro[2][j] == 'O') {
                    System.out.println("Jogador O GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O' ||
                        tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[0][0] == 'O') {
                    System.out.println("Jogador O GANHOU!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                } else if (opcaoJogador.contadorJogadas > 8) {
                    System.out.println("DEU VELHA!");
                    opcaoJogador.fim = true;
                    break VerificarFimOuVelha;
                }
            }
        }

    }

    public static void jogarTheJogo() {
        char[][] tabuleiro = new char[3][3];
        tabuleiro = preencheTabuleiro(tabuleiro);

        do {
            String txt = JOptionPane.showInputDialog(
                    null, "Digite a posição para ser marcada (Ex: 11 para marcar X na linha 1 e coluna 1)\nDigite Sair para fechar");

            if (txt != null && txt.equals("Sair")) {
                opcaoJogador.fim = true;
                txt = null;
            }

            if (txt != null && txt.length() > 0) {
                String[] splitado = txt.split("");
                boolean isLinha=false;
                boolean isColuna=false;

                if(splitado.length>1){
                    isLinha = splitado[0].matches("[0-9]*");
                    isColuna = splitado[1].matches("[0-9]*");
                }else{
                    isLinha = splitado[0].matches("[0-9]*");
                }
                if (isLinha && isColuna && txt.length()>1 && txt.length()<3) {
                    int linha = Integer.parseInt(splitado[0]) - 1;
                    int coluna = Integer.parseInt(splitado[1]) - 1;
                    preencherPosicao(tabuleiro, linha, coluna);
                    verificaVelhaOuFim(tabuleiro);
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um valor válido!");
                }
            }

        } while (opcaoJogador.fim != true);
    }
}

class opcaoJogador {
    public static boolean opcao;
    public static boolean fim = false;
    public static int contadorJogadas = 0;
}

import java.util.Scanner;

public class Partida {


    public Scanner entrada = new Scanner(System.in);

    public Jogador jogador1;

    public Jogador jogador2;

    public Tabuleiro tabuleiro;

    private int vez = 1;


    public Partida(){
        jogar();
    }


    private void imprimePlacar(){
        System.out.println(jogador1.getNomeJogador()+" "+jogador1.getVitorias()+" X "+jogador2.getVitorias()+" "+jogador2.getNomeJogador());
    }

    private boolean verificaPosicaoValida(int valor) {
        if (!(valor == -1) && !(valor == 0)) {
            return true;
        } else {
            System.out.println("posição invalida");
            return false;
        }
    }

    private boolean possoJogar(Tabuleiro tabuleiro, int posicao) {
        if (posicao == 1) {
            return verificaPosicaoValida(tabuleiro.matriz[0][0]);
        } else if (posicao == 2) {
            return verificaPosicaoValida(tabuleiro.matriz[0][1]);
        } else if (posicao == 3) {
            return verificaPosicaoValida(tabuleiro.matriz[0][2]);
        } else if (posicao == 4) {
            return verificaPosicaoValida(tabuleiro.matriz[1][0]);
        } else if (posicao == 5) {
            return verificaPosicaoValida(tabuleiro.matriz[1][1]);
        } else if (posicao == 6) {
            return verificaPosicaoValida(tabuleiro.matriz[1][2]);
        } else if (posicao == 7) {
            return verificaPosicaoValida(tabuleiro.matriz[2][0]);
        } else if (posicao == 8) {
            return verificaPosicaoValida(tabuleiro.matriz[2][1]);
        } else if(posicao == 9) {
            return verificaPosicaoValida(tabuleiro.matriz[2][2]);
        }
        return false;
    }

    private int ganhou(){
        if (tabuleiro.verificaLinhas() == -1 || tabuleiro.verificaColuna() ==-1 || tabuleiro.verificaDiagonal() == -1  ){
            return -1;
        }
        if (tabuleiro.verificaLinhas() == 0 || tabuleiro.verificaColuna() == 0 || tabuleiro.verificaDiagonal() == 0 ){
            return 0;
        }

        return 10;
    }

    private boolean terminou(){
        return ganhou() != 10;
    }

    private void jogar(){


        jogador1 = new JogadorHumano();
        System.out.print("digite o nome do primeiro jogador: ");
        String nomeJogador1 = entrada.next();
        jogador1.setNomeJogador(nomeJogador1);

        jogador2 = new JogadorHumano();
        System.out.print("digite o nome do segundo jogador: ");
        String nomeJogador2 = entrada.next();
        jogador2.setNomeJogador(nomeJogador2);

        boolean jogarMais = true;

        while(jogarMais) {
            tabuleiro = new Tabuleiro();
            while(vez <10 && !terminou()){
                tabuleiro.imprimeTabuleiro();

                System.out.println("escolha uma posição no tabuleiro");
                int posicao = entrada.nextInt();

                while(!possoJogar(tabuleiro, posicao)){
                    tabuleiro.imprimeTabuleiro();
                    System.out.println("escolha outra posição no tabuleiro");
                    posicao = entrada.nextInt();
                }
                if (vez % 2 == 0){
                    jogador2.jogar(tabuleiro, 0, posicao);
                }
                else {
                    jogador1.jogar(tabuleiro, -1, posicao);
                }
                vez++;
            }
            tabuleiro.imprimeTabuleiro();
            if(ganhou() == -1) {
                System.out.println(jogador1.getNomeJogador()+" ganhou!!!");
                jogador1.adicionaVitoria();

            }
            else if(ganhou() == 0) {
                System.out.println(jogador2.getNomeJogador()+" ganhou!!!");
                jogador2.adicionaVitoria();

            }
            else {
                System.out.println("Deu velha!!!");
            }

            imprimePlacar();
            System.out.print("Deseja continuar? (S/N)");
            String resposta = entrada.next();
            if(resposta.toUpperCase().equals("N")){
                jogarMais = false;
            }
            vez = 1;
        }
    }

}

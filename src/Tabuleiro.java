public class Tabuleiro {

    public int[][] matriz;


    public Tabuleiro() {

        int count = 1;
        matriz  = new int[3][3];
        for(int linha=0 ; linha < 3 ; linha++){
            for(int coluna = 0; coluna < 3 ; coluna ++){
                matriz[linha][coluna]=count;
                count = count + 1;
            }
        }
    }

    public int verificaLinhas(){

        for (int linha = 0; linha<3; linha++){
            if(matriz[linha][0] + matriz[linha][1] + matriz[linha][2] == -3){
                return -1;
            }
            if (matriz[linha][0] + matriz[linha][1] + matriz[linha][2] == 0){
                return 0;
            }
        }

        return 10;
    }

    public int verificaColuna(){
        for (int coluna = 0; coluna<3; coluna++){
            if (matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna] == -3){
                return -1;
            }
            if (matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna] == 0 ){
                return 0;
            }

        }
      return 10;
    }
    public int verificaDiagonal(){
        if(matriz[0][0] + matriz[1][1] + matriz[2][2] == -3){
            return -1;
        }
        if (matriz[2][0] + matriz[1][1] + matriz[0][2] == -3){
            return -1;
        }
        if(matriz[0][0] + matriz[1][1] + matriz[2][2] == 0){
            return 0;
        }
        if (matriz[2][0] + matriz[1][1] + matriz[0][2] == 0){
            return 0;
        }
        return 10;
    }

    public void imprimeTabuleiro() {

        for (int linha = 0; linha<3; linha++){
            for (int coluna = 0; coluna<3; coluna++) {
                if (matriz[linha][coluna] == -1){
                    System.out.print(" X ");
                }
                else if (matriz[linha][coluna] == 0){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" "+ matriz[linha][coluna] +" ");
                }
                if(coluna == 0 || coluna == 1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }














}

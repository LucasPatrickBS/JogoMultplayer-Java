public class Vencedor extends Comunicado {

    private int[]    pontuacao   = {-1, -1, -1};
    private String[] nomeUsuario = {null, null, null};
    private String[] vencedores  =  {null, null, null};
    private String[] perdedores  =  {null, null, null};
    private int indiceJogador   = 0;
    private int indiceVencedor  = 0;
    private int indicePerdedor  = 0;

    public Vencedor(){}

    public void setJogador(String nome, int pontuacao) throws Exception{

        if(isFull()){
            throw new Exception("O número máximo de jogadores já foi atingido!");
        }

        for(int i = 0; i < 3; i++){
            if(this.nomeUsuario[i] == null){
                this.nomeUsuario[i] = nome;
                this.pontuacao[i] = pontuacao;
                this.indiceJogador++;
                break;
            }
        }
    }

    public String[] getVencedor(){

        
        for(int i = 0; i < 3; i++){
            if(this.pontuacao[i] == 21){
                this.vencedores[this.indiceVencedor] = this.nomeUsuario[i];
                this.indiceVencedor++;
            }
        }

        return this.vencedores;
    }

    public String[] getPerdedor(){
        for(int i = 0; i < 3; i++){
            if(this.pontuacao[i] > 21){
                this.perdedores[this.indicePerdedor] = this.nomeUsuario[i];
                this.indicePerdedor++;
            }
        }

        return this.perdedores;
    }


    public boolean isFull(){

        if(this.indiceJogador == 4){
            return true;
        }
        
        return false;
    }

    public int getNumeroPerdedores(){
        return this.indicePerdedor;
    }

    public int getNumeroVencedores(){
        return this.indiceVencedor;
    }

    public void reset(){

        for(int i = 0; i < 3; i++){
            this.nomeUsuario[i] = null;
            this.pontuacao[i] = -1;
            this.vencedores[i] = null;
        }

        this.indiceJogador = 0;
        this.indiceVencedor = 0;


        System.out.println("resetou");

    }
}


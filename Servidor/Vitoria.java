public class Vitoria extends Comunicado{
    
    private String nomeJogador;
    private int pontuacao;

    public Vitoria(String jogador, int pontuacao) {
        this.pontuacao = pontuacao;
        this.nomeJogador = jogador;
    }

    public String getVencedor(){
        return this.nomeJogador;
    }

    public int getPontuacao(){
        return this.pontuacao;
    }

}

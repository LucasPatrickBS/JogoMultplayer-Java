public class Vitoria extends Comunicado{
    
    private String nomeJogador;

    public Vitoria(String jogador) {
        this.nomeJogador = jogador;
    }

    public String getVencedor(){
        return this.nomeJogador;
    }
}

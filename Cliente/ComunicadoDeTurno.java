public class ComunicadoDeTurno extends Comunicado {

    private int pontuacao;
    private String nome;


    public ComunicadoDeTurno(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }


    public int getPontuacao(){
        return this.pontuacao;
    }

    public String getNome(){
        return this.nome;
    }
    
}

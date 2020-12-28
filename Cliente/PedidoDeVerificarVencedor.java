public class PedidoDeVerificarVencedor extends Comunicado{

    private String nome;
    private int pont;

    public PedidoDeVerificarVencedor(String nome, int pont){
        this.nome = nome;
        this.pont = pont;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPont(){
        return this.pont;
    }
    
}

public class PedidoDeOperacao extends Comunicado{
    private char   operacao;
    private int    valor;
    private String nomeUsuario;
    
    public PedidoDeOperacao (char operacao, int valor, String nome)
    {
        this.operacao    = operacao;
        this.valor       = valor;
        this.nomeUsuario = nome;
    }

    public PedidoDeOperacao(){};
    
    public char getOperacao ()
    {
        return this.operacao;
    }

    public String getNome ()
    {
        return this.nomeUsuario;
    }

    public int getValor ()
    {
        return this.valor;
    }
    
    public String toString ()
    {
        return (""+this.operacao+this.valor);
    }
    
   
}

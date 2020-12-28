public class CartaAtual extends Comunicado {

    private String cartaAtual;

    public CartaAtual(String carta){

        this.cartaAtual = carta;
    }


    public String getCarta(){

        return ("você pegou a carta: " + this.cartaAtual);
    }
    
}

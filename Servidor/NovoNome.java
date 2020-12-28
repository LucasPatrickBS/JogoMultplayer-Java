public class NovoNome extends Comunicado{
    private String nome = "";


    public NovoNome(String nome){
        this.nome = nome;
    }

    public NovoNome(){};

    public String getNome(){
        return this.nome;
    }
}

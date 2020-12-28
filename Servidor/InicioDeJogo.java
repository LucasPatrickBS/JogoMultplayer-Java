public class InicioDeJogo extends Comunicado{



    private String nomeDoUsuario;


    public InicioDeJogo(String nome) throws Exception{


        if(nome == null || nome.length() == 0)
            throw new Exception("O nome do usuário não pode ser nulo e nem vazio.");


        this.nomeDoUsuario = nome;
    }


    public String getNomeUsuario(){
        return this.nomeDoUsuario;
    }
}
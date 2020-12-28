public class ComunicadoDeDerrota extends Comunicado{

    private String nomePerdedor;

    public ComunicadoDeDerrota(String nomePerdedor) throws Exception{

        if(nomePerdedor == null || nomePerdedor.length() == 0)
            throw new Exception("O nome do perdedor não pode estar vazio.");

        this.nomePerdedor = nomePerdedor;
    }

    public String getNomePerdedor(){
        return this.nomePerdedor;
    }
}

public class ComunicadoPerdedor extends Comunicado{
    
    private String perdedor;
    private String status;

    public ComunicadoPerdedor(String perdedor, String status) throws Exception{


        if(perdedor == null || perdedor.length() == 0)
            throw new Exception("O nome do perdedor não pode ser nulo.");

        if(status != "0" && status != "1")
            throw new Exception("O status não pode ser != de 0 e 1.");


        this.perdedor = perdedor;
        this.status = status;
    }

    public String getPerdedor(){
        return this.perdedor;
    }

    public String getStatus(){
        return this.status;
    }
}

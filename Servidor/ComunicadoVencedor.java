public class ComunicadoVencedor extends Comunicado{
    
    private String txt;
    private int status;

    public ComunicadoVencedor(String msg, int status){
        this.txt = msg;
        this.status = status;
    }

    public String getVencedor(){
        return this.txt;
    }

    public int getStatus(){
        return this.status;
    }

}

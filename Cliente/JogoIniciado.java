public class JogoIniciado extends Comunicado{
    private String Status;
    
    public JogoIniciado (String x){
        this.Status = x;
    }

    public String getStatus(){
        return this.Status;
    }
}

public class JogadoresConectados extends Comunicado{
    
    private String msg = "";

    public JogadoresConectados(String msg) {
        this.msg = msg;
    }

    public String getMsg(){

        return this.msg;
    }
}

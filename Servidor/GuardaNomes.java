import java.util.Vector;

public class GuardaNomes extends Comunicado {

    private Vector<String> nomes  = new Vector<String>();

    public GuardaNomes(String nome){
        nomes.add(nome);
    }

    public GuardaNomes(){
        
    }

    public String getNomes(int i){

        return this.nomes.get(i);

    }
    
}

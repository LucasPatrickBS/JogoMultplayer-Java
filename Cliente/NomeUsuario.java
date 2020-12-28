public class NomeUsuario extends Comunicado {

    
    private String[] nomesDosUsuarios;
    private int fim;
    private int t;

    public NomeUsuario(){

        nomesDosUsuarios = new String[3];
        fim = 0;
        t = 0;

    }
    
    public void inserir(String nome) throws Exception{
        if(isFull())
            throw new Exception("Fila cheia. Impossivel inserir.");
        
        nomesDosUsuarios[fim] = nome;
        fim = (fim + 1) % nomesDosUsuarios.length;
        t++;  
    }

    public String getNomeUsuario(int pos) throws Exception{

        try{
            return nomesDosUsuarios[pos];
        }catch(Exception errGetter){
            return "0";
        }
    }

    public boolean isEmpty(){
        if(t == 0) return true;
        else return false;
    }
    
    public boolean isFull(){
        if(t == nomesDosUsuarios.length) return true;
        else return false;
    }

    @Override
    public String toString(){

        String nomes = "";

        for(int i = 0; i < this.nomesDosUsuarios.length; i++)
            nomes += " " + this.nomesDosUsuarios[i];

        return nomes;

    }
}

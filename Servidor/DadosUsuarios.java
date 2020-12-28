import java.util.*;


public class DadosUsuarios extends Comunicado{

    protected Vector<Integer> pontuacoes = new Vector<Integer>();
    protected Vector<String>  usuarios   = new Vector<String>();

    public DadosUsuarios (){
        
    }

    public String getNomes(int x){
        return usuarios.get(x);
    }

    public void setNome(String nome){
        usuarios.add(nome);
    }

    public void setPont(int pontuacao){
        pontuacoes.add(pontuacao);
    }

    public int getPont(int x){
        return pontuacoes.get(x);
    }

    public String getTodosNomes(){

        String todosNomes = "";
        for(int i = 0; i < usuarios.size(); i++){
            todosNomes += "" + usuarios.get(i) + " ";
        }

        return todosNomes;
    }

    public String getTodosValores(){

        String todosValores = "";
        for(int i = 0; i < pontuacoes.size(); i++){
            todosValores += "" + pontuacoes.get(i) + " ";
        }

        return todosValores;
    }

}
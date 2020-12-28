import java.util.*;

public class Baralho{

    private String[] nipes = {"Ouro", "Copas", "Paus", "Espadas"};
    private String[] sorteadas = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    private String[] cartas ={"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "J", "K"};
    private String nomeCarta = "";
   
    private int i = 0; 
    public Baralho(){

    }

    

    public String getSorteadas(){

        String x = "";
        for(int i = 0; i < this.sorteadas.length; i++){

            x += this.sorteadas[i] + "\n"; 
        }
        return x;
    }


    private int randomNipe(){
        Random random = new Random();
        int randomNipe = random.nextInt(3 + 1) + 0;

        return randomNipe;
    }

    private int randomCarta(){

        
        Random random = new Random();
        int randomCarta = random.nextInt(12 + 1) + 0;

        return randomCarta;
    }

    private boolean jaExiste(String nomeCarta){

            for(int i = 0; i < 52; i++){
                if(this.sorteadas[i].equals(this.nomeCarta)) 
                    return true;
            }

        return false;
    }
    
    private String nomeFinal(){
        int nipe = randomNipe();
        String Nipe = this.nipes[nipe];
        int carta = randomCarta();
        String Carta = this.cartas[carta];
        this.nomeCarta = (Carta + " - " + Nipe); 

        return this.nomeCarta;
    }
    
    public String retornaCarta(){
        
        this.nomeCarta = nomeFinal();
        if(this.sorteadas[0] == null){
            this.sorteadas[0] = nomeFinal();
        }
      
        while(jaExiste(this.nomeCarta)){
            nomeFinal();
        }    
        
        this.sorteadas[this.i] = this.nomeCarta;
        this.i++;
        return this.nomeCarta;
    }
}

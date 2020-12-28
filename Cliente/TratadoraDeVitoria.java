import java.net.*;

public class TratadoraDeVitoria extends Thread
{
    private Parceiro servidor;

    public TratadoraDeVitoria (Parceiro servidor) throws Exception{
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }

    public void run (){
        for(;;){
            
			try{

				if (this.servidor.espie() instanceof Vitoria){
					System.out.println ("mensagem de vitoria");
				    System.exit(0);
                }
                
			} 
			catch (Exception erro){}
        }
    }
}

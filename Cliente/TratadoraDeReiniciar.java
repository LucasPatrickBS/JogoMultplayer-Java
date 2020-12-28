import java.net.*;

public class TratadoraDeReiniciar extends Thread
{
    private Parceiro servidor;

    public TratadoraDeReiniciar (Parceiro servidor) throws Exception
    {
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }

    public void run ()
    {
        for(;;)
        {
			try
			{
				if (this.servidor.espie() instanceof ComunicadoDeReinicio){
					
                }
                
			}
			catch (Exception erro)
			{}
        }
    }
}

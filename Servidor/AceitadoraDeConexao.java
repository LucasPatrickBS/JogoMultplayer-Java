import java.net.*;
import java.util.*;

public class AceitadoraDeConexao extends Thread
{
    private ServerSocket               pedido;
    public static  ArrayList<Parceiro> usuarios;
    private static int                 vezDoJogador;
    private static int                 jogoAcabou;



    public AceitadoraDeConexao(String porta, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (porta==null)
            throw new Exception ("Porta ausente");

        try
        {
            this.pedido =
            new ServerSocket (Integer.parseInt(porta));
        }
        catch (Exception  erro)
        {
            throw new Exception ("Porta invalida");
        }

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.usuarios = usuarios;
    }

    public static void setProximoJogador()
	{
		if(vezDoJogador == 2)
			vezDoJogador = 0;
		else
			vezDoJogador++;
	}

    public static void fimDeJogo()
    {
		jogoAcabou = 1;
    }
    
    public static boolean jogoAcabou()
	{
		if (jogoAcabou == 1)
			return true;

		return false;
	}


    public void run ()
    {
        for(;;)
        {
            Socket conexao=null;
            try
            {
                conexao = this.pedido.accept();
            }
            catch (Exception erro)
            {
                continue;
            }

            SupervisoraDeConexao supervisoraDeConexao=null;
            try
            {
                supervisoraDeConexao =
                new SupervisoraDeConexao (conexao, usuarios);
            }
            catch (Exception erro)
            {} // sei que passei parametros corretos para o construtor
            supervisoraDeConexao.start();
        }
    }
}

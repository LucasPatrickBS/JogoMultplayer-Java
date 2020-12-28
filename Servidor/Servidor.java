import java.util.*;

public class Servidor
{
    public static String      PORTA_PADRAO     = "3000";
    public static int         turno            = 0;
    public static int         indiceInicio     = 0;
    public static NomeUsuario nomesUsuarios    = new NomeUsuario();
    public static Vencedor    vencedor         = new Vencedor();
    public int                total            = 0;
    public String             jogador;
    public String[]           nomesTeste       = new String[3];
    public int[]              pontTeste        = new int   [3];
    public Thread             myThreads[]      = new Thread[3];
    public String[]           jogadores        = new String[3];
    

    public Servidor(){}
    public static void main (String[] args)
    {
        if (args.length>1)
        {
            System.err.println ("Uso esperado: java Servidor [PORTA]\n");
            return;
        }

        String porta = Servidor.PORTA_PADRAO;
        
        if (args.length==1)
            porta = args[0];

        ArrayList<Parceiro> usuarios =
        new ArrayList<Parceiro> ();
        

        AceitadoraDeConexao aceitadoraDeConexao= null;
        try
        { 
            aceitadoraDeConexao =
            new AceitadoraDeConexao (porta, usuarios);
            aceitadoraDeConexao.start();
        }
        catch (Exception erro)
        {
            System.err.println ("Escolha uma porta apropriada e liberada para uso!\n");
            return;
        }

            for(;;)
        {
            System.out.println ("O servidor esta ativo! Para desativa-lo,");
            System.out.println ("use o comando \"desativar\"\n");
            System.out.print   ("> ");
           
            String comando=null;
            try
            {
                comando = Teclado.getUmString();
            }
            catch (Exception erro)
            {}
            
            if (comando.toLowerCase().equals("desativar"))
            {
                synchronized (usuarios)
                {
                    ComunicadoDeDesligamento comunicadoDeDesligamento =
                    new ComunicadoDeDesligamento ();
                    
                    for (Parceiro usuario:usuarios)
                    {
                        try
                        {
                            usuario.receba (comunicadoDeDesligamento);
                            usuario.adeus  ();
                        }
                        catch (Exception erro)
                        {}
                    }          
                }

                System.out.println ("O servidor foi desativado!\n");
                System.exit(0);
            }
            else
                System.err.println ("Comando invalido!\n");
        }
        
    }

}

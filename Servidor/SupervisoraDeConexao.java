import java.io.*;
import java.net.*;
import java.util.*;


public class SupervisoraDeConexao extends Thread 
{
    private int                 valor          = 0;
    private String              msg            = "Aguardando os outros jogadores!";;
    private Parceiro            usuario;
    private Socket              conexao;
    public  ArrayList<Parceiro> usuarios;
    public  Parceiro            cliente        = null;
    public  Servidor            Server         = new Servidor();
    private String              nomeVencedor   = "semVencedor";  
    public  String              nomeUsuario    = "";
    private boolean             verificar      = false;
    

    

    public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> usuarios)
    throws Exception{
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.usuarios = usuarios;

    }


    public void run ()
    {

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }
        
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }

        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} 
            
            return;
        }

        try
        {
            this.usuario =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} 
        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }

            
            for(;;)
            {
                Baralho baralho = new Baralho();
                Comunicado comunicado = this.usuario.envie ();

                if (comunicado==null)
                    return;

                else if (comunicado instanceof PedidoDeOperacao){
                    PedidoDeOperacao pedidoDeOperacao = (PedidoDeOperacao)comunicado;
                    nomeUsuario = pedidoDeOperacao.getNome();

					switch (pedidoDeOperacao.getOperacao())
					{
                        case 'A':
                            Server.turno++;
                            System.out.println("Turno: " + Server.turno);
                            this.usuario.receba(new CartaAtual("Você deve aguardar!"));
                            break;

                        case 'P':
                            System.out.println("cu");
                            String var = baralho.retornaCarta();
                            if(AceitadoraDeConexao.usuarios.size() >= 0 && AceitadoraDeConexao.usuarios.size() < 3){
                            
                                System.out.println("carta: " + var);
                                
                                
                                if(var.contains("A")){
                                    var = "1";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("2")){
                                    var = "2";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("3")){
                                    var = "3";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("4")){
                                    var = "4";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("5")){
                                    var = "5";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("6")){
                                    var = "6";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("7")){
                                    var = "7";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("8")){
                                    var = "8";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("9")){
                                    var = "9";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("10")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("Q")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("J")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("K")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                System.out.println(this.valor + "\n \n \n");
                                Server.turno++;
                                System.out.println("Turno: " + Server.turno);  
                                
                            }
                            else{

                                
                                var = baralho.retornaCarta();
                                System.out.println("carta: " + var);
                                

                                if(var.contains("A")){
                                    var = "1";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("2")){
                                    var = "2";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("3")){
                                    var = "3";
                                    this.valor += Integer.parseInt(var);
                                }


                                else if(var.contains("4")){
                                    var = "4";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("5")){
                                    var = "5";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("6")){
                                    var = "6";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("7")){
                                    var = "7";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("8")){
                                    var = "8";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("9")){
                                    var = "9";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("10")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("Q")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("J")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                }

                                else if(var.contains("K")){
                                    var = "10";
                                    this.valor += Integer.parseInt(var);
                                    
                                }  
                                
                                System.out.println(this.valor + "\n \n \n");
                                Server.turno++;
                                System.out.println("Turno: " + Server.turno);
                                
                            } 
                            this.usuario.receba(new CartaAtual(var));
                            break;
                    }
                }
                            
                else if (comunicado instanceof PedidoDeResultado){
                    //System.out.println("Pedido de Resultado com valor: " + this.valor);
                    this.usuario.receba(new Resultado(this.valor));
                   
                }

                else if (comunicado instanceof PedidoParaSair){
                    synchronized (this.usuarios)
                    {
                        //Server.verificaVencedor.retirar();
                        this.usuarios.remove (this.usuario);
                    }
                    this.usuario.adeus();
                }

                else if (comunicado instanceof InicioDeJogo){


                    InicioDeJogo inicioDeJogo = (InicioDeJogo) comunicado;
                    String nomeJogador = inicioDeJogo.getNomeUsuario();
                    System.out.println("nomeJogador = " + nomeJogador);
                    
                    if(Server.indiceInicio >= 0 && Server.indiceInicio < 3){
                            System.out.println("indice antes = " + Server.indiceInicio);
                            Server.jogadores[Server.indiceInicio] = nomeJogador;
                            Server.indiceInicio++;
                            System.out.println("indice depois = " + Server.indiceInicio);
                            

                            if(Server.indiceInicio == 3){
                                System.out.println("caiu aqui 2");        
                                Server.jogadores[Server.indiceInicio] = nomeJogador;
                                this.usuario.receba(new JogoIniciado("1"));
                                                  
                            }
                            else{
                                this.usuario.receba(new JogoIniciado("0"));
                                System.out.println("caiu aqui 3");
                            }
                    }
                                       

                }

                else if (comunicado instanceof ComunicadoDeTurno){
                    
                    ComunicadoDeTurno turno = (ComunicadoDeTurno)comunicado;

                    String nome = turno.getNome();
                    int pontuacao = turno.getPontuacao();
                    Server.vencedor.setJogador(nome, pontuacao);
                    String msg = null;

                   if(AceitadoraDeConexao.usuarios.size() == 3){

                        if(Server.turno != 0 && Server.turno % 3 == 0){
                            System.out.println("chegou no if final");
                            String[] vencedores = Server.vencedor.getVencedor();
                            System.out.println(vencedores[0]);

                            if(vencedores[0] != null && vencedores[1] == null && vencedores[2] == null){
                                msg = "O usuário: " + vencedores[0] + " ganhou!";
                                usuarios.get(0).receba(new TurnoCompleto(msg));
                                usuarios.get(1).receba(new TurnoCompleto(msg));
                                usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            if(vencedores[0] == null && vencedores[1] != null && vencedores[2] == null){
                            msg = "O usuário: " + vencedores[1] + " ganhou!";
                            usuarios.get(0).receba(new TurnoCompleto(msg));
                            usuarios.get(1).receba(new TurnoCompleto(msg));
                            usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            if(vencedores[0] == null && vencedores[1] == null && vencedores[2] != null){
                            msg = "O usuário: " + vencedores[2] + " ganhou!";
                            usuarios.get(0).receba(new TurnoCompleto(msg));
                            usuarios.get(1).receba(new TurnoCompleto(msg));
                            usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            usuarios.get(0).receba(new TurnoCompleto(null));
                            usuarios.get(1).receba(new TurnoCompleto(null));
                            usuarios.get(2).receba(new TurnoCompleto(null));

                            Server.vencedor.reset();
                        }

                   }else if(AceitadoraDeConexao.usuarios.size() == 2){

                        if(Server.turno != 0 && Server.turno % 2 == 0){
                            System.out.println("chegou no if final");
                            String[] vencedores = Server.vencedor.getVencedor();
                            System.out.println(vencedores[0]);

                            

                            if(vencedores[0] != null && vencedores[1] == null && vencedores[2] == null){
                                msg = "O usuário: " + vencedores[0] + " ganhou!";
                                usuarios.get(0).receba(new TurnoCompleto(msg));
                                usuarios.get(1).receba(new TurnoCompleto(msg));
                                usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            if(vencedores[0] == null && vencedores[1] != null && vencedores[2] == null){
                                msg = "O usuário: " + vencedores[1] + " ganhou!";
                                usuarios.get(0).receba(new TurnoCompleto(msg));
                                usuarios.get(1).receba(new TurnoCompleto(msg));
                                usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            if(vencedores[0] == null && vencedores[1] == null && vencedores[2] != null){
                                msg = "O usuário: " + vencedores[2] + " ganhou!";
                                usuarios.get(0).receba(new TurnoCompleto(msg));
                                usuarios.get(1).receba(new TurnoCompleto(msg));
                                usuarios.get(2).receba(new TurnoCompleto(msg));
                            }

                            usuarios.get(0).receba(new TurnoCompleto(null));
                            usuarios.get(1).receba(new TurnoCompleto(null));
                            usuarios.get(2).receba(new TurnoCompleto(null));

                            Server.vencedor.reset();
                        }
                   }

                }
                
                else if (comunicado instanceof NovoNome){
                    
                    NovoNome novoNome = (NovoNome)comunicado;
                    nomeUsuario = novoNome.getNome();
                    Server.nomesUsuarios.inserir(nomeUsuario);

                    System.out.println(Server.nomesUsuarios);

                    if(Server.nomesUsuarios.isFull()){
                        System.out.println("Chegou no if");
                        String msg = "Jogo iniciado \n \n";
                        usuarios.get(0).receba(new JogadoresConectados(msg));
                        usuarios.get(1).receba(new JogadoresConectados(msg));
                        usuarios.get(2).receba(new JogadoresConectados(msg));
                    }
                }

                else if (comunicado instanceof PedidoDeSaberSeJogoAcabou){
					int jogoAcabou;
					if(AceitadoraDeConexao.jogoAcabou())
						jogoAcabou = 1;
					else
						jogoAcabou = 0;

					this.usuario.receba (new ComunicadoJogoAcabou(jogoAcabou));
                }
                
                else if (comunicado instanceof PedidoDeChecarSeGanhei){
					int soma = this.valor;
					if (soma == 21){
						this.usuario.receba (new ComunicadoSeGanhou(1));
					}
					else{
						this.usuario.receba (new ComunicadoSeGanhou(0));
					}
                }
                
                else if (comunicado instanceof ComunicadoDeclaracaoDeVitoria){
                    AceitadoraDeConexao.fimDeJogo();
                    usuarios.get(0).receba(new FimDeJogo());
                    usuarios.get(1).receba(new FimDeJogo());
                    usuarios.get(2).receba(new FimDeJogo());
                }
                
                else if (comunicado instanceof PedidoProximoJogador){
                    AceitadoraDeConexao.setProximoJogador();
                    usuarios.get(0).receba(new ProximoJogador());
                    usuarios.get(1).receba(new ProximoJogador());
                    usuarios.get(2).receba(new ProximoJogador());
                }

                else if (comunicado instanceof Vitoria){
                    Vitoria vitoria = (Vitoria)comunicado;
                    String Jogador = vitoria.getVencedor();
                    String msgJogador = "O jogador " + Jogador + " venceu!";
                    usuarios.get(0).receba(new ComunicadoDeVitoria(msgJogador));
                    usuarios.get(1).receba(new ComunicadoDeVitoria(msgJogador));
                    usuarios.get(2).receba(new ComunicadoDeVitoria(msgJogador));
                }

                /*
                else if (comunicado instanceof PedidoDeVerificarVencedor){

                    PedidoDeVerificarVencedor vencedor = (PedidoDeVerificarVencedor)comunicado;
                    int pontuacao = vencedor.getPont();
                    System.out.println(pontuacao);
                   

                    if(pontuacao > 21){

                        String msg = "O jogador " + vencedor.getNome() + " perdeu!";
                        usuarios.get(0).receba(new ComunicadoVencedor(msg, 2));
                        usuarios.get(1).receba(new ComunicadoVencedor(msg, 2));
                        usuarios.get(2).receba(new ComunicadoVencedor(msg, 2)); 
                    }
                    if(pontuacao == 21){
                        String nome = vencedor.getNome();

                        String msg = "O jogador: " + nome + " ganhou o jogo!";
                        usuarios.get(0).receba(new ComunicadoVencedor(msg, 1));
                        usuarios.get(1).receba(new ComunicadoVencedor(msg, 1));
                        usuarios.get(2).receba(new ComunicadoVencedor(msg, 1));
                        verificar = true;
                    } 
                    if(verificar == false) {Server.verificaVencedor.somarContador();}
                    if(verificar == false && Server.verificaVencedor.getContador() == 3){
                        usuarios.get(0).receba(new ComunicadoVencedor(null, 0));
                        usuarios.get(1).receba(new ComunicadoVencedor(null, 0));
                        usuarios.get(2).receba(new ComunicadoVencedor(null, 0));
                        Server.verificaVencedor.zerarContador();
                    }

                }
                */
            }
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {}

            return;
        }
    }
}

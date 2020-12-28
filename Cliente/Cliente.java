import java.net.*;
import java.io.*;


public class Cliente{	
	
	public static final String HOST_PADRAO  = "localhost";
	public static final int    PORTA_PADRAO = 3000;
	public static int contador				= 0;
	
	public static void main (String[] args) throws Exception
	{
		char op = 'Z';
		if (args.length > 2){
			System.err.println ("Uso esperado: java Cliente [HOST [PORTA]]\n");
			return;
		}
		do{

		Socket conexao=null;

		try{
			String host = Cliente.HOST_PADRAO;
			int    porta= Cliente.PORTA_PADRAO;

			if (args.length>0)
				host = args[0];

			if (args.length==2)
				porta = Integer.parseInt(args[1]);

			conexao = new Socket (host, porta);
			contador++;
		}
		catch (Exception erro){
			System.err.println ("Indique o servidor e a porta corretos!\n");
			return;
			}

			ObjectOutputStream transmissor=null;
			try{
				transmissor =
				new ObjectOutputStream(
				conexao.getOutputStream());
			}
			catch (Exception erro){
				System.err.println ("Indique o servidor e a porta corretos!\n");
				return;
			}

			ObjectInputStream receptor=null;
			try
			{
				receptor =
				new ObjectInputStream(
				conexao.getInputStream());
			}
			catch (Exception erro)
			{
				System.err.println ("Indique o servidor e a porta corretos!\n");
				return;
			}

			Parceiro servidor=null;
			try
			{
				servidor =
				new Parceiro (conexao, receptor, transmissor);
				contador++;
			}
			catch (Exception erro)
			{
				System.err.println ("Indique o servidor e a porta corretos!\n");
				return;
			}

			TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
			try
			{
				tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento (servidor);
			}
			catch (Exception erro)
			{} 
			
			tratadoraDeComunicadoDeDesligamento.start();


			System.out.println("================================|JOGO 21|================================");
			char opcao;
			int valor;
/*
			System.out.print("Digite seu nome de usuario: ");
			String nomeUsuario = Teclado.getUmString();
			String nomeUsuarioMaiusculo = nomeUsuario.toUpperCase();

			servidor.receba(new NovoNome(nomeUsuario));
			System.out.println("Aguardando os outros jogadores!");

			Comunicado jogadoresConectados = null;
			JogadoresConectados msg = null;
			do{
				jogadoresConectados = (Comunicado) servidor.espie();
			}
			while(!(jogadoresConectados instanceof JogadoresConectados));
			msg = (JogadoresConectados)servidor.envie();
			System.out.println(msg.getMsg());
			*/

			String nomeUsuarioMaiusculo = "ROLA";
			String nomeUsuario = "rola";

				do{	
					int jogoAcabou = 0;
					opcao = 'Z';
					int rNumber;
				
					//carta inicial
					servidor.receba (new PedidoDeOperacao ('P', 0, nomeUsuarioMaiusculo));
					CartaAtual carta;
					Comunicado comCarta = null;
					do{
						comCarta = (Comunicado) servidor.espie();
					}
					while(!(comCarta instanceof CartaAtual));
					carta = (CartaAtual)servidor.envie();
					System.out.println(carta.getCarta() + "\n");


					//pedido de resultado inicial
					servidor.receba (new PedidoDeResultado ());
					Comunicado comunicadoInicial = null;
					do{
						comunicadoInicial = (Comunicado) servidor.espie ();
					}
					while (!(comunicadoInicial instanceof Resultado));
					Resultado resultadoInicial = (Resultado)servidor.envie();
					rNumber = resultadoInicial.getValorResultante();
					
						System.out.println("Pontuação inicial de suas cartas: " + rNumber + "\n");
					
					do{

							System.out.println ("Opcoes: [P]egar nova carta, [C]omeçar novamente ou [A]bortar?");
						
							try
							{
								opcao = Character.toUpperCase(Teclado.getUmChar());
								
							}
							catch (Exception erro)
							{
								System.err.println ("Opcao invalida!\n");
								continue;
							}

							if ("PCA".indexOf(opcao)==-1)
							{
								System.err.println ("Opcao invalida!\n");
								continue;
							}
							
							try
							{
								valor = rNumber;
								
								if ("P".indexOf(opcao)!=-1)
								{

									//pedido de carta
									servidor.receba (new PedidoDeOperacao (opcao, valor, nomeUsuarioMaiusculo));
									carta = null;
									comCarta = null;
									do{
										comCarta = (Comunicado) servidor.espie();
									}
									while(!(comCarta instanceof CartaAtual));
									carta = (CartaAtual) servidor.envie();
									//System.out.println(carta.getCarta() + "\n");


									//pedido de resultado;	
								 	servidor.receba (new PedidoDeResultado ());
									Resultado  resultado = null;
									Comunicado comunicado = null;
									do
									{	
										comunicado = (Comunicado)servidor.espie ();
									}
									while (!(comunicado instanceof Resultado));
									resultado = (Resultado)servidor.envie();
									System.out.println("Sua pontuação atual é: " + resultado.getValorResultante());
									

								
									//turno
									servidor.receba(new ComunicadoDeTurno(nomeUsuario, resultado.getValorResultante()));
									Comunicado comunicadoTurno = null;
									System.out.println("Aguardando os outros jogadores completarem o turno!");
									do{
										comunicadoTurno = (Comunicado) servidor.espie();
									}
									while(!(comunicadoTurno instanceof TurnoCompleto));
									TurnoCompleto turno = (TurnoCompleto) servidor.envie();

									if(turno.getMsg() != null)
										System.out.println(turno.getMsg());
									else 
										System.out.println("Turno completo! \n \n");

									//Verifica se alguém ganhou

									/*
									servidor.receba (new PedidoDeVerificarVencedor(nomeUsuario, resultado.getValorResultante()));
									Comunicado verificarVencedor = null;
									ComunicadoVencedor nomeVencedor = null;
									do{
										verificarVencedor = (Comunicado)servidor.espie();
									}
									while(!(verificarVencedor instanceof ComunicadoVencedor));
									nomeVencedor = (ComunicadoVencedor) servidor.envie();

									if(nomeVencedor.getStatus() == 1){
										System.out.println(nomeVencedor.getVencedor());	
										System.exit(0);

									}else if(nomeVencedor.getStatus() == 2){
										System.out.println(nomeVencedor.getVencedor());
										servidor.receba(new PedidoParaSair());
										System.exit(0);

									}

									*/
								}else if("A".indexOf(opcao)!=-1){

									//pedido de carta
									servidor.receba (new PedidoDeOperacao (opcao, valor, nomeUsuarioMaiusculo));
									carta = null;
									comCarta = null;
									do{
										comCarta = (Comunicado) servidor.espie();
									}
									while(!(comCarta instanceof CartaAtual));
									carta = (CartaAtual) servidor.envie();

									//pedido de resultado;	
								 	servidor.receba (new PedidoDeResultado ());
									Resultado  resultado = null;
									Comunicado comunicado = null;
									do
									{	
										comunicado = (Comunicado)servidor.espie ();
									}
									while (!(comunicado instanceof Resultado));
									resultado = (Resultado)servidor.envie();
									System.out.println("Sua pontuação atual é: " + resultado.getValorResultante());
									
									//turno
									servidor.receba(new ComunicadoDeTurno(nomeUsuario, resultado.getValorResultante()));
									Comunicado comunicadoTurno = null;
									System.out.println("Entendido, aguarde os demais jogadores concluirem seus turnos.");
									do{
										comunicadoTurno = (Comunicado) servidor.espie();
									}
									while(!(comunicadoTurno instanceof TurnoCompleto));
									TurnoCompleto turno = (TurnoCompleto) servidor.envie();

									if(turno.getMsg() != null)
										System.out.println(turno.getMsg());
									else 
										System.out.println("Turno completo! \n \n");

									//Verifica se alguém ganhou
									/*
									servidor.receba (new PedidoDeVerificarVencedor(nomeUsuario, resultado.getValorResultante()));
									Comunicado verificarVencedor = null;
									ComunicadoVencedor nomeVencedor = null;
									do{
										verificarVencedor = (Comunicado)servidor.espie();
									}
									while(!(verificarVencedor instanceof ComunicadoVencedor));
									nomeVencedor = (ComunicadoVencedor) servidor.envie();

									if(nomeVencedor.getStatus() == 1){
										System.out.println(nomeVencedor.getVencedor());	
										System.exit(0);

									}else if(nomeVencedor.getStatus() == 2){
										System.out.println(nomeVencedor.getVencedor());
										servidor.receba(new PedidoParaSair());
										System.exit(0);

									}
									*/
								}
							}
							catch (Exception erro){
								System.err.println(erro);
								System.err.println ("Erro de comunicacao com o servidor;");
								System.err.println ("Tente novamente!");
								System.err.println ("Caso o erro persista, termine o programa");
								System.err.println ("e volte a tentar mais tarde!\n");
							}
					}while(opcao != 'C');
					
						for(;;)
						{
							
							System.out.println("================================|PARTIDA FINALIZADA|================================");
							System.out.println("Deseja iniciar um novo jogo? [S/N]");
							try{
								op = Character.toUpperCase(Teclado.getUmChar());
								System.out.println(op);		
							}
							catch (Exception erro){
								System.err.println ("Opcao invalida!\n");
								
							}

							if ("SN".indexOf(op)==-1){
								System.err.println ("Opcao invalida!\n");
								continue;
							}

							else if(op == 'S'){
								break;
							}	

							else if(op == 'N'){
								try
								{
									servidor.receba (new PedidoParaSair ());
								}
								catch (Exception erro)
								{}
								
								System.out.println("================================|OBRIGADO POR JOGAR|================================");
								System.out.println("=====================================|JOGO 21|================================");
								System.exit(0);
							}	
							break;			
						}
						break;
					
				}
				while(op != 'N');
			}while(true);
	}
}
	
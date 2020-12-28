public class ComunicadoJogoAcabou extends Comunicado
{
	private int jogoAcabou;

	public ComunicadoJogoAcabou (int jogoAcabou)
	{
		this.jogoAcabou = jogoAcabou;
	}

	public int getJogoAcabou()
	{
		return this.jogoAcabou;
	}
}
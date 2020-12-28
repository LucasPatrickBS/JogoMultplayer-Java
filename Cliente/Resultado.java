public class Resultado extends Comunicado
{
    private int valorResultante;

    public Resultado (int valorResultante)
    {
        this.valorResultante = valorResultante;
    }

    public int getValorResultante ()
    {
        return this.valorResultante;
    }
    
    public void setValorResultante(int x){
        this.valorResultante = x;
    }

    public String toString ()
    {
		return (""+this.valorResultante);
	}

}

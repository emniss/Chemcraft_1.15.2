package em_niss.chemcraft.util;

public class Element 
{
	public final String name;
	public final String symbol;
	public final int number;
	public final char phase;
	
	public Element(String name, String symbol, int number, char phase)
	{
		this.name = name;
		this.symbol = symbol;
		this.number = number;
		this.phase = phase;
	}
}

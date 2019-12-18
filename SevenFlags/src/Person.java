// Sean MacDonald
// CSE 214 HW4
// a person class that contains their int id, max lines they can be on, array of current lines they're on and their status
import java.util.Arrays;
public class Person
{
	private int number, maxLines;
	private Ride[] lines;
	String status;
	String regSilGol;
	
	public Person(int number)
	{
		if(number >= 0)
			this.number = number;
		else
			System.out.println("IllegalArgumentException");  // COMPLETE EXCEPTION LATER
	}
	
	public Person(int number, int maxLines, String regSilGol, String status)
	{
		if(number >= 0)
			this.number = number;
		else
			System.out.println("IllegalArgumentException");  // COMPLETE EXCEPTION LATER
		lines = new Ride[maxLines];
		Arrays.fill(lines, null);
		this.regSilGol = regSilGol;
		this.status = status;
		this.maxLines = maxLines;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setRegSilGol(String s)
	{
		regSilGol = s;
	}
	
	public String getRegSilGol()
	{
		return regSilGol;
	}
	
	public Ride[] getLines()
	{
		return lines;
	}
	
	public void setLines(Ride ride, int i)
	{
		lines[i] = ride;
	}
	
	public int getMaxLines()
	{
		return maxLines;
	}
	
	public String getLinesToString()
	{
		String s = "";
		for(int i = 0; i < maxLines; i++)
		{
			if(lines[i] != null)
			{
				s += lines[i].getName();
			}
		}
		
		return s;
	}
	
	
	@Override
	public String toString()
	{
		String s = "" + (number + 1) + ".  ";
		for(int i = 0; i < lines.length; i++)
			s += lines[i].getShortName() + "  ";
		s += " " + status;
		return s;
	}
	
	
	
}

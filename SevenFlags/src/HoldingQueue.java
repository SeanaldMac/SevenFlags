// Sean MacDonald
// CSE 214 HW4
// Models a queue, extends VirtualLine class, serves as a queue for people in line for a ride
import java.util.ArrayList;
public class HoldingQueue extends VirtualLine
{
	private int maxSize;

	public HoldingQueue(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public int getMaxSize()
	{
		return maxSize;
	}
	
	public void enqueue(Person p)
	{
		if(!isFull())
		{
			vLine.add(p);
			
			rear++;
			
			numPersons++;
		}
		else
			System.out.println("isFullException"); // MAKE ISFULL EXCEPTION LATER
	}
	
	public boolean isFull()
	{
		return maxSize == numPersons;
	}
	
	
	
}

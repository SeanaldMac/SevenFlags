// Sean MacDonald
// CSE 214 HW4
// virtual line that models a queue
import java.util.ArrayList;
public class VirtualLine extends ArrayList
{
	ArrayList<Person> vLine = new ArrayList<Person>(0);
	int front = 0, rear = 0, numPersons = 0;
	int queueSize;
	
	public VirtualLine()
	{
	}
	
	public void enqueue(Person p)
	{
			vLine.add(p);
			
			rear++;
			
			numPersons++;
	}
	
	public Person dequeue()
	{
		if(!vLine.isEmpty())
		{
			Person copy = vLine.get(front);
	
			vLine.remove(front);
			
			numPersons--;
			
			return copy;
		}
		else
			return null;
	}
	
	public Person peek()
	{
		if(!isEmpty())
			return vLine.get(front);
		else
			return null;
	}
	
	public ArrayList<Person> getVLine()
	{
		return vLine;
	}
	
	public int getQueueSize()
	{
		return queueSize;
	}
	
	
	
	
	
	
	
	
	public boolean isFull()
	{
		return queueSize == numPersons;
	}
	
	
	
	
	
	
	
	
	
	
}

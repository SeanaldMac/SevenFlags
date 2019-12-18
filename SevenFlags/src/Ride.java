// Sean MacDonald
// CSE 214 HW4
// a class for park rides with duration, VirtualLine, HoldingLine and People on the Ride variables/objects

public class Ride
{
	private int duration, timeLeft;
	private String name, shortName;
	VirtualLine virtualLine = new VirtualLine();
	HoldingQueue holdingQueue;
	HoldingQueue peopleOnRide;
	
	public Ride(String name, int duration, int rideCapacity, int holdingSize)
	{
		this.duration = duration;
		timeLeft = duration;
		this.name = name;
		peopleOnRide = new HoldingQueue(rideCapacity); // amount of people that can be on the ride
		holdingQueue = new HoldingQueue(holdingSize); // amount of people that can be in the holding line
		
		switch(name)
		{
		case "Blue Scream of Death":
			shortName = "BSOD";
			break;
		case "Kingda Knuth":
			shortName = "KK";
			break;
		case "i386 Tower of Terror":
			shortName = "ToT";
			break;
		case "GeForce":
			shortName = "GF";
			break;
		}
	}
	
	public Ride()
	{
	}

	public int getDuration()
	{
		return duration;
	}
	
	public int getTimeLeft()
	{
		return timeLeft;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getShortName()
	{
		return shortName;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public VirtualLine getVirtualLine()
	{
		return virtualLine;
	}
	
	public HoldingQueue getHoldingQueue()
	{
		return holdingQueue;
	}
	
	public HoldingQueue getPeopleOnRide()
	{
		return peopleOnRide;
	}
	
	public void timeProgress()
	{
		timeLeft--;
	}

	public void setTimeLeft()
	{
		timeLeft = duration;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

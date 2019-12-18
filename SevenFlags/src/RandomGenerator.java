// Sean MacDonald
// CSE 214 HW4
// randomly selects a ride
import java.util.Random;
public class RandomGenerator
{
	static Random rando = new Random();
	
	static int randoNumbo;
	
	public static Ride selectRide(Ride[] rides)
	{
		randoNumbo = rando.nextInt(40) + 1;
		
		if(randoNumbo <= 10)
		{
			return rides[0];
		}
		else if(randoNumbo <= 20)
		{
			return rides[1];
		}
		else if(randoNumbo <= 30)
		{
			return rides[2];
		}
		else
			return rides[3];
	}
	
	public static Ride selectRide(Ride[] rides, double[] probabilities)
	{
		randoNumbo = rando.nextInt(100) + 1;
		
		double max1 = probabilities[0] * 100;
		double max2 = probabilities[1] * 100 + max1;
		double max3 = probabilities[2] * 100 + max2;
		
		if(randoNumbo <= max1)
		{
			return rides[0];
		}
		else if(randoNumbo <= max2)
		{			
			return rides[1];
		}
		else if(randoNumbo <= max3)
		{
			return rides[2];
		}
		else
		{			
			return rides[3];
		}
		
		
	}
	
	// Makes random probabilities to select ride from, wrong way for extra credit
	/* public static Ride selectRide(Ride[] rides, double[] probabilities)
	{
		randoNumbo = rando.nextInt(40) + 1;
		
		int max1 = rando.nextInt(34) + 1;
		
		int max2 = rando.nextInt((36 - max1)) + (max1 + 1);
		
		int max3 = rando.nextInt((38 - max2)) + (max2 + 1);
				
		probabilities[0] = (double)max1 / 40;
		
		probabilities[1] = (double)(max2 - max1)/ 40;
		
		probabilities[2] = (double)(max3 - max2) / 40;
		
		probabilities[3] = (double)(40 - max3) / 40;
		
		if(randoNumbo <= max1)
		{
			return rides[0];
		}
		else if(randoNumbo > 10 && randoNumbo <= max2)
		{			
			return rides[1];
		}
		else if(randoNumbo > 20 && randoNumbo <= max3)
		{
			return rides[2];
		}
		else
		{			
			return rides[3];
		}
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

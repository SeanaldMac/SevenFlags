// Sean MacDonald
// CSE 214 HW4
// runs the SevenFlags simulation, has four rides
import java.util.Arrays;
import java.util.Scanner;
public class SevenFlags
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		Ride BSOD = new Ride();
		Ride ToT = new Ride();
		Ride GF = new Ride();
		Ride KK = new Ride();
		
		Person[] reg, silv, gold;
		
		int regs, silvs, golds, simLength, duration, rideCapacity, holdingSize;
		int time = 0, gRides = 0, sRides = 0, rRides = 0, BSODRides = 0, KKRides = 0, ToTRides = 0, GFRides  = 0;
		
		
		// Test RandomGenerator selectRide method(with probabilities) the wrong way
		/*
		double[] probabilities = new double[4];
		
		BSOD.setName("BSOD");
		ToT.setName("ToT");
		GF.setName("GF");
		KK.setName("KK");
		
		System.out.println(RandomGenerator.selectRide(rides, probabilities).getName());
		
		System.out.println(Arrays.toString(probabilities));
		*/
		
		// Tests RandomGenerator selectRide method(with probabilities)
		/*
		Ride[] rides = {BSOD, ToT, GF, KK};
		
		double[] probabilities = new double[4];
		probabilities[0] = input.nextDouble();
		probabilities[1] = input.nextDouble();
		probabilities[2] = input.nextDouble();
		probabilities[3] = input.nextDouble();

		BSOD.setName("BSOD");
		ToT.setName("ToT");
		GF.setName("GF");
		KK.setName("KK");
		
		System.out.println(RandomGenerator.selectRide(rides, probabilities).getName());
		
		System.out.println(Arrays.toString(probabilities));
		*/
		
		
		
		System.out.println("Welcome to Seven Flags!");
		System.out.println();
		
		System.out.println("Please enter the number of regular customers: ");
		regs = input.nextInt();
		System.out.println("Please enter the number of silver customers: ");
		silvs = input.nextInt();
		System.out.println("Please enter the number of gold customers: ");
		golds = input.nextInt();
		System.out.println("Please enter the simulation length: ");
		simLength = input.nextInt();
		System.out.println();
		
		
		reg = new Person[regs];
		silv = new Person[silvs];
		gold = new Person[golds];
		for(int i = 0; i < regs; i++)
		{
			reg[i] = new Person(i, 1, "Regular", "Available");
		}
		for(int i = 0; i < silvs; i++)
		{
			silv[i] = new Person(i, 2, "Silver", "Available");
		}
		for(int i = 0; i < golds; i++)
		{
			gold[i] = new Person(i, 3, "Gold", "Available");
		}	
		
		System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
		duration = input.nextInt();
		System.out.println("Please enter the capacity of Blue Scream of Death: ");
		rideCapacity = input.nextInt();
		System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
		holdingSize = input.nextInt();
		BSOD = new Ride("Blue Scream of Death", duration, rideCapacity, holdingSize);
		System.out.println();
		
		System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
		duration = input.nextInt();
		System.out.println("Please enter the capacity of Kingda Knuth: ");
		rideCapacity = input.nextInt();
		System.out.println("Please enter the holding queue size for Kingda Knuth: ");
		holdingSize = input.nextInt();
		KK = new Ride("Kingda Knuth", duration, rideCapacity, holdingSize);
		System.out.println();
		
		System.out.println("Please enter the duration of i386 Tower of Terror (minutes): ");
		duration = input.nextInt();
		System.out.println("Please enter the capacity of i386 Tower of Terror: ");
		rideCapacity = input.nextInt();
		System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
		holdingSize = input.nextInt();
		ToT = new Ride("i386 Tower of Terror", duration, rideCapacity, holdingSize);
		System.out.println();
		
		System.out.println("Please enter the duration of GeForce (minutes): ");
		duration = input.nextInt();
		System.out.println("Please enter the capacity of GeForce: ");
		rideCapacity = input.nextInt();
		System.out.println("Please enter the holding queue size for GeForce: ");
		holdingSize = input.nextInt();
		GF = new Ride("GeForce", duration, rideCapacity, holdingSize);
		System.out.println();
		
		double[] probabilities = new double[4];
		System.out.println("Please enter the probabilities as decimals of each ride (Must add to 1 in total)");
		// Keeps going until all inputed probabilities equal 1
		do
		{
		System.out.println("Probability 1: ");
		probabilities[0] = input.nextDouble();
		System.out.println("Probability 2: ");
		probabilities[1] = input.nextDouble();
		System.out.println("Probability 3: ");
		probabilities[2] = input.nextDouble();
		System.out.println("Probability 4: ");
		probabilities[3] = input.nextDouble();

		if((double)(probabilities[0] * 10 + probabilities[1] * 10 + probabilities[2] * 10 + probabilities[3] * 10) / 10 != 1)
		{
			System.out.println("Total of probabilities did not equal 1, please enter new ones that equal 1 this time");
		}
		}while((double)(probabilities[0] * 10 + probabilities[1] * 10 + probabilities[2] * 10 + probabilities[3] * 10) / 10 != 1);
		
		System.out.println("Blue Scream of Death probability: " + (probabilities[0] * 100) + "%");
		System.out.println("Kingda Knuth probability: " + (probabilities[1] * 100) + "%");
		System.out.println("i386 Tower of Terror probability: " + (probabilities[2] * 100) + "%");
		System.out.println("GeForce probability: " + (probabilities[3] * 100) + "%");
		System.out.println();
		
		
		System.out.println("- -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- - -- -");
		
		
		Ride[] rides = {BSOD, ToT, GF, KK};
		
		
		do
		{
			// BSOD advancing lines
			if(BSOD.getTimeLeft() == 0)
			{
				for(int i = 0; i < BSOD.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!BSOD.getPeopleOnRide().getVLine().isEmpty())
					{
						BSOD.getPeopleOnRide().getVLine().get(0).setStatus("Available");
						for(int j = 0; j < BSOD.getPeopleOnRide().getVLine().get(0).getMaxLines(); j++)
						{
							if(BSOD.getPeopleOnRide().getVLine().get(0).getLines()[j] == BSOD)
							{
								BSOD.getPeopleOnRide().getVLine().get(0).setLines(null, j);
								break;
							}
						}
						if(BSOD.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Gold"))
							gRides++;
						if(BSOD.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Silver"))
							sRides++;
						if(BSOD.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Regular"))
							rRides++;
						BSODRides++;
						BSOD.getPeopleOnRide().dequeue();
					}
				}
				for(int i = 0; i < BSOD.getHoldingQueue().getMaxSize() && i < BSOD.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!BSOD.getPeopleOnRide().isFull() && !BSOD.getHoldingQueue().getVLine().isEmpty())
					{
					BSOD.getHoldingQueue().getVLine().get(0).setStatus("OnRide");
					BSOD.getPeopleOnRide().enqueue(BSOD.getHoldingQueue().dequeue());
					}
				}
				int y = BSOD.getVirtualLine().getVLine().size();
				for(int i = 0; i < y && i < BSOD.getHoldingQueue().getMaxSize(); i++)
				{
					if(!BSOD.getHoldingQueue().isFull() && !BSOD.getVirtualLine().getVLine().isEmpty())
					{
					BSOD.getVirtualLine().getVLine().get(0).setStatus("Holding");
					BSOD.getHoldingQueue().enqueue(BSOD.getVirtualLine().dequeue());
					}
				}
				BSOD.setTimeLeft();
			}
			
			// KK advancing lines
			if(KK.getTimeLeft() == 0)
			{
				for(int i = 0; i < KK.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!KK.getPeopleOnRide().getVLine().isEmpty())
					{
						KK.getPeopleOnRide().getVLine().get(0).setStatus("Available");
						for(int j = 0; j < KK.getPeopleOnRide().getVLine().get(0).getMaxLines(); j++)
						{
							if(KK.getPeopleOnRide().getVLine().get(0).getLines()[j] == KK)
							{
								KK.getPeopleOnRide().getVLine().get(0).setLines(null, j);
								break;
							}
						}
						if(KK.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Gold"))
							gRides++;
						if(KK.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Silver"))
							sRides++;
						if(KK.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Regular"))
							rRides++;
						KKRides++;
						KK.getPeopleOnRide().dequeue();
					}
				}
				for(int i = 0; i < KK.getHoldingQueue().getMaxSize() && i < KK.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!KK.getPeopleOnRide().isFull() && !KK.getHoldingQueue().getVLine().isEmpty())
					{
						KK.getHoldingQueue().getVLine().get(0).setStatus("OnRide");
						KK.getPeopleOnRide().enqueue(KK.getHoldingQueue().dequeue());
					}
				}
				int y = KK.getVirtualLine().getVLine().size();
				for(int i = 0; i < y && i < KK.getHoldingQueue().getMaxSize(); i++)
				{
					if(!KK.getHoldingQueue().isFull() && !KK.getVirtualLine().getVLine().isEmpty())
					{
						KK.getVirtualLine().getVLine().get(i).setStatus("Holding");
						KK.getHoldingQueue().enqueue(KK.getVirtualLine().dequeue());
					}
				}
				KK.setTimeLeft();
			}
			
			// ToT advancing lines
			if(ToT.getTimeLeft() == 0)
			{
				for(int i = 0; i < ToT.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!ToT.getPeopleOnRide().getVLine().isEmpty())
					{
						ToT.getPeopleOnRide().getVLine().get(0).setStatus("Available");
						for(int j = 0; j < ToT.getPeopleOnRide().getVLine().get(0).getMaxLines(); j++)
						{
							if(ToT.getPeopleOnRide().getVLine().get(0).getLines()[j] == ToT)
							{
								ToT.getPeopleOnRide().getVLine().get(0).setLines(null, j);
								break;
							}
						}
						if(ToT.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Gold"))
							gRides++;
						if(ToT.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Silver"))
							sRides++;
						if(ToT.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Regular"))
							rRides++;
						ToTRides++;
						ToT.getPeopleOnRide().dequeue();
					}
				}
				for(int i = 0; i < ToT.getHoldingQueue().getMaxSize() && i < ToT.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!ToT.getPeopleOnRide().isFull() && !ToT.getHoldingQueue().getVLine().isEmpty())
					{
						ToT.getHoldingQueue().getVLine().get(0).setStatus("OnRide");
						ToT.getPeopleOnRide().enqueue(ToT.getHoldingQueue().dequeue());
					}
				}
				int y = ToT.getVirtualLine().getVLine().size();
				for(int i = 0; i < y && i < ToT.getHoldingQueue().getMaxSize(); i++)
				{
					if(!ToT.getHoldingQueue().isFull() && !ToT.getVirtualLine().getVLine().isEmpty())
					{
						ToT.getVirtualLine().getVLine().get(i).setStatus("Holding");
						ToT.getHoldingQueue().enqueue(ToT.getVirtualLine().dequeue());
					}
				}			
				ToT.setTimeLeft();
			}
			
			// GF advancing lines
			if(GF.getTimeLeft() == 0)
			{
				for(int i = 0; i < GF.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!GF.getPeopleOnRide().getVLine().isEmpty())
					{
						GF.getPeopleOnRide().getVLine().get(0).setStatus("Available");
						for(int j = 0; j < GF.getPeopleOnRide().getVLine().get(0).getMaxLines(); j++)
						{
							if(GF.getPeopleOnRide().getVLine().get(0).getLines()[j] == GF)
							{
								GF.getPeopleOnRide().getVLine().get(0).setLines(null, j);
								break;
							}
						}
						if(GF.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Gold"))
							gRides++;
						if(GF.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Silver"))
							sRides++;
						if(GF.getPeopleOnRide().getVLine().get(0).getRegSilGol().equals("Regular"))
							rRides++;
						GFRides++;
						GF.getPeopleOnRide().dequeue();
					}
				}
				for(int i = 0; i < GF.getHoldingQueue().getMaxSize() && i < GF.getPeopleOnRide().getMaxSize(); i++)
				{
					if(!GF.getPeopleOnRide().isFull() && !GF.getHoldingQueue().getVLine().isEmpty())
					{
						GF.getHoldingQueue().getVLine().get(0).setStatus("OnRide");
						GF.getPeopleOnRide().enqueue(GF.getHoldingQueue().dequeue());
					}
				}
				int y = GF.getVirtualLine().getVLine().size();
				for(int i = 0; i < y && i < GF.getHoldingQueue().getMaxSize(); i++)
				{
					if(!GF.getHoldingQueue().isFull() && !GF.getVirtualLine().getVLine().isEmpty())
					{
						GF.getVirtualLine().getVLine().get(i).setStatus("Holding");
						GF.getHoldingQueue().enqueue(GF.getVirtualLine().dequeue());
					}
				}
				GF.setTimeLeft();
			}
			
			
			// Golds selecting new rides, first
			for(int i = 0; i < golds; i++)
			{
				if(gold[i].getLines()[0] == null)
				{
					gold[i].setLines(RandomGenerator.selectRide(rides, probabilities), 0);
					switch(gold[i].getLines()[0].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;						
					}
				}
			}
			
			// Silvers selecting new rides, first
			for(int i = 0; i < silvs; i++)
			{
				if(silv[i].getLines()[0] == null)
				{
					silv[i].setLines(RandomGenerator.selectRide(rides, probabilities), 0);
					switch(silv[i].getLines()[0].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;						
					}
				}
			}
			
			// Regulars selecting new rides, first
			for(int i = 0; i < regs; i++)
			{
				if(reg[i].getLines()[0] == null)
				{
					reg[i].setLines(RandomGenerator.selectRide(rides, probabilities), 0);
					switch(reg[i].getLines()[0].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !reg[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(reg[i]);
							reg[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !reg[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide"))
								reg[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								reg[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !reg[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(reg[i]);
							reg[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !reg[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide"))
								reg[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide") && !reg[i].getStatus().equals("Holding"))
								reg[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !reg[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(reg[i]);
							reg[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !reg[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide"))
								reg[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide") && !reg[i].getStatus().equals("Holding"))
								reg[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !reg[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(reg[i]);
							reg[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !reg[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide"))
								reg[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(reg[i]);
							if(!reg[i].getStatus().equals("OnRide") && !reg[i].getStatus().equals("Holding"))
								reg[i].setStatus("Available");
						}
						break;						
					}
				}
			}
			
			// Golds selecting new rides, second
			for(int i = 0; i < golds; i++)
			{
				if(gold[i].getLines()[1] == null)
				{
					gold[i].setLines(RandomGenerator.selectRide(rides, probabilities), 1);
					switch(gold[i].getLines()[1].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;						
					}
				}
			}
			
			// Silvers selecting rides, second
			for(int i = 0; i < silvs; i++)
			{
				if(silv[i].getLines()[1] == null)
				{
					silv[i].setLines(RandomGenerator.selectRide(rides, probabilities), 1);
					switch(silv[i].getLines()[1].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !silv[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(silv[i]);
							silv[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !silv[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide"))
								silv[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(silv[i]);
							if(!silv[i].getStatus().equals("OnRide") && !silv[i].getStatus().equals("Holding"))
								silv[i].setStatus("Available");
						}
						break;						
					}
				}
			}
			
			// Golds selecting rides, third
			for(int i = 0; i < golds; i++)
			{
				if(gold[i].getLines()[2] == null)
				{
					gold[i].setLines(RandomGenerator.selectRide(rides, probabilities), 2);
					switch(gold[i].getLines()[2].getName())
					{
					case "Blue Scream of Death":
						if(!BSOD.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							BSOD.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!BSOD.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							BSOD.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							BSOD.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "Kingda Knuth":
						if(!KK.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							KK.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!KK.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							KK.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							KK.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "i386 Tower of Terror":
						if(!ToT.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							ToT.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!ToT.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							ToT.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							ToT.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;
					case "GeForce":
						if(!GF.getPeopleOnRide().isFull() && !gold[i].getStatus().equals("OnRide"))
						{
							GF.getPeopleOnRide().enqueue(gold[i]);
							gold[i].setStatus("OnRide");
						}
						else if(!GF.getHoldingQueue().isFull() && !gold[i].getStatus().equals("Holding"))
						{
							GF.getHoldingQueue().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide"))
								gold[i].setStatus("Holding");
						}
						else
						{
							GF.getVirtualLine().enqueue(gold[i]);
							if(!gold[i].getStatus().equals("OnRide") && !gold[i].getStatus().equals("Holding"))
								gold[i].setStatus("Available");
						}
						break;						
					}					
				}
			}
			
			
			
			
			
			
			
			System.out.println("At Time " + time + ":");
			
			// BSOD print
			System.out.println(BSOD.getName() + " - Time remaining: " + BSOD.getTimeLeft() + " min");
			System.out.print("On Ride: ");
			for(int i = 0; i < BSOD.getPeopleOnRide().getVLine().size(); i++)
			{
				if(BSOD.getPeopleOnRide().getVLine().get(i) != null)
				{
					System.out.print(BSOD.getPeopleOnRide().getVLine().get(i).getRegSilGol() + " " +  (BSOD.getPeopleOnRide().getVLine().get(i).getNumber() + 1));
					if(i != BSOD.getPeopleOnRide().getMaxSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.print("Holding Queue: ");
			for(int i = 0; i < BSOD.getHoldingQueue().getVLine().size(); i++)
			{
				if(BSOD.getHoldingQueue().getVLine().get(i) != null)
				{
					System.out.print(BSOD.getHoldingQueue().getVLine().get(i).getRegSilGol() + " " +  (BSOD.getHoldingQueue().getVLine().get(i).getNumber() + 1));
					if(i != BSOD.getHoldingQueue().getMaxSize() - 1)
						System.out.print(", ");
				}
				}
			System.out.println();
			System.out.print("Virtual Queue: ");
			for(int i = 0; i < BSOD.getVirtualLine().getVLine().size(); i++)
			{
				if(BSOD.getVirtualLine().getVLine().get(i) != null)
				{
					System.out.print(BSOD.getVirtualLine().getVLine().get(i).getRegSilGol() + " " +  (BSOD.getVirtualLine().getVLine().get(i).getNumber() + 1));
					if(i != BSOD.getVirtualLine().getQueueSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.println("- -- - -- - -- - -- - -- - -- - -- - -- -");
			System.out.println();

			// KK print
			System.out.println(KK.getName() + " - Time remaining: " + BSOD.getTimeLeft() + " min");
			System.out.print("On Ride: ");
			for(int i = 0; i < KK.getPeopleOnRide().getVLine().size(); i++)
			{
				if(KK.getPeopleOnRide().getVLine().get(i) != null)
				{
					System.out.print(KK.getPeopleOnRide().getVLine().get(i).getRegSilGol() + " " +  (KK.getPeopleOnRide().getVLine().get(i).getNumber() + 1));
					if(i != KK.getPeopleOnRide().getMaxSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.print("Holding Queue: ");
			for(int i = 0; i < KK.getHoldingQueue().getVLine().size(); i++)
			{
				if(KK.getHoldingQueue().getVLine().get(i) != null)
				{
					System.out.print(KK.getHoldingQueue().getVLine().get(i).getRegSilGol() + " " +  (KK.getHoldingQueue().getVLine().get(i).getNumber() + 1));
					if(i != KK.getHoldingQueue().getMaxSize() - 1)
						System.out.print(", ");
				}
				}
			System.out.println();
			System.out.print("Virtual Queue: ");
			for(int i = 0; i < KK.getVirtualLine().getVLine().size(); i++)
			{
				if(KK.getVirtualLine().getVLine().get(i) != null)
				{
					System.out.print(KK.getVirtualLine().getVLine().get(i).getRegSilGol() + " " +  (KK.getVirtualLine().getVLine().get(i).getNumber() + 1));
					if(i != KK.getVirtualLine().getQueueSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.println("- -- - -- - -- - -- - -- - -- - -- - -- -");
			System.out.println();
			
			// ToT print
			System.out.println(ToT.getName() + " - Time remaining: " + ToT.getTimeLeft() + " min");
			System.out.print("On Ride: ");
			for(int i = 0; i < ToT.getPeopleOnRide().getVLine().size(); i++)
			{
				if(ToT.getPeopleOnRide().getVLine().get(i) != null)
				{
					System.out.print(ToT.getPeopleOnRide().getVLine().get(i).getRegSilGol() + " " +  (ToT.getPeopleOnRide().getVLine().get(i).getNumber() + 1));
					if(i != ToT.getPeopleOnRide().getMaxSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.print("Holding Queue: ");
			for(int i = 0; i < ToT.getHoldingQueue().getVLine().size(); i++)
			{
				if(ToT.getHoldingQueue().getVLine().get(i) != null)
				{
					System.out.print(ToT.getHoldingQueue().getVLine().get(i).getRegSilGol() + " " +  (ToT.getHoldingQueue().getVLine().get(i).getNumber() + 1));
					if(i != ToT.getHoldingQueue().getMaxSize() - 1)
						System.out.print(", ");
				}
				}
			System.out.println();
			System.out.print("Virtual Queue: ");
			for(int i = 0; i < ToT.getVirtualLine().getVLine().size(); i++)
			{
				if(ToT.getVirtualLine().getVLine().get(i) != null)
				{
					System.out.print(ToT.getVirtualLine().getVLine().get(i).getRegSilGol() + " " +  (ToT.getVirtualLine().getVLine().get(i).getNumber() + 1));
					if(i != ToT.getVirtualLine().getQueueSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.println("- -- - -- - -- - -- - -- - -- - -- - -- -");
			System.out.println();
						
			// GF print
			System.out.println(GF.getName() + " - Time remaining: " + GF.getTimeLeft() + " min");
			System.out.print("On Ride: ");
			for(int i = 0; i < GF.getPeopleOnRide().getVLine().size(); i++)
			{
				if(GF.getPeopleOnRide().getVLine().get(i) != null)
				{
					System.out.print(GF.getPeopleOnRide().getVLine().get(i).getRegSilGol() + " " +  (GF.getPeopleOnRide().getVLine().get(i).getNumber() + 1));
					if(i != GF.getPeopleOnRide().getMaxSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.print("Holding Queue: ");
			for(int i = 0; i < GF.getHoldingQueue().getVLine().size(); i++)
			{
				if(GF.getHoldingQueue().getVLine().get(i) != null)
				{
					System.out.print(GF.getHoldingQueue().getVLine().get(i).getRegSilGol() + " " +  (GF.getHoldingQueue().getVLine().get(i).getNumber() + 1));
					if(i != GF.getHoldingQueue().getMaxSize() - 1)
						System.out.print(", ");
				}
				}
			System.out.println();
			System.out.print("Virtual Queue: ");
			for(int i = 0; i < GF.getVirtualLine().getVLine().size(); i++)
			{
				if(GF.getVirtualLine().getVLine().get(i) != null)
				{
					System.out.print(GF.getVirtualLine().getVLine().get(i).getRegSilGol() + " " +  (GF.getVirtualLine().getVLine().get(i).getNumber() + 1));
					if(i != GF.getVirtualLine().getQueueSize() - 1)
						System.out.print(", ");
				}
			}
			System.out.println();
			System.out.println("- -- - -- - -- - -- - -- - -- - -- - -- -");
			System.out.println();
			
			// Print out regulars, silvers and golds
			System.out.println("Regular Customers: ");
			System.out.println();
			System.out.println("Num Line Status");
			System.out.println("---------------");
			printPersons(reg);
			System.out.println();
			System.out.println();
			System.out.println("Silver Customers: ");
			System.out.println();
			System.out.println("Num Line 1 Line 2 Status");
			System.out.println("------------------------");
			printPersons(silv);
			System.out.println();
			System.out.println();
			System.out.println("Gold Customers: ");
			System.out.println();
			System.out.println("Num Line 1 Line 2 Line 3 Status");
			System.out.println("-------------------------------");
			printPersons(gold);
			System.out.println();
			System.out.println();	
			
			
			
			// Time moves forward by 1
			BSOD.timeProgress();
			KK.timeProgress();
			ToT.timeProgress();
			GF.timeProgress();
			time++;
		}
		while(time < simLength);
		
		// average rides for each customer type
		System.out.println("On average, Gold customers have taken " + (double)(gRides / time) + " rides");
		System.out.println("On average, Silver customers have taken " + (double)(sRides / time) + " rides");
		System.out.println("On average, Regular customers have taken " + (double)(rRides / time) + " rides");
		System.out.println();
		
		// total rides completed for each ride
		System.out.println("BSOD has completed rides for " + BSODRides + " people");
		System.out.println("KK has completed rides for " + KKRides + " people");
		System.out.println("ToT has completed rides for " + ToTRides + " people");
		System.out.println("GF has completed rides for " + GFRides + " people");
		

		
	}
	
	
	public static void printPersons(Person[] persons)
	{
		if(persons.length > 0)
		{Arrays.stream(persons).forEach(System.out::println);
		}
	}
	
	
	
}

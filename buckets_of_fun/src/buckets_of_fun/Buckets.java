/*
 * Mackenzie Sutherland
 * Buckets Challenge
 * 
 * Your boss needs a bucket filled with "X" gallons of water and he needs it
 * YESTERDAY. Using two buckets, get the perfect amount of water as fast as
 * possible and tell your boss how you did it.
 * 
 * You have three actions available:
 * Fill a bucket to its brim
 * Empty a bucket entirely
 * Transfer as much water as possible between buckets
 */

package buckets_of_fun;

import java.util.Scanner;

public class Buckets {

	private int size;
	private int water;
	
	// 'target' not used in constructors, accessible everywhere
	private static int target;

	public Buckets()
	{
		int volume;
		int water = 0;
	}
	
	public Buckets(int x, int y)
	{
		int volume = x;
		int water = y;
	}
	
	public int getVolume()
	{
		return this.size;
	}
	
	public void setVolume(int x)
	{
		this.size = x;
	}
	
	public int getWater()
	{
		return this.water;
	}
	
	public void setWater(int x)
	{
		this.water = x;
	}
	
	public void fillBucket()
	{
		this.water = this.size;
	}
	
	public void emptyBucket()
	{
		this.water = 0;
	}
	
	public static void transfer(Buckets from, Buckets to)
	{
		int allowed = to.getVolume() - to.getWater();
		
		if(from.getWater()>= allowed)
		{
			from.setWater(from.getWater() - allowed);
			to.setWater(to.getWater() + allowed);
		}
		else
		{
			to.setWater(to.getWater() + from.getWater());
			from.emptyBucket();
		}
	}
	
	public boolean isFull()
	{
		if(this.getWater() == this.getVolume())
			return true;
		else
			return false;
	}
	
	public static int algorithm(Buckets pBucket, Buckets sBucket)
	{
		int counter = 0;
		
		System.out.println(pBucket.getVolume() + "\t|\t" + sBucket.getVolume());
		System.out.println("-------------------");
		
		System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
		System.out.println(" --> Begin");
		
		while(pBucket.getWater() != target && sBucket.getWater() != target)
		{
			counter++;
			
			if(pBucket.getWater() == 0)
			{
				pBucket.fillBucket();
				System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
				System.out.println(" --> Fill Primary Bucket");
			}
			
			else if(pBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
				System.out.println(" --> Transfer from Primary to Secondary");
			}
			
			else if(sBucket.isFull())
			{
				sBucket.emptyBucket();
				System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
				System.out.println(" --> Empty Secondary Bucket");
			}
			
			else if(pBucket.getWater() > 0 && !pBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
				System.out.println(" --> Transfer from Primary to Secondary");
			}
			
			else if(pBucket.isFull() && !sBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
				System.out.println(" --> Transfer from Primary to Secondary");
			}
		}
		
		if(pBucket.getWater() == target && sBucket.getWater() != 0)
		{
			sBucket.emptyBucket();
			counter++;

			System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
			System.out.println(" --> Empty Secondary Bucket");
			System.out.println();
			
			System.out.println("This problem was solved in " + counter + " steps.");
		}
		
		else if(sBucket.getWater() == target && pBucket.getWater() != 0)
		{
			pBucket.emptyBucket();
			counter++;
			

			System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
			System.out.println(" --> Empty Secondary Bucket");
			System.out.println();
			
			System.out.println("This problem was solved in " + counter + " steps.");
		}
		
		else
		{
			System.out.println();
			System.out.println("This problem was solved in " + counter + " steps.");
		}
		
		pBucket.emptyBucket();
		sBucket.emptyBucket();
		return counter;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int response = 1;
		int secret = 0;
		
		while(response == 1)
		{
			
			Buckets pBucket = new Buckets();
			Buckets sBucket = new Buckets();
			
			System.out.println("Enter Primary Bucket's size: \n");
			int pSize = scan.nextInt();
			pBucket.setVolume(pSize);
			
			System.out.println("\nEnter Secondary Bucket's size: \n");
			int sSize = scan.nextInt();
			sBucket.setVolume(sSize);
			
			System.out.println("\nPlease enter the target volume: \n");
			target = scan.nextInt();
			System.out.println();
			
			if(target > pSize && target > sSize)
			{
				if(secret == 1)
				{
					System.out.println("I'm not putting up with this today.");
					System.exit(0);
				}
				System.out.println("No, that won't work. Why did you think that would work?");
				System.out.println("Try that one again and see what I do. I double-dog dare you.\n");
				secret++;
			}
			
			else
			{
				System.out.println("\nRoute 1: " + pBucket.getVolume() + " to " + sBucket.getVolume());
				System.out.println();
				
				int routeOne = algorithm(pBucket, sBucket);
				
				System.out.println("\nRoute 2: " + sBucket.getVolume() + " to " + pBucket.getVolume());
				System.out.println();
				
				int routeTwo = algorithm(sBucket, pBucket);
				
				System.out.println();
				
				if(routeOne < routeTwo)
					System.out.println("Route 1 is faster");
				else if(routeTwo < routeOne)
					System.out.println("Route 2 is faster");
				else
					System.out.println("Both Routes have the same speed");
				
				System.out.println("\nWould you like to continue? (1 - Continue, 0 - Exit)");
				response = scan.nextInt();
				if(response != 0 && response != 1)
					response = 1;
			}
		}
		
		scan.close();
	}

}

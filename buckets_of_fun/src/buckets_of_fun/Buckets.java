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
import java.math.*;

public class Buckets {

	private int size;
	private int water;
	
	// 'target' not used in constructors, accessible everywhere
	private static int target;

	// Default constructor
	public Buckets()
	{
		int volume;
		int water = 0;
	}
	
	// Constructor with parameters to initialize 'volume' and 'water'
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
	
	// Fill specified Bucket object entirely
	public void fillBucket()
	{
		this.water = this.size;
	}
	
	// Empty specified Bucket object entirely
	public void emptyBucket()
	{
		this.water = 0;
	}
	
	// Transfer as much water as is possible from 'A' to 'B'
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
	
	// Check if given Bucket is full
	public boolean isFull()
	{
		if(this.getWater() == this.getVolume())
			return true;
		else
			return false;
	}
	
	// Moved Algorithm outside of main due to size
	public static int algorithm(Buckets pBucket, Buckets sBucket)
	{
		int counter = 0;
		
		// Tried to make output look like design document
		System.out.println(pBucket.getVolume() + "\t|\t" + sBucket.getVolume());
		System.out.println("-------------------");
		
		System.out.print(pBucket.getWater() + "\t|\t" + sBucket.getWater());
		System.out.println(" --> Begin");
		
		// Used while loop because this could get really big for high volumes
		while(pBucket.getWater() != target && sBucket.getWater() != target)
		{
			counter++;
			
			// Order of conditionals matters. Combining all 'transfer' conditionals
			// lead to infinite loop because two can be true at the same time.
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
		
		// At the end, there must be one empty bucket
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
		
		// In case the user wants to run the program again, empty both buckets
		pBucket.emptyBucket();
		sBucket.emptyBucket();
		return counter;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int response = 1;
		int secret = 0;
		int pSize = 0;
		int sSize = 0;
		
		// While loop so that user can run several tests in one session
		while(response == 1)
		{
			Buckets pBucket = new Buckets();
			Buckets sBucket = new Buckets();
			
			// Negative numbers not allowed, convert to positive
			System.out.println("Enter Primary Bucket's size: \n");
			pSize = scan.nextInt();
			if(pSize < 0)
				pSize = Math.abs(pSize);
			pBucket.setVolume(pSize);

			System.out.println("\nEnter Secondary Bucket's size: \n");
			sSize = scan.nextInt();
			if(sSize < 0)
				sSize = Math.abs(sSize);
			sBucket.setVolume(sSize);
			
			if(pSize == sSize)
			{
				System.out.println("\nBucket sizes cannot be equal.\n");
				continue;
			}
			else if(pSize == 0 || sSize == 0)
			{
				System.out.println("\nZero is not an acceptable volume.\n");
				continue;
			}

			System.out.println("\nPlease enter the target volume: \n");
			target = scan.nextInt();
			if(target < 0)
				target = Math.abs(target);
			System.out.println();
			
			// If you try to break the code with unexpected values
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
				continue;
			}
			
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
			
			// In case they try to enter anything besides 0 or 1
			if(response != 0 && response != 1)
				response = 1;
		}
		
		scan.close();
	}

}

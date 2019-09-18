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
	
	public static boolean notFull(Buckets bucket)
	{
		if(bucket.getWater() == bucket.getVolume())
			return false;
		else
			return true;
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

	public static void main(String[] args) {
		 /* 
		  * The largest bucket will always contain the target volume at the end
		 * If both buckets are of equal size, Primary Bucket (pBucket) will
		 * be used
		 */
		
		int counter = 1;
		
		Scanner scan = new Scanner(System.in);
		
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
		
		// FIGURE OUT COUNTER, DON'T NEED TO DISPLAY COUNTER AT END, JUST FIND OPTIMAL ROUTE
		while(pBucket.getWater() != target && sBucket.getWater() != target)
		{
			counter++;
			
			if(pBucket.getWater() == 0)
			{
				pBucket.fillBucket();
				System.out.println("Filling Primary Bucket... \n");
			}
			
			else if(pBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.println("Transferring from Primary to Secondary... \n");
			}
			
			else if(sBucket.isFull())
			{
				sBucket.emptyBucket();
				System.out.println("Emptying Secondary Bucket... \n");
			}
			
			else if(pBucket.getWater() > 0 && !pBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.println("Transferring from Primary to Secondary... \n");
			}
			
			else if(pBucket.isFull() && !sBucket.isFull())
			{
				transfer(pBucket, sBucket);
				System.out.println("Transferring from Primary to Secondary... \n");
			}
			
			System.out.println("Primary Bucket: " + pBucket.getWater());
			System.out.println("Secondary Bucket: " + sBucket.getWater());
			System.out.println();
			
//			if(pBucket.getWater() == target || sBucket.getWater() == target)
//				break;
		}
		
		if(pBucket.getWater() == target && sBucket.getWater() != 0)
		{
			sBucket.emptyBucket();
			
			System.out.println("Emptying Secondary Bucket... \n");
			System.out.println("Primary Bucket: " + pBucket.getWater());
			System.out.println("Secondary Bucket: " + sBucket.getWater());
			System.out.println();
			
			System.out.println("This problem was solved in " + counter + " steps.");
		}
		
		else if(sBucket.getWater() == target && pBucket.getWater() != 0)
		{
			pBucket.emptyBucket();
			
			System.out.println("Emptying Primary Bucket... \n");
			System.out.println("Primary Bucket: " + pBucket.getWater());
			System.out.println("Secondary Bucket: " + sBucket.getWater());
			System.out.println();
			
			System.out.println("This problem was solved in " + counter + " steps.");
		}
		
		else
		{
			System.out.println("This problem was solved in " + counter + " steps.");
		}
	}

}

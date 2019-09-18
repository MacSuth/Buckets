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
	private boolean largest;
	private int water;
	
	// 'target' not used in constructors, accessible everywhere
	private static int target;

	public Buckets()
	{
		int volume;
		boolean largest;
		int water = 0;
	}
	
	public Buckets(int x, boolean y, int z)
	{
		int volume;
		boolean largest;
		int water;
	}
	
	public int getVolume()
	{
		return this.size;
	}
	
	public void setVolume(int x)
	{
		this.size = x;
	}
	
	public boolean getLargest()
	{
		return this.largest;
	}
	
	public void setLargest(boolean x)
	{
		this.largest = x;
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
	
	public static boolean lessThanTarget(Buckets pBucket)
	{
		if(pBucket.getWater() < target)
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
		
		Buckets pBucket = new Buckets();
		Buckets sBucket = new Buckets();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Primary Bucket's size: \n");
		int pBuckSize = scan.nextInt();
		pBucket.setVolume(pBuckSize);
		
		System.out.println("\nEnter Secondary Bucket's size: \n");
		int sBuckSize = scan.nextInt();
		sBucket.setVolume(sBuckSize);
		
		System.out.println("\nPlease enter the target volume: \n");
		target = scan.nextInt();
		
		if(pBucket.getVolume() > sBucket.getVolume())
			pBucket.setLargest(true);
		else
			sBucket.setLargest(true);
		
		
		
		// Any time Primary Bucket hits "0", fill it
		if(pBucket.getWater() == 0)
			pBucket.fillBucket();
		
		if(lessThanTarget(pBucket) && notFull(sBucket))
			transfer(pBucket, sBucket);
	}

}

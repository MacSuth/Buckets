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
	
	public static int getVolume(Buckets bucket)
	{
		return bucket.size;
	}
	
	public static void setVolume(Buckets bucket, int x)
	{
		bucket.size = x;
	}
	
	public static boolean getLargest(Buckets bucket)
	{
		return bucket.largest;
	}
	
	public static void setLargest(Buckets bucket, boolean x)
	{
		bucket.largest = x;
	}
	
	public static int getWater(Buckets bucket)
	{
		return bucket.water;
	}
	
	public static void setWater(Buckets bucket, int x)
	{
		bucket.water = x;
	}
	
	public static void fillBucket(Buckets bucket)
	{
		bucket.water = bucket.size;
	}
	
	public static void emptyBucket(Buckets bucket)
	{
		bucket.water = 0;
	}
	
	public static boolean notFull(Buckets bucket)
	{
		if(getWater(bucket) == getVolume(bucket))
			return false;
		else
			return true;
	}
	
	public static void transfer(Buckets from, Buckets to)
	{
		int allowed = getVolume(to) - getWater(to);
		
		if(getWater(from) >= allowed)
		{
			setWater(from, getWater(from) - allowed);
			setWater(to, getWater(to) + allowed);
		}
		else
		{
			setWater(to, getWater(to) + getWater(from));
			emptyBucket(from);
		}
	}
	
	public static void swapBuckets(Buckets primary, Buckets secondary)
	{
		// Check if target fits in either bucket
		// If target vol doesn't fit in primary, make secondary primary
		
		if()
	}
	
	public static boolean lessThanTarget(Buckets pBucket)
	{
		if(getWater(pBucket) < target)
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
		setVolume(pBucket, pBuckSize);
		
		System.out.println("\nEnter Secondary Bucket's size: \n");
		int sBuckSize = scan.nextInt();
		setVolume(sBucket, sBuckSize);
		
		System.out.println("\nPlease enter the target volume: \n");
		target = scan.nextInt();
		
		if(getVolume(pBucket) > getVolume(sBucket))
			setLargest(pBucket, true);
		else
			setLargest(sBucket, true);
		
		// if target is greater than pBucket volume, swap bucket positions
		swapBuckets(pBucket, sBucket);
		
		
		
		// Any time Primary Bucket hits "0", fill it
		if(getWater(pBucket) == 0)
			fillBucket(pBucket);
		
		if(lessThanTarget(pBucket) && notFull(sBucket))
			transfer(pBucket, sBucket);
	}

}

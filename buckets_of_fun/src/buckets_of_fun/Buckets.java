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

import java.util.*;

public class Buckets {

	private int size;
	private boolean largest;
	private int target;
	private int water;

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
	
	// fillBucket replaces "setWater"
	public static void fillBucket(Buckets bucket)
	{
		bucket.water = bucket.size;
	}
	
	public static void emptyBucket(Buckets bucket)
	{
		bucket.water = 0;
	}
	
	public static void transfer(Buckets from, Buckets to)
	{
		if(getWater(to) < getVolume(to))
			null;
	}

	public static void main(String[] args) {
		// The largest bucket will always contain the target volume at the end
		// If both buckets are of equal size, Primary Bucket (pBucket) will
		// be used
		
		// Any time Primary Bucket hits "0", fill it
		
		Buckets pBucket = new Buckets();
		Buckets sBucket = new Buckets();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Primary Bucket's size: \n");
		int pBuckSize = scan.nextInt();
		setVolume(pBucket, pBuckSize);
		
		System.out.println("Enter Secondary Bucket's size: \n");
		int sBuckSize = scan.nextInt();
		setVolume(sBucket, sBuckSize);
		
		System.out.println("Please enter the target volume: \n");
		int target = scan.nextInt();
		
		if(getVolume(pBucket) > getVolume(sBucket))
			setLargest(pBucket, true);
		else
			setLargest(sBucket, true);
		
		
	}

}

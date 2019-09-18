# Buckets

You have two empty water jugs, a three gallon bucket and a five gallon
bucket. Given an endless water supply, use the three gallon and five
gallon buckets to measure exactly four gallons of water.
Your actions are limited to fill, transfer and empty. You do not have a
way to measure the partial volume of a bucket, as you can’t query its
contents.

Available actions:
1. Fill – you can fill a bucket
2. Transfer – you can transfer water from one bucket to the other.
This can only transfer the amount that is empty in the target
container. The remaining stays in the source container.
3. Empty – you can empty the contents of a bucket
Given the above, two routes are possible.
Route 1: 3 to 5.

```
3 | 5
-----
0 | 0 => start
3 | 0 => fill bucket A
0 | 3 => transfer bucket A to bucket B
3 | 3 => fill bucket A
1 | 5 => transfer bucket A to bucket B
1 | 0 => empty bucket B
0 | 1 => transfer bucket A to bucket B
3 | 1 => fill bucket A
0 | 4 => transfer bucket A to bucket B
success
```
Route 2: 5 to 3
```
5 | 3
------
0 | 0 => start
5 | 0 => fill bucket A
2 | 3 => transfer bucket A to bucket B
2 | 0 => empty bucket B
0 | 2 => transfer bucket A to bucket B
5 | 2 => fill bucket A
4 | 3 => transfer bucket A to bucket B
4 | 0 => empty bucket B
success
```

Now we know there are two solutions for this given set of inputs.

Objective:
Create an app based on the above, but generalize it for two bucket
sizes and one target volume, (ex: Buckets of 1 & 3, Target volume of 2;
Buckets of 3 and 11, Target volume of 7). Determine whether there is a
solution and how many solutions and what’s the best solution (fewest
steps).
1. Solution should use Java.
2. Create production quality code.
3. Have fun with it. Show us what you love about coding. We really
want to see you show us what you are passionate about.
4. BONUS: Tests and Optimizations for speed or memory.
5. BONUS: Fun/Useful/Engaging README file

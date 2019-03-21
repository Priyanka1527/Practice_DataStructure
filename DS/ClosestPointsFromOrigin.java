/* Given an array containing N points find the K closest points to the origin in the 2D plane */

/* Brute Force approach would be to find the Eucladian Distance for each point from prigin
and then sort them(O(nlogn)) time and then choose least K - but it is costlier as we don't
need to sort ell tha points, we just care about least K */

//Reference: http://www.zrzahid.com/k-closest-points/
//https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/

/* Solution 1 : Using Max-Heap (Priority Queue) of size K for maintaining K min distances. 
Keep adding the distance values until the heap is full. If it is full &
the new point is less distant than the max distance of heap, then replace in O(1) time.
Then Max-Heapify to update heap in O(logK) time.

When all points traversed, make 2nd pass to the array and ouput first K elements having 
distance less than the max distance of the heap(first element) - O(nlogK) time, O(logk) heap space
*/

/* Optimization: using QuickSelect Selection Algorithm in O(n) time and constant space.
https://en.wikipedia.org/wiki/Quickselect
*/

import java.util.*;
import java.lang.*;
class Point implements Comparable<Point>
{
	int x,y;

	Point(int a, int b)
	{
		x = a;
		y = b;
	}

	double getDist()
	{
		return x*x + y*y;
	}

	@Override
	public int compareTo(Point o) {
		int c = Double.compare(getDist(), o.getDist());
		if(c == 0){
			c = Double.compare(x, o.x);
			if(c == 0){
				c = Double.compare(y, o.y);
			}
		}
		return c;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}



class ClosestPointsFromOrigin
{
	static Point[] kClosest(List<Point> points, int k)
	{
		PriorityQueue<Point> queue = new PriorityQueue<>(k, Collections.reverseOrder());

		for(int i=0; i< points.size(); i++)
		{
			if(queue.size() < k)
				queue.add(points.get(i));
			else if (points.get(i).getDist() < queue.peek().getDist())
			{
				queue.remove();
				queue.add(points.get(i));
			}
		}

		return queue.toArray(new Point[k]);
	}

	public static void main(String args[])
	{
		List<Point> points = Arrays.asList(new Point(3,3), new Point(5,-1), new Point(-2,4));
		int k = 2;

		Point[] res = kClosest(points,k);

		for(int i=0; i<res.length; i++)
		{
			System.out.println(res[i]);
		}
	}
}


import java.util.*;

class IntervalTwoList {

static class Interval {
	int start;
	int end;
	Interval(int a, int b) {
		this.start = a;
		this.end = b;
	}
	
	public boolean overlaps(Interval b) {
		if((this.start <= b.end && this.end >= b.start) ||
				(b.start <= this.end && b.end >= this.start))
			return true;
		
		return false;
	}
}

static List<Interval> mergeIntervalFinal(List<Interval> list1, List<Interval> list2) {
	
	List<Interval> result = new ArrayList<Interval>();
	int list1Len = list1.size();
	int list2Len = list2.size();
	int i = 0;
	int j = 0;
			
	while(i < list1Len && j < list2Len) {
		Interval i1 = list1.get(i);
		Interval i2 = list2.get(j);
		int resSize = result.size();
		if(resSize > 0) {
			Interval temp = result.get(resSize - 1);
			if(temp.overlaps(i1) || temp.overlaps(i2)) {
				Interval interval = null;
				if(temp.overlaps(i1)) {
					interval = mergeUtil(temp, i1);
					i++;
				} else {
					interval = mergeUtil(temp, i2);
					j++;
				}
				result.remove(resSize - 1);
				result.add(interval);
				continue;
			}
		}
		if(i1.overlaps(i2)) {
			Interval newInterval = mergeUtil(i1, i2);
			result.add(newInterval);
			i++;
			j++;
		} else if(i1.start > i2.end) {
			result.add(i2);
			j++;
		} else {
			result.add(i1);
			i++;
		
		}
	}
	if(j < list2Len) {
		list1 = list2;
		i = j;
	}
	while(i < list1.size()) {
		Interval i1 = list1.get(i);
		Interval temp = result.get(result.size() - 1);
		if(temp.overlaps(i1)) {
			i1 = mergeUtil(temp, i1);
			result.remove(result.size() - 1);
		} 
		result.add(i1);
		i++;
	}
	return result;
	
}


static Interval mergeUtil (Interval i1, Interval i2) {
		Interval newInterval = new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
		return newInterval;
}


public static void main(String a[]) {

	List<Interval> list = new ArrayList<Interval>();
	List<Interval> list2 = new ArrayList<Interval>();
	
	Interval i1 = new Interval(3,11);
	list.add(i1);
	i1 = new Interval(17,25);
	list.add(i1);
	i1 = new Interval(58,73);
	list.add(i1);
	
	i1 = new Interval(6,18);
	list2.add(i1);
	i1 = new Interval(40,47);
	list2.add(i1);
	
	List<Interval> result = mergeIntervalFinal(list, list2);
	printIntervals(result);
	
}

static void printIntervals(List<Interval> result){
	for(Interval i: result) {
		System.out.println(i.start + "-" + i.end);
	}
}
}
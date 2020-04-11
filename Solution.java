package example_knap;

import java.util.List;

public class Solution {
	// list of items to put in the bag 
	public List<Item> items;
	public int value; // maximum value possible
	
	public Solution(List<Item> items, int value) {
		this.items = items;
		this.value = value;
	}
	public void display() {
		if(items != null && !items.isEmpty()) {
			System.out.println("Knapsack Problem");
			System.out.println("Value ="+ value);
			System.out.println("Items to Pick :");
			
			for (Item item : items) {
			System.out.println("-> "+ item.toString());	
			
	 }
	}
  }
}

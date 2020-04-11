package example_knap;

import java.util.ArrayList;

public class Kanpsack {
	private Item[] items; // Items of our problem
	private int capacity; // Capacity of the bag
	//Constructor
	public Kanpsack(Item[] items, int capacity) {
		this.items = items;
		this.capacity = capacity;
	}
	// method for Prints
	public void print() {
		if(items != null && items.length > 0) {
			System.out.println("Knapsack Problem");
			System.out.println("Capacity = "+ capacity);
			System.out.println("Items :");
			
			for (Item item : items) {
			System.out.println(" -> "+ item.toString());		
	 }
	}
  }
	// write the solve algorithm
	public Solution solve() {
		int NUM_of_ITEMS = items.length; 
		// use a matrix to store the max value at each number of items
		int[][] matrix = new int[NUM_of_ITEMS+1][capacity + 1];
		// first line is initialized to 0
		for (int i = 0; i <= capacity; i++) 
			matrix[0][i] = 0;
		// iterate on item
		for (int i = 1; i <= NUM_of_ITEMS; i++) { 
	    // iterate on each capacity
			for(int j=0; j<= capacity; j++) {
				if (items[i - 1].weight > j)
						matrix[i][j]= matrix[i-1][j];
				else
					// we maximize value at this rank in the matrix.
					matrix[i][j]= Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight]+ items[i-1].value);
				}
				
			}
	// in the cell matrix[NB_ITEMS][capacity]
	// we need to display which elements are put in the bag to max the value
		
		int res = matrix[NUM_of_ITEMS][capacity];
		int w = capacity;
		ArrayList<Item> itemsSolution = new ArrayList<>();
		for (int i = NUM_of_ITEMS;i>0 && res>0 ;i--) {
			if(res != matrix[i-1][w]) {
				itemsSolution.add(items[i-1]);
				// we remove items value & weight
				res -= items[i-1].value;
				w -= items[i-1].weight;
			}	
		}
		return new Solution(itemsSolution, matrix[NUM_of_ITEMS][capacity]);
	}
	
	 	public static void main(String[] args) {
		// we take the same instance of the problem display in the image
		
		Item[] items= {new Item("Sel1", 4,12),new Item("Sel2", 2,1),new Item("Sel3", 2,2),
				new Item("Sel4", 1,1),new Item("Sel5", 10,4)};	
		
		Kanpsack knapsack = new Kanpsack(items, 15);
		knapsack.print();
		Solution solution = knapsack.solve();
		solution.display();
		System.out.println("-----------------------------");

	 	////////////////////////// New Values ANWER ////////////////////////////////////////////
		
	 	Item[] items1= {new Item("Sele1", 20,150),new Item("Sele2", 40,325),new Item("Sel3",50,600),
					new Item("Sel4",36, 805),new Item("Sel5", 25, 430),new Item("Sel6", 64, 1200),
					new Item("Sel7",54, 770),new Item("Sel8", 18, 60),new Item("Sel9", 46, 930),
					new Item("Sel10", 28,353)}; 
	 	Kanpsack knapsack1 = new Kanpsack(items1, 4200);
		knapsack1.print();
	 	
		
		Solution solution1 = knapsack1.solve();
		solution1.display();
		}
		
	}
			

	
	


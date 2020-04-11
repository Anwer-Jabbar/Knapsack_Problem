package example_knap;

public class Item {
	public String name;
	public int value;
	public int weight;
	// Constructor for all Items
	public Item(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	// method for return all Values
//	public String string() {
//		return name + "[value= " + value +", weight= "+ weight + "]";
//	}
	
	@Override
	public String toString() {
		return "Item [name: " + name + ", value=" + value + ", weight=" + weight + "]";
	}
	
}

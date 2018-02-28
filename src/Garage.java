import java.util.ArrayList;

public class Garage {
	private int size;
	private Spot[] spots;
	String garage;
	
	public Garage(JSObject[] objs, String garage) {
		this.garage = garage;
		this.size = objs.length;
		spots = new Spot[this.size];
		
		for(int i = 0; i < objs.length; i++) {
			spots[i] = new Spot(objs[i]);
		}
	}
	
	public Spot[] getOccupied() {
		ArrayList<Spot> occupied = new ArrayList<Spot>();
		for(int i = 0; i < this.size; i++) {
			if(spots[i].isOccupied()) {
				occupied.add(spots[i]);
			}
		}
		
		return occupied.toArray(new Spot[occupied.size()]);
	}
	
	public int getNumOccupied() {
		return this.getOccupied().length;
	}
	
	public boolean isFull() {
		return this.getNumOccupied() == this.size;
	}
	
	public String toString() {
		String s = "" + this.garage + "\n";
		for(int i = 0; i < spots.length; i++) {
			s += spots[i] + "\n";
		}
		
		return s;
	}
}


public class Spot {
	private boolean occupied;
	private int id;
	
	public Spot(JSObject obj) {
		this.occupied = Boolean.parseBoolean(obj.get("occupied"));
		String name = obj.get("name");
		this.id = Integer.parseInt(name.substring(7, 11));
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		String s = "";
		s += "\tSpotId: " + String.format("%04d", this.id) + "\n";
		s += "\tOccupied: " + this.occupied;
		
		return s;
	}
}

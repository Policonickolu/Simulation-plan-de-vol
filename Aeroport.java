
public class Aeroport {
	
	public final String lieu;
	private final Position position;
	
	public Aeroport(String lieu, double longitude, double latitude){
		
		this.lieu = lieu;
		this.position = new Position(longitude, latitude);
		
	}
	
	public Aeroport(){
		
		this.lieu = "";
		this.position = new Position(0,0);
		
	}
	
	public Position getDuplicatedPosition(){
		
		return position.getDuplicatedPosition();
		
	}
	
	public boolean isAtPosition(Position position){
		
		return this.position.samePositionAs(position);
		
	}
	
	public String toString(){
		
		return "'" + lieu + "'" + position;
		
	}
	
}

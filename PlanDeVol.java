
public class PlanDeVol {
	
	public final Aeroport depart;
	public final Aeroport arrivee;
	public final int nbPassagers;
	private Position position;

	public PlanDeVol(Aeroport aeroportDepart, Aeroport aeroportArrivee, int nbPassagers) {
		
		this.depart = aeroportDepart;
		this.arrivee = aeroportArrivee;
		this.nbPassagers = nbPassagers;
		this.position = depart.getDuplicatedPosition();
		
	}
	
	public int getNbPassagers(){
		
		return nbPassagers;
		
	}
	
	public Position getDuplicatedPosition(){
		
		return position.getDuplicatedPosition();
		
	}
	
	public boolean isAtDestination(){
		
		return arrivee.isAtPosition(position);
		
	}
	
	public boolean isEnVol(){
		
		return !depart.isAtPosition(position);
		
	}	
	
	public boolean faireUnPas() {
		
		position.faireUnPas(arrivee.getDuplicatedPosition());
		return (isAtDestination() ? false : true);
		
	}
	
	public String toString(){
		
		String s;
		if(!isEnVol()) s = "EN ATTENTE DE DECOLLAGE";
		else if(isAtDestination()) s = "ARRIVE A DESTINATION";
		else s = "EN VOL " + position;
		
		return "[Plan de vol de " + depart + " à " + arrivee + " pour " + nbPassagers + " passagers : " + s + "]";
		
	}

}

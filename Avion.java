
public class Avion {
	
	public final String compagnie;
	private PlanDeVol planDeVol;


	public Avion(String avionCompagnie) {
		
		this.compagnie = avionCompagnie;
		
	}

	public void setPlanDeVol(PlanDeVol planDeVol) {
		
		this.planDeVol = planDeVol;
		
	}
	
	public boolean hasPlanDevol(){
		
		return planDeVol != null;
	
	}

	public boolean faireUnPas() {
		
		return planDeVol.faireUnPas();		
		
	}
	
	public String toString(){
		
		return "Avion (" + compagnie + ") => " + planDeVol;
		
	}

}

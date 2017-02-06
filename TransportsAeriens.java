import java.util.ArrayList;
import java.util.Iterator;


public class TransportsAeriens {
	
	private ArrayList<Avion> listeSansPlanDeVol;
	private ArrayList<Avion> listeAvecPlanDeVol;
	
	public TransportsAeriens(){
		
		this.listeSansPlanDeVol = new ArrayList<Avion>();
		this.listeAvecPlanDeVol = new ArrayList<Avion>();
		
	}
	
	public void add(String avionCompagnie){
		
		this.listeSansPlanDeVol.add(new Avion(avionCompagnie));
		
	}
	
	public boolean add(String avionCompagnie, Aeroport aeroportDepart, Aeroport aeroportArrivee, int nbPassagers){
		
		Avion a = new Avion(avionCompagnie);
		a.setPlanDeVol(new PlanDeVol(aeroportDepart, aeroportArrivee, nbPassagers));
		return this.listeAvecPlanDeVol.add(a);
		
	}
	
	public boolean faireUnPas(){
		
		for(int i=0;i<listeAvecPlanDeVol.size();i++){
			Avion a = listeAvecPlanDeVol.get(i);
			if(!a.faireUnPas()){
				listeSansPlanDeVol.add(a);
				listeAvecPlanDeVol.remove(a);
			}
		}
		return !listeAvecPlanDeVol.isEmpty();
		
	}
	
	public String toString(){
		
		String s = ">>> LISTE DES AVIONS SANS PLAN DE VOL :\n[";
		Iterator<Avion> i = this.listeSansPlanDeVol.iterator();
		if(i.hasNext())s += i.next().toString();
		while(i.hasNext()){
			s += "\n, " + i.next().toString();
			
		}
		s += "]\n>>> LISTE DES AVIONS AVEC PLAN DE VOL :\n[";
		i = this.listeAvecPlanDeVol.iterator();		
		if(i.hasNext())s += i.next().toString();
		while(i.hasNext()){
			s += "\n, " + i.next().toString();		
		}
		return s + "\n]";
	}

}

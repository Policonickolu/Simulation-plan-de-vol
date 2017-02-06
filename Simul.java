
public class Simul {
	/** Tableau d'aéroports :
	 *  <pre>
	 *  	Paris			(2°20 E, 48°52 N)		Lille		(3°05 E, 50°39 N)
	 *  	Nice			(7°16 E, 43°42 N)		Rennes		(1°40 W, 48°06 N)
	 *  	Strasbourg		(7°45 E, 48°35 N)
	 *  </pre>
	 */
	public static final Aeroport[] aeroports = {
		new Aeroport("Paris", 2.0 + 20.0/60.0, 48.0 + 52.0/60.0),
		new Aeroport("Lille", 3.0 + 5.0/60.0, 50.0 + 39.0/60.0),
		new Aeroport("Nice", 7.0 + 16.0/60.0, 43.0 + 42.0/60.0),
		new Aeroport("Rennes", -1.0 - 40.0/60.0, 48.0 + 6.0/60.0),
		new Aeroport("Strasbourg", 7.0 + 45.0/60.0, 48.0 + 35.0/60.0) };
	
	public static final String[] compagnies = {
		"Air Mine", "Air Mite", "Air Mione", "Air Rant", "Air Shadock" };
	
	static public void main(String[] args){
		
		TransportsAeriens ta = new TransportsAeriens();
		ta.add(Simul.compagnies[0], Simul.aeroports[0], Simul.aeroports[1], 350);
		ta.add(Simul.compagnies[1], Simul.aeroports[0], Simul.aeroports[2], 250);
		ta.add(Simul.compagnies[2], Simul.aeroports[0], Simul.aeroports[3], 150);
		ta.add(Simul.compagnies[3], Simul.aeroports[0], Simul.aeroports[4], 50);
		ta.add(Simul.compagnies[4], Simul.aeroports[1], Simul.aeroports[4], 0);
		
		System.out.println("******** Etat initial ********");
		System.out.println(ta.toString());
		int pas = 0;
		while(ta.faireUnPas()){
			System.out.println("******** Pas numéro " + (++pas) + " ********");
			System.out.println(ta.toString());
		}
		System.out.println("******** Etat final ********");
		System.out.println(ta.toString());
		
	}
	
}

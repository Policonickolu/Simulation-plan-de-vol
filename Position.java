
public class Position {
	
	/** La longitude est une mesure angulaire sur 360° par rapport à un méridien de référence,
	 * avec une étendue de -180° (vers l'Ouest) à +180° (vers l'Est).
	 * La longitude de référence sur Terre (0°) est le méridien de Greenwich. */
	private double longitude;
	/** La latitude (géocentrique) est l'angle que fait une droite menée du centre de la Terre
	 * avec le plan équatorial, son étendue est de -90° (vers le Sud) à +90° (vers le Nord). */
	private double latitude;
	
	public Position(double longitude, double latitude){
		
		this.longitude = longitude;
		this.latitude = latitude;
		
	}
	
	private Position(Position position){
		
		this.longitude = position.longitude;
		this.latitude = position.latitude;
		
	}
	
	public Position getDuplicatedPosition(){
		
		return new Position(this);
		
	}
	
	public double getLongitude(){
		
		return longitude;
		
	}
	
	public double getLatitude(){
		
		return latitude;
		
	}
	
	public boolean samePositionAs(Position p){
		
		return this.longitude == p.longitude && this.latitude == p.latitude;
		
	}
	
	public boolean faireUnPas(Position versPosition){
		
		double longi = 180 + longitude;
		double lati = 90 + latitude;
		
		double versLongi = 180 + versPosition.longitude;
		double versLati = 90 + versPosition.latitude;
		
		double progrLongi = versLongi - longi;
		double progrLati = versLati - lati;
		
		if(Math.abs(progrLongi) < 1.0 && Math.abs(progrLati) < 1.0){
			this.longitude = versPosition.longitude;
			this.latitude = versPosition.latitude;
			return false;
		}
		else{
			double destinationLongi = versPosition.longitude + (longitude*-1);
			double destinationLati = versPosition.latitude + (latitude*-1);
	
			if(destinationLongi > 180){
				destinationLongi = -180 + (destinationLongi - 180);
			}
			if(destinationLongi < -180){
				destinationLongi = 180 + (destinationLongi + 180);
			}
			if(destinationLati > 90){
				destinationLati = 90 - (destinationLati - 90);
			}
			if(destinationLati < -90){
				destinationLati = -90 - (destinationLati + 90);
			}			
			
			longitude += Math.signum(destinationLongi);
			latitude += Math.signum(destinationLati);

			return true;
		}
		
	}

	public String toString(){
		String longi = (longitude < 0 ? "W" : "E");
		String lati = (latitude < 0 ? "S" : "N");

		String strLongi = "" + Math.abs(longitude);
		String strLati = "" + Math.abs(latitude);
		
		int indLongi = strLongi.indexOf('.');
		int indLati = strLati.indexOf('.');
		
		if (indLongi != -1 && indLongi < strLongi.length() - 2) strLongi = strLongi.substring(0, indLongi + 3);
		if (indLati != -1 && indLati < strLati.length() - 2) strLati = strLati.substring(0, indLati + 3);
		
		return "("+strLongi+longi+","+strLati+lati+")";


	}
	
}

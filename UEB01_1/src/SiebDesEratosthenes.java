public class SiebDesEratosthenes {

	private boolean[] field; 
	
	/**
	 * Konstruktor
	 * @param _size Obergrenze
	 */
	public SiebDesEratosthenes(int _size)
	{
		field = new boolean[_size];
		for(int i=0; i<field.length; i++)
			field[i] = true;		
	}
	
	/**
	 * Berechnung der Primzahlen
	 */
	public void doPrim()
	{
		field[0] = false;									// Schritt 1
		int prim = 0;
		do{													// Schritt 3
			prim = pickNextPrim(prim);						// Schritt 2
			int hit= prim + prim;
			do{
				field[hit-1] = false;
				hit = hit + prim;
			
			}while(hit<=field.length);
		}while(prim*prim<field.length-1);
	}
	
	/**
	 * gibt die nächste Primzahl des Feldes zurück
	 * @param _start aktuelle Primzahl
	 * @return Primzahl
	 */
	public int pickNextPrim(int _start)
	{
		int prim = 0;
		for(int i=_start; i<field.length;i++){
			if(field[i] == true){
				prim = i+1;
				break;
			}
		}
		return prim;
	}
	
	/**
	 * Umwandlung des Feldes in Primzahlen
	 * @return Primzahlen 
	 */
	public String toString()
	{
		String sPrim = "";
		for(int i=0; i<field.length; i++)
			if(field[i] == true)
			{
				sPrim = sPrim + (i+1) + ", ";
			}
		return sPrim;
	}
}

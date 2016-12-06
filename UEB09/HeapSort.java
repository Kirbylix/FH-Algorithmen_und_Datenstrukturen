public class HeapSort
{
	/**
	 * Element im Baum versickern
	 * @param zahlen Array
	 * @param knoten das zu versickernde Element
	 * @param anzahl die letzte stellen im Baum die beachtet wird
	 */
	public static void versickern(int[] zahlen, int knoten, int anzahl)
	{		
		while(knoten <= (anzahl/2) -1){
			int kI = ((knoten+1) *2) -1;			// Index des linken Kindes
			
			if(kI + 1 <= anzahl -1){				// existiert ein rechtes Kind
				if(zahlen[kI] < zahlen[kI+1]){		// wenn rechtes Kind größer ist nehme das
					kI++;
				}
			}
			
			if(zahlen[knoten] < zahlen[kI]){		// muss das Element sinken ?
				swap(zahlen, knoten, kI);			// Element versenken
				knoten = kI;						// wiederhole das mit der neuen Position
			}else break;
		}
	}
	
	/**
	 * Vertauschen der zahlen
	 * @param zahlen Array
	 * @param a Position der 1ten Zahl
	 * @param b Position der 2ten Zahl
	 */
	public static void swap(int[] zahlen, int a, int b){
		int tmp = zahlen[a];
		zahlen[a] = zahlen[b];
		zahlen[b] = tmp;
	}

	/**
	 * Heapsort
	 * @param zahlen Array
	 */
	public static void heapsort(int[] zahlen)
	{
		//erste Phase: Umwandlung in einen Heap
		for(int i= (zahlen.length/2)-1; i>=0; i--){
			versickern(zahlen, i, zahlen.length);
		}
		
		//zweite Phase: sortierung nach Heapsort
		for(int i = zahlen.length-1; i>0; i--){
			swap(zahlen, 0, i);
			versickern(zahlen,0, i);
		}
	}

	public static void main(String[] args)
	{
		for (int a=0; a<20; a++)
		{
			// Anzahl für diesen Durchlauf ermitteln
			int[] zahlen = new int[(int)(Math.random()*20+10)];

			// Array mit Zufallszahlen erzeugen
			for (int b=0; b<zahlen.length; b++)
				zahlen[b] = (int)(Math.random()*1000);

			// Sortieren
			heapsort(zahlen);

			// Sortiertes Array ausgeben und die Sortierung prüfen
			boolean sortiert = true;
			for (int b=0; b<zahlen.length; b++)
			{
				System.out.print(zahlen[b] + " ");

				if (b>0)
					sortiert &= zahlen[b] >= zahlen[b-1];
			}

			System.out.println(sortiert ? "OK" : "FEHLER");
		}
	}
}
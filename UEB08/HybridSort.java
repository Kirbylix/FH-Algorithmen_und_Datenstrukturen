public class HybridSort
{
	public static void bubblesort(int[] zahlen, int links, int rechts)
	{
		int puffer;
		for(int i = links; i< rechts; i++){
			for(int j = rechts; j > i; j--){
				if(zahlen[j] < zahlen[j-1]){
					puffer = zahlen[j];
					zahlen[j] = zahlen[j-1];
					zahlen[j-1] = puffer;
				}
			}
		}
	}

	public static void quicksort(int[] zahlen, int links, int rechts)
	{
		int li = links;
		int re = rechts; 
		int pivot = zahlen[(links + rechts) / 2];
		while(li <= re){
			while(zahlen[li] < pivot){
				li++;;
			}
			while(zahlen[re] > pivot){
				re--;
			}
			if(li <= re){
				int puffer = zahlen[li];
				zahlen[li] = zahlen[re];
				zahlen[re] = puffer;
				li++;
				re--;
			}
		}
		if(links < re){
			if((re-links) <= 4){
				bubblesort(zahlen, links, re);
			}else{
				quicksort(zahlen, links, re);
			}
		}
		if(rechts > li){
			if((rechts-li) <= 4){
				bubblesort(zahlen, li, rechts);
			}else{
				quicksort(zahlen, li, rechts);
			}
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
			quicksort(zahlen, 0, zahlen.length-1);

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
import java.util.Collections;


public class main {

	public static void main(String[] args) {
		
		String fail = "samsusdgas";
		String[] worte = {	"android",
							"samsung",
							"acer",
							"philips",
							"logitech",
							"google",
							"mars",
							"essen",
							"trinken",
							"hallo"};
		
		//Wörter sortieren
		heapsort(worte);
		//Wörter ausgeben
		for(int i = 0; i<worte.length; i++){
			System.out.print(worte[i] + ", ");
		}
		System.out.print("\n");
		
		//enthaltende Wörter
		for(int i = 0; i<worte.length; i++){
			if(binaereSuche(worte, worte[i]) == true){
				System.out.println(worte[i] + " - Wort gefunden");
			}else{
				System.err.println(worte[i] + " - Wort nicht gefunden");
			}
		}
		//nicht enthaltendes Wort
		if(binaereSuche(worte, fail) == true){
			System.out.println(fail + " - Wort gefunden");
		}else{
			System.err.println(fail + " - Wort nicht gefunden");
		}
	}
	
	static boolean binaereSuche(String[] worte, String begriff){
				
		int start = 0;
		int ende = worte.length-1;
		int mitte;
		while(start <= ende){
			mitte = start + ((ende - start)/2);
			if(worte[mitte].compareTo(begriff) > 0){		// -> linker Abschnitt
				ende = mitte-1;
			}else if(worte[mitte].compareTo(begriff) < 0){	// -> rechter Abschnitt
				start = mitte + 1;
			}else{
				return true;
			}
		}
		return false;
	}
	
	public static void heapsort(String[] worte)
	{
		for(int i= (worte.length/2)-1; i>=0; i--){
			versickern(worte, i, worte.length);
		}
		for(int i = worte.length-1; i>0; i--){
			swap(worte, 0, i);
			versickern(worte,0, i);
		}
	}
	
	public static void versickern(String[] worte, int knoten, int anzahl)
	{		
		while(knoten <= (anzahl/2) -1){
			int kI = ((knoten+1) *2) -1;			// Index des linken Kindes
			
			if(kI + 1 <= anzahl -1){				// existiert ein rechtes Kind
				if(worte[kI].compareTo(worte[kI+1]) < 0){		// wenn rechtes Kind gr��er ist nehme das
					kI++;
				}
			}		
			if(worte[knoten].compareTo(worte[kI]) < 0){		// muss das Element sinken ?
				swap(worte, knoten, kI);			// Element versenken
				knoten = kI;						// wiederhole das mit der neuen Position
			}else break;
		}
	}
	
	public static void swap(String[] worte, int a, int b){
		String tmp = worte[a];
		worte[a] = worte[b];
		worte[b] = tmp;
	}
}
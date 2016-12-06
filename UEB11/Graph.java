import java.util.*;

class Graph
{
	private static final int KNOTENZAHL = 6;
	private static boolean[] besucht;
	private static KnotenTyp[] knoten;
	private static boolean[][] matrix= {
			{false, true, false, false, false, false},
			{false, false, true, true, false, false},
			{false, true, false, true, false, false},
			{false, true, true, false, false, false},
			{false, false, false, false, true, false},
			{false, false, false, false, false, true},
		};

	Graph()
	{
		knoten  = new KnotenTyp[KNOTENZAHL];
		knoten[0] = new KnotenTyp("A");
		knoten[1] = new KnotenTyp("B");
		knoten[2] = new KnotenTyp("C");
		knoten[3] = new KnotenTyp("D");
		knoten[4] = new KnotenTyp("E");
		knoten[5] = new KnotenTyp("F");
	}
	
	public static void main(String[] args)
	{
		new Graph().Zusammenhangskomponenten();
	}

	static boolean isKante(int k1, int k2)
	{
		return matrix[k1][k2];
	}

	// Tiefensuche
	void Zusammenhangskomponenten()
	{
		besucht = new boolean [KNOTENZAHL];
		System.out.println("Rekrusiv: ");
		for(int a=0;a<KNOTENZAHL; a++){	
			if (!besucht[a]) {
				rekDfs(a);
				System.out.println();
			}
		}
		
		// Zur�cksetzten
		for(int q=0;q<KNOTENZAHL; q++)
			besucht[q] = false;	

		System.out.println("\nIterativ: ");
		for(int a=0;a<KNOTENZAHL; a++){		
			if (!besucht[a]) {
				dfsIterativ(a);
			}
		}
	}

	public static void rekDfs(int node){
			besucht[node] = true;
			System.out.print(knoten[node].getName() + ", ");
			int nachfolger=next(node);
			
			while(nachfolger < KNOTENZAHL){
				if(besucht[nachfolger] == false){
					rekDfs(nachfolger);
				}
				nachfolger=next(node);
			}
	}	
	
	public void dfsIterativ(int node){
		int nachfolger = 0;
		Stack<KnotenTyp> s = new Stack<KnotenTyp>();
		KnotenTyp k;

		s.push(knoten[node]);
		while (!s.isEmpty()) {
			k = s.pop();
			System.out.print(k.getName() + ", ");

			if (!besucht[node]) {
				besucht[node] = true;
				nachfolger = next(node);

				while (nachfolger < KNOTENZAHL) {

					if (!besucht[nachfolger]) {
						besucht[nachfolger] = true;
						s.push(knoten[nachfolger]);
					}
					nachfolger = next(nachfolger);
				}

			}
		}
		System.out.print("\n");
	}

	
	//public static int next(int knoten, int current){
	public static int next(int knoten){
		for(int tmp = 0; tmp < KNOTENZAHL; tmp++){
			if(isKante(knoten, tmp) && !besucht[tmp]){
				return tmp;
			}
		}
		return KNOTENZAHL;
	}
}
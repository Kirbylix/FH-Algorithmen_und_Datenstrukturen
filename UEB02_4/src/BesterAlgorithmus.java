import java.lang.Math;

public class BesterAlgorithmus
{
	// Gibt f�r jede Zahl n zwischen 1 und 2000 aus, welcher der
	// 6 Algorithmen (A1 .. A6) f�r das betrachtete n der Beste ist
	public static void main(String[] args)
	{
		for(int n=1; n<2000; n++)
		{
			System.out.println("Gewinner: g" + gewinnerFuerN(n) + " fuer n=" + n);
		}
	}
		
	// 1000n
	public static double g1(int n)
	{
		return 1000*n;
	}

	// 100n * log2(n+1)
	public static double g2(int n)
	{
		return 100*n*(Math.log(n+1)/Math.log(2));
	}

	// 10 * n * n
	public static double g3(int n)
	{
		return 10 * n * n;
	}

	// n * n * n
	public static double g4(int n)
	{
		return n * n * n;
	}

	// 2 hoch n
	public static double g5(int n)
	{
		return Math.pow(2, n);
	}

	// n!
	public static double g6(int n)
	{
		double fak=1;
		if(n==0)
			return fak;
		else{
			for (int i = 1; i <= n; i++) {
				fak = fak * i;
			}
	    }
        return fak;
	}

	// Bestimmt fuer alle 6 Funktionen den Wert von
	// gi(n) und gibt den Index der Funktion mit
	// dem minimalen Wert zurueck
	public static int gewinnerFuerN(int n)
	{
		int winner=0;
		double[] field = new double[6];
		field[0] = g1(n);
		field[1] = g2(n);
		field[2] = g3(n);
		field[3] = g4(n);
		field[4] = g5(n);
		field[5] = g6(n);
		
		double min = field[0];
		for(int i=1; i<field.length; i++){
			if(field[i]<min){
				min=field[i];
				winner=i;
			}
		}
		return winner+1;
	}
}
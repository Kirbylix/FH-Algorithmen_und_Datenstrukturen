
public class main {

	public static void main(String[] args) {
		StopUhr su = new StopUhr();
		int anzahl = 50;
		long fib = 0;
		for(int i=0; i<=anzahl;i++){
			su.start();
			fib = fibRekursiv(i,1,0);
			su.stop();
			System.out.println(i + "te Fiabonacci = " + fib + ", Dauer: " + su.getDuration());
		}
	}
	
	public static long fibRekursiv(int grenze, long fib1, long fib2) 
	{ 
	 if (grenze == 0) 
	  return fib2; 
	 return fibRekursiv(grenze - 1, fib2, fib1 + fib2);
	}
}

/*
	geht die Berechnung der Reihe nach durch, eine nach der anderen 
	d.h. 1 Methodenaufruf ruft nur 1 weitere Methode auf
	Laufzwitverhalten: die Dauer wird wird jeweils nur um die Dauer 1er weiteren Methoden-
	Dauer erhöht
	Terminiert: beendet wird es wenn die Grenze 0 erreicht hat
*/
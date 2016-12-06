public class main {

	public static void main(String[] args) {
		StopUhr su = new StopUhr();
		int anzahl = 50;
		
		//Fibonacci-Zahlen Rekursiv
		System.out.println("Rekursiv:");
		su.start();
	    for(int i = 0; i<anzahl;i++){
	    	System.out.print(fibRek(i) + ", ");
	    }
	    su.stop();
	    System.out.println();
	    long rekDauer = su.getDuration();
		
		
		//Fibonacci-Zahlen Iterativ
		su.start();
		for(int i = 0; i<anzahl;i++){
	    	System.out.print(fibIter(i) + ", ");
	    }
		su.stop();
		System.out.println();
		long IterDauer = su.getDuration();
		System.out.println("Rekursiv-Dauer: " + rekDauer);
		System.out.println("Iterativ-Dauer: " + IterDauer);
		compare(rekDauer, IterDauer);
		
		
	}
	
	public static long fibRek(int n){
		if(n==0){
			return 0;
		}else if(n==1)
			return 1;
		else{
			return fibRek(n-2) + fibRek(n-1);
		}
	}
	
	public static long fibIter(int n){
		long fib = 0;
		if(n==0){
			fib = 0;
		}else if(n==1)
			fib = 1;
		else{
			long buffer = 0;
			fib = 0;
			for (int i = 2; i<= n; i++)
			{
				long buffer2 = buffer + fib;
				buffer = fib;
				fib = buffer2;
			}
		}
		return fib;
	}
	
	public static void compare(long tRek, long tIter){
		if(tRek<tIter){
			System.out.println("Rekursiv hat gewonnen");
		}else{
			System.out.println("Iterativ hat gewonnen"); 
		}
	}

}


public class main {

	public static void main(String[] args) {
		
		StopUhr su = new StopUhr();
		Zeitmessung z = new Zeitmessung();
		
		int[] n = new int[4];
		n[0] = 1000;
		n[1] = 10000;
		n[2] = 100000;
		n[3] = 1000000;
		
		//fun1
		for(int i=0; i<n.length; i++){
			su.start();
			z.func1(n[i]);
			su.stop();
			System.out.println("Func1 mit n=" + n[i] + " => " + su.getDuration());
		}
		
		//fun2
		for(int i=0; i<n.length; i++){
			su.start();
			z.func2(n[i]);
			su.stop();
			System.out.println("Func2 mit n=" + n[i] + " => " + su.getDuration());
		}

		//fun6
		for(int i=0; i<n.length; i++){
			su.start();
			z.func6(n[i]);
			su.stop();
			System.out.println("Func6 mit n=" + n[i] + " => " + su.getDuration());
		}

	}

}

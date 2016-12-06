import java.util.Scanner;


public class main {

	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.print("Eingabe der Obergrenze: ");
		int i = sc.nextInt();
		
		SiebDesEratosthenes SeD = new SiebDesEratosthenes(i);
		SeD.doPrim();
		System.out.println("Primzahlen: " + SeD.toString());
	}
}
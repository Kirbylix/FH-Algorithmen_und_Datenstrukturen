public class BucketSortTest
{
	public static void main(String[] args)
	{
		Klausur[] k = new Klausur[10];
		k[0] = new Klausur("Duck", "Trick", 7034343, Klausur.PI);
		k[1] = new Klausur("Koll", "Konstantin", 7044005, Klausur.TI);
		k[2] = new Klausur("Duck", "Dagobert", 7095453, Klausur.SWTDUAL);
		k[3] = new Klausur("Panzerknacker", "2", 7176617, Klausur.WI);
		k[4] = new Klausur("Panzerknacker", "4", 7176167, Klausur.WI);
		k[5] = new Klausur("Duck", "Tick", 7034342, Klausur.PI);
		k[6] = new Klausur("Panzerknacker", "3", 7176716, Klausur.WI);
		k[7] = new Klausur("Duck", "Daisy", 7084563, Klausur.MI);
		k[8] = new Klausur("Duck", "Track", 7034344, Klausur.PI);
		k[9] = new Klausur("Panzerknacker", "1", 7176176, Klausur.WI);

		BucketSort bs = new BucketSort(5);

		for (int a = 0; a < k.length; a++)
			bs.addToBucket(k[a], k[a].getStudiengang());

		for (int a = 0; a < 5; a++)
			bs.printBucket(a);
	}
}
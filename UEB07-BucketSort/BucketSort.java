public class BucketSort
{
	private Linkable[] buckets;

	public BucketSort(int count)
	{
		this.buckets = new Linkable[count];
	}

	public void addToBucket(Linkable item, int bucket)
	{
		assert(bucket >= 0);
		assert(bucket < buckets.length);
		
		item.setNext(buckets[bucket]);
		buckets[bucket] = item;
	}

	public void printBucket(int bucket)
	{
		assert(bucket >= 0);
		assert(bucket < buckets.length);

		for (Linkable out = this.buckets[bucket]; out != null; out = out.getNext())
		      System.out.println(out.toString());

		System.out.println();
	}
}
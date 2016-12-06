public class Klausur implements Linkable
{
	public static byte MI = 0;
	public static byte PI = 1;
	public static byte SWTDUAL = 2;
	public static byte TI =3;
	public static byte WI = 4;

	private Linkable next;

	private String name;
	private String vorname;
	private int matrikelnummer;
	private byte studiengang;

	public Klausur(String name, String vorname, int matrikelnummer, byte studiengang)
	{
		this.name = name;
		this.vorname = vorname;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
	}

	public Linkable getNext()
	{
		return next;
	}

	public void setNext(Linkable next)
	{
		this.next = next;
	}

	public byte getStudiengang()
	{
		return studiengang;
	}

	public String toString()
	{
		assert(studiengang >= 0);
		assert(studiengang < 5);

		String[] sg = { "MI", "PI", "SWT dual", "TI", "WI" };

		return name + ", " + vorname + " (" + matrikelnummer + " " + sg[studiengang] + ")";
	}
}
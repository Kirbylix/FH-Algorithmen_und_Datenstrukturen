public class BaumTraversieren
{
	private Baum einBaum;

	public BaumTraversieren(Baum einBaum)
	{
		this.einBaum = einBaum;
	}

	// Pre-Order
	public String traversierePreOrder()
	{
		return (einBaum.getWurzel() != null) ? traversierePreOrder(einBaum.getWurzel()) : "Der Baum ist leer.";
	}

	private String traversierePreOrder(Knoten einKnoten)
	{
		//aktueller Knoten
		String baum = einKnoten.getDaten().toString();
		//Linker Knoten
		if(einKnoten.getKnotenLinks() != null){
			baum = baum + ", " + traversierePreOrder(einKnoten.getKnotenLinks());
		} 
		//Rechter Knoten
		if(einKnoten.getKnotenRechts() != null){
			baum = baum + ", "  + traversierePreOrder(einKnoten.getKnotenRechts());
		}
		return baum;
	}


	// In-Order
	public String traversiereInOrder()
	{
		return (einBaum.getWurzel() != null) ? traversiereInOrder(einBaum.getWurzel()) : "Der Baum ist leer.";
	}

	private String traversiereInOrder(Knoten einKnoten)
	{
		String baum = "";
		//Linker Knoten
		if(einKnoten.getKnotenLinks() != null){
			baum =  traversiereInOrder(einKnoten.getKnotenLinks());
		}
		//aktueller Knoten
		baum = baum + einKnoten.getDaten().toString() + ", " ;
		//Rechter Knoten
		if(einKnoten.getKnotenRechts() != null){
			baum =  baum + traversiereInOrder(einKnoten.getKnotenRechts());
		}
		return baum;
	}


	// Post-Order
	public String traversierePostOrder()
	{
		return (einBaum.getWurzel() != null) ? traversierePostOrder(einBaum.getWurzel()) : "Der Baum ist leer.";
	}

	private String traversierePostOrder(Knoten einKnoten)
	{
		String baum = "";
		//Linker Knoten
		if(einKnoten.getKnotenLinks() != null){
			baum =  traversierePostOrder(einKnoten.getKnotenLinks());
		}
		//Rechter Knoten
		if(einKnoten.getKnotenRechts() != null){
			baum =  baum + traversierePostOrder(einKnoten.getKnotenRechts()) ;
		}
		//aktueller Knoten
		baum = baum + einKnoten.getDaten().toString() + ", "  ;
		return baum;
	}
}
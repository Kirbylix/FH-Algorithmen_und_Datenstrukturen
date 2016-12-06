import java.util.*;

public class BaumTraversieren
{
	private AVLBaum einBaum;

	public BaumTraversieren(AVLBaum einBaum)
	{
		this.einBaum = einBaum;
	}

	// Pre-Order
	public String traversierePreOrder()
	{
		if (einBaum.getWurzel() == null)
			return "Der Baum ist leer.";

		// Diese Methode wird im Praktikum implementiert
		// TODO

		return "NOCH NICHT IMPLEMENTIERT";
	}
}
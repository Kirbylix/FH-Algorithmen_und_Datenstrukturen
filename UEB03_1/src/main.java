
public class main {

	public static void main(String[] args) {
		
		//Aufgabe 1
		Link nachfolger = new Link("Letzter", null);
		Link aktuellesElement = new Link("Test", nachfolger);
		Link anfang = new Link("Erster", aktuellesElement);		
		
		//Aufgabe 2
		Liste eineListe = new Liste();
		
		eineListe.anfuegenElement("Pascal");
		eineListe.einfuegenElement("Java");
		String s = (String)eineListe.entfernenElement();

	}

}

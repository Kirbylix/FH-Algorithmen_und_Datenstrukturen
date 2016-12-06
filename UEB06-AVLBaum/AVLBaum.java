public class AVLBaum<T extends Comparable<T>>
{
	private AVLKnoten<T> wurzel;
	private boolean hoeheGeaendert;

	// Wird nur für grafische Oberfläche benötigt, ohne
	// diese Methode könnte die gesamte Implementierung
	// des Baumes geheim gehalten werden. Alle öffentlichen
	// Methoden sind parameterlos oder besitzen als
	// einzigen Parameter einen Schlüsselwert
	public AVLKnoten<T> getWurzel()
	{
		return wurzel;
	}

	public boolean istLeer()
	{
		return (wurzel == null);
	}

	public void setHoeheGeaendert(boolean hoeheGeaendert)
	{
		this.hoeheGeaendert = hoeheGeaendert;
	}


// Methoden zum Suchen

	public boolean suchen(T daten)
	{
		
		if(this.wurzel == null)
			return false;
		
		AVLKnoten knoten = wurzel;
		int comp = wurzel.getDaten().compareTo(daten);
		
		do{
			System.out.println("Comp: " + comp);
			if(comp < 0){ // nach rechts			
				if(knoten.getKnotenRechts() != null){
					knoten = knoten.getKnotenRechts();
				}else{return false;}
			}else if(comp > 0 && knoten.getKnotenLinks() != null){ // nach links
				if(knoten.getKnotenLinks() != null){
				knoten = knoten.getKnotenLinks();
				}else{return false;}
			}
			comp =  ((Comparable<T>) knoten.getDaten()).compareTo(daten);
		}while(comp<0 || comp>0);
		
		if(comp == 0){
			System.out.println("Gefunden");
			return true;
		}
		return false;
	}


// Methoden zum Einfügen

	public void einfuegen(T daten)
	{
		// Beim Einfügen wird der Baum neu zusammengesetzt, um Rotationen
		// zu ermöglichen. Daher tritt hier kein Sonderfall auf, aber die
		// Wurzel muss neu zugewiesen werden.
		wurzel = einfuegenKnoten(daten, wurzel);
	}

	private AVLKnoten<T> einfuegenKnoten(T daten, AVLKnoten<T> teilbaum)
	{
		if (teilbaum == null)
		{
			hoeheGeaendert = true;
			return new AVLKnoten<T>(daten, null, null);
		}

		// Vergleichs-Ergebnis zwischenspeichern, da compareTo()
		// aufwändig sein kann, und das Ergebnis mehrfach benötigt
		// wird
		int cmp = daten.compareTo(teilbaum.getDaten());

		if (cmp < 0)
		{
			// Einzufügende Daten sind KLEINER als Daten im aktuellen Knoten
			// und müssen daher im LINKEN Teilbaum eingefügt werden
			teilbaum.setKnotenLinks(einfuegenKnoten(daten, teilbaum.getKnotenLinks()));
			if (hoeheGeaendert)
				teilbaum = linksAusgleich(teilbaum);
		}
		else
			if (cmp > 0)
			{
				// Einzufügende Daten sind GROESSER als Daten im aktuellen Knoten
				// und müssen daher im RECHTEN Teilbaum eingefügt werden
				teilbaum.setKnotenRechts(einfuegenKnoten(daten, teilbaum.getKnotenRechts()));
				if (hoeheGeaendert)
					teilbaum = rechtsAusgleich(teilbaum);
			}

		return teilbaum;
	}

	private AVLKnoten<T> linksAusgleich(AVLKnoten<T> w)
	{
		AVLKnoten<T> p;

		switch (w.getBalance())
		{
			case +1:
			{
				w.setBalance(0);				// Der mit w beginnende Teilbaum ist jetzt balanciert
				hoeheGeaendert = false;
				break;
			}

			case 0:								// Der mit w beginnende Teilbaum ist jetzt linkslastig
			{
				w.setBalance(-1);
				break;
			}

			case -1:							// Ausgleich notwendig
			{
				p = w.getKnotenLinks();

				if (p.getBalance() == -1)		// Fall 1
				{
					w = rechtsRotation(w,p);
				}
				else
					if (p.getBalance() == +1)	// Fälle 2a und 2b
					{
						w = lrDoppelRotation(w,p);
						w.setBalance(0);
					}

				w.setBalance(0);
				hoeheGeaendert = false;
			}
		}

		return w;
	}

	private AVLKnoten<T> rechtsAusgleich(AVLKnoten<T> w)
	{
		AVLKnoten<T> p;

		switch (w.getBalance())
		{
			case -1:
			{
				w.setBalance(0);				// Der mit w beginnende Teilbaum ist jetzt balanciert
				hoeheGeaendert = false;
				break;
			}

			case 0:								// Der mit w beginnende Teilbaum ist jetzt rechtslastig
			{
				w.setBalance(+1);
				break;
			}

			case +1:							// Ausgleich notwendig
			{
				p = w.getKnotenRechts();

				if (p.getBalance() == +1)		// Fall 1
				{
					w = linksRotation(w,p);
				}
				else
					if (p.getBalance() == -1)	// Fälle 2a und 2b
					{
						w = rlDoppelRotation(w,p);
					}

				w.setBalance(0);
				hoeheGeaendert = false;
			}
		}

		return w;
	}

	private AVLKnoten<T> rechtsRotation(AVLKnoten<T> w, AVLKnoten<T> p)
	{
		w.setKnotenLinks(p.getKnotenRechts());
		p.setKnotenRechts(w);
		w.setBalance(0);

		return p;
	}

	private AVLKnoten<T> lrDoppelRotation(AVLKnoten<T> w, AVLKnoten<T> p)
	{
		AVLKnoten<T> q = p.getKnotenRechts();
		p.setKnotenRechts(q.getKnotenLinks());
		q.setKnotenLinks(p);
		w.setKnotenLinks(q.getKnotenRechts());
		q.setKnotenRechts(w);

		switch (q.getBalance())
		{
			case -1:
			{
				w.setBalance(+1);
				p.setBalance(0);
				break;
			}
			case +1:							// Fall 2b
			{
				w.setBalance(0);
				p.setBalance(-1);
				break;
			}
			case 0:								// Fall q wird eingefügt
			{
				w.setBalance(0);
				p.setBalance(0);
			}
		}

		return q;
	}

	private AVLKnoten<T> linksRotation(AVLKnoten<T> w, AVLKnoten<T> p)
	{
		w.setKnotenRechts(p.getKnotenLinks());
		p.setKnotenLinks(w);
		w.setBalance(0);

		return p;
	}

	private AVLKnoten<T> rlDoppelRotation(AVLKnoten<T> w, AVLKnoten<T> p)
	{
		AVLKnoten<T> q = p.getKnotenLinks();
		p.setKnotenLinks(q.getKnotenRechts());
		q.setKnotenRechts(p);
		w.setKnotenRechts(q.getKnotenLinks());
		q.setKnotenLinks(w);

		switch (q.getBalance())
		{
			case +1:
			{
				w.setBalance(-1);
				p.setBalance(0);
				break;
			}
			case -1:							// Fall 2b
			{
				w.setBalance(0);
				p.setBalance(+1);
				break;
			}
			case 0:								// Fall q wird eingefügt
			{
				w.setBalance(0);
				p.setBalance(0);
			}
		}

		return q;
	}
}
import java.util.ArrayList;

public class ArbreRecherche {
	private ArrayList<Objet> liste;
	private ArbreRecherche BrancheGauche; // On ajoute pas l'objet i
	private ArbreRecherche BrancheDroite; // On ajoute l'objet i
	private boolean impossible; // Le noeud est trop lourd pour le sac
	private static float BorneInferieure;

	public ArbreRecherche() {
		liste = new ArrayList<>();
		BrancheGauche = null;
		BrancheDroite = null;
	}

	public void ajouter(Objet o, float poidsMax) {
		if (impossible)
			return;
		if (BrancheGauche == null && BrancheDroite == null) {
			BrancheGauche = new ArbreRecherche();
			BrancheDroite = new ArbreRecherche();
			BrancheGauche.liste.addAll(liste);
			BrancheDroite.liste.addAll(liste);
			BrancheDroite.liste.add(o);
			float poidsD = 0f;
			for (Objet ob : BrancheDroite.liste)
				poidsD += ob.getPoids();
			if (poidsD > poidsMax)
				BrancheDroite.impossible = true;
			float poidsG = 0f;
			for (Objet ob : BrancheGauche.liste)
				poidsG += ob.getPoids();
			if (poidsG > poidsMax)
				BrancheGauche.impossible = true;
		} else {
			BrancheDroite.ajouter(o, poidsMax);
			BrancheGauche.ajouter(o, poidsMax);
		}
	}

	public static void setBorneInferieure(float borneInferieure) {
		BorneInferieure = borneInferieure;
	}

	public String toString() {
		String s = "";
		if (BrancheGauche != null)
			s += BrancheGauche.toString();
		s += (liste.toString() + " ");
		if (BrancheDroite != null)
			s += BrancheDroite.toString();
		return s;
	}

	public ArrayList<Objet> rechercheListe(int indiceListe, ListeDesObjets l, SacADos sac) {
		++indiceListe;
		float valeurObj = 0f;
		for (int i = 0; i < this.liste.size(); ++i)
			valeurObj += this.liste.get(i).getValeur();
		if (BorneInferieure < valeurObj)
			BorneInferieure = valeurObj;
		float BorneSuperieure = valeurObj;
		for (int i = indiceListe; i < l.getTailleListe(); ++i)
			BorneSuperieure += l.getListeDesObjets().get(i).getValeur();
		if (BorneSuperieure < BorneInferieure)
			return this.liste;
		if (BrancheGauche == null && BrancheDroite == null)
			return this.liste;
		else {
			if (BrancheGauche.impossible && BrancheDroite.impossible)
				return this.liste;
			else if (BrancheGauche.impossible) {
				ArrayList<Objet> liste1 = BrancheDroite.rechercheListe(indiceListe, l, sac);
				float valeurListe1 = 0f;
				for(int i=0; i<liste1.size();++i)
					valeurListe1 += liste1.get(i).getValeur();
				if(valeurListe1>valeurObj)
					return liste1;
				else
					return this.liste;
			}
			else if (BrancheDroite.impossible) {
				ArrayList<Objet> liste1 = BrancheGauche.rechercheListe(indiceListe, l, sac);
				float valeurListe1 = 0f;
				for(int i=0; i<liste1.size();++i)
					valeurListe1 += liste1.get(i).getValeur();
				if(valeurListe1>valeurObj)
					return liste1;
				else
					return this.liste;
			}
			else {
				ArrayList<Objet> liste1 = BrancheGauche.rechercheListe(indiceListe, l, sac);
				ArrayList<Objet> liste2 = BrancheDroite.rechercheListe(indiceListe, l, sac);
				
				float valeurListe1 = 0f;
				for(int i=0; i<liste1.size();++i)
					valeurListe1 += liste1.get(i).getValeur();
				
				float valeurListe2 = 0f;
				for(int i=0; i<liste2.size();++i)
					valeurListe2 += liste2.get(i).getValeur();
				
				if(valeurListe1>valeurListe2)
					return liste1;
				else
					return liste2;
			}
		}
	}
}

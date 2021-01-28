import java.util.ArrayList;

public class ResolutionPSE {

	public static void Resolution(SacADos sac, ListeDesObjets liste){
		ArbreRecherche a = new ArbreRecherche();
		ResolutionApprochee.Resolution(sac, liste);
		float BorneInferieure = sac.getScore();
		sac.viderSac();
		for(int i = 0; i<liste.getTailleListe();++i) 
			a.ajouter(liste.getListeDesObjets().get(i), sac.getPoidsMaximum());
		ArbreRecherche.setBorneInferieure(BorneInferieure);
		ArrayList<Objet> listeOptimale = a.rechercheListe(-1, liste, sac);
		for(Objet o : listeOptimale)
			sac.ajouter(o);
	}
}

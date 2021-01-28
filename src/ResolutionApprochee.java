public class ResolutionApprochee {
	
	public static void Resolution(SacADos sac,ListeDesObjets liste) {
		liste.trierLaListe();
		for(int i = 0; i< liste.getTailleListe(); ++i) {
			if(sac.peutContenir(liste.getListeDesObjets().get(i))) {
				sac.ajouter(liste.getListeDesObjets().get(i));
			}
			else
				break;
		}
		
	}
}

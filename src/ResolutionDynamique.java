public class ResolutionDynamique {
	public static void Resolution(SacADos sac, ListeDesObjets liste) {
		MatriceDynamique m = new MatriceDynamique(liste, sac);
		float[][] mat = m.getMatrice();
		int i = m.hauteur -1;
		int j = m.largeur -1;
		// Parcours la derniere ligne
		while (j> 0 && mat[i][j] == mat[i][j - 1]) {
			--j;
		}
		while (j > 0 && i >= 0) {
			//Parcours une colone
			while ((i > 0 )&& (mat[i][j] == mat[i - 1][j]))
				--i;
			j = j - ((int) (liste.getListeDesObjets().get(i).getPoids()) * 100);
			if (j >= 0) {
				System.out.println("Ajout de l'objet " + i);
				sac.ajouter(liste.getListeDesObjets().get(i));
			}
			--i;
		}
	}
}

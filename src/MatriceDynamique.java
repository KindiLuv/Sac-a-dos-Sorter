public class MatriceDynamique {
	private float[][] matrice;
	public final int hauteur;
	public final int largeur;

	public MatriceDynamique(ListeDesObjets l, SacADos s) {
		hauteur = l.getListeDesObjets().size();
		largeur = (int) ((s.getPoidsMaximum()) * 100 + 1);
		System.out.println((int) (l.getListeDesObjets().get(0).getPoids()*100));
		matrice = new float[hauteur][largeur];
		for (int j = 0; j < largeur; ++j) {
			if ((int) (l.getListeDesObjets().get(0).getPoids() * 100) > j) {
				matrice[0][j] = 0;
			} else
				matrice[0][j] = ((l.getListeDesObjets().get(0).getValeur()));
		}
		for (int i = 1; i < hauteur; ++i) {
			for (int j = 0; j < largeur; ++j) {
			
				if ((int) ((l.getListeDesObjets().get(i).getPoids()) * 100) > j) {
	
					matrice[i][j] = matrice[i - 1][j];
			
				} else {
					matrice[i][j] = Float.max(matrice[i - 1][j], matrice[i - 1][j - (int) ((l.getListeDesObjets().get(i).getPoids()) * 100)] + (l.getListeDesObjets().get(i).getValeur()));
				}
			}
		}
	}

	public float[][] getMatrice() {
		return matrice;
	}
}

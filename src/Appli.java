public class Appli {

	public static void main(String[] args) {

		SacADos SAKADO = new SacADos(30);
		ListeDesObjets l =  new ListeDesObjets("itemsEval.txt");
		System.out.println(l.getListeDesObjets().get(1));
		ResolutionPSE.Resolution(SAKADO, l);
		System.out.println("Score du sac : " + SAKADO.getScore());
		System.out.println(SAKADO.getContenuDuSac().toString());
	}
}

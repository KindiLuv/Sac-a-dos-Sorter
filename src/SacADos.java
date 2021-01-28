import java.util.ArrayList;

public class SacADos {
	private float poidsMaximum;
	
	private ArrayList<Objet> contenuDuSac;
	private float poidsDuSac;

	public SacADos(float poidsmax) {
		poidsMaximum = poidsmax;
		this.poidsDuSac = 0;
		this.contenuDuSac = new ArrayList<>();
		System.out.println("sac cree a vide");
	}

	public boolean peutContenir(Objet O) {
		return ((poidsDuSac + O.getPoids()) < poidsMaximum);
	}

	public void ajouter(Objet O) {
		poidsDuSac = poidsDuSac + O.getPoids();
		contenuDuSac.add(O);
	} 

	public float getScore() {
		float score = 0;
		for (int index = 0; index < contenuDuSac.size(); index++) {
			score = score + contenuDuSac.get(index).getValeur();
		}
		return score;
	}

	public ArrayList<Objet> getContenuDuSac() {
		return contenuDuSac;
	}

	public float getPoidsMaximum() {
		return poidsMaximum;
	}
	
	public void viderSac() {
		contenuDuSac = new ArrayList<>();
		poidsDuSac = 0f;
	}

}

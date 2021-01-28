public class Objet implements Comparable<Objet> {
	private String nom;
	private float poids;
	private float valeur;

	public Objet(float p, float v, String n) {
	
		this.poids = p;
		this.valeur = v;
		this.nom = n;
		System.out.println("objet cree " + " " + poids +" " + valeur +" " + nom);
	}

	public float getPoids() {
		return poids;
	}

	public String toString() {
		return " Nom : " + this.nom + " Poids : " + this.poids + " Valeur : " + this.valeur + " ";
	}

	public float calculeRapport() {
		return (float) valeur / poids;
	}

	public float getValeur() {
		return valeur;
	}

	@Override
	public int compareTo(Objet O) {
		return -Float.compare(calculeRapport(), O.calculeRapport());
	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ListeDesObjets {
	private ArrayList<Objet> liste = new ArrayList<Objet>();

	public ListeDesObjets(String chemin) {
		try {
			InputStream flux = new FileInputStream(chemin);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;

			while ((ligne = buff.readLine()) != null) {
				String arguments[] = ligne.split(" ; ");
				
				liste.add(new Objet((float) Float.parseFloat(arguments[1]),(float) Float.parseFloat(arguments[2]), arguments[0]));
			}
			
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public int getTailleListe() {
		return liste.size();
	}

	public ArrayList<Objet> getListeDesObjets() {
		return liste;
	}

	public void trierLaListe() {

		Collections.sort(liste);

	}

	public boolean compare(int indice1, int indice2) {
		return liste.get(indice1).calculeRapport() > (liste.get(indice2).calculeRapport());
	}

}

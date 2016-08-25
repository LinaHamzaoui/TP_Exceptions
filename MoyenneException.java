
package moyenneException;

public class MoyenneException{

	public static void main(String[] argv) {

		
		if (argv.length <= 0) {

			System.out.println("Il n'y a pas d'arguments");

			System.exit(1);

		}

		try {
					int moyenne = moyenne(argv);
					System.out.println("Moyenne calculee:"+ moyenne);
			} 
		
		catch ( NumberFormatException e) {
			
			System.out.println("Erreur:"+ e.getMessage());
			return;
			} 
		
		catch (  ArithmeticException e) {
			
			System.out.println("Erreur:"+ e.getMessage());
			return;
			} 
		
		
	

	}

	public static int moyenne(String[] argv) {

		int somme = 0;

		int cpt = 0;

		for (int i = 0; i < argv.length; i++) {

			somme += Integer.parseInt(argv[i]);

			cpt++;

		}

		return somme / cpt;

	}
}

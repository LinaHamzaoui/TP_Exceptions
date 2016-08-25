package moyenneException;

public class ExceptionValeurNegative extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double valeur;
	  ExceptionValeurNegative (double valeur)  {
	     valeur = this.valeur;
	    }

	  public String toString() {
	      return "ExceptionValeurNegative : " + 
		  valeur + " est negatif alors qu'il devrait etre positif";
	    }
	}
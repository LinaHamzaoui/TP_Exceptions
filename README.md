# TP sur les Exceptions:
#L'3 TP JAVA 2015-2016

Concepts abordés

• Classe, Encapsulation, Héritage, Généricité, Polymorphisme, Collections, Interface,
Exceptions
Consignes générales de travail
• Commencez chaque TP dans un nouveau Projet Java (ici TP4)
• Créez toujours un (ou plusieurs) paquetages pour contenir ses classes (ne jamais
utiliser le paquetage par défaut).
• Écrivez chaque nouvelle classe dans son propre fichier (portant le nom de la classe).
• Pour ce TP, déclarez systématiquement vos attributs en private et vos méthodes en
package friendly ou public.
• Définissez systématiquement les méthodes equals():boolean, hashcode:int
et toString():String pour chaque classe que vous écrivez.
• Lisez chaque exercice en entier avant de commencer vos réponses.
Pour mener à bien ces exercices, il est impératif d'ouvrir
1) la Javadoc http://docs.oracle.com/javase/6/docs/api/
2) le tutoriel de Sun sur le collections
http://docs.oracle.com/javase/tutorial/collections/index.html



Partie A: les exceptions
Exercice 1: Moyenne
La classe suivante permet de calculer la moyenne des entiers passés en paramètres au programme.
Il est demandé de gérer les exceptions NumberFormatException et ArithmeticException dans
la méthode main.

Rappel:
 x / 0 pas bien du tout...
SOURCE DE LA CLASSE SANS LES EXCEPTIONS

package moyenneException;
public class MoyenneException{
public static void main(String[] argv) {
if (argv.length <= 0) {
System.out.println("Il n'y a pas d'arguments");
System.exit(1);
}

int moyenne = moyenne(argv);
System.out.println("La moyenne est " + moyenne);
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



Exercice 2: Racine
Il s'agit d'écrire une classe servant à calculer la racine carrée d'un nombre réel de type double.
Ce nombre sera passé comme argument au programme.
La méthode racine lance une exception dans le cas où le double qui lui est passé en paramètre est
négatif.
• On définira une classe étendant la classe Exception, correspondant à la classe de l'exception
qui sera levée dans le cas d'un opérande négatif.
• Dans le cas d'un opérande négatif, on lancera une exception de la classe définie depuis
l'intérieur de la méthode racine de la classe Racine. Cette erreur ne sera pas attrapée par la
méthode racine mais le sera dans la méthode main qui utilise la méthode calcule.

SOURCES DES CLASSES SANS LES EXCEPTIONS

public class Racine
{
 private double precision;

 Racine(double precision)
 {
 this.precision=precision;
 }
 double racine(double operande)
 {
 double solution, carre, a, b;
 a=0;
 b=operande;
 solution=(a+b)/2;
 while(b-a>precision)
{
 carre=solution*solution;
 if (carre>operande) b=solution;
 else a=solution;
 solution=(a+b)/2;
}
 return solution;
 }

 double getPrecision() { return precision; }
 void setPrecision(double precision) { this.precision=precision; }
}

public class UtiliseRacine
{
 public static void main(String[] argv)
 {
 Racine extracteur = new Racine(0.01);
 double operande= (Double.valueOf(argv[0])).doubleValue();
 double valeurRacine;
 valeurRacine=extracteur.racine(operande);
 System.out.println(valeurRacine);
 System.out.println("precision "+extracteur.getPrecision() + " , erreur =" +
(valeurRacine-Math.sqrt(operande)));
 extracteur.setPrecision(0.00001);
 valeurRacine=extracteur.racine(operande);
 System.out.println(valeurRacine);
 System.out.println("precision "+extracteur.getPrecision() + " , erreur =" +
(valeurRacine-Math.sqrt(operande)));

 }

}

On obtient :

6.55865478515625

precision 0.01 , erreur =0.00121626085424964
6.557437360286713
precision 1.0E-5 , erreur =-1.1640152877134824E-6


Partie B: retour sur le TP3 et l'interface Condition

1) Créer une nouvelle classe ExceptionArgumentIncorrect sans attribut qui ne contient que
le constructeur transmettant son paramètre message de type String au constructeur de sa
super-classe.
2) Le constructeur de la classe InclusIntervalle doit lancer une telle exception lorsque la borne
inférieure n'est pas strictement inférieure à la borne supérieure. Le message doit être de la
forme 40 >= 35 si les paramètres sont 30 et 45.
Que faut-il ajouter à la signature du constructeur pour ne pas avoir d'erreur de compilation?
3) Dans la classe TestConditions, afficher l'exception + ''Pas de comptage possible.'' lorsque
l'exception se produit, et dans ce cas, n'effectuer aucun comptage.

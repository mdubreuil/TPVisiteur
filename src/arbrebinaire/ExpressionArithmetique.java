package arbrebinaire;

public class ExpressionArithmetique {
    private Noeud racine;

    public ExpressionArithmetique(Noeud racine){
        this.racine = racine;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void afficherInfixe(){
        System.out.println("\n infixe:");
        racine.accept(new VisiteurInfixe());
    }
    
    public void afficherPrefixe() {
        System.out.println("\n prefixe:");
        racine.accept(new VisiteurPrefixe());
    }

    public void afficherPostFixe() {
        System.out.println("\n postfixe:");
        racine.accept(new VisiteurPostfixe());
    }
    
    public void afficherParentheses() {
        System.out.println("\n Parenthèses :");
        racine.accept(new VisiteurParenthese());
    }

    public int calculerValeur() {
        VisiteurCalculateur v = new VisiteurCalculateur();
        racine.accept(v);
        return v.getTotal();
    }

    public int calculerHauteur() {
        VisiteurHauteur v = new VisiteurHauteur();
        racine.accept(v);
        return v.getHauteur();
    }	
}

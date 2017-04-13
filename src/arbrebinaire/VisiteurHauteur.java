package arbrebinaire;

import static java.lang.Integer.max;

/**
 *
 * @author Mélanie DUBREUIL - 4APP Polytech Lyon 1
 * @author Ophélie EOUZAN - 4APP Polytech Lyon 1
 * 
 */

public class VisiteurHauteur implements Visiteur {
    public Integer hauteur;
    
    VisiteurHauteur (){
        hauteur = 0;
    }

    public Integer getHauteur() {
        return hauteur;
    }
    
    @Override
    public Integer visiterConstante(Constante c) {
        return hauteur += 1;
    }

    @Override
    public Integer visiterNegation(Negation n) {
        return hauteur += 2;
    }

    @Override
    public Integer visiterAddition(Addition a) {
        hauteur += 1;
        VisiteurHauteur v = new VisiteurHauteur();
        VisiteurHauteur v2 = new VisiteurHauteur();
        a.getOpG().accept(v);
        a.getOpD().accept(v2);
        hauteur += max(v.getHauteur(),v2.getHauteur());
        return hauteur;
    }

    @Override
    public Integer visiterMultiplication(Multiplication m) {
        hauteur += 1;
        VisiteurHauteur v = new VisiteurHauteur();
        VisiteurHauteur v2 = new VisiteurHauteur();
        m.getOpG().accept(v);
        m.getOpD().accept(v2);
        hauteur += max(v.getHauteur(),v2.getHauteur());
        return hauteur;
    }
    
}

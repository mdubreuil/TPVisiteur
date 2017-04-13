package arbrebinaire;

/**
 *
 * @author Mélanie DUBREUIL - 4APP Polytech Lyon 1
 * @author Ophélie EOUZAN - 4APP Polytech Lyon 1
 * 
 */

public class VisiteurCalculateur implements Visiteur {
    public Integer total;
    
    VisiteurCalculateur (){
        total = 0;
    }

    public Integer getTotal() {
        return total;
    }    
    
    @Override
    public Integer visiterConstante(Constante c) {
        return total = c.getValeur();
    }

    @Override
    public Integer visiterNegation(Negation n) {
        VisiteurCalculateur v = new VisiteurCalculateur();
        n.getOpG().accept(v);
        total -= v.getTotal();
        return total;
    }

    @Override
    public Integer visiterAddition(Addition a) {
        VisiteurCalculateur v = new VisiteurCalculateur();
        VisiteurCalculateur v2 = new VisiteurCalculateur();
        a.getOpG().accept(v);
        a.getOpD().accept(v2);
        total = v.getTotal() + v2.getTotal();
        return total;
    }

    @Override
    public Integer visiterMultiplication(Multiplication m) {
        VisiteurCalculateur v = new VisiteurCalculateur();
        VisiteurCalculateur v2 = new VisiteurCalculateur();
        m.getOpG().accept(v);
        m.getOpD().accept(v2);
        total = v.getTotal() * v2.getTotal();
        return total;
    }
    
}

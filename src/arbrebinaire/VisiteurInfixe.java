package arbrebinaire;

/**
 *
 * @author Mélanie DUBREUIL - 4APP Polytech Lyon 1
 * @author Ophélie EOUZAN - 4APP Polytech Lyon 1
 * 
 */

public class VisiteurInfixe implements Visiteur {
    
    @Override
    public Integer visiterConstante(Constante c) {
        System.out.print(c.getValeur());
        return 0;
    }

    @Override
    public Integer visiterNegation(Negation n) {
        System.out.print(n.getOp());
        n.getOpG().accept(this);
        return 0;
    }

    @Override
    public Integer visiterAddition(Addition a) {
        a.getOpG().accept(this);
        System.out.print(a.getOp());
        a.getOpD().accept(this);
        return 0;
    }

    @Override
    public Integer visiterMultiplication(Multiplication m) {
        m.getOpG().accept(this);
        System.out.print(m.getOp());
        m.getOpD().accept(this);
        return 0;
    }
    
}

package arbrebinaire;

/**
 *
 * @author Mélanie DUBREUIL - 4APP Polytech Lyon 1
 * @author Ophélie EOUZAN - 4APP Polytech Lyon 1
 * 
 */

public class VisiteurPostfixe implements Visiteur {
    
    @Override
    public Integer visiterConstante(Constante c) {
        System.out.print(c.getValeur());
        return 0;
    }

    @Override
    public Integer visiterNegation(Negation n) {
        n.getOpG().accept(this);
        System.out.print(n.getOp());
        return 0;
    }

    @Override
    public Integer visiterAddition(Addition a) {
        a.getOpG().accept(this);
        a.getOpD().accept(this);
        System.out.print(a.getOp());
        return 0;
    }

    @Override
    public Integer visiterMultiplication(Multiplication m) {
        m.getOpG().accept(this);
        m.getOpD().accept(this);
        System.out.print(m.getOp());
        return 0;
    }
    
}

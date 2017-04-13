package arbrebinaire;

/**
 *
 * @author Mélanie DUBREUIL - 4APP Polytech Lyon 1
 * @author Ophélie EOUZAN - 4APP Polytech Lyon 1
 * 
 */

public interface Visiteur {
    Integer visiterConstante(Constante c);
    Integer visiterNegation(Negation n);
    Integer visiterAddition(Addition a);
    Integer visiterMultiplication(Multiplication m);
}

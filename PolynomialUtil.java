import java.util.Map;

public class PolynomialUtil {
    private static PolynomialUtil polynomialUtil;

    /**
     * DO NOT TRY TO INITIALIZE WITH THIS
     */
    private PolynomialUtil() {

    }

    /**
     * This will get you an object of PolynomialUtil.
     * Singleton factory pattern.
     */
    public static PolynomialUtil getPolynomialUtil() {
        if (polynomialUtil == null) {
            polynomialUtil = new PolynomialUtil();
        }
        return polynomialUtil;
    }

    /**
     * Returns 0 if the exponent isn't present
     * @return the coefficient if the exponent is present
     * and zero otherwise.
     */
    public double getEffectiveCoefficient(Map<Integer, Double> terms, int exponent) {
        return terms.containsKey(exponent) ? terms.get(exponent) : 0;
    }
}

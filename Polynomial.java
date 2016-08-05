import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    Map<Integer, Double> terms;

    public Polynomial(Map<Integer, Double> terms) {
        this.terms = terms;
        completePolynomial();
    }

    public Map<Integer, Double> getTerms() {
        return terms;
    }

    public void setTerms(Map<Integer, Double> terms) {
        this.terms = terms;
    }

    public Polynomial add(Polynomial p1, Polynomial p2) {
        Map<Integer, Double> sum = new HashMap<>();
        int maxDegree = getGreaterDegree(p1, p2);
        for (int exponent = 0; exponent <= maxDegree; exponent++) {
            sum.put(exponent, p1.getTerms().get(exponent) + p2.getTerms().get(exponent));
        }
        return new Polynomial(sum);
    }

    public Polynomial subtract(Polynomial pFrom, Polynomial pToSubtract) {
        Map<Integer, Double> difference = new HashMap<>();
        int maxDegree = getGreaterDegree(pFrom, pToSubtract);
        for (int exponent = 0; exponent <= maxDegree; exponent++) {
            difference.put(exponent, pFrom.getTerms().get(exponent) - pToSubtract.getTerms().get(exponent));
        }
        return new Polynomial(difference);
    }

    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        return null;
    }

    public String toString() {
        return "";
    }

    public String toHTML() {
        return "";
    }

    public String toLaTeX() {
        return "";
    }

    private int getDegree() {
        int degree = 0;
        for (int exponent : terms.keySet()) {
            if (exponent > degree) {
                degree = exponent;
            }
        }
        return degree;
    }

    private int getGreaterDegree(Polynomial p1, Polynomial p2) {
        int degree1 = p1.getDegree();
        int degree2 = p2.getDegree();
        return degree1 > degree2 ? degree1 : degree2;
    }

    private void completePolynomial() {
        int degree = getDegree();
        for (int i = 0; i <= degree; i++) {
            if (!(terms.containsKey(i))) {
                terms.put(i, 0d);
            }
        }
    }

    private void stripPolynomialOfZeroes() {
        int degree = getDegree();
        for (int i = 0; i <= degree; i++) {
            if (terms.get(i) == 0) {
                terms.remove(i);
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    Map<Integer, Double> terms;

    public Polynomial(Map<Integer, Double> terms) {
        this.terms = terms;
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
            sum.put(exponent, p1.getEffectiveCoefficient(exponent) + p2.getEffectiveCoefficient(exponent));
        }
        return new Polynomial(sum);
    }

    public Polynomial subtract(Polynomial pFrom, Polynomial pToSubtract) {
        Map<Integer, Double> difference = new HashMap<>();
        int maxDegree = getGreaterDegree(pFrom, pToSubtract);
        for (int exponent = 0; exponent <= maxDegree; exponent++) {
            difference.put(exponent, pFrom.getEffectiveCoefficient(exponent) - pToSubtract.getEffectiveCoefficient(exponent));
        }
        return new Polynomial(difference);
    }

    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        Map<Integer, Double> product = new HashMap<> ();

    }

    public String toString() {
    	String latexcode="";
    	
    	for(int i=0;i<poly.size();i++){
    		latex+= tostring(poly.get(poly[i]))+"<sup>"+poly[i]+"</sup>";
    	}
    	
        return latexcode;
    }

    public String toHTML() {
    	String latexcode="";
    	latexcode+="<math> \n";
    	for(int i=0;i<poly.size();i++){
    		latex+= tostring(poly.get(poly[i]))+"<sup>"+poly[i]+"</sup>";
    	}
    	latexcode+="\n </math>\n";
        return latexcode;
    }

    public String toLaTeX(Map<Integer, Double > poly) {
    	String latexcode="";
    	latexcode+="\begin{equation} \n";
    	for(int i=0;i<poly.size();i++){
    		latex+= tostring(poly.get(poly[i]))+"^"+poly[i];
    	}
    	latexcode+="\n \end{equation}\n";
        return latexcode;
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

    /**
     * Returns 0 if the exponent isn't present
     * @return the coefficient if the exponent is present
     * and zero otherwise.
     */
    private double getEffectiveCoefficient(int exponent) {
        return terms.containsKey(exponent) ? terms.get(exponent) : 0;
    }
}

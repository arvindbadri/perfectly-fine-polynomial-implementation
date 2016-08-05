import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    Map<Integer, Double> terms;
    private PolynomialUtil polynomialUtil = PolynomialUtil.getPolynomialUtil();

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
            sum.put(exponent,
                    polynomialUtil.getEffectiveCoefficient(p1.getTerms(),exponent)
                            + polynomialUtil.getEffectiveCoefficient(p2.getTerms(),exponent));
        }
        return new Polynomial(sum);
    }

    public Polynomial subtract(Polynomial pFrom, Polynomial pToSubtract) {
        Map<Integer, Double> difference = new HashMap<>();
        int maxDegree = getGreaterDegree(pFrom, pToSubtract);
        for (int exponent = 0; exponent <= maxDegree; exponent++) {
            difference.put(exponent,
                    polynomialUtil.getEffectiveCoefficient(pFrom.getTerms(),exponent)
                            - polynomialUtil.getEffectiveCoefficient(pToSubtract.getTerms(),exponent));
        }
        return new Polynomial(difference);
    }

    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        Map<Integer, Double> product = new HashMap<> ();
        int degree1 = p1.getDegree();
        int degree2 = p2.getDegree();
        for (int exponent1 = 0; exponent1 <= degree1; exponent1 ++) {
            double coefficient1 = polynomialUtil.getEffectiveCoefficient(p1.getTerms(), exponent1);
            for (int exponent2 = 0; exponent2 <= degree2; exponent2 ++) {
                int exponentOfProduct = exponent1 + exponent2;
                double coefficientOfProduct = coefficient1 * polynomialUtil.getEffectiveCoefficient(p2.getTerms(), exponent2);
                double totalProduct = polynomialUtil.getEffectiveCoefficient(product, exponentOfProduct) + coefficientOfProduct;
                product.put(exponentOfProduct, totalProduct);
            }
        }
        return new Polynomial(product);
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


}

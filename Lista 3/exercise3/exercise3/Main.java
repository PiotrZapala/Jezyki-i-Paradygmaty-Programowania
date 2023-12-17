package exercise3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<FloatField> coe1 = new ArrayList<>();
        List<FloatField> coe2 = new ArrayList<>();

        coe1.add(new FloatField(1.0f));
        coe1.add(new FloatField(2.0f));
        coe1.add(new FloatField(3.0f));
        coe1.add(new FloatField(4.0f));
        coe1.add(new FloatField(5.0f));

        coe2.add(new FloatField(1.0f));
        coe2.add(new FloatField(2.0f));
        coe2.add(new FloatField(3.0f));

        Polynomial<FloatField> poly1 = new Polynomial<FloatField>(coe1);
        Polynomial<FloatField> poly2 = new Polynomial<FloatField>(coe2);

        System.out.println("sum");
        System.out.println(poly1.sum(poly2));
        System.out.println("difference");
        System.out.println(poly1.subtract(poly2));
        System.out.println("product");
        System.out.println(poly1.multiply(poly2));
        System.out.println("quotient");
        System.out.println(poly1.divide(poly2));
        System.out.println("remainder");
        System.out.println(poly1.modulo(poly2));

        List<GaloisField> coeficients1 = new ArrayList<>();
        List<GaloisField> coeficients2 = new ArrayList<>();


        coeficients1.add(new GaloisField(1, 5));
        coeficients1.add(new GaloisField(2, 5));
        coeficients1.add(new GaloisField(3, 5));
        coeficients1.add(new GaloisField(4, 5));
        coeficients1.add(new GaloisField(5, 5));

        coeficients2.add(new GaloisField(1, 5));
        coeficients2.add(new GaloisField(2, 5));
        coeficients2.add(new GaloisField(3, 5));

        Polynomial<GaloisField> polynomial1 = new Polynomial<GaloisField>(coeficients1);
        Polynomial<GaloisField> polynomial2 = new Polynomial<GaloisField>(coeficients2);

        System.out.println("sum");
        System.out.println(polynomial1.sum(polynomial2));
        System.out.println("difference");
        System.out.println(polynomial1.subtract(polynomial2));
        System.out.println("product");
        System.out.println(polynomial1.multiply(polynomial2));
        System.out.println("quotient");
        System.out.println(polynomial1.divide(polynomial2));
        System.out.println("remainder");
        System.out.println(polynomial1.modulo(polynomial2));
    }
}
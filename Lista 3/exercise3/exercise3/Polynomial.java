package exercise3;
import java.util.ArrayList;
import java.util.List;

class Polynomial<C extends Field<C>> {

    private List<C> c = null;
  
    public Polynomial() {
      this.c = new ArrayList<>();
    }
  
    public Polynomial(List<C> coefficients) {
      this.c = coefficients;
    }
  
    public Polynomial<C> sum(Polynomial<C> poly) {
      int maxDegree = Math.max(this.c.size(), poly.c.size());
      List<C> coe = new ArrayList<>(maxDegree);
      Polynomial<C> polynomial = new Polynomial<>(coe);
      for (int i = 0; i < this.c.size(); i++) {
        polynomial.c.set(i, this.c.get(i));
      }
  
      for (int i = 0; i < poly.c.size(); i++) {
        polynomial.c.set(i,polynomial.c.get(i).add(poly.c.get(i)));
      }
  
        for (int i = 0; i < polynomial.c.size(); i++) {
            System.out.print(polynomial.c.get(i));
            if (i != 0) {
            System.out.print("x^" + i);
            }
            if (i != polynomial.c.size() - 1) {
                System.out.print(" + ");
            }
        }
        return polynomial;
    }

    public Polynomial<C> subtract(Polynomial<C> poly) {
      int maxDegree = Math.max(this.c.size(), poly.c.size());
      List<C> coe = new ArrayList<>(maxDegree);
      Polynomial<C> polynomial = new Polynomial<>(coe);
      for (int i = 0; i < this.c.size(); i++) {
        polynomial.c.set(i, this.c.get(i));
      }
  
      for (int i = 0; i < poly.c.size(); i++) {
        polynomial.c.set(i,polynomial.c.get(i).sub(poly.c.get(i)));
      }
  
        for (int i = 0; i < polynomial.c.size(); i++) {
            System.out.print(polynomial.c.get(i));
            if (i != 0) {
            System.out.print("x^" + i);
            }
            if (i != polynomial.c.size() - 1) {
                System.out.print(" + ");
            }
        }
        return polynomial;
    }

    public Polynomial<C> multiply(Polynomial<C> poly) {
      int size = this.c.size() + poly.c.size() - 1;
      List<C> coe = new ArrayList<>(size);
      Polynomial<C> polynomial = new Polynomial<>(coe);
      for (int i = 0; i < poly.c.size(); i++) {
          for (int j = 0; j < this.c.size(); j++){
              polynomial.c.set(i+j, polynomial.c.get(i+j).add(this.c.get(j).mul(poly.c.get(i))));
          }
      }

      for (int i = 0; i < size; i++) {
          System.out.print(polynomial.c.get(i));
          if (i != 0) {
              System.out.print("x^" + i);
          }
          if (i != size - 1) {
              System.out.print(" + ");
          }
      }
      return polynomial;
  }

    public Polynomial<C> divide(Polynomial<C> poly) {
      int dividendDegree = this.c.size()-1;
      int divisorDegree = poly.c.size()-1;
      int degreePoly = dividendDegree-divisorDegree;
      List<C> x = new ArrayList<>(dividendDegree+1);
      List<C> y = new ArrayList<>(degreePoly+1);
      Polynomial<C> poly1 = new Polynomial<>(x);
      Polynomial<C> poly2 = new Polynomial<>(y);
      while(dividendDegree >= divisorDegree) {
          for(int i = 0; i <= divisorDegree; i++) {
              poly1.c.set(i+dividendDegree-divisorDegree, poly.c.get(i));
          }
          poly2.c.set(dividendDegree-divisorDegree, this.c.get(dividendDegree).div(poly1.c.get(dividendDegree)));
          for(int i = 0; i <= degreePoly; i++) {
              poly1.c.set(i, poly1.c.get(i).mul(poly2.c.get(dividendDegree-divisorDegree)));
          }
          for(int i = 0; i <= dividendDegree; i++) {
              this.c.set(i, this.c.get(i).sub(poly1.c.get(i)));
          }
          dividendDegree--;
      }

      for (int i = 0; i < poly2.c.size(); i++) {
          System.out.print(poly2.c.get(i));
          if (i != 0) {
              System.out.print("x^" + i);
          }
          if (i != poly2.c.size()-1) {
              System.out.print(" + ");
          }
      }
      return poly2;
    }

    public Polynomial<C> modulo(Polynomial<C> poly) {
      int dividendDegree = this.c.size()-1;
      int divisorDegree = poly.c.size()-1;
      int degreePoly = dividendDegree-divisorDegree;
      List<C> x = new ArrayList<>(dividendDegree+1);
      List<C> y = new ArrayList<>(degreePoly+1);
      Polynomial<C> poly1 = new Polynomial<>(x);
      Polynomial<C> poly2 = new Polynomial<>(y);
      while(dividendDegree >= divisorDegree) {
          for(int i = 0; i <= divisorDegree; i++) {
              poly1.c.set(i+dividendDegree-divisorDegree, poly.c.get(i));
          }
          poly2.c.set(dividendDegree-divisorDegree, this.c.get(dividendDegree).div(poly1.c.get(dividendDegree)));
          for(int i = 0; i <= degreePoly; i++) {
              poly1.c.set(i, poly1.c.get(i).mul(poly2.c.get(dividendDegree-divisorDegree)));
          }
          for(int i = 0; i <= dividendDegree; i++) {
              this.c.set(i, this.c.get(i).sub(poly1.c.get(i)));
          }
          dividendDegree--;
      }
      for (int i = 0; i < degreePoly-1; i++) {
          System.out.print(this.c.get(i));
          if (i != 0) {
            System.out.print("x^" + i);
          }
          if (i != degreePoly-2) {
            System.out.print(" + ");
          }
      }
      return poly2;
    }

    public C get(int i) {
        return this.c.get(i);
    }
  
    public C evaluate(C value) {
        C p = value; 
        C result = this.c.get(0);
        for (int i = 1; i < this.c.size(); i++) {
            result = result.add(this.c.get(i).mul(value));
            value = value.mul(p);
        }
        return result;
    }
}
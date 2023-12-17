#include <stdio.h>
#include <iostream>
#include <math.h>
#include <vector>
#include <bits/stdc++.h>
#include "exercise1.cpp"

using namespace std;

template<typename C>
class Polynomial {

public:
    std::vector<C> c;

public:

    Polynomial() {
        this->c;
    }

    Polynomial(const std::vector<C>& coefficients) {
        this->c = coefficients;
    }   

    Polynomial operator+(const Polynomial & poly) {
        int max_degree = std::max(this->c.size(), poly.c.size());
        std::vector<C> coe (max_degree);
        Polynomial<C> polynomial(coe);
        for(int i = 0; i < this->c.size(); i++) {
            polynomial.c[i] = this->c[i];
        }

        for(int i = 0; i < poly.c.size(); i++) {
            polynomial.c[i] = polynomial.c[i] + poly.c[i];
        }

        for (int i = 0; i < polynomial.c.size(); i++) {
            cout << polynomial.c[i];
            if (i != 0)
                cout << "x^" << i ;
            if (i != polynomial.c.size()-1)
                cout << " + ";
        }
        return polynomial;
    }
    
    Polynomial operator -(const Polynomial & poly) {
        int max_degree = std::max(this->c.size(), poly.c.size());
        std::vector<C> coe (max_degree);
        Polynomial<C> polynomial(coe);
        for(int i = 0; i < this->c.size(); i++) {
            polynomial.c[i] = this->c[i];
        }

        for(int i = 0; i < poly.c.size(); i++) {
            polynomial.c[i] = polynomial.c[i] - poly.c[i];
        }

        for (int i = 0; i < polynomial.c.size(); i++) {
            cout << polynomial.c[i];
            if (i != 0)
                cout << "x^" << i ;
            if (i != polynomial.c.size()-1)
                cout << " + ";
        }
        return polynomial;
    }

    Polynomial operator *(const Polynomial & poly) {
        int size = this->c.size() + poly.c.size() - 1;
        std::vector<C> coe (size);
        Polynomial<C> polynomial(coe);
        for (int i = 0; i < poly.c.size(); i++) {
            for (int j = 0; j < this->c.size(); j++){
                polynomial.c[i+j] = polynomial.c[i+j] + (this->c[j]*poly.c[i]);
            }
        }

        for (int i = 0; i < size; i++) {
            cout << polynomial.c[i];
            if (i != 0)
                cout << "x^" << i ;
            if (i != size-1)
                cout << " + ";
        }
        return polynomial;
    }

    Polynomial operator /(const Polynomial & poly) {     
        int dividendDegree = this->c.size()-1;
        int divisorDegree = poly.c.size()-1;
        int degreePoly = (dividendDegree)-(divisorDegree);
        std::vector<C> x; 
        std::vector<C> y;
        x.resize(dividendDegree+1);
        y.resize(degreePoly+1);
        Polynomial<C> poly1(x);
        Polynomial<C> poly2(y);
        while(dividendDegree >= divisorDegree) {
            for(int i = 0; i <= divisorDegree; i++) {
                poly1.c[i+dividendDegree-divisorDegree] = poly.c[i];
            }
            poly2.c[dividendDegree-divisorDegree] = this->c[dividendDegree] / poly1.c[dividendDegree];
            for(int i = 0; i <= degreePoly; i++) {
                poly1.c[i] = poly1.c[i] * poly2.c[dividendDegree-divisorDegree];
            }
            for(int i = 0; i <= dividendDegree; i++) {
                this->c[i] = this->c[i] - poly1.c[i];
            }
            dividendDegree--;
        }

        for (int i = 0; i < poly2.c.size(); i++) {
            cout << poly2.c[i];
            if (i != 0)
                cout << "x^" << i ;
            if (i != poly2.c.size()-1)
                cout << " + ";
        }
        return poly2;
    }

    Polynomial operator %(const Polynomial & poly) {     
        int dividendDegree = this->c.size()-1;
        int divisorDegree = poly.c.size()-1;
        int degreePoly = (dividendDegree)-(divisorDegree);
        std::vector<C> x; 
        std::vector<C> y;
        x.resize(dividendDegree+1);
        y.resize(degreePoly+1);
        Polynomial<C> poly1(x);
        Polynomial<C> poly2(y);
        while(dividendDegree >= divisorDegree) {
            for(int i = 0; i <= divisorDegree; i++) {
                poly1.c[i+dividendDegree-divisorDegree] = poly.c[i];
            }
            poly2.c[dividendDegree-divisorDegree] = this->c[dividendDegree] / poly1.c[dividendDegree];
            for(int i = 0; i <= degreePoly; i++) {
                poly1.c[i] = poly1.c[i] * poly2.c[dividendDegree-divisorDegree];
            }
            for(int i = 0; i <= dividendDegree; i++) {
                this->c[i] = this->c[i] - poly1.c[i];
            }
            dividendDegree--;
        }
        for (int i = 0; i < degreePoly-1; i++) {
            cout << this->c[i];
            if (i != 0)
                cout << "x^" << i;
            if (i != degreePoly-2)
                cout << " + ";
        }
        return poly2;
    }    

    bool operator ==(const Polynomial & poly) {
        if(this->c.size() == poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    bool operator !=(const Polynomial & poly) {
        if(this->c.size() != poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    bool operator <(const Polynomial & poly) {
        if(this->c.size() < poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    bool operator >(const Polynomial & poly) {
        if(this->c.size() > poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    bool operator <=(const Polynomial & poly) {
        if(this->c.size() <= poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    bool operator >=(const Polynomial & poly) {
        if(this->c.size() >= poly.c.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    C operator [](int i) {
        return this->c[i];
    }

    C operator ()(C value) {
        C p = value; 
        int i = 0; 
        C result = this->c[0];
        for (int i=1; i < this->c.size(); i++) {
            result = result + this->c[i]*value;
            value = value * p;
        }
        return result;
    }

};
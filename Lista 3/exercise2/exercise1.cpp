#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

template<typename P>
class GaloisField {

public:
    P p;
    P x;

public:

    GaloisField() {
        this->p = 0;
        this->x = 0;
    }

    GaloisField(P prime, P number) {
        this->p = prime;
        this->x = number;
    }

    GaloisField operator+(const GaloisField & gf) {
        if(this->x < 0 && gf.x > 0) {
            return GaloisField(p, ((p+this->x) + gf.x)%p);
        }
        else if (this->x > 0 && gf.x < 0) {
            return GaloisField(p, (this->x + (p+gf.x))%p);         
        }
        else if (this->x < 0 && gf.x < 0) {
            return GaloisField(p, ((p+this->x) + (p+gf.x))%p);  
        }
        else {
            return GaloisField(p, (this->x + gf.x)%p); 
        }
    }
    
    GaloisField operator -(const GaloisField & gf) {
        if(this->x < 0 && gf.x > 0) {
            return GaloisField(p, ((p+this->x) - gf.x)%p);
        }
        else if (this->x > 0 && gf.x < 0) {
            return GaloisField(p, (this->x - (p+gf.x))%p);         
        }
        else if (this->x < 0 && gf.x < 0) {
            return GaloisField(p, ((p+this->x) - (p+gf.x))%p);  
        }
        else {
            return GaloisField(p, (this->x - gf.x)%p); 
        }
    }

    GaloisField operator *(const GaloisField & gf) {
        if(this->x < 0 && gf.x > 0) {
            return GaloisField(p, ((p+this->x) * gf.x)%p);
        }
        else if (this->x > 0 && gf.x < 0) {
            return GaloisField(p, (this->x * (p+gf.x))%p);         
        }
        else if (this->x < 0 && gf.x < 0) {
            return GaloisField(p, ((p+this->x) * (p+gf.x))%p);  
        }
        else {
            return GaloisField(p, (this->x * gf.x)%p); 
        }
    }

    GaloisField operator /(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        int x, y, inv;
        int g = extendedEuclideanAlgorithm(gfa.x, p, &x, &y);
        if(g != 1)
            inv = -1;
        else    
            inv = (x%p + p) % p;
        this->x = this->x%p;
        if (inv == -1)
            return GaloisField(p, 0);
        else
            return GaloisField(p, (inv * this->x)%p);
    }

    GaloisField operator ^(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x-1;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x-1;  
        }
        else {
            gfa.x = gf.x;
        }
        P result = 1;
        int y = gfa.x;
        while (y > 0) {
            if (y % 2 == 1)
                result = (result * this->x)%p;
            y = y >> 1;
            this->x = (this->x * this->x)%p;
        }
        return GaloisField(p, result);
    }


    bool operator ==(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p == gfa.x%p)
            return true;
        else
            return false;
    }  

    bool operator !=(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p != gfa.x%p)
            return true;
        else
            return false;
    }  

    bool operator >(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p > gfa.x%p)
            return true;
        else
            return false;
    }  

    bool operator <(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p < gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator >=(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p >= gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator <=(const GaloisField & gf) {
        GaloisField gfa;
        if(this->x < 0 && gf.x > 0) {
            this->x = p+this->x;
            gfa.x = gf.x;   
        }
        else if (this->x > 0 && gf.x < 0) {
            gfa.x = p+gf.x;         
        }
        else if (this->x < 0 && gf.x < 0) {
            this->x = p+this->x;
            gfa.x = p+gf.x;  
        }
        else {
            gfa.x = gf.x;
        }
        if (this->x%p <= gf.x%p)
            return true;
        else
            return false;
    }  

    friend ostream& operator <<(ostream& s, const GaloisField & gf) {
        return s << gf.x;
    }

    int extendedEuclideanAlgorithm(int a, int b, int *x, int *y) {
        if (a == 0){
            *x = 0, *y = 1;
            return b;
        }
        int x1, y1;
        int gcd = extendedEuclideanAlgorithm(b%a, a, &x1, &y1);
        *x = y1 - (b/a) *x1;
        *y = x1;
        return gcd;
    }
};
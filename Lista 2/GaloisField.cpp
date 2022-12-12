#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

const int p = 1234567891;

class GaloisField {

public:

    unsigned long long int x;

public:

    GaloisField() {
        this->x = 0;
    }

    GaloisField(int x) {
        this->x = x;
    }

    GaloisField operator+(const GaloisField & gf) {
        return GaloisField((this->x + gf.x)%p);
    }
    
    GaloisField operator -(const GaloisField & gf) {
        return GaloisField((this->x - gf.x)%p);
    }

    GaloisField operator *(const GaloisField & gf) {
        return GaloisField((this->x * gf.x)%p);
    }

    GaloisField operator /(const GaloisField & gf) {
        int x, y, inv;
        int g = extendedEuclideanAlgorithm(gf.x, p, &x, &y);
        if(g != 1)
            inv = -1;
        else    
            inv = (x%p + p) % p;
        this->x = this->x%p;
        if (inv == -1)
            return GaloisField(0);
        else
            return GaloisField((inv * this->x)%p);
    }

    GaloisField operator ^(const GaloisField & gf) {
        unsigned long long int result = 1;
        int y = gf.x;
        while (y > 0) {
            if (y % 2 == 1)
                result = (result * this->x);
            y = y >> 1;
            this->x = (this->x * this->x);
        }
        return GaloisField(result%p);
    }


    bool operator ==(const GaloisField & gf) {
        if (this->x%p == gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator !=(const GaloisField & gf) {
        if (this->x%p != gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator >(const GaloisField & gf) {
        if (this->x%p > gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator <(const GaloisField & gf) {
        if (this->x%p < gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator >=(const GaloisField & gf) {
        if (this->x%p >= gf.x%p)
            return true;
        else
            return false;
    }  

    bool operator <=(const GaloisField & gf) {
        if (this->x%p <= gf.x%p)
            return true;
        else
            return false;
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

ostream& operator <<(ostream& s, const GaloisField& gf) {
    return s << gf.x;
}

void menu(int oper, GaloisField num1, GaloisField num2) {
    switch (oper) {
        case 1:
            cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
            break;
        case 2:
            cout << num1 << " - " << num2 << " = " << num1 - num2 << endl;
            break;
        case 3:
            cout << num1 << " * " << num2 << " = " << num1 * num2 << endl;
            break;
        case 4:
            cout << num1 << " / " << num2 << " = " << num1 / num2 << endl;
            break;
        case 5:
            cout << num1 << " ^ " << num2 << " = " << (num1 ^ num2) << endl;
            break;
        case 6:
            cout << num1 << " == " << num2 << "  " << (num1 == num2) << endl;
            break;
        case 7:
            cout << num1 << " < " << num2 << "  " << (num1 < num2) << endl;
            break;
        case 8:
            cout << num1 << " > " << num2 << "  " << (num1 > num2) << endl;
            break;
        case 9:
            cout << num1 << " <= " << num2 << "  " << (num1 <= num2) << endl;
            break;
        case 10:
            cout << num1 << " >= " << num2 << "  " << (num1 >= num2) << endl;
            break;
        case 11:
            cout << num1 << " != " << num2 << "  " << (num1 != num2) << endl;
            break;
        default:
            break;
        }
        return;
}

int main() {
    bool cond = true;
    int oper;
    GaloisField num1, num2;
    while (true) {
        cout << "Enter an operation\n 1. '+'\n 2. '-'\n 3. '*'\n 4. '/'\n 5. '^'\n 6. '=='\n 7. '<'\n 8. '>'\n 9. '<='\n 10. '>='\n 11. '!='\n To quit press '0'!\n ";
        cin >> oper;
        if (oper == 0)
            break;
        cout << "Enter two numbers: ";
        cin >> num1.x >> num2.x;
        menu(oper, num1, num2);
    }
    return 0;
}
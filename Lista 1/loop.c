#include "loop.h"

int factorial(int n) {
    int fact = 1;
    for(int i = 1; i <= n; i++) {
        fact = fact * i;
    }
    return fact;
}

int greatest_common_divisor(int a, int b) {
    int gcd;
    for(int i = 1; i <= a && i <= b; i++) {
        if (a % i == 0 && b % i == 0) {
            gcd = i;
        }
    }
    return gcd;
}

int diophantine_equation_solver(int a, int b, int c) {
    
}
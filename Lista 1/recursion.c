#include "recursion.h"
#include <stdio.h>

int factorial(int n) {
    if (n==0) 
        return 1;
    else
        return n*factorial(n-1);
}

int greatest_common_divisor(int a, int b) {
    if (a==0 || b==0)
        return 0;
    else if (a==b)
        return a;
    else if (a > b)
        return greatest_common_divisor(a-b, b);
    else 
        return greatest_common_divisor(a, b-a);
}

int extended_euclidean_algorithm(int a, int b, int *x, int *y) {
    if (b == 0) {
        *x = 1;
        *y = 0;
        return a;
    }
    else {
        int x1 = *x, y1 = *y;
        int gcd = extended_euclidean_algorithm(b, a%b, &x1, &y1);
        *x = y1; 
        *y = x1 - (a/b) * y1;
        return gcd;
    }
}

Struct diophantine_equation_solver(int a, int b, int c) {
    Struct s;
    if (a == 0 && b == 0) {
        if (c == 0) {
            printf("Solutions exist!");
        }
        else {
            printf("Solution does not exist!");
        }
    }
    int gcd = extended_euclidean_algorithm(a, b, &s.x, &s.y);
    if (c % gcd != 0) {
        printf("Solution does not exist!");
    }
    else {
        s.x = s.x * (c / gcd);
        s.y = s.y * (c / gcd);
        return s;
    }
}
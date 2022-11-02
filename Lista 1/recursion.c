#include "recursion.h"

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

int extended_euclidean_algorithm(int a, int b, int x, int y) {
    if (a == 0) {
        x = 0;
        y = 1;
        return b;
    }
    int gcd = extended_euclidean_algorithm(b%a, a, x, y);
    int x1 = x, y1 = y;
    x = y1 - (b/a) * x1;
    y = x1;
    return gcd;
}

int diophantine_equation_solver(int a, int b, int c) {
    int x, y;
    if (a == 0 && b == 0) {
        if (c == 0) {
            printf("Solutions exist!");
        }
        else {
            printf("Solution does not exist!");
        }
    }
    int gcd = extended_euclidean_algorithm(a, b, x, y);
    if (c % gcd != 0) {
        printf("Solution does not exist!");
    }
    else {
        return x * (c / gcd), y * (c / gcd);
    }
}
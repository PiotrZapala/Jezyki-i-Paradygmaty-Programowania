#ifndef __RECURSIVE_H__
#define __RECURSIVE_H__

int factorial(int n);

int greatest_common_divisor(int a, int b);

int extended_euclidean_algorithm(int a, int b, int *x, int *y);

struct diophantine {
    int x, y;
};

typedef struct diophantine Struct;

Struct diophantine_equation_solver(int a, int b, int c);

#endif /*__RECURSIVE_H__*/
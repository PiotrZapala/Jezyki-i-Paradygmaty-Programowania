#include <stdio.h>

extern void adainit(void);
extern void adafinal(void);
extern int factorial(int);
extern int greatest_common_divisor(int, int);
extern int extended_euclidean_algorithm(int, int);
struct results {
    int x, y;
};
typedef struct results Struct;
extern Struct diophantine_equation_solver(int, int, int);

int main() {
    Struct results;
    int result1 = factorial(7);
    printf("%d", result1);
    printf("\n");
    int result2 = greatest_common_divisor(28, 14);
    printf("%d", result2);
    printf("\n");
    results = diophantine_equation_solver(25, 18, 10);
    printf("x = %d and y = %d\n", results.x, results.y);
    printf("\n");
    return 0;
}
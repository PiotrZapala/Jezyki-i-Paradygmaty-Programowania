#include "recursive.h"
#include <stdio.h>

int main() {
    int result1 = factorial(7);
    printf("%d", result1);
    printf("\n");
    int result2 = greatest_common_divisor(28, 14);
    printf("%d", result2);
    printf("\n");
    Struct result;
    result = diophantine_equation_solver(25, 18, 10);
    printf("x = %d and y = %d\n", result.x, result.y);
    return 0;
}
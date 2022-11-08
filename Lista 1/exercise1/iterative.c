#include "iterative.h"
#include <stdio.h>

int factorial(int n)
{
    int fact = 1;
    for (int i = 1; i <= n; i++)
    {
        fact = fact * i;
    }
    return fact;
}

int greatest_common_divisor(int a, int b)
{
    int gcd;
    for (int i = 1; i <= a && i <= b; i++)
    {
        if (a % i == 0 && b % i == 0)
        {
            gcd = i;
        }
    }
    return gcd;
}

int extended_euclidean_algorithm(int a, int b, int *x, int *y)
{
    *x = 1, *y = 0;
    int x1 = *y, y1 = *x;
    int a1 = a, b1 = b;
    int temp, temp1, temp2, temp3;
    if (b > a)
    {
        temp = a;
        a = b;
        b = temp;
    }
    while (b != 0)
    {
        int q = a / b;
        temp1 = a % b;
        a = b;
        b = temp1;

        temp2 = *x;
        *x = x1 - q * *x;
        x1 = temp2;

        temp3 = *y;
        *y = y1 - q * *y;
        y1 = temp3;
    }    
    *x = x1;
    *y = y1;
    return a;
}

Struct diophantine_equation_solver(int a, int b, int c)
{
    Struct s;
    if (a == 0 && b == 0)
    {
        if (c == 0)
        {
            printf("Solutions exist!");
        }
        else
        {
            printf("Solution does not exist!");
        }
    }

    int gcd = extended_euclidean_algorithm(a, b, &s.x, &s.y);

    if (c % gcd != 0)
    {
        s.x = 0;
        s.y = 0;
        return s;
    }
    else
    {
        s.x = s.x * (c / gcd);
        s.y = s.y * (c / gcd);
        return s;
    }
}
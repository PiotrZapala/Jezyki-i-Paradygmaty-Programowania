import math
p = 1234567891

class GaloisField:
    def __init__(self, x=0):
        self.x = x
    #x + y
    def __add__(self, other):
        return GaloisField((self.x + other.x) % p)
    #x - y
    def __sub__(self, other):
        return GaloisField((self.x - other.x) % p)
    #x * y
    def __mul__(self, other):
        return GaloisField((self.x * other.x) % p)
    #x / y
    def __truediv__(self, other):
        g, x, y = gcdExtended(other.x, p)
        if (g != 1):
            inv = -1
        else:
            inv = (x%p + p) % p
        self.x = self.x % p
        if (inv == -1):
            print("Division not defined")
        else:
            return GaloisField((inv * self.x) % p)
    #x ^ y
    def __pow__(self, other):
        return GaloisField(pow(self.x, other.x, p))
    #x == y
    def __eq__(self, other):
        if (self.x%p == other.x%p):
            return True;
        else:
            return False;
    #x < y
    def __lt__(self, other):
        if (self.x%p < other.x%p):
            return True;
        else:
            return False;
    #x > y
    def __gt__ (self, other):
        if (self.x%p > other.x%p):
            return True;
        else:
            return False;
    #x <= y
    def __le__(self, other):
        if (self.x%p <= other.x%p):
            return True;
        else:
            return False;
    #x >= y
    def __ge__(self, other):
        if (self.x%p >= other.x%p):
            return True;
        else:
            return False;
    #x != y
    def __ne__(self, other):
        if (self.x%p != other.x%p):
            return True;
        else:
            return False;

    def __str__(self):
        return "{}".format(self.x)

def gcdExtended(a, b):
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = gcdExtended(b%a, a)
    x = y1 - (b//a) * x1
    y = x1
    return gcd, x, y


def main():
    while True:
       print("Enter an operator (+, -, *, /, ^, ==, <, >, <=, >=, !=): To quit press 'q'!")
       option = str(input().strip())
       print("Enter two numbers:")
       x = int(input().strip())
       y = int(input().strip())
       num1 = GaloisField(x)
       num2 = GaloisField(y)
       if option == '+':
            print('{} + {} = {}'.format(num1, num2, num1 + num2))      
       elif option == '-':
            print('{} - {} = {}'.format(num1, num2, num1 - num2)) 
       elif option == '*':
            print('{} * {} = {}'.format(num1, num2, num1 * num2)) 
       elif option == '/':
            print('{} / {} = {}'.format(num1, num2, num1 / num2)) 
       elif option == '^':
            print('{} ^ {} = {}'.format(num1, num2, num1 ** num2)) 
       elif option == '==':
            print('{} == {}  {}'.format(num1, num2, num1 == num2)) 
       elif option == '<':
            print('{} < {}  {}'.format(num1, num2, num1 < num2)) 
       elif option == '>':
            print('{} > {}  {}'.format(num1, num2, num1 > num2)) 
       elif option == '<=':
            print('{} <= {}  {}'.format(num1, num2, num1 <= num2)) 
       elif option == '>':
            print('{} >= {}  {}'.format(num1, num2, num1 >= num2)) 
       elif option == '!=':
            print('{} != {}  {}'.format(num1, num2, num1 != num2)) 
       elif option == 'q':
            break
       else:
        continue

if __name__ == '__main__':
    main()
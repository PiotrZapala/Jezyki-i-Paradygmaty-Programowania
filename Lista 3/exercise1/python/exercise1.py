import math

class GaloisField:
    def __init__(self, x, p):
        self.x = x
        self.p = p
    #x + y
    def __add__(self, other):
        if (self.x < 0 and other.x > 0):
            return GaloisField(((self.p+self.x) + other.x) % self.p, self.p)
        elif (self.x > 0 and other.x < 0):
            return GaloisField((self.x + (self.p+other.x)) % self.p, self.p)
        elif (self.x < 0 and other.x < 0):
            return GaloisField(((self.p+self.x) + (self.p+other.x)) % self.p, self.p)     
        else:
            return GaloisField((self.x + other.x) % self.p, self.p)
    #x - y
    def __sub__(self, other):
        if (self.x < 0 and other.x > 0):
            return GaloisField(((self.p+self.x) - other.x) % self.p, self.p)
        elif (self.x > 0 and other.x < 0):
            return GaloisField((self.x - (self.p+other.x)) % self.p, self.p)
        elif (self.x < 0 and other.x < 0):
            return GaloisField(((self.p+self.x) - (self.p+other.x)) % self.p, self.p)     
        else:
            return GaloisField((self.x - other.x) % self.p, self.p, self.p)
    #x * y
    def __mul__(self, other):
        if (self.x < 0 and other.x > 0):
            return GaloisField(((self.p+self.x) * other.x) % self.p, self.p)
        elif (self.x > 0 and other.x < 0):
            return GaloisField((self.x * (self.p+other.x)) % self.p, self.p)
        elif (self.x < 0 and other.x < 0):
            return GaloisField(((self.p+self.x) * (self.p+other.x)) % self.p, self.p)     
        else:
            return GaloisField((self.x * other.x) % self.p, self.p)
    #x / y
    def __truediv__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x=self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x=self.p+other.x  
        g, x, y = gcdExtended(other.x, self.p)
        if (g != 1):
            inv = -1
        else:
            inv = (x%self.p + self.p) % self.p
        self.x = self.x % self.p
        if (inv == -1):
            print("Division not defined")
        else:
            return GaloisField((inv * self.x) % self.p, self.p)
    #x ^ y
    def __pow__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x-1
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x-1  
        return GaloisField(pow(self.x, other.x, self.p), self.p)
    #x == y
    def __eq__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  
            
        if (self.x%self.p == other.x%self.p):
            return True;
        else:
            return False;
    #x < y
    def __lt__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  

        if (self.x%self.p < other.x%self.p):
            return True;
        else:
            return False;
    #x > y
    def __gt__ (self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  

        if (self.x%self.p > other.x%self.p):
            return True;
        else:
            return False;
    #x <= y
    def __le__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  

        if (self.x%self.p <= other.x%self.p):
            return True;
        else:
            return False;
    #x >= y
    def __ge__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  

        if (self.x%self.p >= other.x%self.p):
            return True;
        else:
            return False;
    #x != y
    def __ne__(self, other):
        if (self.x < 0 and other.x > 0):
            self.x = self.p+self.x
        elif (self.x > 0 and other.x < 0):
            other.x = self.p+other.x
        elif (self.x < 0 and other.x < 0):
            self.x = self.p+self.x  
            other.x = self.p+other.x  

        if (self.x%self.p != other.x%self.p):
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
       if option == 'q':
            return 0
       print("Enter prime number:")
       p = int(input().strip())
       print("Enter two numbers:")
       x = int(input().strip())
       y = int(input().strip())
       num1 = GaloisField(x, p)
       num2 = GaloisField(y, p)
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
       else:
        continue

if __name__ == '__main__':
    main()
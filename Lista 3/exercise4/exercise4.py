from exercise1 import *

class Polynomial:
    def __init__(self, coefficients):
        self.x = coefficients

    #x + y
    def __add__(self, other):
        maxDegree = max(len(self.x) , len(other.x))
        coe = [self.x[0]]*maxDegree
        polynomial = Polynomial(coe)
        for i in range(len(self.x)):
            polynomial.x[i] = self.x[i]

        for i in range(len(other.x)):
            polynomial.x[i] = polynomial.x[i] + other.x[i]

        for i in range(len(polynomial.x)):
            print(polynomial.x[i], end='')
            if i != 0:
                print("x^"+str(i), end='')
            if i != len(polynomial.x) - 1:
                print(" + ", end='')

    #x - y
    def __sub__(self, other):
        maxDegree = max(len(self.x), len(other.x))
        coe = [0]*maxDegree
        polynomial = Polynomial(coe)
        for i in range(len(self.x)):
            polynomial.x[i] = self.x[i]

        for i in range(len(other.x)):
            polynomial.x[i] = polynomial.x[i] - other.x[i]

        for i in range(len(polynomial.x)):
            print(polynomial.x[i], end='')
            if i != 0:
                print("x^"+str(i), end='')
            if i != len(polynomial.x) - 1:
                print(" + ", end='')

    
    #x * y
    def __mul__(self, other):
        size = len(self.x) + len(other.x) - 1
        coe = [0]*size
        polynomial = Polynomial(coe)

        for i in range(size):
            polynomial.x[i] = 0;

        for i in range(len(other.x)):
            for j in range(len(self.x)):
                polynomial.x[i+j] = polynomial.x[i+j] + (self.x[j]*other.x[i])
        
        for i in range(size):
            print(polynomial.x[i], end='')
            if i != 0:
                print("x^"+str(i), end='')
            if i != size - 1:
                print(" + ", end='')


    #x / y
    def __truediv__(self, other):
        dividendDegree = len(self.x) - 1
        divisorDegree = len(other.x) - 1
        degreePoly = (dividendDegree)-(divisorDegree)
        x = [0]*(dividendDegree+1)
        y = [0]*(degreePoly+1)
        poly1 = Polynomial(x)
        poly2 = Polynomial(y)
        while dividendDegree >= divisorDegree:
            x = [0 for i in range(len(x))]
            poly1 = Polynomial(x)
            for i in range(0, divisorDegree+1):
                poly1.x[i+dividendDegree-divisorDegree] = other.x[i]

            poly2.x[dividendDegree-divisorDegree] = self.x[dividendDegree] / poly1.x[dividendDegree]
            for i in range(0, degreePoly+1):
                poly1.x[i] = poly1.x[i] * poly2.x[dividendDegree-divisorDegree]
            for i in range(0, dividendDegree+1):
                self.x[i] = self.x[i] - poly1.x[i]
            dividendDegree -= 1
        
        for i in range(len(poly2.x)):
            print(poly2.x[i], end='')
            if i != 0:
                print("x^"+str(i), end='')
            if i != len(poly2.x) - 1:
                print(" + ", end='')


        #x % y
    def __mod__(self, other):
        dividendDegree = len(self.x) - 1
        divisorDegree = len(other.x) - 1
        degreePoly = (dividendDegree)-(divisorDegree)
        x = [0]*(dividendDegree+1)
        y = [0]*(degreePoly+1)
        poly1 = Polynomial(x)
        poly2 = Polynomial(y)
        while dividendDegree >= divisorDegree:
            x = [0 for i in range(len(x))]
            poly1 = Polynomial(x)
            for i in range(0, divisorDegree+1):
                poly1.x[i+dividendDegree-divisorDegree] = other.x[i]

            poly2.x[dividendDegree-divisorDegree] = self.x[dividendDegree] / poly1.x[dividendDegree]
            for i in range(0, degreePoly+1):
                poly1.x[i] = poly1.x[i] * poly2.x[dividendDegree-divisorDegree]
            for i in range(0, dividendDegree+1):
                self.x[i] = self.x[i] - poly1.x[i]
            dividendDegree -= 1
        
        for i in range(degreePoly-1):
            print(self.x[i])
            if i != 0:
                print("x^"+str(i), end='')
            if i != degreePoly - 2:
                print(" + ")

    # x == y
    def __eq__(self, other):
        if len(self.x) == len(other.x):
            return True
        else:
            return False

    # x != y
    def __ne__(self, other):
        if len(self.x) != len(other.x):
            return True
        else:
            return False

    # x < y
    def __lt__(self, other):
        if len(self.x) < len(other.x):
            return True
        else:
            return False

    # x > y
    def __gt__ (self, other):
        if len(self.x) > len(other.x):
            return True
        else:
            return False

    # x <= y
    def __le__(self, other):
        if len(self.x) <= len(other.x):
            return True
        else:
            return False

    # x >= y
    def __ge__(self, other):
        if len(self.x) >= len(other.x):
            return True
        else:
            return False
         
    def __getitem__(self, index):
        return self.x[index]

    def __setitem__(self, index, value): 
        self.x[index] = value
    
    def __call__(self, value):
        counter = value
        result = self.x[0]
        for i in range(1, len(self.x)):
            result = result + self.x[i]*value
            value = value * counter
        return result

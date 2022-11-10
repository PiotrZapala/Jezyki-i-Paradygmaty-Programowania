package Iterative is

    function Factorial
    (N : Integer) return Integer;
    function Greatest_Common_Divisor 
    (A : Integer;
     B : Integer) return Integer;
    function Extended_Euclidean_Algorithm
    (A : Integer; B : Integer;
     X : Integer; Y : Integer) return Integer;
    function Diophantine_Equation_Solver
    (A : Integer;
     B : Integer; C : Integer) return Vector;

end Iterative;
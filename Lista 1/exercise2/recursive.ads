package Recursive is

    type My_Int_Array is array(1 .. 3) of Integer;
    type Results is record
        x : Integer;
        y : Integer;
        gcd : Integer;
    end record;
    subtype Struct is Results;
    function Factorial
    (N : Integer) return Integer;
    function Greatest_Common_Divisor 
    (A, B : Integer) return Integer;
    function Extended_Euclidean_Algorithm
    (A, B : Integer) return My_Int_Array;
    function Diophantine_Equation_Solver
    (A, B, C : Integer) return Results;

end Recursive;
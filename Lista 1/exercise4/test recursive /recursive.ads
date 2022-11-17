package Recursive is

    type My_Int_Array is array(1 .. 3) of Integer;
    type Results is record
        x : Integer;
        y : Integer;
        gcd : Integer;
    end record;
    function Factorial
    (N : Integer) return Integer;
    pragma Export (C, Factorial, "factorial");
    function Greatest_Common_Divisor 
    (A, B : Integer) return Integer;
    pragma Export (C, Greatest_Common_Divisor , "greatest_common_divisor");
    function Extended_Euclidean_Algorithm
    (A, B : Integer) return My_Int_Array;
    pragma Export (C, Extended_Euclidean_Algorithm , "extended_euclidean_algorithm");
    function Diophantine_Equation_Solver
    (A, B, C : Integer) return Results;
    pragma Export (C, Diophantine_Equation_Solver , "diophantine_equation_solver");
    
end Recursive;
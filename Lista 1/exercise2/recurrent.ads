package Recurrent is

    type My_Int_Array is array(1 .. 3) of Integer;

    function Factorial
    (N : Integer) return Integer;
    function Greatest_Common_Divisor 
    (A, B : Integer) return Integer;
    function Extended_Euclidean_Algorithm
    (A, B : Integer) return My_Int_Array;
    function Diophantine_Equation_Solver
    (A, B, C : Integer) return My_Int_Array;

end Recurrent;
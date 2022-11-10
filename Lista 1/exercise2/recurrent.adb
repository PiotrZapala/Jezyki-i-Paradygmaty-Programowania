with Ada.Text_IO; use Ada.Text_IO;

package body Recurrent is  

    function Factorial
    (N : Integer) return Integer is
    begin
        if N = 0 then
            return 1;
        else
            return N*Factorial(N-1);
        end if;
    end Factorial;

    function Greatest_Common_Divisor 
    (A, B : Integer) return Integer is
    begin
        if A = 0 or B = 0 then
            return 0;
        elsif A = B then
            return A;
        elsif A > B then
            return Greatest_Common_Divisor(A-B, B);
        else
            return Greatest_Common_Divisor(A, B-A);
        end if;
    end Greatest_Common_Divisor;

    function Extended_Euclidean_Algorithm
    (A, B : Integer) return My_Int_Array is
    X, Y : Integer;
    Results : My_Int_Array;
    begin 
        X := 0;
        Y := 0;
        if B = 0 then
            Results(1) := 1;
            Results(2) := 0;
            Results(3) := A;
            return Results;
        end if;
        Results(1) := X;
        Results(2) := Y;
        Results := Extended_Euclidean_Algorithm(B, A mod B);
        X := Results(2);
        Y := Results(1) - (A/B) * Results(2);
        Results(1) := X;
        Results(2) := Y;
        return Results;
    end Extended_Euclidean_Algorithm;

    function Diophantine_Equation_Solver
    (A, B, C : Integer) return My_Int_Array is
    Results1 : My_Int_Array;
    Results2 : My_Int_Array;
    begin
        if A = 0 and B = 0 then
            if C = 0 then 
                Put_Line ("Solution exist!");
            else
                Put_Line ("Solution does not exist!");
            end if;
        end if;
        Results1 := Extended_Euclidean_Algorithm(A, B);
        if C mod Results1(3) /= 0 then
            Put_Line ("Solution Does not exist!");
        else
            Results2(1) := Results1(1) * (C/Results1(3));
            Results2(2) := Results1(2) * (C/Results1(3));
            Results2(3) := Results1(3);
        end if;
        return Results2;
    end Diophantine_Equation_Solver;

end Recurrent;
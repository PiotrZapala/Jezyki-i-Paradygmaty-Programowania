with Ada.Text_IO; use Ada.Text_IO;

package body Iterative is  

    function Factorial
    (N : Integer) return Integer is
    Fact : Integer;
    begin
        Fact := 1;
        for I in 1 .. N loop
            Fact := Fact * I;
        end loop;
        return Fact;
    end Factorial;

    function Greatest_Common_Divisor 
    (A, B : Integer) return Integer is
    Gcd, I : Integer;
    begin
        I := 1;
        while I <= A and I <= B loop
            if A mod I = 0 and B mod I = 0 then
                Gcd := I;
            end if;
            I := I + 1;
        end loop;
        return Gcd;
    end Greatest_Common_Divisor;

    function Extended_Euclidean_Algorithm
    (A, B: Integer) return My_Int_Array is
    X, Y, X1, Y1, Q, Temp, Temp1, Temp2, Temp3, A1, B1 : Integer;
    Results : My_Int_Array;
    begin 
        A1 := A;
        B1 := B;
        X := 1;
        Y := 0;
        X1 := Y;
        Y1 := X;
        if B1 > A1 then
            Temp := A1;
            A1 := B1;
            B1 := Temp;
        end if;
        while B1 /= 0 loop
            Q := A1/B1;
            Temp1 := A1 mod B1;
            A1 := B1;
            B1 := Temp1;

            Temp2 := X;
            X := X1 - Q * X;
            X1 := Temp2;

            Temp3 := Y;
            Y := Y1 - Q * Y;
            Y1 := Temp3;
        end loop;
        Results(1) := Y1;
        Results(2) := X1;
        Results(3) := A1;
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

end Iterative;
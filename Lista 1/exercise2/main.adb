with Iterative, Recurrent, Ada.Text_IO; use Ada.Text_IO;

procedure Main is
FactI : Integer;
GcdI : Integer;
ResultsI : Iterative.My_Int_Array;
FactR : Integer;
GcdR : Integer;
ResultsR : Recurrent.My_Int_Array;
begin
   FactI := Iterative.Factorial(7);
   GcdI := Iterative.Greatest_Common_Divisor(36, 18);
   ResultsI := Iterative.Diophantine_Equation_Solver(25, 18, 10);
   Put_Line (integer'Image(FactI));
   Put_Line (integer'Image(GcdI));
   Put_Line (integer'Image(ResultsI(1)));
   Put_Line (integer'Image(ResultsI(2)));
   FactR := Recurrent.Factorial(7);
   GcdR := Recurrent.Greatest_Common_Divisor(36, 18);
   ResultsR := Recurrent.Diophantine_Equation_Solver(25, 18, 10);
   Put_Line (integer'Image(FactR));
   Put_Line (integer'Image(GcdR));
   Put_Line (integer'Image(ResultsR(1)));
   Put_Line (integer'Image(ResultsR(2)));
end Main;

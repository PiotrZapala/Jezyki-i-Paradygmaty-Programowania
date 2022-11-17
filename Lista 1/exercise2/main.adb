with Iterative, Recursive, Ada.Text_IO; use Ada.Text_IO;

procedure Main is
FactI : Integer;
GcdI : Integer;
ResultsI : Iterative.Results;
FactR : Integer;
GcdR : Integer;
ResultsR : Recursive.Results;
begin
   FactI := Iterative.Factorial(7);
   GcdI := Iterative.Greatest_Common_Divisor(36, 18);
   ResultsI := Iterative.Diophantine_Equation_Solver(25, 18, 10);
   Put_Line ("Iterative implementation:");
   Put_Line ("");
   Put_Line ("Factorial=" & integer'Image(FactI));
   Put_Line ("Greatest common divisor=" & integer'Image(GcdI));
   Put_Line ("X= " & integer'Image(ResultsI.x));
   Put_Line ("Y= " & integer'Image(ResultsI.y));
   FactR := Recursive.Factorial(7);
   GcdR := Recursive.Greatest_Common_Divisor(36, 18);
   ResultsR := Recursive.Diophantine_Equation_Solver(25, 18, 10);
   Put_Line ("");
   Put_Line ("Reccurent implementation:");
   Put_Line ("");
   Put_Line ("Factorial=" & integer'Image(FactR));
   Put_Line ("Greatest common divisor=" & integer'Image(GcdR));
   Put_Line ("X= " & integer'Image(ResultsR.x));
   Put_Line ("Y= " & integer'Image(ResultsR.y));
end Main;

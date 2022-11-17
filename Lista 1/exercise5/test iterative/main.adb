with Ada.Text_IO; use Ada.Text_IO;
with iterative_h; use iterative_h;
with Interfaces.C; use Interfaces.C;

procedure Main is
FactI : int;
GcdI : int;
ResultsI : Struct;
begin
   FactI := factorial(7);
   GcdI := greatest_common_divisor(36, 18);
   ResultsI := diophantine_equation_solver(25, 18, 10);
   Put_Line ("Iterative implementation:");
   Put_Line ("");
   Put_Line ("Factorial=" & int'Image(FactI));
   Put_Line ("Greatest common divisor=" & int'Image(GcdI));
   Put_Line ("X= " & int'Image(ResultsI.x));
   Put_Line ("Y= " & int'Image(ResultsI.y));
end Main;
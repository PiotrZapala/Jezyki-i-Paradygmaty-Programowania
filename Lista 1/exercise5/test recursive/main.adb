with Ada.Text_IO; use Ada.Text_IO;
with recursive_h; use recursive_h;
with Interfaces.C; use Interfaces.C;

procedure Main is
FactR : int;
GcdR : int;
ResultsR : Struct;
begin
   FactR := factorial(7);
   GcdR := greatest_common_divisor(36, 18);
   ResultsR := diophantine_equation_solver(25, 18, 10);
   Put_Line ("Iterative implementation:");
   Put_Line ("");
   Put_Line ("Factorial=" & int'Image(FactR));
   Put_Line ("Greatest common divisor=" & int'Image(GcdR));
   Put_Line ("X= " & int'Image(ResultsR.x));
   Put_Line ("Y= " & int'Image(ResultsR.y));
end Main;

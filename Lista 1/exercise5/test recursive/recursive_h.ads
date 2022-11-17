pragma Ada_2012;
pragma Style_Checks (Off);

with Interfaces.C; use Interfaces.C;

package recursive_h is

   function factorial (n : int) return int  -- recurrent.h:4
   with Import => True, 
        Convention => C, 
        External_Name => "factorial";

   function greatest_common_divisor (a : int; b : int) return int  -- recurrent.h:6
   with Import => True, 
        Convention => C, 
        External_Name => "greatest_common_divisor";

   function extended_euclidean_algorithm
     (a : int;
      b : int;
      x : access int;
      y : access int) return int  -- recurrent.h:8
   with Import => True, 
        Convention => C, 
        External_Name => "extended_euclidean_algorithm";

   type diophantine is record
      x : aliased int;  -- recurrent.h:11
      y : aliased int;  -- recurrent.h:11
   end record
   with Convention => C_Pass_By_Copy;  -- recurrent.h:10

   subtype Struct is diophantine;  -- recurrent.h:14

   function diophantine_equation_solver
     (a : int;
      b : int;
      c : int) return Struct  -- recurrent.h:16
   with Import => True, 
        Convention => C, 
        External_Name => "diophantine_equation_solver";

end recursive_h;

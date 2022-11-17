package main

// #include <stdlib.h>
// #include "recursive.h"
import "C"

func main() {
	n := C.int(7)
	factorial := C.factorial(n)
	println(factorial)
	a := C.int(36)
	b := C.int(18)
	gcd := C.greatest_common_divisor(a, b)
	println(gcd)
	a1 := C.int(25)
	b1 := C.int(18)
	c1 := C.int(10)
	result := C.diophantine_equation_solver(a1, b1, c1)
	println(result.x)
	println(result.y)
}

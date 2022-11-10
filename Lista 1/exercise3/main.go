package main

import (
	iterative "jipp/packages/iterative"
	recurrent "jipp/packages/recurrent"
)

func main() {
	var ni int = iterative.Factorial(7)
	println(ni)
	var gcdi int = iterative.GreatestCommonDivisor(36, 18)
	println(gcdi)
	var resulti = iterative.DiophantineEquationSolver(25, 18, 10)
	println(resulti[0])
	println(resulti[1])
	println()
	var nr int = recurrent.Factorial(7)
	println(nr)
	var gcdr int = recurrent.GreatestCommonDivisor(36, 18)
	println(gcdr)
	var resultsr = recurrent.DiophantineEquationSolver(25, 18, 10)
	println(resultsr[0])
	println(resultsr[1])
}

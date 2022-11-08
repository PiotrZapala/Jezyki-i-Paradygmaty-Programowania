package main

import (
	fmt "fmt"
	iterative "jipp/packages/iterative"
	recurrent "jipp/packages/recurrent"
)

func main() {
	fmt.Print(iterative.Factorial(7),
		iterative.GreatestCommonDivisor(100, 69),
		iterative.DiophantineEquationSolver(25, 18, 10),
		recurrent.Factorial(7),
		recurrent.GreatestCommonDivisor(100, 69),
		recurrent.DiophantineEquationSolver(25, 18, 10))
}

package recursive

func Factorial(n int) int {
	if n == 0 {
		return 1
	} else {
		return n * Factorial(n-1)
	}
}

func GreatestCommonDivisor(a int, b int) int {
	if a == 0 || b == 0 {
		return 0
	} else if a == b {
		return a
	} else if a > b {
		return GreatestCommonDivisor(a-b, b)
	} else {
		return GreatestCommonDivisor(a, b-a)
	}
}

func ExtendedEuclideanAlgorithm(a int, b int, x *int, y *int) int {
	if b == 0 {
		*x = 1
		*y = 0
		return a
	}
	var x1 int = *x
	var y1 int = *y
	var gcd int = ExtendedEuclideanAlgorithm(b, a%b, &x1, &y1)
	*x = y1
	*y = x1 - (a/b)*y1
	return gcd
}

type Result struct {
	x, y int
}

func DiophantineEquationSolver(a int, b int, c int) [2]int {
	var Results Result
	Results.x = 0
	Results.y = 0
	var result [2]int
	if a == 0 && b == 0 {
		if c == 0 {
			println("Solution exist!")
		} else {
			println("Solution does not exist!")
		}
	}

	var gcd int = ExtendedEuclideanAlgorithm(a, b, &Results.x, &Results.y)

	if c%gcd != 0 {
		println("Solution does not exist!")
	} else {
		result[0] = Results.x * (c / gcd)
		result[1] = Results.y * (c / gcd)
	}
	return result
}

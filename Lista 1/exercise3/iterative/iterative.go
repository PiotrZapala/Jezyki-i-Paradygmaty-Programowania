package iterative

func Factorial(n int) int {
	var fact int = 1
	for i := 1; i <= n; i++ {
		fact = fact * i
	}
	return fact
}

func GreatestCommonDivisor(a int, b int) int {
	var gcd int
	for i := 1; i <= a && i <= b; i++ {
		if a%i == 0 && b%i == 0 {
			gcd = i
		}
	}
	return gcd
}

func ExtendedEuclideanAlgorithm(a int, b int, x *int, y *int) int {
	*x = 1
	*y = 0
	var x1, y1 int = *y, *x
	var temp, temp1, temp2, temp3 int
	if b > a {
		temp = a
		a = b
		b = temp
	}
	for b != 0 {
		var q int = a / b
		temp1 = a % b
		a = b
		b = temp1

		temp2 = *x
		*x = x1 - q**x
		x1 = temp2

		temp3 = *y
		*y = y1 - q**y
		y1 = temp3
	}
	*x = y1
	*y = x1
	return a
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

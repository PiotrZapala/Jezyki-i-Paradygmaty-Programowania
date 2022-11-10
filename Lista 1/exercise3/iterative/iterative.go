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
	*x = x1
	*y = y1
	return a
}

func DiophantineEquationSolver(a int, b int, c int) int {

	return 0

}

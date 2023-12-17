solve(A, B, C, X, Y) :-
    extended_gcd(A, B, GCD, X, Y),
    C mod GCD =:= 0,
    X is X * (C // GCD),
    Y is Y * (C // GCD).

extended_gcd(A, 0, A, 1, 0).
extended_gcd(A, B, GCD, X, Y) :-
    B > 0,
    R is A mod B,
    extended_gcd(B, R, GCD, X1, Y1),
    X is Y1,
    Y is X1 - (A // B) * Y1.

package exercise1;

class GaloisField<T extends Comparable<T>> {
    public T p;
    public T x;

    public GaloisField(T prime, T number) {
        this.p = prime;
        this.x = number;
    }
    //x + y 
    public Integer add(Integer x, Integer y) {
        return x + y;
    }
    public GaloisField add(GaloisField gf) {
        GaloisField result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            result =  new GaloisField(p, (add(add(this.p, this.x) + gf.x))%p);
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(this.p, (this.x + (this.p + gf.x))%p);
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(p, ((this.p + this.x) + (this.p + gf.x))%p);
        }
        else {
            result =  new GaloisField(p, (this.x + gf.x)%p);
        }
        return result;
    }

    //x - y
    public GaloisField sub(GaloisField gf) {
        GaloisField result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            result =  new GaloisField(p, ((this.p + this.x) - gf.x)%p);
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(this.p, (this.x - (this.p + gf.x))%p);
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(p, ((this.p + this.x) - (this.p + gf.x))%p);
        }
        else {
            result =  new GaloisField(p, (this.x - gf.x)%p);
        }
        return result;
    }

    //x * y
    public GaloisField mul(GaloisField gf) {
        GaloisField result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            result =  new GaloisField(p, ((this.p + this.x) * gf.x)%p);
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(this.p, (this.x * (this.p + gf.x))%p);
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            result =  new GaloisField(p, ((this.p + this.x) * (this.p + gf.x))%p);
        }
        else {
            result =  new GaloisField(p, (this.x * gf.x)%p);
        }
        return result;
    }
    
    //x / y
    public GaloisField div(GaloisField gf) {
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        long inv1 = 0;
        GaloisField result;
        GaloisField inv;
        GaloisField p1 = new GaloisField(p, p-2);
        int g = (int) gcd(gf.x, p);
        if (g != 1) {
            inv1 = -1;
        }
        else {
            inv = gf.pow(p1);
            inv1 = inv.x;
        }
        this.x = this.x % p;
        if (inv1 == -1) {
            System.out.println("Division not defined!");
            result = new GaloisField(p, 0);
        }
        else {
            result = new GaloisField(p, (inv1 * this.x)%p);
        }
        return result;
    }

    //x ^ y
    public GaloisField pow(GaloisField gf) {
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x-1;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x-1;
        }
        long result = 1; 
        long y = gf.x;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * this.x)%p;
            }
            y = y >> 1;
            this.x = this.x * this.x%p; 
        }
        return new GaloisField(p, result);
    }

    //x == y
    public boolean eq(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x.compareTo(gf.x)==0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    //x < y
    public boolean lt(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x.compareTo(gf.x)==-1) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    //x > y
    public boolean gt(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x.compareTo(gf.x)==1) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    //x <= y
    public boolean le(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x.compareTo(gf.x)==-1 && gf.x.compareTo(gf.x)==0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    //x >= y
    public boolean ge(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x.compareTo(gf.x)==1 && gf.x.compareTo(gf.x)==0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    //x != y
    public boolean ne(GaloisField gf) {
        boolean result;
        if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==1){
            this.x=p+this.x;
        }
        else if (this.x.compareTo(0)==1 && gf.x.compareTo(0)==-1){
            gf.x=p+gf.x;
        }
        else if (this.x.compareTo(0)==-1 && gf.x.compareTo(0)==-1){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        if (this.x%p != gf.x%p) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }


    public static long gcd(long a, long b) {
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    
}

class Main {
    public static void main(String args[]) {
        GaloisField<Integer> num1 = new GaloisField(2, 8);
        GaloisField<Integer> num2 = new GaloisField(2, 1);
        System.out.println(num1.x+"+"+num2.x+"="+num1.add(num2).x);
    }
}
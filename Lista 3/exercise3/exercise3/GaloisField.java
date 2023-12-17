package exercise3;

public class GaloisField implements Field<GaloisField> {
    private long x;
    public final long p;

    public GaloisField(long number, long prime){
        this.x = number;
        this.p = prime;
    }
    
    @Override
    public final GaloisField add(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x + gf.x)%p, p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x + (p+gf.x))%p, p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x + p+gf.x)%p, p);
        }
        else {
            result =  new GaloisField((this.x + gf.x)%p, p);
        }
        return result;
    }

    @Override
    public final GaloisField sub(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x - gf.x)%p, p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x - (p+gf.x))%p, p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x - p+gf.x)%p, p);
        }
        else {
            result =  new GaloisField((this.x - gf.x)%p, p);
        }
        return result;
    }

    @Override
    public GaloisField mul(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x * gf.x)%p, p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x * (p+gf.x))%p, p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x * p+gf.x)%p, p);
        }
        else {
            result =  new GaloisField((this.x * gf.x)%p, p);
        }
        return result;
    }
    
    @Override
    public GaloisField div(GaloisField gf) {
        if (this.x < 0 && gf.x > 0){
            this.x=p+this.x;
        }
        else if (this.x > 0 && gf.x < 0){
            gf.x=p+gf.x;
        }
        else if (this.x < 0 && gf.x < 0){
            this.x=p+this.x;
            gf.x=p+gf.x;
        }
        long inv1 = 0;
        GaloisField result;
        GaloisField inv;
        GaloisField p1 = new GaloisField(p-2, p);
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
            result = new GaloisField(0,p);
        }
        else {
            result = new GaloisField((inv1 * this.x)%p, p);
        }
        return result;
    }

    private GaloisField pow(GaloisField gf) {
        if (this.x < 0 && gf.x > 0){
            this.x=p+this.x;
        }
        else if (this.x > 0 && gf.x < 0){
            gf.x=p+gf.x-1;
        }
        else if (this.x < 0 && gf.x < 0){
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
        return new GaloisField(result,p);
    }
    public static long gcd(long a, long b) {
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public int compareTo(GaloisField o) {
        return Long.valueOf(this.x).compareTo(o.x);
    }
    
}
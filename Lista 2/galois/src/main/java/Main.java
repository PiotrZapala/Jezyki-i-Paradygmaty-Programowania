package galois.src.main.java;
import java.util.Scanner;

class GaloisField {
    public long x;
    private static int p = 1234577;

    public GaloisField(long l) {
        this.x = l;
    }
    //x + y
    public GaloisField add(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x + gf.x)%p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x + (p+gf.x))%p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x + p+gf.x)%p);
        }
        else {
            result =  new GaloisField((this.x + gf.x)%p);
        }
        return result;
    }

    //x - y
    public GaloisField sub(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x - gf.x)%p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x - (p+gf.x))%p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x - p+gf.x)%p);
        }
        else {
            result =  new GaloisField((this.x - gf.x)%p);
        }
        return result;
    }

    //x * y
    public GaloisField mul(GaloisField gf) {
        GaloisField result;
        if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((p+this.x * gf.x)%p);
        }
        else if (this.x < 0 && gf.x > 0){
            result =  new GaloisField((this.x * (p+gf.x))%p);
        }
        else if (this.x < 0 && gf.x < 0){
            result =  new GaloisField((p+this.x * p+gf.x)%p);
        }
        else {
            result =  new GaloisField((this.x * gf.x)%p);
        }
        return result;
    }

    //x / y
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
        GaloisField p1 = new GaloisField(p-2);
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
            result = new GaloisField(0);
        }
        else {
            result = new GaloisField((inv1 * this.x)%p);
        }
        return result;
    }

    //x ^ y
    public GaloisField pow(GaloisField gf) {
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
        return new GaloisField(result);
    }

    //x == y
    public boolean eq(GaloisField gf) {
        boolean result;
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
        if (this.x%p == gf.x%p) {
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
        if (this.x%p < gf.x%p) {
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
        if (this.x%p > gf.x%p) {
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
        if (this.x%p <= gf.x%p) {
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
        if (this.x%p >= gf.x%p) {
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
        GaloisField num1 = new GaloisField(0);
        GaloisField num2 = new GaloisField(0);
        while (true) {
            System.out.println("Enter an operation\n 1. '+'\n 2. '-'\n 3. '*'\n 4. '/'\n 5. '^'\n 6. '=='\n 7. '<'\n 8. '>'\n 9. '<='\n 10. '>='\n 11. '!='\n To quit press '0'!");
            Scanner myObj = new Scanner(System.in); 
            int oper = myObj.nextInt(); 
            if (oper == 0) {
                break;
            }
            System.out.println("Enter two numbers:");
            num1.x = myObj.nextInt();
            num2.x = myObj.nextInt();
            menu(oper, num1, num2);
        }
    }
    public static void menu(int oper, GaloisField num1, GaloisField num2) {
        switch (oper) {
            case 1:
                System.out.println(num1.x+"+"+num2.x+"="+num1.add(num2).x);
                break;
            case 2:
                System.out.println(num1.x+"-"+num2.x+"="+num1.sub(num2).x);
                break;
            case 3:
                System.out.println(num1.x+"*"+num2.x+"="+num1.mul(num2).x);
                break;
            case 4:
                System.out.println(num1.x+"/"+num2.x+"="+num1.div(num2).x);
                break;
            case 5:
                System.out.println(num1.x+"^"+num2.x+"="+num1.pow(num2).x);
                break;
            case 6:
                System.out.println(num1.x+"=="+num2.x+" "+num1.eq(num2));
                break;
            case 7:
                System.out.println(num1.toString()+"<"+num2.toString()+" "+num1.lt(num2));
                break;
            case 8:
                System.out.println(num1.toString()+">"+num2.toString()+" "+num1.gt(num2));
                break;
            case 9:
                System.out.println(num1.toString()+"<="+num2.toString()+" "+num1.le(num2));
                break;
            case 10:
                System.out.println(num1.toString()+">="+num2.toString()+" "+num1.ge(num2));
                break;
            case 11:
                System.out.println(num1.toString()+"!="+num2.toString()+" "+num1.ne(num2));
                break;
            default:
                break;
        }
    }
}
import java.math.BigInteger;
import java.util.Scanner;
 
class BigFactorial {
    public static void main(String arg[]){
        BigInteger fac=new BigInteger("1");
        int n;
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        n=sc.nextInt();
        
        for(int i=2;i<=n;++i){
            fac=fac.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println(fac);
    }
}

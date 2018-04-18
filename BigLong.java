import java.math.BigInteger;
public class BigLong {
    public static void main (String[] a) {
      long n = Long.valueOf(a[0]);
      System.out.println(n);
        BigInteger fac=new BigInteger("1");
        for(long i=2;i<=n;i++){
            fac=fac.multiply(BigInteger.valueOf(i));
        }

        System.out.println(fac);

        }
    }

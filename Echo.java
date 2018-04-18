public class Echo {
    public static void main (String[] args) {
       int c = 0;
        for (String s: args) {
            System.out.print(c);
            System.out.print(" ");
            System.out.println(s);
            c++;
        }
    }
}

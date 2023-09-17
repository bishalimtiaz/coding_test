package important.recursion;

public class NthFibonacci {
    public static int getNthFib(int n) {
        // Write your code here.

        if (n==0) return 0;
        else if(n==1) return 1;
        return getNthFib(n-1) + getNthFib(n-2);
      }

    public static void main(String[] args) {
        System.out.println(getNthFib(1));
    }
}

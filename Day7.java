import java.util.*;
public class BankApp
{
    //fibnacci series using interation
    // public static void fib(int n)
    // {
    //     int a=0;
    //     int b=1;
    //     int c=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         a=b;//1
    //         b=c;//0
    //         c=a+b;
    //         System.out.println(c);
    //     }
    // }
    // //fibnacci series using recursion
    // public static int fib(int n)
    // {
    //     if( n<=1) return n;

    //     return fib(n-1)+fib(n-2);
        
    // }
    // // //fibnacci series using Memositation
    // public static int fib(int n,int [] dp)
    // {
    //     if( n<=1) return n;

    //     if( dp[n]!=-1) return dp[n];

    //     dp[n]= fib(n-1, dp)+fib( n-2, dp);
    //     return dp[n];
        
    // }
    //  //fibnacci series using Tabulation
    // public static int fib(int n)
    // {
    //     int [] dp=new int[n+1];
    //     dp[0]=0;
    //     dp[1]=1;

    //     for(int i=2;i<=n;i++)
    //     {
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    //  //fibnacci Space Optimization
    public static void fib(int n)
    {
        int cur=0;
        int prev=n;
        int next=0;
        for(int i=0;i<=n;i++)
        {
            cur=prev;
            prev=next;
            next=cur+prev;
            System.out.println(next);
        }
    }
    public static void main(String[] args) {
        int n=5;
        
        fib(n) ;
        

    }


    
}

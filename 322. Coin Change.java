//RECURSION
import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int ans= solveRec(n-1,amount,coins );
        return (ans>=(int )1e9)?-1:ans;
        
    }
    public static int   solveRec(int idx,int amount,int [] coins )
    {
        if( amount==0)return 0;

        if( idx==0)
        {
            if( amount%coins[0]==0)
            {
                return amount/coins[0];
            }
            else
            {
                return (int)1e9;
            }
        }
        //not take
        int notTake=solveRec(idx-1,amount,coins);
        //take
        int take=(int)1e9;
        if( coins[idx]<=amount)
        {
            take=1+solveRec(idx,amount-coins[idx],coins);
        }
        return Math.min( take,notTake);
    }
}
///Memosiation
import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<amount+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans= solveRec(n-1,amount,coins,dp );
        return (ans>=(int )1e9)?-1:ans;
        
    }
    public static int   solveRec(int idx,int amount,int [] coins ,int[][] dp)
    {
        if( amount==0)return 0;

        if( dp[idx][amount]!=-1)
        {
            return dp[idx][amount];
        }
        if( idx==0)
        {
            if( amount%coins[0]==0)
            {
                return dp[idx][amount]=amount/coins[0];
            }
            else
            {
                return  dp[idx][amount]=(int)1e9;
            }
        }
        //not take
        int notTake=solveRec(idx-1,amount,coins,dp);
        //take
        int take=(int)1e9;
        if( coins[idx]<=amount)
        {
            take=1+solveRec(idx,amount-coins[idx],coins,dp);
        }
        dp[idx][amount]=Math.min( take,notTake);
        return dp[idx][amount];
    }
}


///tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int INF = amount + 1; // any value > amount works as "infinite"
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
        {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int coin : coins)
        {
            for (int i = coin; i <= amount; i++)
            {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
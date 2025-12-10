// ///Recursion
class Solution {
    public boolean canPartition(int[] nums) {
        int sm=0;
        for(int i=0;i<nums.length;i++)
        {
            sm+=nums[i];
        }
        if( sm%2==1) return false;
        int target=sm/2;
        int n=nums.length;
        return solve(n-1,target,nums );
    }
    public static boolean solve(int idx,int target,int [] nums )
    {
        if( target==0) return true;
        if(idx==0) 
        {
            return nums[0]==target;
        }
        boolean Nott=solve(idx-1,target,nums);
        boolean take=solve(idx-1,target-nums[idx],nums);
        return Nott|| take;
    }
}
// ///Memosition
class Solution {
    public boolean canPartition(int[] nums) 
    {
        int idx=nums.length;
        int sm=0;
        for(int i:nums)
        {
            sm+=i;
        }
        if( sm%2!=0) return false;
        int target=sm/2;
        int [][] dp=new int [idx][target+1];
        for(int i=0;i<idx;i++)
        {
            for(int j=0;j<target+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        return solve(idx-1,target,nums,dp)==1?true:false;
    }
    public static int solve(int idx,int target,int []nums,int  [][]dp)
    {
        if( idx==0) 
        {
            return dp[idx][target]= nums[idx]==target? 1:0;
        }
        if( nums[idx]==target)
        {
            return dp[idx][target]= 1;
        }
        if( dp[idx][target]!=-1)
        {
            return dp[idx][target];
        } 
        //nt
        int nt=solve( idx-1,target,nums,dp);
        int t=0;
        if( nums[idx]>target)
        {
            return dp[idx][target]=nt;
        }
        //t
        t=solve( idx-1,target-nums[idx],nums,dp);

        int res=( t==1 || nt==1 )? 1:0;
        dp[idx][target]=res;
        return dp[idx][target];
    }

}
// ///Tabulation
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[i - 1][t];
                boolean take = false;

                if (nums[i] <= t) {
                    take = nums[i] <= t && dp[i - 1][t - nums[i]];
                }

                dp[i][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }
}

// //Space optimization
class Solution {
    public boolean canPartition(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return false;

        int sum = 0;
        for (int x : nums) sum += x;
        if (sum % 2 != 0) return false;  // If sum is odd, cannot partition
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums)
        {
            if (num > target) continue; 
            for (int t = target; t >= num; t--)
            {
                dp[t] = dp[t] || dp[t - num];
            }
            if (dp[target]) return true;
        }
        return dp[target];
    }
}






17. Letter Combinations of a Phone Number
class Solution{
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        

        List<String> ans=new ArrayList<>();
        helper(digits,0,"",ans);
        return ans;
    }
    public void helper(String digits,int index,String curr,List<String> ans)
    {
        if( index==digits.length())// base case
        {
            ans.add(curr);
            return;
        }
        for(char c: map[digits.charAt(index)-'0'].toCharArray() )
        {
            helper( digits,index+1,curr+c,ans);
        }
    }
}


1823. Find the Winner of the Circular Game
class Solution {
    public int findTheWinner(int n, int k) {

        if( n==0)
        {
            return 1;
        }

        helper( n,k);
        return 1+ return( findTheWinner(n-1,  k)+k)%n)
        
    }
    public static voiod helper(int  n,int k);
    {
        if(n==0)
        {
            return 1;
        }
        return helper( n-1,k)+k;

    }
}

Print preorder of String
import java.util.*;

public class demo {

    public static void subset(String st) {
        helper(st, 0, "");
    }

    public static void helper(String st, int idx, String current) {
        if (idx == st.length()) {
            System.out.print(current + " ");
            return;
        }

        // Include current character
        helper(st, idx + 1, current + st.charAt(idx));

        // Exclude current character
        helper(st, idx + 1, current);
    }

    public static void main(String[] args)
    {
        String s = "abc";
        subset(s);
    }
}




public class demo {

    // All ways to reach from source (0,0) to destination (rows-1, cols-1)
    public static int ways(int[][] matrix)
    {
        return helper(0, 0, matrix);
    }

    private static int helper(int r, int c, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Out of bounds
        if (r >= rows || c >= cols) return 0;

        // Blocked cell
        if (matrix[r][c] == 0) return 0;

        // Destination reached
        if (r == rows - 1 && c == cols - 1) return 1;

        // Move right + move down (no memoization)
        int right = helper(r, c + 1, matrix);
        int down = helper(r + 1, c, matrix);

        return right + down;
    }

    public static void main(String[] args) {
   

        int[][] grid2 = {
            {1,1},
            {1,1}
            // {1,1,1}
        };
        System.out.println(ways(grid2)); // 2
    }
}



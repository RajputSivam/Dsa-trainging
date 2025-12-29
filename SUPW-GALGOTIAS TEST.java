
/** 

In ICO School, all students have to participate regularly in SUPW. There is a different SUPW activity each day, and each activity has its own duration. The SUPW schedule for the next term has been announced, including information about the number of minutes taken by each activity.
Nikhil has been designated SUPW coordinator. His task is to assign SUPW duties to students, including himself. The school's rules say that no student can go three days in a row without any SUPW duty.
Nikhil wants to find an assignment of SUPW duty for himself that minimizes the number of minutes he spends overall on SUPW.
12345
5 6 7 9 10 11 12) 13
Input format
Line 1: A single integer N. the number of days in the future for which SUPW data is available.
Line 2: N non-negative integers, where the integer in position/represents the number of minutes required for SUPW work on day
Output format
The output consists of a single non-negative integer, the minimum number of minutes that Nikhil needs to spend on SUPW duties this term
Test data
There is only one subtask worth 100 marks. In all inputs:
- 1 <= N <= 2 * 10 ^ 5
The number of minutes of SUPW each day is between 0 and 10", inclusive.
Test against Conta
1231233



***/
import java.io.*;
import java.util.*;

public class Main {

    // ---------- FAST INPUT ----------
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int N=fs.nextInt();
        int[] ar=new int[N];
        for(int i=0;i<N;i++)
        {
            ar[i]=fs.nextInt();
        }
        System.out.println(solve(0 ,0, ar, N));
    }
  
    public static int solve(int day, int skip, int[] a, int tday) 
    {
        
        if (day == tday) return 0;
        
        int take = a[day] + solve(day + 1, 0, a, tday);
        
        int notTake = Integer.MAX_VALUE;
        
        if (skip < 2) {
            notTake = solve(day + 1, skip + 1, a, tday);
        }
        return Math.min(take, notTake);
    }
}


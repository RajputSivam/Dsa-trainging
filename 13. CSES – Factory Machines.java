import java.io.*;
import java.util.*;

public class Main {

    // ---------- FAST SCANNER ----------
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
      

        int n=fs.nextInt();// no. of machines
        int t=fs.nextInt();// no. of products
        long [] cos=new long[n+1];

        for(int i=0;i<n;i++)
        {
            cos[i]=fs.nextInt();
        }
        long l=0;
        long r=(int)1e9;
        long ans=0;
        long sm=0;
        while(l<=r)
        {
            sm=0;
            long md=l+(r-l)/2;
            for(int i=0;i<n;i++)
            {
                sm+=md/cos[i];
                if( sm>=t)
                {
                    break;
                }
            }

            if( sm>=t)
            {
                ans=md;
                r=md-1;
            }
            else
            {
                l=md+1;
            }
        }
        System.out.println(ans);
    }
}
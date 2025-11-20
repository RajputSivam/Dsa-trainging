// public class demo {
//     public static void  wirednumber(int n)
//     {
//         System.out.print(n);
//         if( n<=1)
//         {
//             return;
//         }
//         else if( n%2==0)
//         {
//             wirednumber(n/2);
//         }else
//         {
//             wirednumber(n*3+1); 
//         }
//     }
//     public static void main(String[] args) {
//         int n=3;
//         wirednumber( n);
//     }
    
// }

//reverse stack

import java.util.*;
import java.util.List;

public class demo
{
//     public static void sort(ArrayList<Integer> ar)
//     {
//         if( ar.size()==1)
//         {
//             return;
//         }
//         int last=ar.remove(ar.size()-1);
//         sort(ar);
//         insert(ar,last);
//     }
//     public static void insert(ArrayList<Integer> ar,int val)
//     {
//         if( ar.size()==0 || ar.get(ar.size()-1)<=val )
//         {
//             ar.add(val);
//             return;
//         }
//         int x=ar.remove(ar.size()-1);
//         insert(ar, val);
//         ar.add(x);
//     }



    public static   void sort(List<Integer>ar )
    {
        if( ar.size()<=1)
        {
            return ;
        }
        int last=ar.remove(ar.size()-1);
        sort(ar);
        insert(ar,last);
    }
    public static void insert(List<Integer>ar,int last)
    {
        if( ar.size()==0 || ar.get( ar.size()-1 )<=last)
        {
            ar.add(last);
            return;
        }
        int x=ar.remove(ar.size()-1);
        insert(ar, last);
        ar.add(x);
        return;

    }

    public static void main(String[] args)
    {
        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(3);
        ar.add(1);
        ar.add(0);
        System.out.print(ar);
        sort( ar);
        System.out.print(ar);
    }
}
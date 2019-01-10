import java.util.Arrays;

/**
 * Add to the BinarySearch test client the ability 
 */

 public class Exercise23{
     public static void main(String[] args) {
         In in =new In(args[0]);
         int[] whitelist = in.readAllInts();;
         Arrays.sort(whitelist);
         while(!StdIn.isEmpty()){
             int key = StdIn.readInt();
             if(rank(key, whitelist, 0, whitelist.length-1)<0){
                 System.out.printf("-%d\n", key);
             }else{
                 System.out.printf("+%d\n", key);
             }
         }
     }
     private static int rank(int key,int[] a,int lo,int hi){
         // Array must be sorted
         if(lo>hi) return -1;
         int mid = (lo+hi)/2;
         if(mid>key) return rank(key,a,lo,mid-1);
         if(mid<key) return rank(key,a,mid+1,hi);
         return mid;
     }
 }
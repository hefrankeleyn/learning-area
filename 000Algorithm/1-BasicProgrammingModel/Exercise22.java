/**
 * Write a version fof BinarySearch 
 */

public class Exercise22{
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        exercise22(2,a,0,5,0);
    }
    private static int exercise22(int key,int[] a,int lo,int hi,int depth){
        if(depth<0){
            depth=0;
        }
        int i=0;
        String indentStr = " ";
        while(i<depth){
            indentStr+=" ";
            i++;
        }
        System.out.println(indentStr+lo+","+hi);
        if(lo>hi) return -1;
        int mid = (lo+hi)/2;
        if(a[mid]>key) return exercise22(key,a,lo,mid-1,depth+1);
        if(a[mid]<key) return exercise22(key, a, key+1, hi,depth+1);
        else           return mid;
    }

}
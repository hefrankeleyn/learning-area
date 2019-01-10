import java.util.Arrays;

class IntersectionOfTwoArrays{

	public int[] intersect(int[] nums1,int[] nums2){
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		this.ospArray(nums1);
		this.ospArray(nums2);
		StringBuilder sb=new StringBuilder();
		int x=0;
		for(int i=0;i<nums2.length;i++){
			System.out.println("i:"+i);
			System.out.println(x);
			for(int j=x;j<nums1.length;j++){
				if(nums2[i]==nums1[j]){
					sb.append(nums2[i]+",");
					x+=1;
					break;
				}else if(nums2[i]>nums1[j]){
					x+=1;
				}else{
					break;
				}
			}
		}
		String sbToStr=sb.toString();
		if(!sbToStr.trim().equals("")){
			String[] strArray=sbToStr.split(",");
			int[] resultArray=new int[strArray.length];
			for(int i=0;i<strArray.length;i++){
				resultArray[i]=Integer.parseInt(strArray[i]);
			}
			return resultArray;
		}else{
			return new int[0];
		}
	}
	
	public static void main(String[] args){
		//int[] a=new int[]{1,2,5,4,3,9,11,15,13,10};
		//int[] b=new int[]{11,2,5,4};
		int[] a=new int[]{4,9,5};
		int[] b=new int[]{9,4,9,8,4};
		IntersectionOfTwoArrays arrayObj=new IntersectionOfTwoArrays();
		int[] reslutArray=arrayObj.intersect(a,b);
		System.out.println("**result such as:");
		arrayObj.ospArray(reslutArray);
	}
	public void ospArray(int[] numArray){
		for(int i=0;i<numArray.length;i++){
			if(i==numArray.length-1){
				System.out.println(numArray[i]);
			}else{
				System.out.print(numArray[i]+",");
			}
				
		}
	}

}

class RemoveDuplicates{
	
	public static void main(String[] args){
		
		RemoveDuplicates removeDuplicates=new RemoveDuplicates();
		//removeDuplicates.showFor();
		//int[] array01=new int[]{11,2,3,4,5,6,91,21};
		int[] array01=new int[]{1,1,2,2,3,3,4,4,5,6,6,91,91};
		removeDuplicates.showFor(array01);
		int a = removeDuplicates.showIndex(array01);
		System.out.println(a);
		removeDuplicates.showFor(array01);
	}
	public void showFor(int[] array01){
		//int[] array01=new int[]{1,2,3,4,5,6,91,21};
		for(int n :array01)
			System.out.print(n+",");
		System.out.println();
		
	}
	public int showIndex(int[] nums){
		int i = nums.length > 0 ? 1 : 0;
		for(int n : nums)
			if (n > nums[i-1])
				nums[i++]=n;
		return i;
		
	}
}
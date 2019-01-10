class PlusOne{

	public static void main(String[] args){
		PlusOne plusOne=new PlusOne();
		
		
		//int[] array01={1,2,3,4,5};
		//int[] array01={9,8,7,6,5,4,3,2,1,0};
		int[] array01={9};
		/*
		int[] array02=plusOne.plusOne(array01);
		plusOne.printArray(array01);
		plusOne.printArray(array02);
		*/
		int[] res=plusOne.solution02(array01);
		System.out.println(res.length);
		plusOne.printArray(res);
	}
	
	public int[] solution02(int[] digits){
		int[] temRes = new int[digits.length+1];
		for(int i=digits.length-1;i>=0;i--){
			temRes[i+1]=digits[i];
		}
		for(int i=temRes.length-1;i>=0;i--){
			int lastVPlusOne = temRes[i]+1;
			if (lastVPlusOne==10){
				temRes[i]=0;
				continue;
			}else{
				temRes[i]=lastVPlusOne;
				break;
			}
		}
		if(temRes[0]==0){
			for(int i=0;i<digits.length;i++){
				digits[i]=temRes[i+1];
			}
			return digits;
		}
		return temRes;
	}
	
	
	public void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
			if(i!=array.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}
	public int[] plusOne(int[] digits){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<digits.length;i++){
			sb.append(digits[i]+"");
		}
		int result=Integer.parseInt(sb.toString());
		int result02=result+1;
		int len=(result02+"").length();
		int[] res = new int[len];
		for(int i=0;i<len;i++){
			String temStr = (result02+"").substring(i,len);
			int temInt = Integer.parseInt(temStr);
			res[i] = temInt/tenMi(temStr.length());
		}
		return res;
	}
	public int tenMi(int num){
		int result=1;
		for(int i=1;i<num;i++){
			result*=10;
		}
		return result;
	}
}
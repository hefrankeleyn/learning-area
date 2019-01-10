public class ReverseStringQuestion{

	public static void main(String[] args){
		String s = "I have a dream.";
		System.out.println("s:"+s);
		
		ReverseStringQuestion rObj = new ReverseStringQuestion();
		String resultS = rObj.reverseString(s);
		System.out.println("resultS:"+resultS);
	}
	
	private String reverseString(String s){
		byte[] ba = s.getBytes();
		for(int i=0,j=ba.length-1;i<j;i++,j--){
			byte tb = ba[i];
			ba[i] = ba[j];
			ba[j] = tb;
		}
		return new String(ba);
	}
}
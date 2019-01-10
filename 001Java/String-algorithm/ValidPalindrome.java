public class ValidPalindrome{
    public static void main(String[] args) {
        char c = 'a';
        String s= "A man, a plan, a canal: Panama";
        System.out.println(s);
        String sc = ValidPalindrome.removeFalseAlphanumeric(s);
        System.out.println(sc);
        String rs = ValidPalindrome.reverseString(s);
        System.out.println(rs);
        String result = ValidPalindrome.removeFalseAlphanumeric(rs);
        System.out.println(result);
        System.out.println(sc.equals(result));
        
    }
    // 将数字字母以外的字符去掉,并全部转换成小写
    private static String removeFalseAlphanumeric(String s){
        return s.trim().replaceAll("\\W", "").replaceAll("_","").toLowerCase();
    }
    // 将字符串反转过来
    private static String reverseString(String s){
        byte[] tb = s.getBytes();
        for(int i=0,j=tb.length-1;i<j;i++,j--){
            byte b = tb[i];
            tb[i]=tb[j];
            tb[j]=b;
        }
        return new String(tb);
    }
}
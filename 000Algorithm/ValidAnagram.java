import java.util.Arrays;

public class ValidAnagram{
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "abc";
        String t = "cba";
        boolean r = va.solution(s, t);
        System.out.println(r);
    }

    private boolean solution(String s,String t){
        String sc = strSort(s);
        String tc = strSort(t);
        return sc.equals(tc);
    }

    // 将字符串排序
    private String strSort(String str){
        if(str.trim().equals("")){
            return "";
        }
        // 将空格替换掉
        String sr = str.replaceAll(" ", "");
        byte[] b=sr.getBytes();
        Arrays.sort(b);
        return new String(b);
    }
}
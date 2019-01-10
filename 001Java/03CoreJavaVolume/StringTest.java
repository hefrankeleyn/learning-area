public class StringTest{
    public static void main(String[] args) {
        //codePointTest();
        //showCodePoint();
        //printCodePoint();
        fromLastLoopCodePoint();
    }
    // 从后往前操作，遍历字符串，并查看每一个码点
    private static void fromLastLoopCodePoint(){
        String str01="\uD835\uDD46";
        String str02 = str01+"hello"+str01+"World";
        // 代码单元的长度
        int codeUtilLen=str02.length();
        for(int i=codeUtilLen;i>0;){
            i--;
            if(Character.isSurrogate(str02.charAt(i))) i--;

            System.out.println("i: "+i);
            // 码点的十进制
            int cp = str02.codePointAt(i);
            //码点的十六进制
            String cpHex = Integer.toHexString(cp);
            System.out.println(cp+" , "+cpHex);
        }
    }
    // 遍历一个字符串并查看每一个码点
    private static void printCodePoint(){
        String str01="\uD835\uDD46";
        String str02 = str01+"hello"+str01+"World";
        int i=0;
        // 判断i是否小于str02的代码单元长度
        while(i<str02.length()){
            System.out.println("i: "+i);
            // 码点的十进制表示
            int cp = str02.codePointAt(i);
            // 码点的十六进制表示
            String cpHex = Integer.toHexString(cp);
            System.out.println(cp+" , "+cpHex);
            // 判断是否为补充码点，如果是补充码点就加2，如果不是补充码点就加1
            if(Character.isSupplementaryCodePoint(cp)) i+=2;
            else i++;
        }
    }
    // 以此打印码点
    private static void showCodePoint(){
        //String str01="\u1D546";
        String str01="\uD835\uDD46";
        try {
            // 将Unicode字符转为UTF-8格式
            byte[] b = str01.getBytes("UTF-8");
            String rb = new String(b,"UTF-8");
            // 为rb拼接一些内容
            rb = rb+"abc";
            // 打印rb的内容
            System.out.println(rb);
            // 打印rb的代码单元长度
            System.out.println(rb.length());
            // 打印rb的码点长度
            int codePointLen = rb.codePointCount(0, rb.length());
            System.out.println(codePointLen);
            System.out.println("*******************");
            // 根据码点长度，遍历各个码点
            for(int i=0;i<codePointLen;i++){
                // 码点的偏移量
                int index = rb.offsetByCodePoints(0, i);
                System.out.println(index);
                // 码点的十进制表示
                int cp = rb.codePointAt(index);
                // 码点的十六进制表示
                String cpHex = Integer.toHexString(cp);
                System.out.println(cp+" , "+cpHex);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private static void codePointTest(){
        String greeting = "Hello";
        String specialChar = "𝕆";
        
        System.out.println("你好");
        // 代码单元的数据
        int n = greeting.length();
        int n2 = specialChar.length();
        System.out.println(n+" , "+n2);
        // 码点的数量
        int cpCount = greeting.codePointCount(0, greeting.length());
        int cpCount2 = specialChar.codePointCount(0, specialChar.length());
        System.out.println(cpCount+" , "+cpCount2);
        // 第n位置的代码单元
        char first = greeting.charAt(0);
        char first02 = specialChar.charAt(0);
        // H,饾
        System.out.println(first+","+first02);
        //第i个码点
        int index = greeting.offsetByCodePoints(0, 1);
        int cp = greeting.codePointAt(index);
        int index02 = specialChar.offsetByCodePoints(0, 1);
        System.out.println(index02);
        int cp02 = specialChar.codePointAt(index02);
        System.out.println("码点：");
        System.out.println(cp+" , "+cp02);
        //
        String sub = greeting.substring(0, 1);
        String sub02 = specialChar.substring(0, 2);
        /*
        try{
            byte[] b = sub02.getBytes("UTF-16");
            String conver02 = new String(b,"UTF-16");
            System.out.println(conver02.length()+" , "+sub02.length());
            System.out.println(conver02.codePointCount(0, conver02.length()));
            System.out.println(conver02);
            System.out.println("*****");
            System.out.println(sub+" , "+conver02);
        }catch(Exception e){
            System.err.println(e);
        }
        */
        
    }
}
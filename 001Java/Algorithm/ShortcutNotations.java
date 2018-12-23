public class ShortcutNotations{
    public static void main(String[] args) {
        ShortcutNotations.implicitAssignments();;
    }

    private static void implicitAssignments(){
        int leftA = 10;
        int rightA = 10;
        int x = leftA--;
        int y = --leftA;
        System.out.println("x:"+x+", y:"+y);
        //System.out.println("leftA:"+leftA);
        //System.out.println("rightA:"+rightA);
    }
}
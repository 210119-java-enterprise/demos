public class Hawk extends Raptor{
    static {
        System.out.println("b1");
    }
    public Hawk(){
    }
    {
        System.out.println("b3");
    }
    public static void main(){
        System.out.println("b2");
    }
}

//b3, r1, r4, init, b1, r5, r3,b2,r2, hawk

import com.revature.classloading.Bird;

public class Raptor extends Bird {

    static {
        System.out.println("r1");
    }

    Raptor() {

        System.out.println("r2");
    }

    // You would not really ever have more than one non-static init block
    {
        System.out.println("r5");
    }

    {
        System.out.println("r3");
    }

    static {
        System.out.println("r4");
    }

}
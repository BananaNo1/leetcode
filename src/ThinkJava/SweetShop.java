package ThinkJava;

import java.util.Stack;

/**
 * @ClassName SweetShop
 * @Description TODO
 * @Author leis
 * @Date 2019/8/14 11:05
 * @Version 1.0
 **/

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {

    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {

        Class intClass = int.class;
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;
        intClass = double.class;



        //  integerClass= double.class;

        System.out.println(Candy.class);
    }
}

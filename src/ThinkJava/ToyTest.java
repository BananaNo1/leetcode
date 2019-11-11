package ThinkJava;

/**
 * @ClassName ToyTest
 * @Description TODO
 * @Author leis
 * @Date 2019/8/14 11:17
 * @Version 1.0
 **/
interface HaseBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
   /* Toy() {
    }*/

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HaseBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + "is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canoical name: " + cc.getCanonicalName());
        System.out.println("*****************************");
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ThinkJava.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class anInterface : c.getInterfaces()) {
            printInfo(anInterface);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

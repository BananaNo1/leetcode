public class Singleton1 {

    private static class SingleInner {
        private static final Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingleInner.instance;
    }

    private Singleton1() {
    }
}

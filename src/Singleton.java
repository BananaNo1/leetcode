public class Singleton {

    private Singleton() {
    }

    /**
     * 双重检查
     */
    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类
     */
    private static class SingletonInner {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance1() {
        return SingletonInner.instance;
    }

}

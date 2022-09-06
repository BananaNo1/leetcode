public class Singleton2 {

    private enum SingletonEnum {
        INSTANCE;

        private final Singleton2 instance;

        SingletonEnum() {
            instance = new Singleton2();
        }

        private Singleton2 getInstance() {
            return instance;
        }
    }

    public static Singleton2 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }


}

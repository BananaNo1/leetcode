package ThinkJava;

public final class TSData {

    private final int intData;

    public TSData(int d) {
        intData = d;
    }

    public TSData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "TSData{" +
                "intData=" + intData +
                '}';
    }
}

package simple;

public class s492 {

    public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }


    public static void main(String[] args) {
        int[] res = constructRectangle(10);
        System.out.println(res[0] + "*" + res[1]);
    }
}

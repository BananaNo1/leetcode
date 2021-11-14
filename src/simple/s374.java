package simple;

public class s374 {


    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(guess(mid)==-1){
                right=mid-1;
            }else if(guess(mid)==1){
                left=mid+1;
            }else
                return mid;
        }
        return 0;
    }

    public int guess(int n) {
        return 0;
    }

    public static void main(String[] args) {

    }
}

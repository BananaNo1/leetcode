package medium;

/**
 * @ClassName Convert
 * @Description
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * @Author leis
 * @Date 2019/11/21 18:10
 * @Version 1.0
 **/
public class Convert {

    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb =new StringBuilder();
        int len=s.length();
        int step = 2*numRows-2;
        for(int i=0;i<numRows;i++){
            for(int j=0;j+i<len;j=j+step){
                    sb.append(s.charAt(j+i));
                    if(i!=0&&i!=numRows-1&&j+step-i<len){
                            sb.append(s.charAt(j+step-i));
                    }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s ="LEETCODEISHIRING";
        System.out.println(convert(s, 3));
    }

}

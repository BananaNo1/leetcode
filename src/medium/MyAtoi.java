package medium;

/**
 * @ClassName MyAtoi
 * @Description
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * @Author leis
 * @Date 2019/11/25 17:46
 * @Version 1.0
 **/
public class MyAtoi {
    // 越界問題
    public static int myAtoi(String str) {
        if(str.equals("")){
            return 0;
        }
        int sum =0;
        int flag=1;
        int i=0;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                continue;
            }else{
                break;
            }
        }
         if(i==str.length()){
             return 0;
         }
         char ch =str.charAt(i);
         if(ch=='+'){
             i++;
         }else if(ch=='-'){
             flag=-1;
             i++;
         }
         for(;i<str.length();i++){
             ch =str.charAt(i);
             if(ch<'0'||ch>'9'){
                break;
             }
             if(flag>0&&sum>Integer.MAX_VALUE/10){
                return Integer.MAX_VALUE;
             }else if(flag>0&&sum ==Integer.MAX_VALUE/10&&ch-'0'>Integer.MAX_VALUE%10){
                return Integer.MAX_VALUE;
             }else if(flag<0&&-sum<Integer.MIN_VALUE/10){
                 return Integer.MIN_VALUE;
             }else if(flag<0&&-sum==Integer.MIN_VALUE/10 && -(ch-'0')<Integer.MIN_VALUE%10){
                return Integer.MIN_VALUE;
             }
             sum =sum *10+ch-'0';
         }

        return sum*flag;
    }

    public static void main(String[] args) {
        String s =" ";
        myAtoi(s);
        //        String str="42";
//        System.out.println(myAtoi(str));
//        String str1="   -42";
//        System.out.println(myAtoi(str1));
//        String str2="4193 with words";
//        System.out.println(myAtoi(str2));
//        String str3="words and 987";
//        System.out.println(myAtoi(str3));
//        String str4="-91283472332";
//        System.out.println(myAtoi(str4));
//        System.out.println(-0&11);
    }
}

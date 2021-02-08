package simple;

/**
 * @Descirption
 *
 *  将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * @author leis
 * @date 2021/1/16 15:44
 */
 
import java.util.LinkedList;

public class SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return partition(nums,0,nums.length-1);
    }

    public TreeNode partition(int[] nums, int low, int high) {
        if(low>high){
            return null;
        }
        int mid = (low +high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=partition(nums,low,mid-1);
        root.right=partition(nums,mid+1,high);
        return root;
    }


    public static void main(String[] args) {

    }

}

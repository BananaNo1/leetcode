package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        find(ans, candidates, cur, target, 0);
        return ans;
    }

    public static void find(List<List<Integer>> ans, int[] candidates, List<Integer> cur, int target, int pos) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > pos && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                find(ans, candidates, cur, target - candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(candidates, target);
        System.out.println(ans);
    }
}

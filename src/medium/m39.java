package medium;

import java.util.LinkedList;
import java.util.List;

public class m39 {

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        find1(ans, candidates, target, list, 0);
        return ans;
    }

    public static void find1(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int current) {
        if (current == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        find1(ans, candidates, target, list, current + 1);
        if (target - candidates[current] >= 0) {
            list.add(candidates[current]);
            find1(ans, candidates, target - candidates[current], list, current);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        dfs(ans, candidates, target, cur, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, int[] candidates, int target, List<Integer> cur, int pos) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                cur.add(candidates[i]);
                dfs(ans, candidates, target - candidates[i], cur, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = combinationSum2(candidates, target);
        System.out.println(ans);
    }
}

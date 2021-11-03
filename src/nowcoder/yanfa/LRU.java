package nowcoder.yanfa;

import java.util.*;

/**
 * @author leis
 * @Descirption 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * @date 2021/3/10 15:00
 */

public class LRU {

    public int[] LRU(int[][] operators, int k) {
        // write code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int[] operator : operators) {
            int key = operator[1];
            switch (operator[0]) {
                case 1:
                    int value = operator[2];
                    if (map.size() < k) {
                        map.put(key, value);
                    } else {
                        Iterator it = map.keySet().iterator();
                        map.remove(it.next());
                        map.put(key, value);
                    }
                    break;
                case 2:
                    if (map.containsKey(key)) {
                        int val = map.get(key);
                        list.add(val);
                        map.remove(key);
                        map.put(key, val);
                    } else {
                        list.add(-1);
                    }
                    break;
                default:
                    break;

            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int val : list) {
            res[i++] = val;
        }
        return res;
    }


}

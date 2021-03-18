package Test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;


class Test1 {
    static Integer a[] = null;

    public static void main(String[] args) {
        int a[] = new int[]{8, 2};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(10, 2);
        map.put(5, 2);
        map.put(9, 2);
        map.put(0, 2);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());


    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int longestSubarray2(int[] nums, int limit) {
        PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int res = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            max.offer(new int[]{nums[i], i});
            min.offer(new int[]{nums[i], i});
            while (!max.isEmpty() && !min.isEmpty() && Math.abs(max.peek()[0] - min.peek()[0]) > limit) {
                if (max.peek()[1] <= left) max.poll();
                if (min.poll()[1] <= left) min.poll();
            }
            res = Math.max(i - left + 1, res);
        }
        return res;

    }

    public int longestSubarray3(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty() && nums[max.getLast()] < nums[i]) {
                max.removeLast();
            }
            while (!min.isEmpty() && nums[min.getLast()] > nums[i]) {
                min.removeLast();
            }
            max.offerLast(nums[i]);
            min.offerLast(nums[i]);
            while (!max.isEmpty() && !min.isEmpty() && nums[max.peek()] - nums[min.peek()] > limit) {
                if (max.peek() <= left) max.poll();
                if (min.peek() <= left) min.peek();
                left++;
            }
            res = Math.max(res, i - left + 1);

        }
        return res;
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = word1.length();
        int len2 = word2.length();
        int a = 0;
        if (len < len2) {
            a = len;
        } else {
            a = len2;
        }
        for (int i = 0; i < a; i++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));
        }
        if (len < len2)
            stringBuilder.append(word2.substring(len, word2.length()));
        if (len > len2)
            stringBuilder.append(word1.substring(len, word1.length()));

        return stringBuilder.toString();
    }

    public int[] minOperations(String boxes) {
        char ch[] = boxes.toCharArray();
        int res[] = new int[boxes.length()];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (ch[j] == '1' && j != i) {
                    res[i] += j - i;
                }
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int count = 1;
        int res = 0;
        while (right < len) {
            count *= nums[right];
            while (count >= k) {
                count /= nums[left];
                left++;
                res++;
            }
            res++;
            right++;
        }
        res += len - left;
        return res;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int left = 0;
        int right = 0;
        int count = 0;
        int len = A.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        while (left < len) {
            if (right != 0) {
                if (map.get(A[left]) > 1) {
                    map.put(A[left], map.get(A[left]) - 1);
                    //res++;
                } else {
                    map.remove(A[left]);
                    count--;
                }
                left++;
                if (count == K) res++;
            }
            while (right < len && (count < K || map.containsKey(A[right]))) {
                map.put(A[right], map.getOrDefault((A[right]), 0) + 1);
                if (map.get(A[right]) == 1) {
                    count++;
                }
                if (count == K) {
                    res++;
                }
                right++;
                if (right < len && count == K && !map.containsKey(A[right])) break;
            }
            //  left++;
        }
        return res;

    }

    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int count = 0;
        int res = 0;
        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = Math.abs(s.charAt(i) - t.charAt(i));
            System.out.print(dp[i] + " ");
        }
        while (left < s.length()) {
            if (left != 0) {
                count -= dp[left - 1];
            }
            while (right < s.length() && count + dp[right] <= maxCost) {
                count += dp[right];
                right++;
            }
            System.out.print(right + " " + left);
            res = Math.max(res, right - left);
            left++;
        }
        return res;
    }

    int mod = 1000000007;

    public int countPairs(int[] deliciousness) {
        int count = 0;
        int dp[] = new int[10000000];
        int d = 1;
        for (int i = 1; i <= 21; i++) {
            d = d * 2;
            dp[d] = 1;
            System.out.println(d);
        }
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (isPowerOfTwo(sum)) {
                    System.out.println(sum);
                    count = (count + 1) % mod;
                }
            }
        }
        return count % mod;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        Arrays.fill(left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) left[i] += left[i - 1];
            else left[i] = 1;
        }
        int right = 1, res = 0;
        for (int i = ratings.length - 1; i > 0; i++) {
            System.out.print(i);
            if (ratings[i] > ratings[i - 1]) right++;
            else right = 1;
            res += Math.max(right, left[i]);
        }
        return res;
    }

    public char findTheDifference(String s, String t) {
        int len = s.length();
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        for (int i = 0; i < len; i++) {
            hash1[s.charAt(i) - 'a']++;
            hash2[t.charAt(i) - 'a']++;
        }
        hash2[t.charAt(len) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (hash1[i] != hash2[i]) return (char) (i + 'a');
        }
        return 'a';
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int solve(int n, int[] a) {
        // write code here
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(a);
        dfs(a, 0, list, 0);
        return max - min;
    }

    void dfs(int[] nums, int left, LinkedList<Integer> list, int sum) {
        if (list.size() == 3) {
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            if (valid(a, b, c)) {
                max = Math.max(max, sum);
                min = Math.min(min, sum);

            }
        }
        for (int i = left; i < nums.length; i++) {
            list.offer(nums[i]);
            if (list.size() == 3 && sum < nums[i]) {
                list.removeLast();
                break;
            }
            dfs(nums, i + 1, list, sum + nums[i]);
            list.removeLast();
        }
    }

    boolean valid(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }

}

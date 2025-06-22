class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    Map<Integer, ArrayList<Integer>> memo = new HashMap<>();

    public ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = solve(i, arr, memo);
            if (temp.size() >= res.size()) {
                res = temp;
            }
        }
        return res;
    }

    ArrayList<Integer> solve(int index, int[] arr, Map<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        ArrayList<Integer> maxSubset = new ArrayList<>();
        maxSubset.add(arr[index]);

        for (int j = index + 1; j < arr.length; j++) {
            if (arr[j] % arr[index] == 0) {
                ArrayList<Integer> subset = solve(j, arr, memo);
                if (subset.size() >= maxSubset.size() - 1) {
                    maxSubset = new ArrayList<>();
                    maxSubset.add(arr[index]);
                    maxSubset.addAll(subset);
                }
            }
        }

        memo.put(index, maxSubset);
        return maxSubset;
    }
}
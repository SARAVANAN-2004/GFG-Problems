class Solution {
    public boolean validgroup(int[] arr, int k) {
    int n = arr.length;
    if(n % k != 0) return false;

    Arrays.sort(arr);  // sort the array
    int max = arr[arr.length - 1];
    
    // frequency map
    int[] map = new int[max + 1];
    for(int num : arr) {
        map[num]++;
    }

    // Try to group from smallest number
    for(int i = 0; i <= max; i++) {
        while(map[i] > 0) {
            int freq = map[i];
            // Check if k consecutive numbers are available
            for(int j = i; j < i + k; j++) {
                if(j > max || map[j] < freq) {
                    return false;
                }
                map[j] -= freq;
            }
        }
    }

    return true;
}

}
class Solution {
    public static String caseSort(String s) {
        // code here
        char[] arr = s.toCharArray();
        List<Character> up = new ArrayList<>();
        List<Character> low = new ArrayList<>();
        for(char ch:arr){
            if(Character.isUpperCase(ch)){
                up.add(ch);
            }else{
                low.add(ch);
            }
        }
        Collections.sort(up);
        Collections.sort(low);
        int u = 0, l = 0;
        for(int i = 0;i<arr.length;i++){
            if(Character.isUpperCase(arr[i])){
                arr[i] = up.get(u++);
            }else{
                arr[i] = low.get(l++);
            }
        }
        return String.valueOf(arr);
    }
}
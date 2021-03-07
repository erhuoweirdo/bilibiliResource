public class Solution {
    public int[] printNumbers(int n) {
        int length = (int) Math.pow(10, n) - 1;
        int[] result= new int[length];
        for (int i = 1; i <= length; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}

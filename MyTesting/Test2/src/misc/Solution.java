package misc;

import java.util.Arrays;

class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[0]);
    }
    
    public int solution(int[] A) {
        
        int ret = 1;
        
        // initial checking
        if (A == null || A.length < 1) {
            return ret;
        }
        
        // sort the array
        Arrays.sort(A);
        
        // find the smallest int
        for (int i = 0, j=1 ; i < A[A.length-1] ; i++) {
            if (j == A[i]) {
                ret = ++j;
                continue;
            } else if (j < A[i]){
                return j;
            }
        }
        
        return ret;
        
    }
}

public class MaxSum{
    public int maxArray(int[] input) {
        int max = input[0];
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > max)
                max = input[i];
        }
        return max;
    }

    public int maxsubSlow(int[] input) {
        int m = 0; // the maximum found so far
        for (int j = 0; j < input.length; j++) {
            for (int k = j; k < input.length; k++) {
                int s = 0;
                for (int i = j; i < k; i++) {
                    s = s + input[i];
                    if (s > m)
                        m = s;
                }
            }
        }

        return m;
    }

    public int maxSubFaster(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n + 1]; // Prefix sum array
        
        int S = 0; // the initial prefix sum
        for (int i = 1; i <= n; i++) {
            S = S + A[i - 1];
            prefixSum[i] = S;
        }
        
        int m = 0; // the maximum found so far
        for (int j = 1; j <= n; j++) {
            for (int k = j; k <= n; k++) {
                int s = prefixSum[k] - prefixSum[j - 1];
                if (s > m) {
                    m = s;
                }
            }
        }
        
        return m;
    }
    public int maxSubFastest(int[] A) {

        int mStart = 0; // the initial prefix maximum
        int mMax = 0;  // the maximum found so far
        
        for (int t = 1; t < A.length; t++) {
            mStart = Math.max(0, mStart + A[t - 1]);
            mMax = Math.max(mMax, mStart);
        }
        
        return mMax;
    }

}
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i=0;i<=n;i++){
            int countBits = 0;
            int num = i;

            while(num!=0){
                
                if((num & 1) == 1){
                    countBits++;
                }

                num = num >> 1;
            }

            arr[i] = countBits;

        }
        return arr;
    }
}

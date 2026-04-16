class Solution {
    public int getSum(int a, int b) {
        
        int result = 0;
        int carry = 0;
        
        for (int i = 0; i < 32; i++) {
            int lastBit1 = a & 1;
            int lastBit2 = b & 1;

            int sum = lastBit1 + lastBit2 + carry;

            // Set the ith bit in result
            if (sum % 2 == 1) {
                result = result | (1 << i);
            }

            // Update carry
            carry = sum / 2;

            // Shift a and b to process next bits
            a = a >> 1;
            b = b >> 1;
        }

        return result;
    }
}
class Solution {
    public int smallestNumber(int n, int t) {
        int result = n;

        while (digitProduct(result) % t != 0) {
            result++;
        }

        return result;
    }

    private int digitProduct(int number) {
        int product = 1;

        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }

        return product;
    }
}

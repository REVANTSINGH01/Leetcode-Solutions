/**
 *        PROBLEM: PRODUCT OF THE LAST K NUMBERS
 * 
 * Implement a class `ProductOfNumbers` that supports two operations:
 * 1. `add(int num)`: Appends the integer `num` to the stream.
 * 2. `getProduct(int k)`: Returns the product of the last `k` numbers in the stream.
 * 
 * If at any point `0` is added, the previous products become invalid,
 * so we reset the product list.
 * 
 * Example:
 * Input:
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);
 * productOfNumbers.add(0);
 * productOfNumbers.add(2);
 * productOfNumbers.add(5);
 * productOfNumbers.add(4);
 * System.out.println(productOfNumbers.getProduct(2)); // Output: 20
 * System.out.println(productOfNumbers.getProduct(3)); // Output: 40
 * System.out.println(productOfNumbers.getProduct(4)); // Output: 0
 * 
 * Time Complexity:
 * - `add(int num)`: O(1)
 * - `getProduct(int k)`: O(1)
 * Space Complexity: O(n)
 */

class ProductOfNumbers {
    List<Integer> list = new ArrayList<>();

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1); // Initialize with 1 to maintain prefix product logic
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1); // Reset the list when 0 is encountered
        } else {
            list.add(num * list.get(list.size() - 1));
        }
    }

    public int getProduct(int k) {
        int size = list.size();
        if (size <= k) return 0; // If k exceeds the available numbers, return 0
        return list.get(size - 1) / list.get(size - k - 1);
    }
}

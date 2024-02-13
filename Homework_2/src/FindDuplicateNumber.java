public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5, 4, 6};

        int duplicate = findDuplicate(nums);

        System.out.println("The repeated number is: " + duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int x = nums[0];
        int y = nums[0];

        do {
            x = nums[x];
            y = nums[nums[y]];
        } while (x != y);

        x = nums[0];
        while (x != y) {
            x = nums[x];
            y = nums[y];
        }

        return x;
    }
}

public class Test702 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.err.println(search(nums , target));
    }


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int index = left + ((right - left) / 2);
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < target) {
                left = index + 1;
                continue;
            }
            if (nums[index] > target) {
                right = index - 1;
                continue;
            }
        }

        return -1;
    }


}

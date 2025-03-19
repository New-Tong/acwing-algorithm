package LeetCode.Hot100.寻找重复数;

/**
 @Author NewTong
 @Date 2025/3/18 -20:39
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    // 类似于环状列表，快慢指针，第一次相遇时一定在环内，然后让slow回到起点，两者同速，再相遇就是环点
    // 映射nums数组为一个链表，i->nums[i]->nums[nums[i]]->......
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

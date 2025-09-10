

LEETCODE ASSIGNMENT





// ================================================
// 1) Reverse Integer
// LeetCode: https://leetcode.com/problems/reverse-integer/
// Reverses digits of an integer and returns 0 if overflow occurs
// ================================================
class Solution1 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before multiplying
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }

            ans = ans * 10 + digit;
            x /= 10;
        }
        return ans;
    }
}

// ================================================
// 2) Longest Substring Without Repeating Characters
// LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Sliding window approach with HashSet
// ================================================
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> strSet = new HashSet<>();
        int l = 0; // left pointer
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            // Shrink the window until no duplicate
            while (strSet.contains(s.charAt(r))) {
                strSet.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r - l + 1);
            strSet.add(s.charAt(r));
        }

        return res;
    }
}

// ================================================
// 3) Longest Palindromic Substring
// LeetCode: https://leetcode.com/problems/longest-palindromic-substring/
// Expand around center approach
// ================================================
class Solution3 {
    public String longestPalindrome(String s) {
        int resLen = 0, resIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            // Even length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}

// ================================================
// 4) Two Sum
// LeetCode: https://leetcode.com/problems/two-sum/
// Uses a HashMap for O(n) solution
// ================================================
class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> verumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (verumMap.containsKey(diff)) {
                return new int[] {verumMap.get(diff), i};
            }

            verumMap.put(num, i);
        }

        return new int[] {}; // return empty array if no solution
    }
}

// ================================================
// 5) Median of Two Sorted Arrays
// LeetCode: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Merge two sorted arrays and find median
// ================================================
class Solution5 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        int p = nums1.length + nums2.length - 1;

        int[] nums = new int[p + 1];

        // Merge arrays from the end
        while (p >= 0) {
            if (p1 >= 0 && (p2 < 0 || nums1[p1] >= nums2[p2])) {
                nums[p] = nums1[p1];
                p1--;
            } else {
                nums[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Compute median
        double median = 0;
        if (nums.length % 2 == 0) {
            median = (nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2.0;
        } else {
            median = nums[nums.length / 2];
        }

        return median;
    }
}

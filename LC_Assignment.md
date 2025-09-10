

LEETCODE ASSIGNMENT





1\)

class Solution

{



&nbsp;   public int reverse(int x) {

&nbsp;       int j = 0;

&nbsp;       while (x != 0) {

&nbsp;           int digit = x % 10;

&nbsp;          

&nbsp;           if (ans > Integer.MAX\_VALUE ||ans < Integer.MIN\_VALUE) {

&nbsp;               return 0;

&nbsp;           }

&nbsp;           j = j\*10 + digit;

&nbsp;           x /= 10;

&nbsp;       }

&nbsp;       return ans;

&nbsp;   }

}



2\)

&nbsp; class Solution {

&nbsp;   public int lengthOfLongestSubstring(String s) {

&nbsp;       HashSet<Character> strset = new HashSet<>();

&nbsp;       int l=0;

&nbsp;       int res=0;

&nbsp;       for(int r=0;r<s.length();r++)

&nbsp;       {

&nbsp;           while(strset.contains(s.charAt(r)))

&nbsp;           {

&nbsp;               strset.remove(s.charAt(l));

&nbsp;               l++;

&nbsp;           }

&nbsp;           res=Math.max(res,r-l+1);

&nbsp;           strset.add(s.charAt(r));

&nbsp;       }

&nbsp;       return res;

&nbsp;3)

&nbsp; 

&nbsp; public class Solution {

&nbsp;   public string LongestPalindrome(string s) {

&nbsp;       int resLen = 0, resIdx = 0;



&nbsp;       for (int i = 0; i < s.Length; i++) {

&nbsp;           

&nbsp;           int l = i, r = i;

&nbsp;           while (l >= 0 \&\& r < s.Length \&\&

&nbsp;                  s\[l] == s\[r]) {

&nbsp;               if (r - l + 1 > resLen) {

&nbsp;                   resIdx = l;

&nbsp;                   resLen = r - l + 1;

&nbsp;               }

&nbsp;               l--;

&nbsp;               r++;

&nbsp;           }



&nbsp;                     l = i;

&nbsp;           r = i + 1;

&nbsp;           while (l >= 0 \&\& r < s.Length \&\&

&nbsp;                  s\[l] == s\[r]) {

&nbsp;               if (r - l + 1 > resLen) {

&nbsp;                   resIdx = l;

&nbsp;                   resLen = r - l + 1;

&nbsp;               }

&nbsp;               l--;

&nbsp;               r++;

&nbsp;           }

&nbsp;       }



&nbsp;       return s.Substring(resIdx, resLen);

&nbsp;   }

}



4\)

&nbsp; class Solution {

&nbsp;   public int\[] twoSum(int\[] nums, int target) {

&nbsp;     HashMap<Integer,Integer> verumMap = new HashMap<>();



&nbsp;    for(int i=0;i<nums.length;i++)

&nbsp;    {

&nbsp;       int num=nums\[i];

&nbsp;       int diff=target-nums\[i];

&nbsp;       if (verumMap.containsKey(diff)){

&nbsp;           return new int\[] {verumMap.get(diff),i};

&nbsp;       }

&nbsp;      

&nbsp;       verumMap.put(num,i);





&nbsp;    }

&nbsp;    return new int\[] {};

&nbsp;   }

}



5\)

&nbsp; 

&nbsp; public class Solution {

&nbsp;   public double FindMedianSortedArrays(int\[] nums1, int\[] nums2) {

&nbsp;       int p1=nums1.Length-1;

&nbsp;       int p2=nums2.Length-1;

&nbsp;       int p=nums1.Length + nums2.Length-1;

&nbsp;       int\[] nums=new int\[p+1];

&nbsp;       while(p>=0)

&nbsp;       {

&nbsp;           if(p1>=0 \&\& (p2<0 ||nums1\[p1]>=nums2\[p2]))

&nbsp;           {

&nbsp;               nums\[p]=nums1\[p1];

&nbsp;               p1--;

&nbsp;               p--;

&nbsp;           }

&nbsp;           else {

&nbsp;               nums\[p]=nums2\[p2];

&nbsp;               p2--;

&nbsp;               p--;

&nbsp;           }

&nbsp;       }

&nbsp;       double median =0;

&nbsp;       if(nums.Length%2==0)

&nbsp;       {

&nbsp;           median=(nums\[nums.Length/2] +nums\[(nums.Length/2)-1])/2.0;

&nbsp;       }else{

&nbsp;           median=nums\[nums.Length/2];

&nbsp;       }

&nbsp;       return median;

&nbsp;   }

}


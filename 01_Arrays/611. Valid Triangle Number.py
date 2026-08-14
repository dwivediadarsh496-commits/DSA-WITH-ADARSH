class Solution(object):
    def triangleNumber(self, nums):
        nums.sort()
        ans = 0
        for k in range(len(nums)-1 , 1 , -1):
            j = k - 1
            i = 0
       
        
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    ans += j - i
                    j -= 1
                else:
                    i += 1

        return ans
            
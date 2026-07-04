class Solution(object):
    def runningSum(self, nums):
        ans =[]
        total = 0
        for nums in nums:
            
            total += nums
            ans.append(total)
        return ans


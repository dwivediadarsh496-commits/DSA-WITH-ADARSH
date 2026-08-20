class Solution(object):
    def findMaxAverage(self, nums, k):
        l = 0
        sumi = 0
        ans = float("-inf")

        for r in range(len(nums)):
            sumi += nums[r]

            if r-l+1 > k:
                sumi -= nums[l]
                l+=1
            if r - l+1 == k:
                ans = max(ans , sumi/float(k))    
                
        return ans         
                
             

        
        
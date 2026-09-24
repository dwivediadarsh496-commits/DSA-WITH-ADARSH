class Solution(object):
    def longestSubarray(self, nums):
        i = 0
        zero_count = 0
        max_ones = 0

        for j in range(len(nums)):
            if nums[j] == 0:
                zero_count += 1
            while zero_count > 1:
                if nums[i] == 0:
                    zero_count -= 1
                i +=1
            max_ones = max(max_ones , j - i) 
        return max_ones           
                   
            
        
        
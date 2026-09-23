class Solution(object):
    def minSubArrayLen(self, target, nums):
        i = 0
        window_sum = 0
        min_length = float('inf')

        for j in range(len(nums)):
            window_sum += nums[j]

            while window_sum >= target:
                min_length = min(min_length , j - i + 1)
                window_sum -= nums[i]
                i += 1
        if min_length == float('inf'):
            return 0
        return min_length           





        
        
        
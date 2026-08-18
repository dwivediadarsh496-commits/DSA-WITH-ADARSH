class Solution(object):
    def largestInteger(self, nums, k):

        n = len(nums)

        
        if k == 1:
            count = {}

            for x in nums:
                count[x] = count.get(x, 0) + 1

            ans = -1

            for x in nums:
                if count[x] == 1:
                    ans = max(ans, x)

            return ans

        
        if k == n:
            return max(nums)

        
        count = {}

        for x in nums:
            count[x] = count.get(x, 0) + 1

        ans = -1

        if count[nums[0]] == 1:
            ans = max(ans, nums[0])

        if count[nums[-1]] == 1:
            ans = max(ans, nums[-1])

        return ans
        
class Solution(object):
    def shuffle(self, nums, n):
        ans = []
        i = 0
        j = n
        while i < n:
            ans.append(nums[i])
            ans.append(nums[j])
            i+=1
            j+=1
        return ans 
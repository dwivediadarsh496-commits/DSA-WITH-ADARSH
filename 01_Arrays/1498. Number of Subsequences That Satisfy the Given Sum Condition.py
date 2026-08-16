class Solution(object):
    def numSubseq(self, nums, target):
        nums.sort()
        i = 0
        j = len(nums)-1
        
        count = 0

        while i<=j:

            if nums[i] + nums[j] <= target :
                count += 2**(j-i)
                i+=1
                
            else :
                j-=1
        return count % (10**9 + 7)         

        



        
        
        
       
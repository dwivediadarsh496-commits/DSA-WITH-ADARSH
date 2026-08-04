class Solution(object):
    def findNumbers(self, nums):
        ans = 0
        for num in nums :
            count =0
            temp = num
            while temp > 0:
                temp = temp//10
                count += 1

            if count % 2 == 0:
                ans+=1
        return ans            
         
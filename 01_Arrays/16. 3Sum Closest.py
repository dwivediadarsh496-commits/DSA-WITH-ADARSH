class Solution(object):
    def threeSumClosest(self, nums, target):
        j=0
        i = 0
        k = len(nums)
        for i in range(len(nums)):
            for j in range(len(nums) - i - 1):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j + 1], nums[j]

        closest = nums[0] + nums[1] + nums[2]

        for i in range(len(nums) - 2):

            j = i + 1
            k = len(nums) - 1

            while j < k:

                total = nums[i] + nums[j] + nums[k]

                
                if abs(total - target) < abs(closest - target):
                    closest = total

                
                if total < target:
                    j += 1

                elif total > target:
                    k -= 1

                else:
                    return total

        return closest   
            



       
        
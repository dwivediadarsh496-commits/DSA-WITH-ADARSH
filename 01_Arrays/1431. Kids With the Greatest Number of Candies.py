class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        maximum = max(candies)
        result=[]
        for i in range(len(candies)):
            if candies[i]+ extraCandies >= maximum:
                result.append(True)
            else:

                result.append(False)
        return result 
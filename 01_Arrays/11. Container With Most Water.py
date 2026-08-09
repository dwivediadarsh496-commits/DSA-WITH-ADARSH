class Solution(object):
    def maxArea(self, height):
        i = 0
        j = len(height) - 1
        maxi = 0

        while i < j :
            area = (j-i) * min(height[i] , height[j])
            maxi = max(maxi , area)
            
            if height[i]<height[j]:
                i+=1
            else :
                j-=1
                
        return maxi        
                


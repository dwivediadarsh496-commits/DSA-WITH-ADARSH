class Solution(object):
    def isPalindrome(self, x):
        
        if x < 0:
            return False

        temp = x
        ans = 0    
        while temp >0:
            last = temp%10
            ans = (ans *10) + last
            temp = temp//10
        if ans == x:
            return True
        else :
            return False    
        
        
        
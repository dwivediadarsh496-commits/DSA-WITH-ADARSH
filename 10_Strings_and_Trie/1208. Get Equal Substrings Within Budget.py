class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        i = 0
        max_len = 0
        cost =  0

        for j in range(len(s)):
            cost += abs(ord(s[j])-ord(t[j]))

            while cost > maxCost:
                cost -= abs(ord(s[i]) -ord(t[i]) )
                i += 1
            max_len = max(max_len , j- i + 1)    
        return max_len
      
        
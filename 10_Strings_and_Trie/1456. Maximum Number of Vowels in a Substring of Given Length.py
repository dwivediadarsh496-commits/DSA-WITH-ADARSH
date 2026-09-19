class Solution(object):
    def maxVowels(self, s, k):
        i = 0
        j = 0
        num_vowel = 0
        max_vowel = 0
        vowel = "aeiou"


        while j <len(s):
            if s[j] in vowel:
                num_vowel +=1

                    
            if j-i+1 == k: 
                max_vowel = max(max_vowel , num_vowel)
                if s[i] in vowel:
                    num_vowel -=1
                i+=1  

            j+=1      
        return max_vowel





       
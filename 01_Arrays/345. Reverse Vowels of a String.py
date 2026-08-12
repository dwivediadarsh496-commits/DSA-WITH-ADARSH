class Solution(object):
    def reverseVowels(self, s):
        
    
        i = 0
        j = len(s) - 1
        s = list(s)

        vowels = "aeiouAEIOU"

        while i < j:

            while i < j and s[i] not in vowels:
                i += 1
            while i < j and s[j] not in vowels:
                j -= 1
            s[i], s[j] = s[j], s[i]

            i += 1
            j -= 1

        return "".join(s)
      
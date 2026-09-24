class Solution(object):
    def checkInclusion(self, s1, s2):
        i = 0
        window_size = len(s1)
        count_s1 = {}
        count_window = {}

        for ch in s1:
            count_s1[ch] = count_s1.get(ch , 0) + 1

        for j in range(len(s2)):    

            count_window[s2[j]] = count_window.get(s2[j], 0) + 1

            if j - i + 1 > window_size:
                count_window[s2[i]] -= 1

                if count_window[s2[i]] == 0:
                    del count_window[s2[i]]

                i += 1

            if count_s1 == count_window:
                return True

        return False
        

        
        
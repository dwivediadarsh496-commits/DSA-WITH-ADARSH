class Solution(object):
    def totalFruit(self, fruits):
        i = 0
        
        max_fruits = 0
        count = {}

        for j in range(len(fruits)):
            
            count[fruits[j]] = count.get(fruits[j], 0) + 1

            while len(count) > 2:
                count[fruits[i]] -=1

                if count[fruits[i]] == 0:
                    del count[fruits[i]]

                i+=1
            max_fruits = max(max_fruits , j - i + 1)        

        return max_fruits    
        
        
        
class Solution(object):
    def maximumWealth(self, accounts):
        max_wealth = 0
        
        for i in range(len(accounts)):
            total_wealth =  0
            

            for j in range(len(accounts[i])):
                total_wealth = total_wealth + accounts[i][j]
            max_wealth = max(max_wealth ,total_wealth) 

        return max_wealth   
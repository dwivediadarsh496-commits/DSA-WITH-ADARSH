class Solution(object):
    def maxSatisfied(self, customers, grumpy, minutes):
        satisfied = 0
        window = 0
        max_extra = 0

        
        for i in range(len(customers)):
            if grumpy[i] == 0:
                satisfied += customers[i]

        
        i = 0

       
        for j in range(len(customers)):

            if grumpy[j] == 1:
                window += customers[j]

            if j - i + 1 > minutes:

                if grumpy[i] == 1:
                    window -= customers[i]

                i += 1

            max_extra = max(max_extra, window)

        return satisfied + max_extra
        
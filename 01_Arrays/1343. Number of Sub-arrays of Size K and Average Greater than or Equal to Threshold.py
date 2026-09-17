class Solution(object):
    def numOfSubarrays(self, arr, k, threshold):
        i = 0
        j = 0
        count = 0
        window_sum = 0

        while j < len(arr):
            window_sum += arr[j]

            if j - i + 1 == k:
                average = window_sum / float(k)

                if average >= threshold:
                    count += 1

                window_sum -= arr[i]
                i += 1

            j += 1

        return count



        
        
class Solution(object):
    def backspaceCompare(self, s, t):

        stackS =[]
        stackT =[]
        for ch in s:
            if ch == "#":
                if stackS:
                    stackS.pop()
                else:
                    stackS.append(ch)
        for ch in t:            
            if ch == "#":
                if stackT:
                    stackT.pop()
                else:
                    stackT.append(ch)
        return stackS == stackT                   
                            
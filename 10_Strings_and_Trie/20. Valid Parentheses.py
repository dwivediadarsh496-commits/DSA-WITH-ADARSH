class Solution(object):
    def isValid(self, s):
        stack = []

        for c in s:
            if c == '(':
                stack.append(')')
            elif c == '{':
                stack.append('}')
            elif c == '[':
                stack.append(']')
            else:
                if not stack or stack[-1] != c:
                    return False
                stack.pop()

        return len(stack) == 0
       
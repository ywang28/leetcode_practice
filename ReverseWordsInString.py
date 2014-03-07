class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        t = s.strip().rsplit()
        t.reverse()
        return " ".join(t)

public class ValidAnagram {
    public boolean anagram(String s, String t) {
        // write your code here
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        for (char c : s.toCharArray()) {
            cntS[c]++;
        }
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (cntS[i] != cntT[i]) {
                return false;
            }
        }
        return true;
    }
}

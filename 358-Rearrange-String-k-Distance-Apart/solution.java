public class Solution {
    class Word {
        int len;
        char character;
        public Word(char character, int len) {
            this.character = character;
            this.len = len;
        }
    }
    public String rearrangeString(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int len = str.length();
        PriorityQueue<Word> pq = new PriorityQueue<Word>((w1, w2) -> (w2.len - w1.len));
        for (Character c : map.keySet()) {
            Word word = new Word(c, map.get(c));
            pq.offer(word);
        }
        StringBuilder res = new StringBuilder();
        Queue<Word> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
           Word word = pq.poll();
           res.append(word.character);
           word.len = word.len - 1;
           queue.offer(word);
           if (queue.size() < k) {
               continue;
           }
           Word frontWord = queue.poll();
           if (frontWord.len > 0) {
               pq.offer(frontWord);
           }
        }
        return res.length() == str.length() ? res.toString() : "";
    }
}
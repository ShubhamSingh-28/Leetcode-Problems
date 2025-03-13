class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public long countOfSubstrings(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // compute index of next consonant for all indices
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            // while we have a valid window, try to shrink it
            while (
                start < word.length() &&
                vowelCount.keySet().size() == 5 &&
                consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }
            end++;
        }

        return numValidSubstrings;
        // this is a brute force approach it solve 
        // HashSet<Character> vowels= new HashSet<>(Arrays.asList('a','e','i','o','u'));
        // int count=0;
        // for(int i=0;i<word.length();i++){
        //     int constants=0;
        //     HashSet<Character> fvowels= new HashSet<>();
        //     for(int j=i;j<word.length();j++){
        //         char ch =word.charAt(j);
        //         if(vowels.contains(ch)){
        //             fvowels.add(ch);
        //         }else{
        //             constants++;
        //         }

        //         if(fvowels.size()==5 && constants==k){
        //             count++;
        //         }
        //         if(constants>k) break;
        //     }
        // }
        // return count;
    }
}
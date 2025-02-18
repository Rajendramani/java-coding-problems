package hard;

import java.util.HashMap;

/*
Given a string s, find the length of the longest substring without repeating characters.
A substring is a contiguous sequence of characters within a string.
Input: s = "abcabcbb"
Output: 3

Input: s = "bbbbb"
Output: 1
 */
public class Problem1 {
    public static int getLongestSubstring(String s) {
        int left = 0;
        int maxlength = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charMap.containsKey(currentChar) && charMap.get(currentChar) >= left){
                left = charMap.get(currentChar) + 1;
            }

            charMap.put(currentChar, right);
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println("Output of (abcabcbb) : "+getLongestSubstring("abcabcbb"));
        System.out.println("Output of (bbbbb) : "+getLongestSubstring("bbbbb"));
    }
}
/*
விளக்கம் :
- இதை ஒரு Sliding Window Technique மூலம் அணுகலாம், அதாவது இரண்டு கதவு இருக்கும் அதில் ஒன்றை அதே இடதில் வைத்தது மற்ற ஒன்றை நகர்த்த வேண்டும்
- Substring இல் 0th index இல் pointer left, right ஐ வைக்க வேண்டும்
- ஒரு HashMap<Character, Integer> charMap ஒன்றை உருவாக்க வேண்டும். இதில் அந்த character <Key> மற்றும் அது கடைசியாக இருந்த index <value> வாக சேகரிக்க வேண்டும்
- இப்போது right pointer ஐ ஒரு ஒரு index ஆக நகர்த வேண்டும்
    - அந்த நேரதில் இருக்கக்கூடிய char value வை currentChar இல் வைக்க வேண்டும்
    - இப்போது அந்த currentChar charMap key ஆக இருக்கிறதா என்றும் charMap இல் currentChar index ஆனது left ஐ விட பெரியதாக இருக்கிறதா என்று பார்க்கவேண்டும்
        - அப்படி இருந்தால் left pointer ஐ charMapஇன் current index + 1 இல் நகர்த வேண்டும்
    - currentChar ஐ key ஆகவும்,right index ஐ value வாகவும் charMap இல் சேர்க்க வேண்டும்
    - maxlength ஐ update செய்ய வேண்டும் maxLength = Math.max(maxLength, right - left + 1);

 */

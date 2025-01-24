package medium;

import java.net.StandardSocketOptions;
import java.util.Arrays;

/*
 * My input is: ASDAPSDAODLAKJSDFJALSDJSALJFDOIAWUREOQWYAS
 * Output should be alphabet along with count: A4 S4 D5 E6
 */
public class Problem1 {
    public static void main(String[] args) {
        String inputs = "ASDAPSDAODLAKJSDFJBBALSDJSALJFDOIAWUREOQWYAS";

        int[] frequencies = new int[26]; //26 alphabets buckets

        //Iterate alphabets and increase the bucket count based on the index e.g. (0->A, 1->B ...)
        for(char c : inputs.toCharArray()){
            //System.out.println("Chars: " + c);
            frequencies[c - 'A']++; //Increase buck size based on ASCII values e.g. A->65, B-> 66
        }
        System.out.println("Frequencies buckets: " + Arrays.toString(frequencies));

        //Print alphabets along with count
        for(int i=0; i<frequencies.length; i++){
            System.out.println((char) (i +'A') +":"+ frequencies[i]);  // index 0+65=65(A), index 1+65=66(B) ...
        }
    }
}

/*
விளக்கம்:
1. முதலில் பிரச்சனையை ஆழமாக அணுக வேண்டும். Alphabets ஐ input ஆக கொடுத்தால் அதனுடன் சேர்த்து count னும் வரவேண்டும்
2. எனவே, இப்படி imagine செய்து பார்க்கவும். 26 bucket ஐ எடுத்து கொள்ளவும்.
    அதை A, B, ...Z என imagine செய்யவும் ( int[] frequencies = new int[26];)
3. இப்போது input இல் ஒரு ஒரு character ஆக எடுத்து, சரியான bucket இல் போடவும். a வந்தால் அதனுடைய index 0, b வந்தால் 1..
    எப்படி index ஐ கண்டுபிடிப்பது?
    ASCII value, A உடைய ASCII value 65,  B-> 66
    //Iterate alphabets and increase the bucket count based on the index e.g. (0->A, 1->B ...)
        for(char c : inputs.toCharArray()){
            //System.out.println("Chars: " + c);
            frequencies[c - 'A']++; //Increase buck size based on ASCII values e.g. A->65, B-> 66
        }
4. 'A' is a char literal with an ASCII value of 65.
    frequencies[c - 'A']++;
    frequencies['A' - 'A']++;  //[65-65] value is 0, ++ என்பது index value வை அதிகரிபது 0th index இன் value இபொது 1
5. இப்பொழுது frequencies array வானது இப்படி இருக்கும் Frequencies buckets: [8, 2, 0, 6, 1, 2, 0, 0, 1, 4, 1, 3, 0, 0, 3, 1, 1, 1, 6, 0, 1, 0, 2, 0, 1, 0]
6. இப்பொழுது மீண்டும் அந்த frequencies array வை ஒரு ஒரு element ஆக எடுத்து அதன் value உடன் print செய்ய வேண்டும்
    //Print alphabets along with count
        for(int i=0; i<frequencies.length; i++){
            System.out.println((char) (i +'A') +":"+ frequencies[i]); //
        }

Note:
'A' is a char literal with an ASCII value of 65.
"A" is a string literal.
When a String is concatenated with a char, the char is implicitly converted to a String e.g. System.out.println("A" + 'A'); //Output AA

System.out.println('A'+'A'); //Output 120
System.out.println("A" + 'A'); //Output AA
System.out.println((char)65); //output A
*/

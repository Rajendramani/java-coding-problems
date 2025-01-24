package easy;

/*
Reverse a String Without Using Built-in Methods
 */
public class Problem2 {

    //Option 1
    // reverse என்ற முறை (method) ஒரு String ஐ எடுத்துக்கொண்டு,
    // அதைப் பழமையான முறை மூலம் எதிரெதிராக மாற்றி (reverse) திரும்ப பெறுகிறது
    public static String reverse(String str) {

        // தொர்நுடைய எழுத்துகளைக் (characters) char வரிசையாக எடுத்துக் கொள்கிறது
        char[] chars = str.toCharArray();

        // இடது (left) தொடக்கம்
        int left = 0;

        // வலது (right) கடைசிப் பெட்டி (index)
        int right = chars.length - 1;

        // இடது குறியீடு வலது குறியீட்டின் வலைப்பால் (left < right) இருக்கும் வரை செயல்படு
        while (left < right) {
            // இடது எழுத்தை temp இல் வைத்துக்கொள்க
            char temp = chars[left];
            // வலது எழுத்தை இடது பந்தியில் பதிலிடு
            chars[left] = chars[right];
            // temp-இல் வைத்திருந்த (அதாவது முதல் எழுத்து) எழுத்தை வலது பந்தியில் பதிலிடு
            chars[right] = temp;

            // அடுத்த கட்டமாக left ஐ 1 உயர்த்தி வலது குறியீட்டை 1 குறைக்கவும்
            left++;
            right--;
        }

        // முழுமையாகப் பெற்ற char வரிசையைக் கொண்டு புதிய String ஒன்றை உருவாக்கி திருப்பி அளிக்கிறது
        return new String(chars);
    }

    //Option 2
    public static void reverseString() {
        String str = "HELLO";
        char[] arr = str.toCharArray();
        String str1 = "";
        for (int i = arr.length; i > 0; i--) {
            System.out.println("TEST : " + arr[i - 1]);
            str1 += arr[i - 1];
        }
        System.out.println("OP:" + str1);
    }

    public static void main(String[] args) {
        String input = "HelloWorld";
        System.out.println("Reversed String: " + reverse(input));
    }

}

/*
விளக்கம்:
1. முதலில் input array வை char[] வாக மற்றவேண்டும், அப்போதுதான் நமக்கு தேவையானதை பண்ண முடியும்
     char[] chars = str.toCharArray();
2. இப்பொழுது இந்த chars[ ] வை ஒரு 5 பெட்டிகள் கொண்ட இரயில் போல எண்ணிக்கொள்ளவும் ['H','E','L','L','O']
    முதல் index இல் இருப்பது Engine, கடைசி index இல் இருப்பது இரயில் மாஸ்டர் பெட்டி.
    இபொது இந்த இரண்டு பெட்டியை இடை மாற்றம் செய்ய வேண்டும்
 */
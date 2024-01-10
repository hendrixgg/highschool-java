public class MoreRecursion {
    public static void main(String[] args) {
        // String a = "Camel";
        // String b = "Bananas";
        // System.out.printf("The word \"%s\" contains %d a, the word \"%s\" contains %d a's.%n", a, charCount(a, 'a'), b, charCount(b, 'a'));
    
        // String cheer = "Go Team! ";
        // System.out.println(cheerRepeatExpGrowth(cheer, 3) + "Hello");

        String prefix = "";
        flowerNumbers(prefix, 4);

        // drawImage(8);
    }

    public static int charCount(String s, char c) {
        if (s.length() < 1)
            return 0;
        return (s.charAt(0) == c) ? 1 + charCount(s.substring(1), c) : charCount(s.substring(1), c);
    }

    public static String cheerRepeat(String s, int i) {
        if(i > 5000)
            return cheerRepeatLoop(s, i);
        if(i < 1)
            return "";
        return s + " " + cheerRepeat(s, i-1);
    }

    private static String cheerRepeatLoop(String s, int i) {
        String ans = "";
        for (int j = 1; j < i; j++) {
            ans += s;
        }
        return ans;
    }
    /**
     * Returns the input string repeated 2^i times.
     * @param s the string to be repeated.
     * @param i the number of times to double the length of the string
     * @return  the string {@code s} appended onto it's self 2^i times.
     */
    public static String cheerRepeatExpGrowth(String s, int i) {
        if(i <= 0)
            return s;
        return cheerRepeatExpGrowth(s + s, i - 1);
    }

    public static void numbers(String prefix, int levels) {
        if (levels == 1) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(prefix + i + ".");
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                numbers(prefix + i + ".", levels - 1);
            }
        }
    }

    public static void flowerNumbers(String prefix, int levels) {
        if (levels == 1) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(prefix + i + ".");
            }
        } else {
            for (int i = 1; i <= 5; i++) {
                flowerNumbers(prefix + i + ".", levels - 1);
            }
        }
    }

    public static void numbersLoop(String prefix, int levels) {
        int lastSection = (int)(Math.pow(10, levels)) - 1;
        for (int i = (lastSection)/9; i <= lastSection; i++) {
            /** 1. Since sections are only to be from 1-9, there can be no 0's in the section. ex: no section 2.0. or 3.0.5.
                -  check each power of 10 (10, 100, 1000,...) i is divisible by. Then, add (the power of 10 "i" was divisible by)/10 to i.
                -  When the loop is over, if i was divisible by 10, then i would be i + 1. Or, if i was divisible by 10 and 100, then i would be i + 11.
                
                2. Since we cannot activly increase i during this process as it would change our results.
                -  The variable "add" is used and it starts the loop equal to i and we compare i to j.
                -  This way, i is only changed at the end of the loop.
            */
            int j = 10;
            int add;
            for (add = i; i % j == 0; j *= 10) {
                add += j/10;
            }
            i = add;
            /** Now the prefix and the section need to be printed
                3. The section number is i, but there are no periods after the digits.
                -  To print each digit with a period after, the integer i is converted to a string.
                -  Then in the for loop "." is inserted after each digit in the string.
                -  note: The index at which to insert the period is incremented by 2 after each insertion. 
                         If this did not happen, then there would be an infinite loop.
            */
            String section = "" + i;
            for ( j = 1; j < section.length(); j+=2) {
                section = section.substring(0,j+1) + "." + section.substring(j+1);
            }
            System.out.println(prefix + section);
        }
    }

    public static void drawImage(int n) {
        if (n == 1)
            System.out.print("*  ");
        else{
            drawImage(n-n/2);
            System.out.println();
            System.out.println();
            for (int i = 0; i < n; i++)
                drawImage(1);
            System.out.println();
            System.out.println();
            drawImage(n-n/2);
        }
    }
}

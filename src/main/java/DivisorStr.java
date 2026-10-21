public class DivisorStr {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";

        int gcd = findGCD(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getGCD(int a, int b){
        return b == 0 ? a: getGCD(b, a%b);
    }
}

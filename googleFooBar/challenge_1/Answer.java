public class Answer {
    public static String answer(String s) {
        String original = new String(s);
        String decrpyted = "";
        for (int i = 0; i < original.length() ; i++) {
          int char_ascii = (int)(original.charAt(i));
          if (char_ascii >=97 && char_ascii <=122){
            char_ascii = 97 + Math.abs(char_ascii - 122);

          }
          decrpyted += (char)char_ascii;
        }
        return decrpyted;
    }
    public static void main(String[] args) {
        System.out.println(answer("ABCDEFGabcdefghijklmnopqrstuvwxyz"));
    }
}

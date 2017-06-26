import java.util.Arrays;

public class Answer {
      public static int[] answer(int[] pegs) {
        boolean isEven = (pegs.length % 2 == 0);
        if (isEven) {
          int[] new_pegs = pegs;

          while(true){
            if(new_pegs.length == 2){
              int diff = new_pegs[1] - new_pegs[0];
              int denominator = diff*2;
              int numerator = 3;
              int gcd = gcd(denominator, numerator);
              denominator /= gcd;
              numerator /= gcd;
              float ans = denominator / numerator;
              if(isValid(ans, pegs)){
                int[] answer = {denominator, numerator};
                return answer;
              }
              else{
                int[] answer = {-1, -1};
                return answer;
              }
            }
            else{
              int mid = (new_pegs.length / 2) - 1;
              int diff = (new_pegs[mid+1] - new_pegs[mid]) * 2;
              int[] temp = new_pegs;

              new_pegs = new int[new_pegs.length - 2];

              int new_mid = (new_pegs.length / 2);
              for(int i = 0; i < new_pegs.length; i++){
                if(i < new_mid){
                  new_pegs[i] = temp[i];
                }
                else{
                  new_pegs[i] = temp[i+2] - diff;
                }
              }
            }
          }
        }
        else {
          int[] diffs = new int[pegs.length-1];
          for(int i = 0; i < pegs.length-1; i++){
            diffs[i] = pegs[i+1] - pegs[i];
          }
          int sum = 0;
          for (int i = 0; i < diffs.length; i++ ){
            if(i % 2 == 0){
              sum += diffs[i];
            }
            else{
              sum -= diffs[i];
            }
          }
          if(sum > 0) {
            int[] answer = {sum*2, 1};
            return answer;
          }
          else {
            int[] answer = {-1, -1};
            return answer;
          }
        }
    }
    public static int gcd(int a, int b){
      if (b==0) return a;
        return gcd(b,a%b);
    }
    public static boolean isValid(float answer_radius, int[] pegs){
      float radius = answer_radius;
      for (int i=1; i <pegs.length-1 ;i++ ) {
        if(pegs[i]-pegs[i-1]-radius < 1){
          return false;
        }
        else{
          radius = pegs[i]-pegs[i-1]-radius;
        }
      }
      return true;
    }
    public static void main(String[] args) {
      int[] pegs_1 = {4, 16, 28, 40, 49};
      int[] pegs_2 = {4, 10, 16, 24, 32, 38};
      int[] pegs_3 = {4, 13, 24, 32};
      int[] pegs_4 = {4, 17, 50};
      int[] pegs_5 = {1, 2, 3, 4, 6};
      System.out.println(Arrays.toString(answer(pegs_1)));
    }
}

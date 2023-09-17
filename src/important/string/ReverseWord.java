package important.string;

public class ReverseWord {

    public void reverse(char[] str, int left, int right){
            while(left<right){
                char temp = str[left];
                str[left] = str[right];
               str[right] = temp;
                left++;
                right--;

            }
        }

        public String reverseWords(String s) {

            char[] str = s.toCharArray();


            int left = 0;
            int right = str.length-1;

            while (left<right){
                if (str[right]==' ') right--;
                else {
                    int ptr = right;
                    while (ptr>=left && str[ptr] != ' '){
                        ptr--;
                    }
                    reverse(str, left, ptr-1);
                    reverse(str, ptr+1, right);
                    reverse(str, left, right);
                    left+=(right-ptr)+1;

                }
            }

            while (str[right] ==' '){
                right--;
            }



            return new String(str).substring(0,right+1);

        }
}

class Main{
    public static void main(String[] args){
            String str2 = "aAbcDefabcAdf";
            String str1 = "abc";
            not_common(str1,str2);
    }
    public static void not_common(String str1,String str2){
        int M = str1.length();
        int N = str2.length();
     
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (str2.charAt(i + j) != str1.charAt(j))
                    break;
            if (j == M){
                System.out.println("Yes");
                return;
            }
                
        }
     
        System.out.println("No");
    }
}
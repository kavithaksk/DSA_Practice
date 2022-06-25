package com.company;

public class RemoveKDigits {

        public static String removeKdigits(String num, int k) {

            String s = num.substring(k);
            int min = 0;
            int m = 0;
            String result = "0";

            if (!s.isEmpty())
            {
                min = Integer.parseInt(s);
                if (s.charAt(0) == '0') {
                    while (m < s.length()) {
                        if (s.charAt(m) != '0') {
                            break;
                        }
                        m++;
                    }
                }
                result = s.substring(m);
                for (int i = 1; i <= num.length() - k ; i++) {
                    StringBuilder sb = new StringBuilder();
                    String temp = num.substring(0, i);
                    String temp1 = num.substring(i + k);
                    sb.append(temp);
                    sb.append(temp1);
                    int res = Integer.parseInt(sb.toString());

                    if (res < min) {
                        min = res;
                        result = sb.toString();

                    }
                }
            }

            if (result.isEmpty())
                return "0";
            else
                return result;

        }

}

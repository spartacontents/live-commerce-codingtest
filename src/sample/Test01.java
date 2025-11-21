package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

class Test01 {

    private static final int TEST_CASE_NUM = 3;

    public static void main(String[] args) throws IOException {

        String[] answer = new String[TEST_CASE_NUM];

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P001/tests/public/input_%02d.txt", i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            answer[i] = Boolean.toString(solution(br.readLine()));
        }

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P001/tests/public/output_%02d.txt", i + 1)));
            BufferedReader br2 = new BufferedReader(new java.io.InputStreamReader(System.in));

            String correct = br2.readLine();
            System.out.print( "Case #" + (i + 1) + ": " + correct + " " + answer[i] + "/ Result: ");
            if (correct.equals(answer[i])) {
                System.out.println("정답");
            }
            else {
                System.out.println("오답");
            }
        }
    }

    public static boolean solution(String domain) {
        // TODO: 아래에 코드를 작성해주세요.
        return true;
    }
}
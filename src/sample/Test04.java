package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

class Test04 {

    private static final int TEST_CASE_NUM = 2;

    public static void main(String[] args) throws IOException {

        String[] answer = new String[TEST_CASE_NUM];

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P004/tests/public/input_%02d.txt", i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int top = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] project = new int[n];
            for (int j = 0; j < n; j++) {
                project[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] exam = new int[n];
            for (int j = 0; j < n; j++) {
                exam[j] = Integer.parseInt(st.nextToken());
            }

            answer[i] = Long.toString(solution(n, top, project, exam));
        }

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P004/tests/public/output_%02d.txt", i + 1)));
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

    public static long solution(int n, int top, int[] project, int[] exam) {
        // TODO: 아래에 코드를 작성해주세요.
        return 0;
    }
}
package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

class Test03 {

    private static final int TEST_CASE_NUM = 3;

    public static void main(String[] args) throws IOException {

        String[] answer = new String[TEST_CASE_NUM];

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P003/tests/public/input_%02d.txt", i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] cards = new int[n];
            for (int j = 0; j < n; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] price = new int[m];
            for (int j = 0; j < m; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            answer[i] = Integer.toString(solution(n, m, cards, price));
        }

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.setIn(new FileInputStream(String.format("P003/tests/public/output_%02d.txt", i + 1)));
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

    public static int solution(int n, int m, int[] cards, int[] price) {
        // TODO: 아래에 코드를 작성해주세요.
        return 0;
    }
}
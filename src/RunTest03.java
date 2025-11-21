import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class RunTest03 {

    private static final TestType TEST_TYPE = TestType.HIDDEN;

    private static final int PUBLIC_TEST_CASE_NUM = 3;
    private static final int HIDDEN_TEST_CASE_NUM = 10;

    public static void main(String[] args) throws IOException {

        int tc = TEST_TYPE == TestType.PUBLIC ? PUBLIC_TEST_CASE_NUM : HIDDEN_TEST_CASE_NUM;

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P003/tests/%s/input_%02d.txt", TEST_TYPE.name(), i + 1)));
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

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P003/tests/%s/output_%02d.txt", TEST_TYPE.name(), i + 1)));
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
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int card : cards) {
            pq.add(card);
        }

        for (int p : price) {
            if (pq.peek() >= p) {
                pq.add(pq.poll() - p);
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
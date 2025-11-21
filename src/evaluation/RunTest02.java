package evaluation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class RunTest02 {

    private static final TestType TEST_TYPE = TestType.HIDDEN;

    private static final int PUBLIC_TEST_CASE_NUM = 2;
    private static final int HIDDEN_TEST_CASE_NUM = 10;

    public static void main(String[] args) throws IOException {

        int tc = TEST_TYPE == TestType.PUBLIC ? PUBLIC_TEST_CASE_NUM : HIDDEN_TEST_CASE_NUM;

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P002/tests/%s/input_%02d.txt", TEST_TYPE.name(), i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] beads = new long[n];
            for (int j = 0; j < n; j++) {
                beads[j] = Long.parseLong(st.nextToken());
            }
            answer[i] = Long.toString(solution(n, m, beads));
        }

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P002/tests/%s/output_%02d.txt", TEST_TYPE.name(), i + 1)));
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

    public static long solution(int n, long m, long[] beads) {
        HashMap<Long, Integer> beadsCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            beadsCountMap.put(beads[i], beadsCountMap.getOrDefault(beads[i], 0) + 1);
        }

        int maxCount = 0;
        long minBeadNum = m + 1;

        for (Map.Entry<Long, Integer> a : beadsCountMap.entrySet()) {
            if (a.getValue() == maxCount && a.getKey() < minBeadNum) {
                minBeadNum = a.getKey();
            }
            else if (a.getValue() > maxCount) {
                maxCount = a.getValue();
                minBeadNum = a.getKey();
            }
        }

        return minBeadNum;
    }
}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

class RunTest01 {

    private static final TestType TEST_TYPE = TestType.HIDDEN;

    private static final int PUBLIC_TEST_CASE_NUM = 3;
    private static final int HIDDEN_TEST_CASE_NUM = 10;

    public static void main(String[] args) throws IOException {

        int tc = TEST_TYPE == TestType.PUBLIC ? PUBLIC_TEST_CASE_NUM : HIDDEN_TEST_CASE_NUM;

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P001/tests/%s/input_%02d.txt", TEST_TYPE.name(), i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            answer[i] = Boolean.toString(solution(br.readLine()));
        }

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P001/tests/%s/output_%02d.txt", TEST_TYPE.name(), i + 1)));
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
        return (domain.endsWith(".com") || domain.endsWith(".kr"));
    }
}
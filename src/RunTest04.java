import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class RunTest04 {

    private static final TestType TEST_TYPE = TestType.HIDDEN;

    private static final int PUBLIC_TEST_CASE_NUM = 2;
    private static final int HIDDEN_TEST_CASE_NUM = 10;

    public static void main(String[] args) throws IOException {

        int tc = TEST_TYPE == TestType.PUBLIC ? PUBLIC_TEST_CASE_NUM : HIDDEN_TEST_CASE_NUM;

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P004/tests/%s/input_%02d.txt", TEST_TYPE.name(), i + 1)));
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

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P004/tests/%s/output_%02d.txt", TEST_TYPE.name(), i + 1)));
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

    public static class Student {
        int project;
        int exam;
        int projectRank = -1;
        int examRank = -1;

        public Student(int project, int exam) {
            this.project = project;
            this.exam = exam;
        }
    }

    public static long solution(int n, int top, int[] project, int[] exam) {
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(project[i], exam[i]);
        }

        // project 기준 내림 차순 정렬
        Arrays.sort(students, (a, b) -> Integer.compare(b.project, a.project));

        for (int i = 0; i < n; i++) {
            students[i].projectRank = i + 1;
        }

        // exam 기준 내림 차순 정렬
        Arrays.sort(students, (a, b) -> Integer.compare(b.exam, a.exam));

        for (int i = 0; i < n; i++) {
            students[i].examRank = i + 1;
        }

        return Arrays.stream(students).filter(s -> s.projectRank <= top && s.examRank <= top).count();
    }
}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RunTest05 {

    private static final TestType TEST_TYPE = TestType.HIDDEN;

    private static final int PUBLIC_TEST_CASE_NUM = 1;
    private static final int HIDDEN_TEST_CASE_NUM = 10;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] ry = {-1, 0, 1, 0};
    private static final int[] rx = {0, 1, 0, -1};

    private static int[][] dist;

    public static void main(String[] args) throws IOException {

        int tc = TEST_TYPE == TestType.PUBLIC ? PUBLIC_TEST_CASE_NUM : HIDDEN_TEST_CASE_NUM;

        String[] answer = new String[tc];

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P005/tests/%s/input_%02d.txt", TEST_TYPE.name(), i + 1)));
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            answer[i] = Long.toString(solution(n, m, map));
        }

        for (int i = 0; i < tc; i++) {
            System.setIn(new FileInputStream(String.format("P005/tests/%s/output_%02d.txt", TEST_TYPE.name(), i + 1)));
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

    public static int solution(int n, int m, int[][] map) {
        dist = new int[n][m];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.addLast(new Node(0, 0));
        dist[0][0] = 0;
        map[0][0] = -1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            if (map[now.r][now.c] >= dist[now.r][now.c]) {
                dist[now.r][now.c]++;
                queue.addLast(now);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                if (dist[nr][nc] > 0)
                    continue;

                dist[nr][nc] = dist[now.r][now.c] + 1;
                queue.addLast(new Node(nr, nc));
            }
        }

        return dist[n - 1][m - 1];
    }

}
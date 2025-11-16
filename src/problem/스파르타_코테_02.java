import java.util.HashMap;
import java.util.Map;

class 스파르타_코테_02 {
    /*
    [제목]
    구슬 놀이

    [문제 설명]
    르탄이는 자연수가 적혀 있는 구슬들로 특별한 구슬 놀이를 하고 있습니다.
    여러개의 구슬들이 들어 있는 주머니에서 구슬을 하나를 꺼냅니다. 꺼낸 구슬의 숫자를 확인하고 다시 주머니에 그 구슬을 넣습니다.
    그리고 주머니를 열어서 꺼냈던 구슬의 숫자와 동일한 숫자가 적힌 구슬의 총 개수를 세는 놀이입니다.
    예를 들어 주머니에 [3, 3, 1, 4, 2, 2, 2] 와 같이 구슬 7개 들어있었을 때,
    주머니에서 꺼낸 구슬이 2였다면 2가 적힌 구슬은 총 3개가 됩니다.
    르탄이는 총 개수가 가장 크게 나오는 경우를 알고 싶었습니다.
    즉, 이 경우 1은 1개, 2는 3개, 3은 2개, 4는 1개이므로 답은 2가 됩니다. 2가 3개로 가장 많습니다.
    르탄이 도와 구슬의 개수, 구슬에 적힌 숫자의 범위 그리고 각 구슬들에 적힌 숫자가 주어졌을 때 답을 구하는 Solution 함수를 작성해주세요.

    [제약 조건]
    구슬의 개수 n은 1 ~ 1,000,000 까지의 자연수 입니다.
    구슬에 적힌 숫자의 범위 M은 1 ~ 1,000,000,000,000 까지의 자연수 입니다. m이 5인 경우 (1 ~ M)
    구슬에 적힌 숫자들은 정수형 배열 beads로 주어지며 배열의 사이즈는 N과 같습니다.
    동일한 숫자가 적힌 구슬의 개수가 가장 많은 케이스가 여러개라면 구슬의 숫자가 가장 작은 것을 반환합니다. (예시2 참고)

    [입출력 예시]
    예시 #1 n = 7, m = 4, beads = [3, 3, 1, 4, 2, 2, 2]
    예시 #2 n = 10, m = 5, beads = [1, 2, 3, 1, 2, 3, 1, 2, 3, 4]

    [입출력 예시 설명]
    예시 #1
    문제 설명의 케이스와 동일하며 답은 2입니다.

    예시 #2
    구슬의 개수를 합산해보면 1이 3개, 2가 3개, 3이 3개, 4가 1개이므로 1, 2, 3이 전부 3개로 가장 많습니다.
    이 경우 1, 2, 3중에 가장 작은 수인 1을 반환합니다.
     */

    public static void main(String[] args) {
        //예시1
        System.out.println(solution(7, 4, new long[]{3, 3, 1, 4, 2, 2, 2}));

        //예시2
        System.out.println(solution(10, 5, new long[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 4}));
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
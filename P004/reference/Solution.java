import java.util.Arrays;

class Solution {
    /*
    [제목]
    장학금 대상자 구하기

    [문제 설명]
    스파르타 개발자 교육 과정에서는 교육 마지막에 평가를 하여 평가 결과가 우수한 학생들에게 장학금을 지급하기로 결정했습니다.
    평가는 과제 점수와 코딩 테스트 점수 이 두가지 점수를 기반으로 진행합니다.
    장학금을 지급받을 우수한 학생 선정 방식은 과제 점수와 코딩 테스트 점수 모두 다른 학생들에 비해 우수한 학생으로 정하기로 했습니다.
    예를 들어 과제 점수가 상위 10등안에 들면서 동시에 코딩 테스트 점수도 상위 10등안에 드는 학생에게만 학장금을 지급하는 형식입니다.
    총 학생 수(n), 학생들의 과제 점수(project)와 코딩 테스트 점수(exam), 장학금 지급 기준 등수(top)가 주어졌을 때,
    장학금을 지급받는 학생 수를 구하는 Solution 함수를 작성해주세요.

    [제약 조건]
    총 학생 수 n은 1 ~ 100,000 사이의 자연수입니다.
    학생들의 과제 점수 project는 배열로 주어지며 사이즈는 n과 같고, 각 값은 1 ~ 1,000,000 사이의 자연수입니다.
    학생들의 코딩 테스트 점수 exam은 배열로 주어지며 사이즈는 n과 같고, 각 값은 1 ~ 1,000,000 사이의 자연수입니다.
    장학금 지급 기준 등수 top은 1 ~ 100 사이의 자연수이며 n보다 작거나 같습니다.
    과제 점수가 동일한 학생은 없으며, 코딩 테스트 점수가 동일한 학생도 없습니다.

    [입력 예시]
    예시 #1
    n = 5, top = 3, project = [90, 80, 70, 60, 50], exam = [50, 60, 70, 80, 90]

    예시 #2
    n = 10, top = 5, project = [40, 30, 10, 50, 20, 15, 25, 35, 45, 55], exam = [100, 30, 95, 20, 50, 75, 35, 15, 40, 80]

    [출력 예시 및 설명]
    예시 #1
    1

    1번 학생은 과제 1등, 코딩 테스트 5등
    2번 학생은 과제 2등, 코딩 테스트 4등
    3번 학생은 과제 3등, 코딩 테스트 3등
    4번 학생은 과제 4등, 코딩 테스트 2등
    5번 학생은 과제 5등, 코딩 테스트 4등
    따라서 3번 학생만 유일하게 과제도 3등 안에 들면서 코딩 테스트도 3등안에 들어오기 때문에 3번 학생만 장학금을 지급받을 수 있으며 답은 1이 됩니다.

    예시 #2
    2

    1번 학생 (40, 100)과 10번 학생(55, 80)만 두 점수 모두 5등안에 들어오기 때문에 답은 2가 됩니다.
     */

    public static void main(String[] args) {
        //예시1
        System.out.println(solution(5, 3, new int[]{90, 80, 70, 60, 50}, new int[]{50, 60, 70, 80, 90}));

        //예시2
        System.out.println(solution(10, 5, new int[]{40, 30, 10, 50, 20, 15, 25, 35, 45, 55}, new int[]{100, 30, 95, 20, 50, 75, 35, 15, 40, 80}));
    }

    /*
    문제 해설 및 정답 코드
    과제 점수, 코딩 테스트 점수를 쌍으로 저장하여 2번 정렬해서 문제를 해결할 수 있습니다.
    Naive하게 접근하면 시간 초과가 발생할 수 있습니다.
    과제 점수, 코딩 테스트 점수, 과제 등수, 코딩 테스트 등수를 저장할 Student 클래스를 만듭니다.
    Student 클래스를 n개 담을 수 있는 배열을 만들고 project, exam 점수를 저장합니다.
    과제(project) 점수를 기준으로 내림 차순 정렬한 후에 등수를 저장합니다.
    코딩 테스트(exam) 점수를 기준으로 내림 차순 정렬한 후에 등수를 저장합니다.
    각 등수가 모두 top 이하인 값들만 남긴 후에 개수를 반환합니다.
     */
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

}

class 스파르타_코테_01 {
    /*
    [제목]
    도메인 주소 검증 함수

    [문제 설명]
    신입 개발자 르탄이는 첫 개발 업무로 도메인 주소 검증 함수를 만들게 되었습니다.
    요구 사항은 도메인 주소 문자열을 파라미터로 받아서 [.com] 또는 [.kr] 로 끝나는지 판별해야 합니다.
    르탄이를 도와서 문자열이 [.com] 또는 [.kr] 로 끝나면 true, 아닌 경우 false를 반환하는 solution 함수를 작성해주세요.

    [제약조건]
    도메인 주소로 들어오는 문자열 domain은 길이가 3 이상 50 이하이며, 영어 소문자와 특수 문자 "." 으로만 이루어져 있습니다.

    [입출력 예시]
    예시 #1 domain = "spartacodingclub.co.kr"
    예시 #2 domain = "google.com"
    예시 #3 domain = claude.ai

    [입출력 예시 설명]
    예시 #1
    정답: true

    예시 #2
    정답: true

    예시 #3
    정답: false
     */

    public static void main(String[] args) {
        //예시1
        System.out.println(solution("spartacodingclub.kr"));

        //예시2
        System.out.println(solution("google.com"));

        //예시3
        System.out.println(solution("claude.ai"));
    }

    public static boolean solution(String domain) {
        return (domain.endsWith(".com") || domain.endsWith(".kr"));
    }
}

class Solution {
    /*
    [제목]
    도메인 주소 검증 함수

    [문제 설명]
    신입 개발자 르탄이는 첫 개발 업무로 도메인 주소 검증 함수를 만들게 되었습니다.
    요구 사항은 도메인 주소 문자열을 파라미터로 받아서 [.com] 또는 [.kr] 로 끝나는지 판별해야 합니다.
    르탄이를 도와서 문자열이 [.com] 또는 [.kr] 로 끝나면 true, 아닌 경우 false를 반환하는 solution 함수를 작성해주세요.

    [제약조건]
    도메인 주소로 들어오는 문자열 domain은 길이가 3 이상 50 이하이며, 영어 소문자와 특수 문자 "." 으로만 이루어져 있습니다.

    [입력 예시]
    예시 #1
    spartacodingclub.co.kr

    예시 #2
    google.com

    예시 #3
    claude.ai

    [출력 예시 및 설명]
    예시 #1
    true

    예시 #2
    true

    예시 #3
    false
     */

    public static void main(String[] args) {
        //예시1
        System.out.println(solution("spartacodingclub.kr"));

        //예시2
        System.out.println(solution("google.com"));

        //예시3
        System.out.println(solution("claude.ai"));
    }

    /*
    문제 해설 및 정답 코드
    단순히 문자열의 끝이 .com 또는 .kr 로 끝나는지만 판별하면 되는 간단한 문제입니다.
    indexOf, endsWith 등의 메소드를 사용하거나 또는 문자열을 배열로 변환해서도 간단히 문제를 해결할 수 있습니다.
     */
    public static boolean solution(String domain) {
        return (domain.endsWith(".com") || domain.endsWith(".kr"));
    }
}
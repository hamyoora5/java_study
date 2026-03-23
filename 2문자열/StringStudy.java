// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// StringStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class StringStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // char는 문자 1개만 저장할 수 있는 자료형입니다.
        // 문자는 작은따옴표(' ')로 감쌉니다.
        char firstLetter = 'J';

        // String은 문자 여러 개를 저장하는 문자열 자료형입니다.
        // 문자열은 큰따옴표(" ")로 감쌉니다.
        String language = "Java";

        // char와 String의 차이를 출력해 봅니다.
        System.out.println("문자 1개: " + firstLetter);
        System.out.println("문자열: " + language);

        // 문자열끼리는 + 기호로 이어 붙일 수 있습니다.
        String message = "안녕하세요" + " " + "자바";
        System.out.println("문자열 연결: " + message);

        // 숫자와 문자열을 +로 연결하면 숫자도 문자열처럼 이어집니다.
        String textNumber = "숫자: " + 10;
        System.out.println(textNumber);

        // 문자열 안에 큰따옴표를 넣고 싶을 때는 \"를 사용합니다.
        String quote = "\"자바 문자열\" 공부 중";
        System.out.println("이스케이프 문자 사용: " + quote);

        // \n은 줄바꿈을 의미합니다.
        String multiLine = "첫째 줄\n둘째 줄";
        System.out.println(multiLine);

        // length()는 문자열의 길이를 반환합니다.
        String fruit = "apple";
        System.out.println("문자열 길이: " + fruit.length());

        // charAt(번호)는 해당 위치의 문자 1개를 가져옵니다.
        // 인덱스는 0부터 시작하므로 0은 첫 번째 문자입니다.
        System.out.println("0번 인덱스 문자: " + fruit.charAt(0));
        System.out.println("2번 인덱스 문자: " + fruit.charAt(2));

        // substring(시작번호)는 시작 위치부터 끝까지 잘라냅니다.
        System.out.println("부분 문자열 1: " + fruit.substring(2));

        // substring(시작번호, 끝번호)는 시작 위치부터 끝번호 전까지 잘라냅니다.
        System.out.println("부분 문자열 2: " + fruit.substring(1, 4));

        // toUpperCase()는 문자열을 모두 대문자로 바꿉니다.
        System.out.println("대문자 변환: " + fruit.toUpperCase());

        // toLowerCase()는 문자열을 모두 소문자로 바꿉니다.
        System.out.println("소문자 변환: " + "JAVA".toLowerCase());

        // equals()는 문자열의 내용이 같은지 비교합니다.
        String a = "java";
        String b = "java";
        String c = "Java";
        System.out.println("a와 b가 같은가: " + a.equals(b));
        System.out.println("a와 c가 같은가: " + a.equals(c));

        // equalsIgnoreCase()는 대소문자를 무시하고 비교합니다.
        System.out.println("a와 c를 대소문자 무시하고 비교: " + a.equalsIgnoreCase(c));

        // == 는 문자열 내용이 아니라 같은 객체인지 비교할 수 있으므로
        // 문자열 비교에서는 보통 equals()를 사용하는 것이 안전합니다.
        System.out.println("a == b 결과: " + (a == b));

        // contains()는 특정 문자열이 포함되어 있는지 확인합니다.
        String sentence = "Java is fun";
        System.out.println("fun 포함 여부: " + sentence.contains("fun"));

        // startsWith()는 특정 문자열로 시작하는지 확인합니다.
        System.out.println("Java로 시작하는가: " + sentence.startsWith("Java"));

        // endsWith()는 특정 문자열로 끝나는지 확인합니다.
        System.out.println("fun으로 끝나는가: " + sentence.endsWith("fun"));

        // replace()는 특정 문자열을 다른 문자열로 바꿉니다.
        System.out.println("문자열 바꾸기: " + sentence.replace("fun", "easy"));

        // trim()은 문자열 앞뒤 공백을 제거합니다.
        String spaced = "  hello java  ";
        System.out.println("공백 제거 전: [" + spaced + "]");
        System.out.println("공백 제거 후: [" + spaced.trim() + "]");

        // split()은 구분자를 기준으로 문자열을 나눕니다.
        String colors = "red,green,blue";
        String[] colorArray = colors.split(",");

        // 배열에 나뉜 문자열이 어떻게 들어갔는지 출력합니다.
        System.out.println("첫 번째 색상: " + colorArray[0]);
        System.out.println("두 번째 색상: " + colorArray[1]);
        System.out.println("세 번째 색상: " + colorArray[2]);

        // String.valueOf()는 다른 자료형 값을 문자열로 바꿉니다.
        int score = 100;
        String scoreText = String.valueOf(score);
        System.out.println("문자열로 변환된 점수: " + scoreText);

        // 문자열을 숫자로 바꿀 때는 Integer.parseInt()를 사용할 수 있습니다.
        String numberText = "250";
        int number = Integer.parseInt(numberText);
        System.out.println("문자열을 숫자로 변환한 결과: " + number);
    }
}

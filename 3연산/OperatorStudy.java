// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// OperatorStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class OperatorStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // int는 정수를 저장하는 자료형입니다.
        int a = 10;
        int b = 3;

        // +는 덧셈 연산자입니다.
        System.out.println("덧셈: " + (a + b));

        // -는 뺄셈 연산자입니다.
        System.out.println("뺄셈: " + (a - b));

        // *는 곱셈 연산자입니다.
        System.out.println("곱셈: " + (a * b));

        // /는 나눗셈 연산자입니다.
        // int끼리 나누면 결과도 int가 되어 소수점 이하는 버려집니다.
        System.out.println("정수 나눗셈: " + (a / b));

        // 실수로 정확한 나눗셈 결과를 얻고 싶으면 double을 사용합니다.
        System.out.println("실수 나눗셈: " + (10.0 / 3));

        // %는 나머지를 구하는 연산자입니다.
        System.out.println("나머지: " + (a % b));

        // 부호 연산자는 숫자의 양수, 음수를 표현할 때 사용합니다.
        int minusNumber = -a;
        System.out.println("음수 만들기: " + minusNumber);
        System.out.println("다시 양수 만들기: " + (-minusNumber));

        // 증감 연산자는 값을 1 증가 또는 감소시킵니다.
        int count = 5;
        count++;
        System.out.println("count++ 후 값: " + count);

        count--;
        System.out.println("count-- 후 값: " + count);

        // 전위 증가 연산자는 먼저 값을 증가시키고 사용합니다.
        int x = 5;
        System.out.println("전위 증가 ++x: " + (++x));

        // 후위 증가 연산자는 먼저 현재 값을 사용하고 나중에 증가시킵니다.
        int y = 5;
        System.out.println("후위 증가 y++: " + (y++));
        System.out.println("후위 증가 후 y 값: " + y);

        // 비교 연산자는 두 값을 비교한 결과를 true 또는 false로 반환합니다.
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        // 논리 연산자는 true, false를 조합할 때 사용합니다.
        boolean isAdult = true;
        boolean hasTicket = false;

        // &&는 두 조건이 모두 true일 때만 true입니다.
        System.out.println("isAdult && hasTicket: " + (isAdult && hasTicket));

        // ||는 두 조건 중 하나라도 true이면 true입니다.
        System.out.println("isAdult || hasTicket: " + (isAdult || hasTicket));

        // !는 논리값을 반대로 바꿉니다.
        System.out.println("!isAdult: " + (!isAdult));

        // 대입 연산자는 변수에 값을 저장할 때 사용합니다.
        int number = 10;
        System.out.println("초기값: " + number);

        // +=는 현재 값에 더한 후 다시 저장합니다.
        number += 5;
        System.out.println("number += 5 결과: " + number);

        // -=는 현재 값에서 뺀 후 다시 저장합니다.
        number -= 3;
        System.out.println("number -= 3 결과: " + number);

        // *=는 현재 값에 곱한 후 다시 저장합니다.
        number *= 2;
        System.out.println("number *= 2 결과: " + number);

        // /=는 현재 값을 나눈 후 다시 저장합니다.
        number /= 4;
        System.out.println("number /= 4 결과: " + number);

        // %=는 현재 값을 나머지 연산한 후 다시 저장합니다.
        number %= 3;
        System.out.println("number %= 3 결과: " + number);

        // 삼항 연산자는 조건에 따라 두 값 중 하나를 선택합니다.
        int age = 20;
        String result = (age >= 19) ? "성인" : "미성년자";
        System.out.println("삼항 연산자 결과: " + result);

        // 문자열과 숫자를 +로 연결하면 문자열 결합이 일어납니다.
        System.out.println("문자열 + 숫자: " + "점수는 " + 100);

        // 괄호가 없으면 왼쪽부터 순서대로 계산됩니다.
        System.out.println("1 + 2 + \"3\" 결과: " + (1 + 2 + "3"));

        // 문자열이 먼저 나오면 뒤의 숫자들도 문자열로 이어집니다.
        System.out.println("\"1\" + 2 + 3 결과: " + ("1" + 2 + 3));

        // 연산의 우선순위에 따라 곱셈과 나눗셈이 덧셈보다 먼저 계산됩니다.
        System.out.println("2 + 3 * 4 결과: " + (2 + 3 * 4));

        // 괄호를 사용하면 원하는 순서대로 먼저 계산할 수 있습니다.
        System.out.println("(2 + 3) * 4 결과: " + ((2 + 3) * 4));

        // 관계식과 논리 연산자를 함께 사용해 복합 조건을 만들 수 있습니다.
        int score = 85;
        boolean pass = score >= 80 && score <= 100;
        System.out.println("점수가 80 이상 100 이하인가: " + pass);

        // 짧은 회로 평가란 앞의 결과만으로 전체 결과가 결정되면 뒤는 검사하지 않는 것입니다.
        // false && 뒤쪽은 검사하지 않으므로 안전하게 조건을 구성할 때 자주 사용합니다.
        int safeNumber = 0;
        System.out.println("짧은 회로 평가: " + (safeNumber != 0 && 10 / safeNumber > 1));

        // 비트 연산자는 정수의 2진수 비트 단위로 계산합니다.
        int bitA = 5;
        int bitB = 3;

        // &는 각 비트가 모두 1일 때만 1이 됩니다.
        System.out.println("비트 AND: " + (bitA & bitB));

        // |는 각 비트 중 하나라도 1이면 1이 됩니다.
        System.out.println("비트 OR: " + (bitA | bitB));

        // ^는 각 비트가 서로 다를 때 1이 됩니다.
        System.out.println("비트 XOR: " + (bitA ^ bitB));

        // ~는 비트를 반전시킵니다.
        System.out.println("비트 NOT: " + (~bitA));

        // <<는 왼쪽으로 비트를 이동합니다.
        System.out.println("왼쪽 시프트: " + (bitA << 1));

        // >>는 오른쪽으로 비트를 이동합니다.
        System.out.println("오른쪽 시프트: " + (bitA >> 1));

        // 형변환과 연산을 함께 사용할 수도 있습니다.
        double average = (double) (a + b) / 2;
        System.out.println("평균: " + average);
    }
}

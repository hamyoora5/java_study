import java.util.Arrays;

// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// MethodStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
/**
 * 자바 메서드의 선언, 호출, 반환값, 매개변수 사용법을 학습하기 위한 예제 클래스입니다.
 */
public class MethodStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 메서드는 특정 작업을 묶어 두고 필요할 때 다시 호출해서 사용하는 기능입니다.
        // main도 메서드의 한 종류입니다.

        // 반환값이 없고 매개변수도 없는 메서드를 호출합니다.
        sayHello();

        // 반환값이 없고 매개변수가 있는 메서드를 호출합니다.
        printName("홍길동");

        // 반환값이 있는 메서드는 결과를 변수에 저장할 수 있습니다.
        int sumResult = add(10, 20);
        System.out.println("add 메서드 결과: " + sumResult);

        // 메서드 호출 결과를 바로 출력할 수도 있습니다.
        System.out.println("subtract 메서드 결과: " + subtract(20, 5));

        // double 반환값을 가지는 메서드도 만들 수 있습니다.
        System.out.println("평균: " + getAverage(90, 80, 100));

        // boolean을 반환하는 메서드는 조건 판단에 자주 사용됩니다.
        System.out.println("성인인가: " + isAdult(20));

        // String을 반환하는 메서드도 만들 수 있습니다.
        System.out.println("학점: " + getGrade(87));

        // 메서드 안에서 계산한 값을 return으로 돌려줄 수 있습니다.
        int maxValue = getMax(50, 80);
        System.out.println("더 큰 값: " + maxValue);

        // 메서드 오버로딩은 이름은 같지만 매개변수가 다른 메서드를 여러 개 만드는 것입니다.
        System.out.println("오버로딩 add(int, int): " + add(3, 4));
        System.out.println("오버로딩 add(double, double): " + add(2.5, 1.5));
        System.out.println("오버로딩 add(int, int, int): " + add(1, 2, 3));

        // 매개변수는 메서드 안에서 사용할 입력값입니다.
        printMessage("메서드는 재사용하기 좋습니다.");

        // 메서드는 같은 코드를 여러 번 반복하지 않게 도와줍니다.
        printLine();
        printLine();

        // 메서드를 다른 메서드 안에서 호출할 수도 있습니다.
        introduce("김자바", 20);

        // return은 값을 돌려주거나 메서드를 즉시 끝낼 수 있습니다.
        checkNumber(10);
        checkNumber(-3);

        // 지역 변수는 메서드 안에서 선언되고 그 메서드 안에서만 사용할 수 있습니다.
        showLocalVariable();

        // 매개변수로 전달된 기본형 값은 복사되어 전달됩니다.
        int number = 10;
        changePrimitive(number);
        System.out.println("기본형 전달 후 원래 값: " + number);

        // 배열 같은 참조형은 참조값이 전달되어 내부 요소 변경이 반영될 수 있습니다.
        int[] numbers = {1, 2, 3};
        changeArray(numbers);
        System.out.println("배열 전달 후 값: " + Arrays.toString(numbers));

        // 메서드에 배열을 전달해서 합계를 구할 수 있습니다.
        System.out.println("배열 합계: " + getArraySum(numbers));

        // 메서드가 배열을 반환할 수도 있습니다.
        int[] copiedArray = copyArray(numbers);
        System.out.println("메서드가 반환한 배열: " + Arrays.toString(copiedArray));

        // 가변인자 메서드는 전달하는 인수 개수가 달라도 받을 수 있습니다.
        System.out.println("가변인자 합계 1: " + sumAll(1, 2, 3));
        System.out.println("가변인자 합계 2: " + sumAll(10, 20, 30, 40));

        // 재귀 메서드는 메서드가 자기 자신을 다시 호출하는 방식입니다.
        System.out.println("팩토리얼 5!: " + factorial(5));

        // 피보나치 같은 계산도 재귀로 표현할 수 있습니다.
        System.out.println("피보나치 6번째 값: " + fibonacci(6));

        // 메서드를 이용하면 조건 검사도 더 읽기 좋게 만들 수 있습니다.
        if (isEven(8)) {
            System.out.println("8은 짝수입니다.");
        }

        // 여러 값을 처리하는 메서드는 문제 풀이에서 자주 씁니다.
        int[] scores = {70, 85, 90, 100, 65};
        System.out.println("배열 최댓값: " + getArrayMax(scores));
        System.out.println("배열 최솟값: " + getArrayMin(scores));
        System.out.println("배열 평균: " + getArrayAverage(scores));

        // 정렬된 설명 문자열을 반환하는 메서드 예제입니다.
        System.out.println("점수 설명: " + describeScore(95));

        // 메서드는 호출 순서대로 실행되고 끝나면 다시 호출한 곳으로 돌아옵니다.
        startProgram();

        // static 메서드는 객체를 만들지 않고 클래스 이름으로 바로 호출할 수 있습니다.
        // 지금 작성한 메서드 대부분은 main에서 바로 쓰기 위해 static으로 만들었습니다.

        // public은 어디서든 호출 가능하다는 뜻이고,
        // private은 이 클래스 내부에서만 사용할 수 있다는 뜻입니다.
        // 아래 private 메서드도 같은 클래스 안이므로 호출할 수 있습니다.
        System.out.println("private 메서드 결과: " + multiply(3, 4));
    }

    // 반환값이 없고 매개변수도 없는 메서드입니다.
    public static void sayHello() {
        System.out.println("안녕하세요. 메서드 공부를 시작합니다.");
    }

    // 반환값이 없고 매개변수가 1개인 메서드입니다.
    public static void printName(String name) {
        System.out.println("이름: " + name);
    }

    /**
     * 두 정수를 더한 결과를 반환합니다.
     *
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return 두 정수의 합
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * 두 실수를 더한 결과를 반환합니다.
     *
     * @param a 첫 번째 실수
     * @param b 두 번째 실수
     * @return 두 실수의 합
     */
    public static double add(double a, double b) {
        return a + b;
    }

    // 이름은 같지만 매개변수 개수가 다르면 다른 메서드로 구분됩니다.
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // 두 수를 빼는 메서드입니다.
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 세 점수의 평균을 구합니다.
     *
     * @param a 첫 번째 점수
     * @param b 두 번째 점수
     * @param c 세 번째 점수
     * @return 세 점수의 평균
     */
    public static double getAverage(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    /**
     * 전달받은 나이가 성인 기준 이상인지 검사합니다.
     *
     * @param age 검사할 나이
     * @return 19세 이상이면 true, 아니면 false
     */
    public static boolean isAdult(int age) {
        return age >= 19;
    }

    // 점수에 따라 학점을 반환하는 메서드입니다.
    public static String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        }

        return "F";
    }

    // 두 값 중 큰 값을 반환하는 메서드입니다.
    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }

        return b;
    }

    // 문자열 메시지를 출력하는 메서드입니다.
    public static void printMessage(String message) {
        System.out.println("메시지: " + message);
    }

    // 구분선을 출력하는 메서드입니다.
    public static void printLine() {
        System.out.println("--------------------");
    }

    // 다른 메서드를 조합해서 사용하는 메서드입니다.
    public static void introduce(String name, int age) {
        printLine();
        System.out.println("이름은 " + name + "입니다.");
        System.out.println("나이는 " + age + "세입니다.");
        printLine();
    }

    // return을 사용해 메서드를 중간에 종료하는 예제입니다.
    public static void checkNumber(int number) {
        if (number < 0) {
            System.out.println("음수입니다.");
            return;
        }

        System.out.println("0 이상의 수입니다.");
    }

    // 지역 변수는 선언된 메서드 안에서만 사용할 수 있습니다.
    public static void showLocalVariable() {
        int localNumber = 100;
        System.out.println("지역 변수 값: " + localNumber);
    }

    // 기본형 값은 복사되어 전달되므로 바깥 변수는 바뀌지 않습니다.
    public static void changePrimitive(int value) {
        value = 999;
        System.out.println("메서드 안의 기본형 값: " + value);
    }

    // 배열 요소를 바꾸면 원본에도 반영될 수 있습니다.
    public static void changeArray(int[] array) {
        array[0] = 100;
    }

    /**
     * 배열에 들어 있는 모든 값의 합계를 구합니다.
     *
     * @param array 합계를 구할 정수 배열
     * @return 배열 요소 전체의 합
     */
    public static int getArraySum(int[] array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum;
    }

    // 배열을 복사해서 새 배열을 반환하는 메서드입니다.
    public static int[] copyArray(int[] array) {
        return array.clone();
    }

    /**
     * 전달받은 모든 정수의 합계를 구합니다.
     *
     * @param numbers 합계를 구할 정수들
     * @return 전달된 정수들의 합
     */
    public static int sumAll(int... numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    /**
     * 재귀 호출을 이용해 팩토리얼 값을 구합니다.
     *
     * @param n 팩토리얼을 구할 수
     * @return n! 값
     */
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // 피보나치 재귀 예제입니다.
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 짝수인지 검사하는 메서드입니다.
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * 배열에서 가장 큰 값을 반환합니다.
     *
     * @param array 검사할 정수 배열
     * @return 배열의 최댓값
     */
    public static int getArrayMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    // 배열의 최솟값을 반환하는 메서드입니다.
    public static int getArrayMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    /**
     * 배열의 평균값을 반환합니다.
     *
     * @param array 평균을 구할 정수 배열
     * @return 배열의 평균
     */
    public static double getArrayAverage(int[] array) {
        return (double) getArraySum(array) / array.length;
    }

    // 점수를 설명하는 문자열을 반환하는 메서드입니다.
    public static String describeScore(int score) {
        if (score >= 90) {
            return "매우 우수한 점수입니다.";
        } else if (score >= 80) {
            return "좋은 점수입니다.";
        } else if (score >= 70) {
            return "보통 점수입니다.";
        }

        return "더 연습이 필요합니다.";
    }

    // 메서드 호출 흐름을 보기 위한 예제입니다.
    public static void startProgram() {
        System.out.println("프로그램 시작");
        processTask();
        System.out.println("프로그램 종료");
    }

    // 다른 메서드에서 호출되는 메서드입니다.
    public static void processTask() {
        System.out.println("작업 처리 중");
        finishTask();
    }

    // 메서드 호출의 마지막 단계 예제입니다.
    public static void finishTask() {
        System.out.println("작업 처리 완료");
    }

    // private 메서드는 이 클래스 내부에서만 사용할 수 있습니다.
    private static int multiply(int a, int b) {
        return a * b;
    }
}

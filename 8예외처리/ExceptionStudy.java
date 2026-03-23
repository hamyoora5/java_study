import java.io.FileReader;
import java.io.IOException;

// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// ExceptionStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class ExceptionStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 예외는 프로그램 실행 중에 발생하는 오류 상황입니다.
        // 예외가 발생했는데 처리하지 않으면 프로그램이 강제 종료될 수 있습니다.

        // try-catch는 예외가 발생할 수 있는 코드를 감싸고,
        // 예외가 발생했을 때 대신 실행할 코드를 작성하는 구조입니다.
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }

        // 배열 범위를 벗어나면 ArrayIndexOutOfBoundsException이 발생합니다.
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어났습니다.");
        }

        // null 참조로 메서드나 필드에 접근하면 NullPointerException이 발생합니다.
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("null 객체는 사용할 수 없습니다.");
        }

        // 숫자로 바꿀 수 없는 문자열을 parseInt()에 넣으면 NumberFormatException이 발생합니다.
        try {
            int number = Integer.parseInt("십");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다.");
        }

        // 하나의 try에 여러 catch를 둘 수도 있습니다.
        try {
            String[] values = {"10", "20"};
            System.out.println(Integer.parseInt(values[2]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 오류가 발생했습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 오류가 발생했습니다.");
        }

        // Exception은 많은 예외들의 부모 클래스입니다.
        // 구체적인 예외를 먼저 쓰고, 더 큰 범위의 예외를 나중에 써야 합니다.
        try {
            String value = null;
            System.out.println(value.length());
        } catch (NullPointerException e) {
            System.out.println("구체적인 예외 처리");
        } catch (Exception e) {
            System.out.println("모든 예외를 넓게 처리");
        }

        // 예외 객체 e에는 오류 정보가 들어 있습니다.
        try {
            int result = Integer.parseInt("abc");
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("예외 메시지: " + e.getMessage());
            System.out.println("예외 클래스 이름: " + e.getClass().getName());
        }

        // finally는 예외 발생 여부와 상관없이 항상 실행됩니다.
        try {
            System.out.println("try 블록 실행");
            int result = 5 / 1;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("산술 예외 발생");
        } finally {
            System.out.println("finally는 항상 실행됩니다.");
        }

        // finally는 예외가 발생한 경우에도 실행됩니다.
        try {
            System.out.println("예외가 발생하는 try 블록");
            int result = 5 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("예외 발생 후 catch 실행");
        } finally {
            System.out.println("예외가 있어도 finally 실행");
        }

        // 메서드에서 예외를 직접 처리할 수도 있습니다.
        divideWithCatch(10, 0);

        // 메서드가 예외를 throws로 넘기고, 호출한 쪽에서 처리할 수도 있습니다.
        try {
            divideWithThrows(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("throws로 넘겨진 예외를 main에서 처리했습니다.");
        }

        // throw는 예외를 직접 발생시킬 때 사용합니다.
        try {
            validateAge(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("throw로 발생시킨 예외: " + e.getMessage());
        }

        // 사용자 정의 예외도 만들 수 있습니다.
        try {
            checkScore(150);
        } catch (InvalidScoreException e) {
            System.out.println("사용자 정의 예외 처리: " + e.getMessage());
        }

        // checked exception은 컴파일 시점에 처리 여부를 확인하는 예외입니다.
        // IOException은 대표적인 checked exception입니다.
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("파일 처리 중 IOException 발생: " + e.getMessage());
        }

        // unchecked exception은 RuntimeException 계열로,
        // 컴파일러가 강제로 처리하라고 요구하지는 않지만 실제 실행 중 발생할 수 있습니다.
        explainUncheckedException();

        // 예외를 잡아서 프로그램이 계속 실행되도록 만들 수도 있습니다.
        System.out.println("예외 처리 후에도 프로그램은 계속 실행됩니다.");

        // 예외는 조건문처럼 활용되어서는 안 되고,
        // 예외적인 상황에서만 사용하는 것이 좋습니다.
    }

    // try-catch를 메서드 내부에서 처리하는 예제입니다.
    public static void divideWithCatch(int a, int b) {
        try {
            System.out.println("나눗셈 결과: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("divideWithCatch: 0으로 나눌 수 없습니다.");
        }
    }

    // throws는 이 메서드가 예외를 직접 처리하지 않고 호출한 쪽으로 넘긴다는 뜻입니다.
    public static int divideWithThrows(int a, int b) throws ArithmeticException {
        return a / b;
    }

    // 잘못된 값이 들어왔을 때 throw로 예외를 직접 발생시킬 수 있습니다.
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }

        System.out.println("올바른 나이입니다.");
    }

    // 사용자 정의 예외를 throw 하는 예제입니다.
    public static void checkScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("점수는 0부터 100 사이여야 합니다.");
        }

        System.out.println("정상 점수입니다.");
    }

    // checked exception을 발생시킬 수 있는 메서드 예제입니다.
    public static void readFile() throws IOException {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("없는파일.txt");
            System.out.println("파일을 열었습니다.");
        } finally {
            // 자원이 열려 있으면 닫고, null이면 아무 것도 하지 않습니다.
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    // RuntimeException 계열은 보통 프로그램 실행 중 잘못된 사용 때문에 발생합니다.
    public static void explainUncheckedException() {
        try {
            String text = null;
            System.out.println(text.toUpperCase());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException 계열 예외 처리: " + e.getClass().getSimpleName());
        }
    }
}

// Exception을 상속받아 사용자 정의 checked exception을 만들 수 있습니다.
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

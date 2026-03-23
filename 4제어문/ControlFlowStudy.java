// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// ControlFlowStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class ControlFlowStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // if문은 조건이 true일 때만 코드를 실행합니다.
        int score = 85;

        if (score >= 80) {
            System.out.println("if문: 점수가 80 이상입니다.");
        }

        // if-else문은 조건이 true, false일 때 각각 다른 코드를 실행합니다.
        int age = 17;

        if (age >= 19) {
            System.out.println("if-else문: 성인입니다.");
        } else {
            System.out.println("if-else문: 미성년자입니다.");
        }

        // if-else if-else문은 여러 조건을 순서대로 검사할 때 사용합니다.
        int ranking = 2;

        if (ranking == 1) {
            System.out.println("등수는 1등입니다.");
        } else if (ranking == 2) {
            System.out.println("등수는 2등입니다.");
        } else if (ranking == 3) {
            System.out.println("등수는 3등입니다.");
        } else {
            System.out.println("등수는 3등 밖입니다.");
        }

        // 중첩 if문은 if문 안에 또 다른 if문이 들어가는 구조입니다.
        boolean hasIdCard = true;
        int userAge = 20;

        if (userAge >= 19) {
            if (hasIdCard) {
                System.out.println("중첩 if문: 성인이며 신분증도 있습니다.");
            } else {
                System.out.println("중첩 if문: 성인이지만 신분증이 없습니다.");
            }
        } else {
            System.out.println("중첩 if문: 성인이 아닙니다.");
        }

        // switch문은 하나의 값에 따라 여러 경우를 나눌 때 사용합니다.
        int menu = 2;

        switch (menu) {
            case 1:
                System.out.println("switch문: 아메리카노를 선택했습니다.");
                break;
            case 2:
                System.out.println("switch문: 라테를 선택했습니다.");
                break;
            case 3:
                System.out.println("switch문: 주스를 선택했습니다.");
                break;
            default:
                System.out.println("switch문: 없는 메뉴입니다.");
        }

        // 문자열도 switch문으로 비교할 수 있습니다.
        String day = "MON";

        switch (day) {
            case "MON":
                System.out.println("문자열 switch문: 월요일입니다.");
                break;
            case "TUE":
                System.out.println("문자열 switch문: 화요일입니다.");
                break;
            default:
                System.out.println("문자열 switch문: 다른 요일입니다.");
        }

        // for문은 반복 횟수가 정해져 있을 때 자주 사용합니다.
        for (int i = 1; i <= 5; i++) {
            System.out.println("for문 반복: " + i);
        }

        // for문은 배열이나 규칙적인 반복에도 자주 사용합니다.
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("짝수 출력: " + i);
        }

        // while문은 조건이 true인 동안 계속 반복합니다.
        int number = 1;

        while (number <= 3) {
            System.out.println("while문 반복: " + number);
            number++;
        }

        // do-while문은 먼저 한 번 실행한 뒤 조건을 검사합니다.
        int count = 1;

        do {
            System.out.println("do-while문 반복: " + count);
            count++;
        } while (count <= 3);

        // break는 반복문을 즉시 종료합니다.
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("break 실행");
                break;
            }

            System.out.println("break 전 반복값: " + i);
        }

        // continue는 현재 반복만 건너뛰고 다음 반복으로 넘어갑니다.
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("continue 실행");
                continue;
            }

            System.out.println("continue 예제 값: " + i);
        }

        // 중첩 반복문은 반복문 안에 또 다른 반복문이 들어가는 구조입니다.
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.println("중첩 반복문 i: " + i + ", j: " + j);
            }
        }

        // 구구단처럼 반복 규칙이 있는 출력에 중첩 반복문이 자주 사용됩니다.
        for (int dan = 2; dan <= 3; dan++) {
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " x " + i + " = " + (dan * i));
            }
        }

        // 조건문과 반복문을 함께 사용하면 원하는 값만 골라 처리할 수 있습니다.
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("짝수만 출력: " + i);
            }
        }

        // 무한 반복은 조건이 항상 true라서 계속 반복되는 구조입니다.
        // 실제로는 break 같은 종료 조건을 함께 두는 경우가 많습니다.
        int infiniteExample = 1;
        while (true) {
            System.out.println("무한 반복 예제 값: " + infiniteExample);
            infiniteExample++;

            if (infiniteExample > 3) {
                break;
            }
        }
    }
}

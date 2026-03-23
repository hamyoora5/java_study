import java.util.Arrays;

// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// ArrayStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class ArrayStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 배열은 같은 자료형의 여러 값을 한 번에 저장하는 자료구조입니다.
        // int[]는 정수 배열을 의미합니다.
        int[] numbers = {10, 20, 30, 40, 50};

        // 배열 이름.length는 배열의 길이를 의미합니다.
        System.out.println("numbers 배열 길이: " + numbers.length);

        // 배열의 각 요소는 인덱스로 접근합니다.
        // 인덱스는 0부터 시작합니다.
        System.out.println("0번 인덱스 값: " + numbers[0]);
        System.out.println("2번 인덱스 값: " + numbers[2]);

        // 배열 요소의 값을 변경할 수도 있습니다.
        numbers[1] = 99;
        System.out.println("값 변경 후 1번 인덱스: " + numbers[1]);

        // new를 사용하면 원하는 길이의 배열을 만들 수 있습니다.
        int[] scores = new int[5];

        // int 배열은 값을 넣지 않으면 기본값 0으로 채워집니다.
        System.out.println("기본값 확인 scores[0]: " + scores[0]);

        // 배열에 직접 값을 저장할 수 있습니다.
        scores[0] = 70;
        scores[1] = 80;
        scores[2] = 90;
        scores[3] = 100;
        scores[4] = 95;

        // for문으로 배열 전체를 순회할 수 있습니다.
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] = " + scores[i]);
        }

        // 향상된 for문은 배열의 값을 하나씩 꺼낼 때 편리합니다.
        for (int score : scores) {
            System.out.println("향상된 for문 값: " + score);
        }

        // 배열의 합계를 구할 수 있습니다.
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        System.out.println("배열 합계: " + sum);

        // 평균도 계산할 수 있습니다.
        double average = (double) sum / scores.length;
        System.out.println("배열 평균: " + average);

        // 최댓값과 최솟값도 반복문으로 구할 수 있습니다.
        int max = scores[0];
        int min = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }

            if (scores[i] < min) {
                min = scores[i];
            }
        }

        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);

        // String 배열도 만들 수 있습니다.
        String[] names = {"김철수", "이영희", "박민수"};
        System.out.println("첫 번째 이름: " + names[0]);

        // char 배열은 문자들을 저장할 수 있습니다.
        char[] letters = {'J', 'A', 'V', 'A'};
        System.out.println("char 배열 첫 문자: " + letters[0]);

        // boolean 배열의 기본값은 false입니다.
        boolean[] checks = new boolean[3];
        System.out.println("boolean 배열 기본값: " + checks[0]);

        // double 배열의 기본값은 0.0입니다.
        double[] heights = new double[2];
        System.out.println("double 배열 기본값: " + heights[0]);

        // 참조형 배열의 기본값은 null입니다.
        String[] words = new String[2];
        System.out.println("String 배열 기본값: " + words[0]);

        // Arrays.toString()은 1차원 배열 전체를 보기 쉽게 출력합니다.
        System.out.println("numbers 배열 전체 출력: " + Arrays.toString(numbers));

        // Arrays.sort()는 배열을 오름차순 정렬합니다.
        int[] randomNumbers = {5, 2, 8, 1, 3};
        Arrays.sort(randomNumbers);
        System.out.println("정렬 후 배열: " + Arrays.toString(randomNumbers));

        // Arrays.binarySearch()는 정렬된 배열에서 값을 빠르게 찾습니다.
        int index = Arrays.binarySearch(randomNumbers, 3);
        System.out.println("값 3의 인덱스: " + index);

        // Arrays.fill()은 배열 전체를 같은 값으로 채웁니다.
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        System.out.println("fill 후 배열: " + Arrays.toString(filled));

        // 배열 복사는 clone()으로 할 수 있습니다.
        int[] cloneArray = numbers.clone();
        System.out.println("clone 배열: " + Arrays.toString(cloneArray));

        // Arrays.copyOf()는 원하는 길이만큼 복사할 수 있습니다.
        int[] copiedArray = Arrays.copyOf(numbers, 3);
        System.out.println("copyOf 배열: " + Arrays.toString(copiedArray));

        // Arrays.copyOfRange()는 원하는 구간만 잘라서 복사할 수 있습니다.
        int[] rangeCopyArray = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("copyOfRange 배열: " + Arrays.toString(rangeCopyArray));

        // System.arraycopy()는 배열 일부를 다른 배열로 복사할 때 사용합니다.
        int[] source = {1, 2, 3, 4, 5};
        int[] target = new int[5];
        System.arraycopy(source, 1, target, 0, 3);
        System.out.println("arraycopy 결과: " + Arrays.toString(target));

        // 배열끼리 내용이 같은지 비교할 때는 Arrays.equals()를 사용합니다.
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("배열 내용 비교: " + Arrays.equals(arr1, arr2));

        // 배열 변수는 실제 배열 객체의 주소를 참조합니다.
        int[] original = {10, 20, 30};
        int[] referenceCopy = original;
        referenceCopy[0] = 999;
        System.out.println("참조 복사 후 original: " + Arrays.toString(original));

        // 깊은 복사처럼 독립된 배열을 만들고 싶다면 새 배열에 값을 복사해야 합니다.
        int[] independentCopy = original.clone();
        independentCopy[1] = 777;
        System.out.println("독립 복사 후 original: " + Arrays.toString(original));
        System.out.println("독립 복사 후 independentCopy: " + Arrays.toString(independentCopy));

        // 두 요소의 자리를 바꾸는 것은 배열 문제에서 자주 나옵니다.
        int[] swapArray = {1, 2, 3};
        int temp = swapArray[0];
        swapArray[0] = swapArray[2];
        swapArray[2] = temp;
        System.out.println("값 교환 후 배열: " + Arrays.toString(swapArray));

        // 배열 뒤집기도 자주 나오는 기본 패턴입니다.
        int[] reverseArray = {1, 2, 3, 4, 5};
        for (int i = 0; i < reverseArray.length / 2; i++) {
            int tempValue = reverseArray[i];
            reverseArray[i] = reverseArray[reverseArray.length - 1 - i];
            reverseArray[reverseArray.length - 1 - i] = tempValue;
        }
        System.out.println("뒤집은 배열: " + Arrays.toString(reverseArray));

        // 특정 값이 몇 개 있는지 세는 것도 많이 나오는 패턴입니다.
        int[] countArray = {1, 2, 2, 3, 2, 4};
        int targetNumber = 2;
        int targetCount = 0;

        for (int value : countArray) {
            if (value == targetNumber) {
                targetCount++;
            }
        }
        System.out.println("숫자 2의 개수: " + targetCount);

        // 배열에서 특정 값을 직접 찾을 수도 있습니다.
        int findValue = 4;
        int foundIndex = -1;

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == findValue) {
                foundIndex = i;
                break;
            }
        }
        System.out.println("숫자 4의 위치: " + foundIndex);

        // 모든 요소가 같은지 검사하는 패턴도 있습니다.
        int[] sameArray = {7, 7, 7, 7};
        boolean allSame = true;

        for (int i = 1; i < sameArray.length; i++) {
            if (sameArray[i] != sameArray[0]) {
                allSame = false;
                break;
            }
        }
        System.out.println("모든 값이 같은가: " + allSame);

        // 선택 정렬처럼 배열을 직접 정렬하는 원리도 알아두면 좋습니다.
        int[] manualSortArray = {4, 1, 5, 2, 3};
        for (int i = 0; i < manualSortArray.length - 1; i++) {
            for (int j = i + 1; j < manualSortArray.length; j++) {
                if (manualSortArray[i] > manualSortArray[j]) {
                    int tempNumber = manualSortArray[i];
                    manualSortArray[i] = manualSortArray[j];
                    manualSortArray[j] = tempNumber;
                }
            }
        }
        System.out.println("직접 정렬한 배열: " + Arrays.toString(manualSortArray));

        // 2차원 배열은 배열 안에 배열이 들어 있는 구조입니다.
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // 2차원 배열도 인덱스로 접근합니다.
        System.out.println("matrix[0][1]: " + matrix[0][1]);
        System.out.println("matrix[1][2]: " + matrix[1][2]);

        // 2차원 배열의 행 개수는 matrix.length로 구합니다.
        System.out.println("행 개수: " + matrix.length);

        // 각 행의 열 개수는 matrix[행번호].length로 구합니다.
        System.out.println("첫 번째 행의 열 개수: " + matrix[0].length);

        // 중첩 반복문으로 2차원 배열 전체를 순회할 수 있습니다.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("matrix[" + i + "][" + j + "] = " + matrix[i][j]);
            }
        }

        // Arrays.deepToString()은 2차원 배열 전체를 출력할 때 사용합니다.
        System.out.println("2차원 배열 출력: " + Arrays.deepToString(matrix));

        // 가변 배열은 각 행의 길이가 서로 달라도 되는 2차원 배열입니다.
        int[][] jaggedArray = {
                {1, 2},
                {3, 4, 5},
                {6}
        };
        System.out.println("가변 배열 출력: " + Arrays.deepToString(jaggedArray));

        // 2차원 배열의 전체 합계도 중첩 반복문으로 구할 수 있습니다.
        int matrixSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixSum += matrix[i][j];
            }
        }
        System.out.println("2차원 배열 전체 합계: " + matrixSum);

        // 2차원 배열도 new를 사용해서 만들 수 있습니다.
        int[][] seats = new int[2][3];
        seats[0][0] = 1;
        seats[0][1] = 2;
        seats[0][2] = 3;
        seats[1][0] = 4;
        seats[1][1] = 5;
        seats[1][2] = 6;
        System.out.println("new로 만든 2차원 배열: " + Arrays.deepToString(seats));

        // final 배열은 참조 대상을 다시 바꿀 수는 없지만 내부 값은 변경할 수 있습니다.
        final int[] finalArray = {1, 2, 3};
        finalArray[0] = 100;
        System.out.println("final 배열의 내부 값 변경: " + Arrays.toString(finalArray));

        // 배열을 메서드에 전달해서 합계를 구할 수도 있습니다.
        System.out.println("메서드로 구한 합계: " + getSum(scores));

        // 배열을 메서드에 전달해서 최댓값을 구할 수도 있습니다.
        System.out.println("메서드로 구한 최댓값: " + getMax(scores));

        // 배열을 메서드에 전달해서 최솟값을 구할 수도 있습니다.
        System.out.println("메서드로 구한 최솟값: " + getMin(scores));

        // 메서드가 새 배열을 만들어 반환할 수도 있습니다.
        int[] doubledArray = createDoubledArray(new int[]{1, 2, 3, 4});
        System.out.println("메서드가 반환한 배열: " + Arrays.toString(doubledArray));

        // 배열의 각 요소를 한 줄로 출력하는 메서드도 만들 수 있습니다.
        printArray(numbers);

        // 배열의 범위를 벗어난 인덱스를 사용하면 예외가 발생합니다.
        // 예: numbers[10] 처럼 없는 위치에 접근하면 오류가 납니다.

        // 배열은 크기가 고정되어 있어서 한 번 만들면 길이를 바꿀 수 없습니다.
        // 크기를 바꾸고 싶으면 새 배열을 만들거나 ArrayList 같은 컬렉션을 사용합니다.

        // 배열은 문제 풀이에서 매우 자주 사용됩니다.
        // 입력 저장, 최댓값과 최솟값 찾기, 정렬, 탐색, 누적합, 빈도 계산 등에 자주 쓰입니다.
    }

    // 배열의 합계를 구하는 메서드입니다.
    public static int getSum(int[] array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum;
    }

    // 배열의 최댓값을 구하는 메서드입니다.
    public static int getMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    // 배열의 최솟값을 구하는 메서드입니다.
    public static int getMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    // 배열을 받아서 각 값을 2배로 만든 새 배열을 반환합니다.
    public static int[] createDoubledArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * 2;
        }

        return result;
    }

    // 배열의 값을 한 줄씩 출력하는 메서드입니다.
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("printArray 메서드 값: " + array[i]);
        }
    }
}

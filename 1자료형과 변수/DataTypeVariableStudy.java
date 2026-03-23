// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바에서 코드를 담는 기본 단위입니다.
// DataTypeVariableStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class DataTypeVariableStudy {
    // public은 자바가 이 메서드를 찾을 수 있게 해줍니다.
    // static은 객체를 만들지 않고도 바로 실행할 수 있다는 뜻입니다.
    // void는 이 메서드가 실행 후 값을 돌려주지 않는다는 뜻입니다.
    // main은 자바 프로그램이 가장 먼저 시작하는 특별한 메서드 이름입니다.
    // String[] args는 실행할 때 전달하는 문자열 값들을 저장하는 자리입니다.
    public static void main(String[] args) {
        // int는 정수를 저장하는 자료형입니다.
        // age라는 이름의 변수를 만들고 20을 저장합니다.
        int age = 20;

        // long은 int보다 더 큰 정수를 저장할 때 사용하는 자료형입니다.
        // 숫자 뒤에 L을 붙여서 long 값이라는 것을 표시합니다.
        long population = 51000000L;

        // double은 소수점이 있는 실수를 저장하는 자료형입니다.
        // height 변수에 175.5를 저장합니다.
        double height = 175.5;

        // float도 실수를 저장하는 자료형이지만 double보다 크기가 작습니다.
        // float 값을 쓸 때는 숫자 뒤에 f를 붙입니다.
        float weight = 68.3f;

        // char는 문자 1개를 저장하는 자료형입니다.
        // 문자는 작은따옴표(' ')로 감쌉니다.
        char grade = 'A';

        // String은 문자열을 저장하는 자료형입니다.
        // 문자열은 큰따옴표(" ")로 감쌉니다.
        String name = "홍길동";

        // boolean은 참(true) 또는 거짓(false)만 저장하는 자료형입니다.
        boolean isStudent = true;

        // println은 괄호 안의 내용을 출력하고 줄을 바꿉니다.
        // "이름: " 문자열과 name 변수의 값을 이어서 출력합니다.
        System.out.println("이름: " + name);

        // age 변수에 저장된 값을 출력합니다.
        System.out.println("나이: " + age);

        // height 변수에 저장된 실수 값을 출력합니다.
        System.out.println("키: " + height);

        // weight 변수에 저장된 float 값을 출력합니다.
        System.out.println("몸무게: " + weight);

        // grade 변수에 저장된 문자 1개를 출력합니다.
        System.out.println("학점: " + grade);

        // isStudent 변수에 저장된 true 값을 출력합니다.
        System.out.println("학생 여부: " + isStudent);

        // population 변수에 저장된 long 값을 출력합니다.
        System.out.println("인구수: " + population);

        // 이미 만들어진 age 변수의 값을 21로 바꿉니다.
        age = 21;

        // 변경된 age 값을 다시 출력합니다.
        System.out.println("1년 후 나이: " + age);

        // final을 붙이면 값을 한 번만 저장할 수 있는 상수가 됩니다.
        // PI는 원주율을 의미하는 상수 이름입니다.
        final double PI = 3.14159;

        // 상수 PI의 값을 출력합니다.
        System.out.println("원주율: " + PI);

        // int형 변수 number를 만들고 10을 저장합니다.
        int number = 10;

        // int 값을 double 변수에 넣으면 자동으로 형변환이 일어납니다.
        // 정수 10이 실수 10.0 형태로 저장됩니다.
        double convertedNumber = number;

        // 자동 형변환된 결과를 출력합니다.
        System.out.println("자동 형변환: " + convertedNumber);

        // double형 변수 score를 만들고 95.8을 저장합니다.
        double score = 95.8;

        // (int)를 앞에 붙이면 강제 형변환을 의미합니다.
        // 소수점 아래는 버려지고 95만 저장됩니다.
        int changedScore = (int) score;

        // 강제 형변환된 결과를 출력합니다.
        System.out.println("강제 형변환: " + changedScore);
    }
}

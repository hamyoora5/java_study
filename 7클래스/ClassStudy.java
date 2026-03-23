import java.util.Arrays;

// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// ClassStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
/**
 * 자바 클래스와 객체, 생성자, 필드, 메서드 사용법을 학습하기 위한 예제 클래스입니다.
 */
public class ClassStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 클래스는 설계도이고 객체는 그 설계도로 만든 실제 결과물입니다.
        // Student 클래스라는 설계도로 student1, student2 객체를 만들 수 있습니다.

        // new는 객체를 생성할 때 사용하는 키워드입니다.
        Student student1 = new Student();

        // 객체의 필드에 값을 저장할 수 있습니다.
        student1.name = "홍길동";
        student1.age = 20;
        student1.score = 95;

        // 객체의 필드 값을 출력할 수 있습니다.
        System.out.println("student1 이름: " + student1.name);
        System.out.println("student1 나이: " + student1.age);
        System.out.println("student1 점수: " + student1.score);

        // 객체 안에 있는 메서드도 호출할 수 있습니다.
        student1.introduce();
        System.out.println("student1 통과 여부: " + student1.isPass());

        // 생성자는 객체가 만들어질 때 자동으로 호출되는 특별한 메서드입니다.
        Student student2 = new Student("김자바", 22, 88);
        student2.introduce();

        // 생성자 오버로딩으로 다양한 방식의 객체 생성을 지원할 수 있습니다.
        Student student3 = new Student("이코드");
        student3.introduce();

        // this는 현재 객체 자신을 가리킵니다.
        // 아래 메서드는 this를 이용해 현재 객체의 필드 값을 바꿉니다.
        student3.setInfo("이코드", 21, 77);
        student3.introduce();

        // getter와 setter는 private 필드에 안전하게 접근할 때 사용합니다.
        BankAccount account = new BankAccount("123-456", "박사용");
        account.deposit(10000);
        account.withdraw(3000);
        System.out.println("계좌 번호: " + account.getAccountNumber());
        System.out.println("예금주: " + account.getOwnerName());
        System.out.println("잔액: " + account.getBalance());

        // 잘못된 값이 들어오지 않도록 setter나 메서드 안에서 검사할 수 있습니다.
        account.withdraw(50000);

        // 객체 변수는 객체 자체를 저장하는 것이 아니라 객체의 참조를 저장합니다.
        Student referenceStudent = student2;
        referenceStudent.name = "공유참조";
        System.out.println("student2 이름 변경 확인: " + student2.name);

        // null은 아무 객체도 참조하지 않는 상태입니다.
        Student emptyStudent = null;
        System.out.println("null 참조 예시: " + emptyStudent);

        // 객체 배열도 만들 수 있습니다.
        Student[] students = new Student[3];
        students[0] = new Student("학생1", 20, 90);
        students[1] = new Student("학생2", 21, 80);
        students[2] = new Student("학생3", 22, 70);

        for (Student student : students) {
            student.introduce();
        }

        // 객체 배열에서 점수만 따로 꺼내 쓸 수도 있습니다.
        int[] studentScores = new int[students.length];
        for (int i = 0; i < students.length; i++) {
            studentScores[i] = students[i].score;
        }
        System.out.println("학생 점수 배열: " + Arrays.toString(studentScores));

        // static 필드는 객체마다 따로 생기지 않고 클래스 전체가 함께 사용합니다.
        System.out.println("생성된 학생 수: " + Student.count);

        // static 메서드는 객체 없이 클래스 이름으로 호출할 수 있습니다.
        System.out.println("학교 이름: " + Student.getSchoolName());

        // final 필드는 한 번 값이 정해지면 다시 바꿀 수 없습니다.
        System.out.println("주민등록번호 같은 고정값 예시: " + student2.studentId);

        // 클래스 안에 메서드를 여러 개 둘 수 있고 객체 상태를 이용해 계산할 수 있습니다.
        System.out.println("student2 등급: " + student2.getGrade());

        // 참조 비교는 == 로 할 수 있습니다.
        System.out.println("student2와 referenceStudent가 같은 객체인가: " + (student2 == referenceStudent));
        System.out.println("student1과 student2가 같은 객체인가: " + (student1 == student2));

        // 객체의 정보를 문자열로 보고 싶을 때 toString()을 오버라이드하면 편리합니다.
        System.out.println("student2 객체 정보: " + student2);

        // 클래스는 서로 협력할 수 있습니다.
        Classroom classroom = new Classroom("자바 기초반", students);
        classroom.printClassInfo();
        System.out.println("반 평균 점수: " + classroom.getAverageScore());

        // 인스턴스 필드는 객체마다 따로 존재합니다.
        Student anotherStudent = new Student("별도학생", 19, 100);
        System.out.println("anotherStudent 이름: " + anotherStudent.name);
        System.out.println("student1 이름: " + student1.name);

        // 객체를 메서드에 전달할 수도 있습니다.
        celebrateHighScore(anotherStudent);
        anotherStudent.introduce();

        // 객체를 메서드에서 반환할 수도 있습니다.
        Student topStudent = createTopStudent();
        System.out.println("메서드가 반환한 객체: " + topStudent);

        // 익명으로 바로 객체를 만들어 사용할 수도 있습니다.
        new Student("임시학생", 18, 60).introduce();
    }

    /**
     * 점수가 높은 학생에게 보너스 점수를 추가합니다.
     *
     * @param student 점수를 확인할 학생 객체
     */
    public static void celebrateHighScore(Student student) {
        if (student.score >= 90) {
            student.score += 5;
            System.out.println(student.name + " 학생에게 보너스 점수를 줍니다.");
        }
    }

    /**
     * 최우수 학생 객체를 새로 만들어 반환합니다.
     *
     * @return 새로 생성한 Student 객체
     */
    public static Student createTopStudent() {
        return new Student("최우수", 20, 100);
    }
}

// Student 클래스는 학생 한 명의 정보를 표현하는 설계도입니다.
/**
 * 학생 한 명의 상태와 동작을 표현하는 예제 클래스입니다.
 */
class Student {
    // 필드는 객체가 가지는 데이터입니다.
    String name;
    int age;
    int score;

    // static 필드는 모든 Student 객체가 함께 공유합니다.
    static int count = 0;
    static String schoolName = "코딩고등학교";

    // final 필드는 한 번 초기화하면 바꿀 수 없습니다.
    final String studentId;

    /**
     * 기본값으로 학생 객체를 생성합니다.
     */
    Student() {
        this.name = "이름없음";
        this.age = 0;
        this.score = 0;
        this.studentId = "ID-" + (++count);
    }

    // 생성자 오버로딩으로 다양한 초기화 방법을 제공할 수 있습니다.
    Student(String name) {
        this.name = name;
        this.age = 0;
        this.score = 0;
        this.studentId = "ID-" + (++count);
    }

    /**
     * 이름, 나이, 점수를 받아 학생 객체를 생성합니다.
     *
     * @param name 학생 이름
     * @param age 학생 나이
     * @param score 학생 점수
     */
    Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.studentId = "ID-" + (++count);
    }

    /**
     * 학생 정보를 화면에 출력합니다.
     */
    void introduce() {
        System.out.println("학생 이름: " + name + ", 나이: " + age + ", 점수: " + score);
    }

    // boolean 값을 반환하는 메서드입니다.
    boolean isPass() {
        return score >= 60;
    }

    // this는 현재 객체를 가리키므로 필드와 매개변수 이름이 같을 때 구분할 수 있습니다.
    void setInfo(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    /**
     * 점수를 기준으로 학점을 반환합니다.
     *
     * @return 계산된 학점 문자열
     */
    String getGrade() {
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

    // static 메서드는 static 필드에 접근할 때 자주 사용합니다.
    static String getSchoolName() {
        return schoolName;
    }

    // toString()을 재정의하면 객체 출력 결과를 보기 쉽게 만들 수 있습니다.
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", score=" + score + ", studentId='" + studentId + "'}";
    }
}

// BankAccount 클래스는 캡슐화를 보여 주는 예제입니다.
/**
 * private 필드와 사용자 정의 메서드로 캡슐화를 설명하기 위한 예제 클래스입니다.
 */
class BankAccount {
    // private 필드는 외부에서 직접 접근하지 못하게 막습니다.
    private String accountNumber;
    private String ownerName;
    private int balance;

    /**
     * 계좌번호와 예금주 이름을 받아 계좌 객체를 생성합니다.
     *
     * @param accountNumber 계좌번호
     * @param ownerName 예금주 이름
     */
    BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    // 아래 메서드들은 모두 BankAccount 클래스 안에 직접 만든 사용자 정의 메서드입니다.
    // 즉, 자바가 자동으로 만들어 준 것이 아니라 우리가 필요에 따라 작성한 메서드입니다.

    /**
     * 계좌번호를 반환합니다.
     *
     * @return 계좌번호 문자열
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 예금주 이름을 반환합니다.
     *
     * @return 예금주 이름
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 현재 잔액을 반환합니다.
     *
     * @return 현재 잔액
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 계좌에 금액을 입금합니다.
     *
     * @param amount 입금할 금액
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return;
        }

        balance += amount;
        System.out.println(amount + "원 입금 완료");
    }

    /**
     * 계좌에서 금액을 출금합니다.
     *
     * @param amount 출금할 금액
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }

        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        balance -= amount;
        System.out.println(amount + "원 출금 완료");
    }
}

// Classroom 클래스는 다른 객체들을 필드로 가질 수도 있음을 보여 줍니다.
class Classroom {
    String className;
    Student[] students;

    Classroom(String className, Student[] students) {
        this.className = className;
        this.students = students;
    }

    void printClassInfo() {
        System.out.println("반 이름: " + className);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    double getAverageScore() {
        int sum = 0;

        for (Student student : students) {
            sum += student.score;
        }

        return (double) sum / students.length;
    }
}

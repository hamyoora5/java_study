import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// FileIOStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class FileIOStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 파일 입출력은 파일에 데이터를 저장하거나 파일에서 데이터를 읽어 오는 작업입니다.
        // 입출력은 예외가 자주 발생할 수 있으므로 try-catch가 많이 사용됩니다.

        // Path는 파일이나 폴더 경로를 표현하는 객체입니다.
        Path studyDir = Paths.get("study_io");
        Path textFile = studyDir.resolve("sample.txt");
        Path byteFile = studyDir.resolve("sample_bytes.dat");

        try {
            // createDirectories()는 폴더가 없으면 만들고, 이미 있으면 그대로 둡니다.
            Files.createDirectories(studyDir);
            System.out.println("폴더 생성 또는 확인 완료: " + studyDir.toAbsolutePath());

            // File 객체는 파일이나 폴더 정보를 다룰 때 사용합니다.
            File folder = studyDir.toFile();
            System.out.println("폴더 존재 여부: " + folder.exists());
            System.out.println("폴더인가: " + folder.isDirectory());

            // 문자 스트림을 사용한 파일 쓰기 예제입니다.
            // FileWriter는 문자를 파일에 기록하는 클래스입니다.
            FileWriter writer = new FileWriter(textFile.toFile(), StandardCharsets.UTF_8);
            writer.write("자바 파일 입출력 공부\n");
            writer.write("FileWriter로 첫 줄과 둘째 줄을 기록합니다.\n");
            writer.close();

            // FileReader는 문자 단위로 파일을 읽는 클래스입니다.
            FileReader reader = new FileReader(textFile.toFile(), StandardCharsets.UTF_8);
            int data;
            System.out.println("FileReader로 한 글자씩 읽기 시작");
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            reader.close();
            System.out.println();

            // BufferedWriter는 버퍼를 사용해서 문자 출력을 더 효율적으로 해 줍니다.
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(textFile.toFile(), StandardCharsets.UTF_8, true))) {
                bufferedWriter.write("BufferedWriter로 추가한 줄입니다.");
                bufferedWriter.newLine();
                bufferedWriter.write("버퍼를 사용하면 효율이 좋아집니다.");
                bufferedWriter.newLine();
            }

            // BufferedReader는 한 줄씩 읽기에 편리합니다.
            try (BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(textFile.toFile(), StandardCharsets.UTF_8))) {
                String line;
                System.out.println("BufferedReader로 한 줄씩 읽기");
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("읽은 줄: " + line);
                }
            }

            // 바이트 스트림은 이미지, 영상, 실행 파일 같은 바이너리 데이터에도 사용됩니다.
            // FileOutputStream은 바이트 단위로 파일에 기록합니다.
            try (FileOutputStream outputStream = new FileOutputStream(byteFile.toFile())) {
                outputStream.write(65);
                outputStream.write(66);
                outputStream.write(67);
            }

            // FileInputStream은 바이트 단위로 파일을 읽습니다.
            try (FileInputStream inputStream = new FileInputStream(byteFile.toFile())) {
                int byteData;
                System.out.println("바이트 파일 읽기");
                while ((byteData = inputStream.read()) != -1) {
                    System.out.println("읽은 바이트 값: " + byteData + ", 문자로는: " + (char) byteData);
                }
            }

            // Files.writeString()은 문자열 전체를 간단하게 저장할 때 편리합니다.
            Files.writeString(textFile, "Files.writeString으로 전체 내용을 새로 씁니다.\n다음 줄도 함께 저장합니다.",
                    StandardCharsets.UTF_8);

            // Files.readString()은 파일 전체 내용을 한 번에 읽습니다.
            String fileContent = Files.readString(textFile, StandardCharsets.UTF_8);
            System.out.println("Files.readString 결과:");
            System.out.println(fileContent);

            // Files.write()로 여러 줄을 한 번에 저장할 수도 있습니다.
            List<String> linesToWrite = List.of("첫 번째 줄", "두 번째 줄", "세 번째 줄");
            Files.write(textFile, linesToWrite, StandardCharsets.UTF_8);

            // Files.readAllLines()는 파일의 모든 줄을 리스트로 읽어 옵니다.
            List<String> readLines = Files.readAllLines(textFile, StandardCharsets.UTF_8);
            System.out.println("readAllLines 결과: " + readLines);

            // 파일 정보 확인도 자주 사용됩니다.
            System.out.println("파일 존재 여부: " + Files.exists(textFile));
            System.out.println("파일 크기: " + Files.size(textFile) + " bytes");
            System.out.println("파일 이름: " + textFile.getFileName());
            System.out.println("절대 경로: " + textFile.toAbsolutePath());

            // 파일 복사 예제입니다.
            Path copyFile = studyDir.resolve("copy.txt");
            Files.copy(textFile, copyFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            System.out.println("파일 복사 완료: " + copyFile.getFileName());

            // 파일 이동 또는 이름 변경 예제입니다.
            Path movedFile = studyDir.resolve("moved.txt");
            Files.move(copyFile, movedFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            System.out.println("파일 이동 또는 이름 변경 완료: " + movedFile.getFileName());

            // append 방식으로 이어 쓰는 예제입니다.
            try (BufferedWriter appendWriter = new BufferedWriter(
                    new FileWriter(movedFile.toFile(), StandardCharsets.UTF_8, true))) {
                appendWriter.write("추가로 이어 쓴 내용입니다.");
                appendWriter.newLine();
            }

            // try-with-resources는 사용이 끝난 자원을 자동으로 닫아 줍니다.
            printFileWithTryWithResources(movedFile);

            // 메서드로 파일에 문자열 저장하기
            Path memoFile = studyDir.resolve("memo.txt");
            saveText(memoFile, "메서드로 저장한 메모입니다.");
            System.out.println("memo.txt 내용: " + loadText(memoFile));

            // 없는 파일을 읽으려고 하면 예외가 발생할 수 있습니다.
            try {
                Files.readString(studyDir.resolve("not_found.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println("없는 파일 읽기 실패: " + e.getMessage());
            }

            // 파일 삭제 예제입니다.
            Files.deleteIfExists(byteFile);
            System.out.println("byte 파일 삭제 여부 확인: " + Files.exists(byteFile));
        } catch (IOException e) {
            System.out.println("파일 입출력 중 예외 발생: " + e.getMessage());
        }
    }

    // try-with-resources를 사용한 파일 읽기 메서드입니다.
    public static void printFileWithTryWithResources(Path path) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            System.out.println("try-with-resources로 파일 읽기");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("내용: " + line);
            }
        }
    }

    // 파일에 텍스트를 저장하는 메서드입니다.
    public static void saveText(Path path, String text) throws IOException {
        Files.writeString(path, text, StandardCharsets.UTF_8);
    }

    // 파일에서 텍스트를 읽어 오는 메서드입니다.
    public static String loadText(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}

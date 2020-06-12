package newpackage;

public class Main {
    public static void main(String[] args) {
        SMS cl = new SMS();
        try {
            cl.Message("01032042646");
            // 입력 받는 부분

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import Config.GlobalException;
import Config.SeedData;

public class Main {
    public static void main(String[] args) {
        GlobalException.setup();
        new UI.LoginFrame();
        new SeedData();
        new UI.BookDetailForm(7);
    }
}
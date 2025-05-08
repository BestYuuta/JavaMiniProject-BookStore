package Config;

public class GlobalException implements Thread.UncaughtExceptionHandler {

    public static void setup() {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalException());
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg = e.getMessage();
        if (msg == null || msg.isBlank()) {
            msg = e.toString();
        }
        CustomDialog.show(false, "Unexpected Error:\n" + msg);
    }
}
public class FailedLoginCounter {
    private static final FailedLoginCounter INSTANCE = new FailedLoginCounter();

    private FailedLoginCounter() {
    }

    public static FailedLoginCounter get_count_fails() {
        return INSTANCE;
    }
}

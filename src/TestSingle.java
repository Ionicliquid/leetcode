public class TestSingle {


    private TestSingle() {
    }
    private static volatile TestSingle instance;

    public static synchronized TestSingle getInstance() {
        if (instance == null) {
            synchronized (TestSingle.class) {
                if (instance == null) {
                    instance = new TestSingle();
                }
            }

        }
        return instance;

    }
}

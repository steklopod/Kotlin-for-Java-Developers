

public class MySingleton {
    private static MySingleton INSTANCE = null;

    private MySingleton(){}

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MySingleton();
        }
    }

    public static MySingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
}

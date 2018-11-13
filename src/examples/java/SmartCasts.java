

public class SmartCasts {
    class Service {
        public void callService() {
            // ..
        }
    }

    public void myFunction(Object obj) {
        if (obj instanceof Service) {
            ((Service) obj).callService();
        }
    }
}

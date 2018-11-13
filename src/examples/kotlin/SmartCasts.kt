package examples.kotlin

class Service {
    public fun callService() {
        // ..
    }
}

public fun myFunction(obj: Any) {
    if (obj is Service) {
        obj.callService()
    }
}
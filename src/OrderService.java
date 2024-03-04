public class OrderService {
    String getOrder(int orderId) {
        Utils.randomSleep();
        return STR."Order \{orderId}";
    }
}

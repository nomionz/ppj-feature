import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.ExecutionException;

public class InvoiceService {
    private OrderService orderService;
    private TemplateService templateService;

    public InvoiceService(OrderService orderService, TemplateService templateService) {
        this.orderService = orderService;
        this.templateService = templateService;
    }

    String createInvoice(int orderId, String language) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Subtask<String> orderTask = scope.fork(() -> orderService.getOrder(orderId));
            Subtask<String> templateTask = scope.fork(() -> templateService.getTemplate(language));

            scope.join();
            scope.throwIfFailed();

            String order = orderTask.get();
            String template = templateTask.get();

            return generate(order, template);
        }
    }

    private String generate(String order, String template) {
        Utils.randomSleep();
        return STR."Invoice order: \{order} and template: \{template}";
    }
}

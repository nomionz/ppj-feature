import java.util.concurrent.ExecutionException;
public class Main {
    public static void main(String[] args) {
        int orderId = 123;
        String language = "EN";

        InvoiceService invoiceService = new InvoiceService(new OrderService(), new TemplateService());

        try {
            String invoice = invoiceService.createInvoice(orderId, language);
            System.out.println("Invoice created successfully: " + invoice);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Invoice creation was interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("An error occurred during invoice creation: " + e.getCause().getMessage());
        }
    }
}

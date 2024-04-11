package OrderModifier;

import MainMenu.Invoice;
import java.util.ArrayList;

public class ViewCustomerInvoice {
    public static void viewInvoices() {
        // Get invoices ArrayList
        ArrayList<Invoice> invoices = Invoice.getInvoiceList();

        // Check if the list of invoices is empty
        if (invoices.isEmpty()) {
            System.out.println("No Invoice Available.");
        } else {
            // Iterate through the list of invoices
            for (Invoice invoice : invoices) {
                // Generate and display the invoice details
                invoice.generateInvoice();
            }
        }
    }
}

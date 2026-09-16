public class Bar {
    void main(String[] args) {
        System.out.println("""
            ====================================
                       MENU DEL BAR
            ====================================""");

        System.out.printf("%-10s %-10s %-10s%n", "PRODOTTO", "PREZZO", "DISPONIBILE");
        System.out.printf("%-10s %-10s %-10s%n", "Caffè", "1.20", "SI");
        System.out.printf("%-10s %-10s %-10s%n", "Cappuccino", "1.80", "SI");
        System.out.printf("%-10s %-10s %-10s%n", "Brioche", "1.50", "NO");
        System.out.printf("%-10s %-10s %-10s%n", "Acqua", "1.00", "SI");
    }
}
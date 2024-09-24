public class Conversor {
    double conversion_rate;
    String base_code;
    String target_code;

    public Conversor(CurrencyRecord currencyRecord){
        this.conversion_rate = Double.parseDouble(currencyRecord.conversion_rate());
        this.base_code = currencyRecord.base_code();
        this.target_code = currencyRecord.target_code();
    }

    public void result(double quantityToExchange) {
        System.out.println(
                "You are converting " + base_code + " to " + target_code + " The converted amount is: " + quantityToExchange * conversion_rate + target_code);
    }
}

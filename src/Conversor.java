import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversor {
    double conversion_rate;
    String base_code;
    String target_code;
    String historyText;
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Conversor(CurrencyRecord currencyRecord){
        this.conversion_rate = Double.parseDouble(currencyRecord.conversion_rate());
        this.base_code = currencyRecord.base_code();
        this.target_code = currencyRecord.target_code();
    }

    public void result(double quantityToExchange) {
        double op = quantityToExchange * conversion_rate;
        BigDecimal round = new BigDecimal(op);
        BigDecimal result = round.setScale(2, RoundingMode.HALF_UP);
        System.out.println("You are converting " + base_code + " to " + target_code +
                        " The converted amount is: " + result + " "+ target_code + " at a rate of " + conversion_rate + " " + target_code +
                " per " + base_code );

      historyText = "["+ time.format(formatter) +"]" + "Converted " + quantityToExchange + " " + base_code + " to " + target_code +
              ". The total amount was " + result + " " + target_code;
    }
}

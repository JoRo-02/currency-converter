import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String currencyToConvert = "";
        String targetCurrency;
        double quantityToExchange;
        System.out.println("Welcome");
        System.out.println();
        System.out.println("*************************************");
        String menu = """
                -UNITED STATES DOLLAR (USD)
                -EURO (EUR)
                -JAPANESE YEN (JPY)
                -BRAZILIAN REAL (BRL)
                -DOMINICAN PESO (DOP)
                -ARGENTINE PESO (ARS)
                -MEXICAN PESO (MXN)
                -CLOSE
                """;
        while (!currencyToConvert.equals("CLOSE")){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the code of the currency you want to convert from:");
            System.out.println(menu);
            currencyToConvert = input.nextLine();

            if (currencyToConvert.equalsIgnoreCase("CLOSE")){
                break;
            }

            System.out.println("Enter the code of the target currency: ");
                System.out.println(menu);
            targetCurrency = input.nextLine();

            System.out.println("How much would you like to convert?");
            quantityToExchange = input.nextDouble();


            String apiKey = "";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey
                            + "/pair/" + currencyToConvert + "/" + targetCurrency
                            + "/" + quantityToExchange ))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            CurrencyRecord currency = gson.fromJson(response.body(), CurrencyRecord.class);
            Conversor conversor = new Conversor(currency);
            conversor.result(quantityToExchange);
        }
    }

}
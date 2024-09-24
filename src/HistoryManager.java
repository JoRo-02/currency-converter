import java.time.Instant;
import java.time.InstantSource;
import java.util.ArrayList;
import java.util.function.Consumer;

public class HistoryManager {


    ArrayList<Conversor> history= new ArrayList<>();

    Consumer<Conversor> conversorConsumer = new Consumer<Conversor>() {
        @Override
        public void accept(Conversor conversor) {
            System.out.println(conversor.historyText);
        }
    };


    public void HistoryAddElement(Conversor element){
        history.add(element);
    }

    public void HistoryShowElements(){

        history.forEach(conversorConsumer);
    }
}
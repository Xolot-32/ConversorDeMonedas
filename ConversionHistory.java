import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private final List<ConversionRecord> history;
    private static final int MAX_HISTORY_SIZE = 10;

    public ConversionHistory() {
        this.history = new ArrayList<>();
    }

    public void addRecord(ConversionRecord record) {
        if (history.size() >= MAX_HISTORY_SIZE) {
            history.remove(0);
        }
        history.add(record);
    }

    public List<ConversionRecord> getHistory() {
        return new ArrayList<>(history);
    }
}
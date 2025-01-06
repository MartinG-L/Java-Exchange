import java.util.Map;

public record ApiResponse(
    String time_last_update_utc,
    Map<String, Double> conversion_rates,
    String result
) {
}

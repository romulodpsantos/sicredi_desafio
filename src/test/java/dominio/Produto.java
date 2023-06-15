package dominio;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {
    @Builder.Default
    private String title = "teste";
    @Builder.Default
    private String description = "teste";
    @Builder.Default
    private double price = 13;
    @Builder.Default
    private double discountPercentage = 8.4;
    @Builder.Default
    private float rating = 1.26F;
    @Builder.Default
    private double stock = 65;
    @Builder.Default
    private String brand = "teste";
    @Builder.Default
    private String category = "teste";
    @Builder.Default
    private String thumbnail = "teste";
}

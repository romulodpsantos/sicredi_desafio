package dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {

    @Builder.Default
    private float lat = 1;
    @Builder.Default
    private float lng = 2;
}

package march.challenge.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private long productId;
    private double originalPrice;
    private double discountedPrice;
}

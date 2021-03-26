package march.challenge.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long productId;
    private String productName;
    private String productDesc;
    private Double productPrice;
    private Double DiscountedPrice;
    private Boolean productStock;
}

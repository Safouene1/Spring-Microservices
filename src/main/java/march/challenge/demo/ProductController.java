package march.challenge.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    //Product Info
    List<ProductInfo> productList = new ArrayList<ProductInfo>();
    List<Price> priceList = new ArrayList<Price>();
    List<Inventory> inventoryList = new ArrayList<Inventory>();
    // REST API GETTER.
    @GetMapping("/product/details/{productid}")
        public Product getProductDetails (@PathVariable Long productid){

        //Get name and Desc from service
                 ProductInfo productInfo = getProductInfo(productid);

        // Get price from service
                Price price = getPriceInfo(productid);

       // Getting the Stock from Service

         Inventory inventory= getInventoryInfo(productid);

       // API
        assert price != null;
        assert productInfo != null;
        return new Product
                (productInfo.getProductId(), productInfo.getProductName(),productInfo.getProductDesc()
                        , price.getOriginalPrice(), price.getDiscountedPrice(), inventory.isStock() );

    }


         // Searching through the inventory
    private Inventory getInventoryInfo(Long productid) {
        populateInventoryList();
        for (Inventory p: inventoryList){
            if(productid.equals(p.getProductid())){
                return p;
            }
        }
        return null;
    }


    // Searching through the price list
    private Price getPriceInfo(Long productid) {
        populatePriceList();
        for (Price p: priceList){
            if(productid.equals(p.getProductId())){
                return p;
            }
        }
        return null;
    }



    // Searching the product Id
    private ProductInfo getProductInfo(Long productid) {
        populateProductList();
        // getting the product info
        for (ProductInfo p: productList){
            if(productid.equals(p.getProductId())){
                return p;
            }
        }
        return null;
    }


    private void populateInventoryList() {
        inventoryList.add(new Inventory(6601,true));
        inventoryList.add(new Inventory(6602,true));
        inventoryList.add(new Inventory(6603,false));
        inventoryList.add(new Inventory(6604,false));
    }

    private void populateProductList() {
        productList.add( new ProductInfo (6601,"Asus Pc","incredible"));
        productList.add( new ProductInfo (6602,"Iphone","made by apple"));
        productList.add( new ProductInfo (6603,"Book","Harry Poter"));
        productList.add( new ProductInfo (6604,"Washing Machine","MC bRAND"));
    }
    private void populatePriceList() {
            priceList.add( new Price (6601,2500.00,1900.00));
            priceList.add( new Price (6602,620.00,540.00));
            priceList.add( new Price (6603,122.00,120.00));
            priceList.add( new Price (6604,2600.00,2300.00));
        }
    }


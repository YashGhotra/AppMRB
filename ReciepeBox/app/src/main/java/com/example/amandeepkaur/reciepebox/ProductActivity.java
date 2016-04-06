package com.example.amandeepkaur.reciepebox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.amandeepkaur.reciepebox.adapter.ProductAdapter;
import com.example.amandeepkaur.reciepebox.model.Products;

import java.util.ArrayList;

/**
 * Created by Amandeep Kaur on 7/04/2016.
 */
public class ProductActivity extends Activity {

    ListView  listProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       setContentView(R.layout.activity_product);
        listProduct    = (ListView)findViewById(R.id.list_product);

        ArrayList<Products> productDataList = getProductData();
        ProductAdapter productAdapter  = new ProductAdapter(this,productDataList);
        listProduct.setAdapter(productAdapter);

        super.onCreate(savedInstanceState);
    }


    private ArrayList<Products> getProductData(){
        ArrayList<Products> productList   = new ArrayList<Products>();
        Products  products  = new Products();
        products.setProductName("One person product");
        products.setDescription("Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum ");

        productList.add(products);

        Products  productTwo  = new Products();
        productTwo.setProductName("Two person product");
        productTwo.setDescription("Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum ");
        productList.add(productTwo);

        Products  productThree  = new Products();
        productThree.setProductName("Three person product");
        productThree.setDescription("Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum ");
        productList.add(productThree);

        Products  productFour  = new Products();
        productFour.setProductName("Four person product");
        productFour.setDescription("Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum Lorium Ipsum ");
        productList.add(productFour);


         return productList;

    }

}

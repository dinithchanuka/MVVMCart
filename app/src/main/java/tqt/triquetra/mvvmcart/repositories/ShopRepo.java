package tqt.triquetra.mvvmcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tqt.triquetra.mvvmcart.models.Product;

public class ShopRepo {
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac",1299,true,"https://picsum.photos/200"));

        mutableProductList.setValue(productList);
    }
}

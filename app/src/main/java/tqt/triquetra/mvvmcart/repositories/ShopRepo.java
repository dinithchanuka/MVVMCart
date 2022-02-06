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

        productList.add(new Product(UUID.randomUUID().toString(),"iMac1",12991,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac2",12992,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac3",12993,false,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac4",12994,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac5",12995,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac6",12996,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac7",12997,false,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac8",12998,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac9",12999,true,"https://picsum.photos/200"));
        productList.add(new Product(UUID.randomUUID().toString(),"iMac0",12990,true,"https://picsum.photos/200"));

        mutableProductList.setValue(productList);
    }
}

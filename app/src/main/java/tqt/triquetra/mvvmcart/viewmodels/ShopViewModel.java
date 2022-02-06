package tqt.triquetra.mvvmcart.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tqt.triquetra.mvvmcart.models.CartItem;
import tqt.triquetra.mvvmcart.models.Product;
import tqt.triquetra.mvvmcart.repositories.CartRepo;
import tqt.triquetra.mvvmcart.repositories.ShopRepo;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Product> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }

    public void setProduct(Product product){
        mutableLiveData.setValue(product);
    }

    public LiveData<Product> getProduct(){
        return mutableLiveData;
    }

    public LiveData<List<CartItem>> getCart(){
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product){
        return cartRepo.addItemToCart(product);
    }
}

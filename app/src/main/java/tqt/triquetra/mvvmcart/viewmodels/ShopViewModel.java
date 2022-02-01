package tqt.triquetra.mvvmcart.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tqt.triquetra.mvvmcart.models.Product;
import tqt.triquetra.mvvmcart.repositories.ShopRepo;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts(){
        return shopRepo.getProducts();
    }

}

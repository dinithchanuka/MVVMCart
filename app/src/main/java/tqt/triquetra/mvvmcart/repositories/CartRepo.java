package tqt.triquetra.mvvmcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import tqt.triquetra.mvvmcart.models.CartItem;
import tqt.triquetra.mvvmcart.models.Product;

public class CartRepo {

    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart(){
        if(mutableCart.getValue() == null){
            initCart();
        }
        return mutableCart;
    }

    public void initCart() {
        mutableCart.setValue(new ArrayList<>());
    }

    public boolean addItemToCart(Product product){
        if(mutableCart.getValue()==null){
            initCart();
        }

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        for (CartItem cartItem:cartItemList){
            if(cartItem.getProduct().getId().equals(product.getId())){
                if(cartItem.getQty() == 5){
                    return false;
                }
                int index = cartItemList.indexOf(cartItem);
                cartItem.setQty(cartItem.getQty()+1);
                cartItemList.set(index,cartItem);

                mutableCart.setValue(cartItemList);
                return true;
            }
        }
        CartItem cartItem = new CartItem(product,1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);

        return true;
    }

    public void removeItemFromCart(CartItem cartItem) {
        if(mutableCart.getValue()==null){
            return;
        }

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
    }
}

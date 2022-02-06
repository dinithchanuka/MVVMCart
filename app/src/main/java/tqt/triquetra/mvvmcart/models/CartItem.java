package tqt.triquetra.mvvmcart.models;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import java.security.SecurityPermission;
import java.util.Objects;

public class CartItem {
    private Product product;
    private int qty;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return qty == cartItem.qty && product.equals(cartItem.product);
    }

    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner,int qty){
        spinner.setSelection(qty -1,true);
    }

    public static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.getProduct().equals(newItem.getProduct());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}

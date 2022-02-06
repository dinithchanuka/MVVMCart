package tqt.triquetra.mvvmcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import tqt.triquetra.mvvmcart.databinding.CartRowBinding;
import tqt.triquetra.mvvmcart.models.CartItem;

public class CartListAdapter extends ListAdapter<CartItem,CartListAdapter.CartViewHolder> {

    public CartListAdapter() {
        super(CartItem.itemCallback);
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CartRowBinding cartRowBinding = CartRowBinding.inflate(layoutInflater,parent,false);
        return new CartViewHolder(cartRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.cartRowBinding.setCartItem(getItem(position));
        holder.cartRowBinding.executePendingBindings();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        CartRowBinding cartRowBinding;
        public CartViewHolder(@NonNull CartRowBinding cartRowBinding) {
            super(cartRowBinding.getRoot());
            this.cartRowBinding = cartRowBinding;
        }
    }
}

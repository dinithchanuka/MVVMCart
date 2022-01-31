package tqt.triquetra.mvvmcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import tqt.triquetra.mvvmcart.databinding.ShopRawBinding;
import tqt.triquetra.mvvmcart.models.Product;

public class ShopListAdapter extends ListAdapter<Product,ShopListAdapter.ShopViewHolder> {

    public ShopListAdapter() {
        super(Product.itemCallback);
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopRawBinding shopRawBinding = ShopRawBinding.inflate(layoutInflater,parent,false);
        return new ShopViewHolder(shopRawBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Product product = getItem(position);
        holder.shopRawBinding.setProduct(product);
    }

    class ShopViewHolder extends RecyclerView.ViewHolder{

        ShopRawBinding shopRawBinding;
        public ShopViewHolder(ShopRawBinding shopRawBinding) {
            super(shopRawBinding.getRoot());
            this.shopRawBinding = shopRawBinding;
        }
    }

    public interface ShopInterface{
        void addItem(Product product);
        void onItemClick(Product product);
    }
}

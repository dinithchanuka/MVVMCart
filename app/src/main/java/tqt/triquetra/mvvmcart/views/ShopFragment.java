package tqt.triquetra.mvvmcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tqt.triquetra.mvvmcart.R;
import tqt.triquetra.mvvmcart.adapters.ShopListAdapter;
import tqt.triquetra.mvvmcart.databinding.FragmentShopBinding;
import tqt.triquetra.mvvmcart.models.Product;

public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;

    public ShopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater,container,false);;
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopListAdapter = new ShopListAdapter();
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}
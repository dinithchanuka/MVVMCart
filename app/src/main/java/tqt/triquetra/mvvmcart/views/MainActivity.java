package tqt.triquetra.mvvmcart.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import tqt.triquetra.mvvmcart.R;
import tqt.triquetra.mvvmcart.models.CartItem;
import tqt.triquetra.mvvmcart.viewmodels.ShopViewModel;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    ShopViewModel shopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController);

        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item,navController)||super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }
}
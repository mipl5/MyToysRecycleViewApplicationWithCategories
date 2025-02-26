package michael.co.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;

import java.util.Locale;

public class ToyCategoryViewModel extends ViewModel {
    private Categories categories;
    private MutableLiveData<Categories> toyCategoriesLiveData;

    public ToyCategoryViewModel(){
        categories = new Categories();
        categories.getAll();

        toyCategoriesLiveData = new MutableLiveData<>();
        toyCategoriesLiveData.setValue(categories);
    }

    public MutableLiveData<Categories> getToyCategoriesLiveData(){
        return this.toyCategoriesLiveData;
    }
}

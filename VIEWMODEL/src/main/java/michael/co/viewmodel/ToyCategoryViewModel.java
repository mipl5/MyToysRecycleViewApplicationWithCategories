package michael.co.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;
import com.example.model.Category;

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

    public void add(Category category){
        categories.add(category);
        toyCategoriesLiveData.setValue(categories);
    }

    public void removeLast(){
        categories.remove(categories.size() - 1);
        toyCategoriesLiveData.setValue(categories);
    }
}

package michael.co.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;
import com.example.model.Category;

import java.util.Locale;
import java.util.Objects;

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

    public void remove(String name){
        int index = getIndexCategory(name);
        if (index != -1) {
            categories.remove(index);
            toyCategoriesLiveData.setValue(categories);
        }
    }
    
    public int getIndexCategory(String name){
        for (int i = 0; i < categories.size(); i++)
            if (Objects.equals(categories.get(i).getName(), name))
                return i;
        return -1;
    }
}

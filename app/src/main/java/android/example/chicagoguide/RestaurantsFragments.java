package android.example.chicagoguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class RestaurantsFragments extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] nameOfRes = getResources().getStringArray(R.array.nameOfRestaurants);
        String[] descOfRes = getResources().getStringArray(R.array.descriptionOfRestaurants);
        String[] priceOfRes = getResources().getStringArray(R.array.priceOfRestaurants);
        String[] numOfRes = getResources().getStringArray(R.array.numbersOfRestaurants);

        int[] images = {
                R.drawable.avec_restaurants,
                R.drawable.birriersia_restaurants,
                R.drawable.boka_restaurants,
                R.drawable.galit_restaurants,
                R.drawable.giant_restaurants,
                R.drawable.graziano_restaurants,
                R.drawable.lula_restaurants,
                R.drawable.oriole_restaurants,
                R.drawable.tzuco_restaurants
        };

        View rootview = inflater.inflate(R.layout.activity_category, container, false);

        final ArrayList<Info> placeInfo = new ArrayList<Info>();
        for (int i = 0; i < nameOfRes.length; i++) {
            placeInfo.add(new Info(
                    nameOfRes[i],
                    descOfRes[i],
                    priceOfRes[i],
                    numOfRes[i],
                    images[i]
                    ));
        }
        InfoAdapter infoAdapter = new InfoAdapter(getActivity(), placeInfo);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(infoAdapter);

        return rootview;
    }
}

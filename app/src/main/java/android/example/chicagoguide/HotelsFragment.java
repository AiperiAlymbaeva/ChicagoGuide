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

public class HotelsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] nameOfHotel = getResources().getStringArray(R.array.nameOfHotels);
        String[] descOfHotel = getResources().getStringArray(R.array.descriptionOfHotels);
        String[] priceOfHotel = getResources().getStringArray(R.array.priceOfHotels);
        String[] numOfHotel = getResources().getStringArray(R.array.numbersOfHotels);

        int[] images = {
                R.drawable.julian_hotel,
                R.drawable.claridge_hotel,
                R.drawable.langham_hotel,
                R.drawable.londonhouse_hotel,
                R.drawable.moxy_hotel,
                R.drawable.peninsula_hotel,
                R.drawable.trump_hotel,
                R.drawable.virgin_hotel,
                R.drawable.thompson_hotel
        };

        View rootview = inflater.inflate(R.layout.activity_category, container, false);

        final ArrayList<Info> placeInfo = new ArrayList<Info>();
        for (int i = 0; i < nameOfHotel.length; i++) {
            placeInfo.add(new Info(
                    nameOfHotel[i],
                    descOfHotel[i],
                    priceOfHotel[i],
                    numOfHotel[i],
                    images[i]));
        }
        InfoAdapter infoAdapter = new InfoAdapter(getActivity(), placeInfo);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(infoAdapter);

        return rootview;
    }
}

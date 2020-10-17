package android.example.chicagoguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] nameOfParks = getResources().getStringArray(R.array.nameOfParks);
        String[] descOfParks = getResources().getStringArray(R.array.descriptionOfParks);
        String[] addressOfParks = getResources().getStringArray(R.array.addressOfParks);
        String[] hoursOfParks = getResources().getStringArray(R.array.hoursOfParks);

        int[] images = {
                R.drawable.garfield_park,
                R.drawable.grant_park,
                R.drawable.humboldt_park,
                R.drawable.jackson_park,
                R.drawable.lincoln_park,
                R.drawable.magie_park,
                R.drawable.millenium_park,
                R.drawable.south_park,
                R.drawable.six_park
        };

        View rootview = inflater.inflate(R.layout.activity_category, container, false);

        final ArrayList<Info> placeInfo = new ArrayList<Info>();
        for (int i = 0; i < nameOfParks.length; i++) {
            placeInfo.add(new Info(
                    nameOfParks[i],
                    descOfParks[i],
                    hoursOfParks[i],
                    images[i],
                    addressOfParks[i]));
        }
        InfoAdapter infoAdapter = new InfoAdapter(getActivity(), placeInfo);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(infoAdapter);

        return rootview;
    }
}
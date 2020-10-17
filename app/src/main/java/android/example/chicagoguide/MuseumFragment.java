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

public class MuseumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] nameOfMuseum = getResources().getStringArray(R.array.nameofMuseums);
        String[] descOfMuseum = getResources().getStringArray(R.array.descriptionOfMuseum);
        String[] addressOfMuseum = getResources().getStringArray(R.array.addressOfMuseums);
        String[] hoursOfMuseum = getResources().getStringArray(R.array.hoursOfMuseums);

        int[] images = {
                R.drawable.adler_museum,
                R.drawable.art_museum,
                R.drawable.contemporary_art_museum,
                R.drawable.contemporary_photography_museum,
                R.drawable.field_museum,
                R.drawable.history_museum,
                R.drawable.oriental_institute_museum,
                R.drawable.science_museum,
                R.drawable.smart_museum
        };

        View rootview = inflater.inflate(R.layout.activity_category, container, false);

        final ArrayList<Info> placeInfo = new ArrayList<Info>();
        for (int i = 0; i < nameOfMuseum.length; i++) {
            placeInfo.add(new Info(
                    nameOfMuseum[i],
                    descOfMuseum[i],
                    hoursOfMuseum[i],
                    images[i],
                    addressOfMuseum[i]
                    ));
        }
        InfoAdapter infoAdapter = new InfoAdapter(getActivity(), placeInfo);

        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(infoAdapter);

        return rootview;
    }
}

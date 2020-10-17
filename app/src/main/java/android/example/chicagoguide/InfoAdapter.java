package android.example.chicagoguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info> {
    public InfoAdapter(Activity contex, ArrayList<Info> infos) {
        super(contex, 0, infos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Info currentInfo = getItem(position);

        final TextView title = listItemView.findViewById(R.id.name);
        title.setText(currentInfo.getTitle());

        ImageView imageFragment = listItemView.findViewById(R.id.image);
        Glide.with(getContext()).load(currentInfo.getImageResourceId()).into(imageFragment);

        final TextView address =  listItemView.findViewById(R.id.maplink);
        address.setVisibility(View.GONE);

        final TextView number = listItemView.findViewById(R.id.phonelink);
        number.setVisibility(View.GONE);

        final ImageView phoneIcon = listItemView.findViewById(R.id.phone_ic);
        phoneIcon.setVisibility(View.GONE);

        final TextView price = listItemView.findViewById(R.id.price);
        price.setVisibility(View.GONE);

        final ImageView dollarIcon = listItemView.findViewById(R.id.dollar_ic);
        dollarIcon.setVisibility(View.GONE);

        final TextView hours = listItemView.findViewById(R.id.hours);
        hours.setVisibility(View.GONE);

        final ImageView hoursIcon = listItemView.findViewById(R.id.time_ic);
        hoursIcon.setVisibility(View.GONE);

        final ImageView descIcon = listItemView.findViewById(R.id.desc_ic);
        descIcon.setVisibility(View.GONE);

        final TextView desc = listItemView.findViewById(R.id.desc);
        desc.setVisibility(View.GONE);

        final ImageView showBtn = listItemView.findViewById(R.id.show);
        showBtn.setVisibility(View.VISIBLE);

        final ImageView hideBtn = listItemView.findViewById(R.id.hide);
        hideBtn.setVisibility(View.VISIBLE);

        final ImageView mapIcon = listItemView.findViewById(R.id.map_ic);
        mapIcon.setVisibility(View.GONE);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideBtn.setVisibility(View.VISIBLE);
                showBtn.setVisibility(View.VISIBLE);
                descIcon.setVisibility(View.VISIBLE);
                desc.setText(currentInfo.getDescription());
                desc.setVisibility(View.VISIBLE);


                if (currentInfo.hasNumber()) {
                    price.setText(currentInfo.getPrice());
                    price.setVisibility(View.VISIBLE);
                    dollarIcon.setVisibility(View.VISIBLE);

                    phoneIcon.setVisibility(View.VISIBLE);
                    number.setText(currentInfo.getPhoneNumber());
                    number.getPaint().setUnderlineText(true);
                    number.setVisibility(View.VISIBLE);
                    number.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent numberIntent = new Intent(Intent.ACTION_DIAL);
                            getContext().startActivity(numberIntent.setData(Uri.parse("tel:"+ currentInfo.getPhoneNumber())));
                        }
                    });
                }
                if(currentInfo.hasHours()){
                    hours.setText(currentInfo.getHours());
                    hours.setVisibility(View.VISIBLE);
                    hoursIcon.setVisibility(View.VISIBLE);
                    mapIcon.setVisibility(View.VISIBLE);
                    address.setText(currentInfo.getAddress());
                    address.getPaint().setUnderlineText(true);
                    address.setVisibility(View.VISIBLE);
                    address.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent addressIntent = new Intent(Intent.ACTION_VIEW);
                            String title = "  Choose program";
                            Intent intent = Intent.createChooser(addressIntent.setData(Uri.parse("geo:0,0?q=" + currentInfo.getAddress())), title);
                            getContext().startActivity(intent);
                        }
                    });
                }


            }
        });

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtn.setVisibility(View.VISIBLE);
                hideBtn.setVisibility(View.VISIBLE);
                if (currentInfo.hasNumber()) {
                    price.setVisibility(View.GONE);
                    phoneIcon.setVisibility(View.GONE);
                    dollarIcon.setVisibility(View.GONE);
                    number.setVisibility(View.GONE);


                }
                address.setVisibility(View.GONE);
                mapIcon.setVisibility(View.GONE);
                hoursIcon.setVisibility(View.GONE);
                hours.setVisibility(View.GONE);
                descIcon.setVisibility(View.GONE);
                desc.setVisibility(View.GONE);

            }
        });

        return listItemView;


    }
}

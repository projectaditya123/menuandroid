package com.example.tes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;

public class HomeFragment extends Fragment {

    private String[] imageURLs = {
            "https://terbang.sch.id/front-end/assets/img/news/ip_logo1.jpg",
            "https://1000logos.net/wp-content/uploads/2016/11/google-logo.jpg",
            "https://iconlogovector.com/uploads/images/2023/02/lg-a2b48b800bc00589f086b19d13e8902a62.jpg"
    };

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager2 viewPager = rootView.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageSliderAdapter());

        return rootView;
    }

    private class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder> {
        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, parent, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
            Glide.with(requireContext())
                    .load(imageURLs[position])
                    .into(holder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Buka tautan yang sesuai saat gambar di-klik
                    String url = "";
                    switch (position) {
                        case 0:
                            url = "https://terbang.sch.id/";
                            break;
                        case 1:
                            url = "https://www.google.com/";
                            break;
                        case 2:
                            url = "https://www.tiktok.com/id-ID/";
                            break;
                    }
                    Uri webpage = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
                        view.getContext().startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return imageURLs.length;
        }

        class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            ImageViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageSlider);
            }
        }
    }
}

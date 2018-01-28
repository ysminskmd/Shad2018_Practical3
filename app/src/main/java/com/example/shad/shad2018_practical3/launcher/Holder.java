package com.example.shad.shad2018_practical3.launcher;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.shad.shad2018_practical3.R;

class Holder {

    static class GridHolder extends RecyclerView.ViewHolder {

        private final View mImageView;

        GridHolder(final View view) {
            super(view);

            mImageView = view.findViewById(R.id.launcher_image);
        }

        View getImageView() {
            return mImageView;
        }
    }
}

package com.codenicely.project.groceryappadmin.helper.image_loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by meghal on 13/10/16.
 */

public class GlideImageLoader implements ImageLoader {

    private static final String TAG = "GlideImageLoader";
    Context mContext;
    private RequestManager requestManager;

    public GlideImageLoader(Context mContext) {

        this.mContext = mContext;
        requestManager = Glide.with(mContext);
    }

    @Override
    public void loadImage(String url, final ImageView imageView, final ProgressBar progressBar) {
//        Log.d("Response",url);
//        url = url.replace("\"", "");


//        requestManager.load(url).crossFade().thumbnail(0.1f);

        //      requestManager.load(url).crossFade().thumbnail(0.05f);

        requestManager.load(url).crossFade().thumbnail(1f).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }

                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
                return false;
            }
        }).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //.animate(R.anim.image_animation)
                .fitCenter().crossFade().into(imageView);


        // This code is used for Round Image View using Glide :)
        /*
        Glide.with(mContext).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
*/

    }
/*    public void load_circular_image(String url,final ImageView imageView){
        Glide.with(mContext).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {

            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(),resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }


        });
    }*/

}


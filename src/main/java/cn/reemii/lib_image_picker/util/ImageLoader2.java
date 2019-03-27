package cn.reemii.lib_image_picker.util;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import cn.reemii.lib_image_picker.R;
import cn.reemii.lib_image_picker.loader.ImageLoader;


public class ImageLoader2 implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        RequestOptions options = new RequestOptions()
                .centerInside()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_default_image)
                .error(R.drawable.ic_default_image)
                .override(width, height);

        Glide.with(activity)
                .load(Uri.fromFile(new File(path)))
                .apply(options)
                .into(imageView);
    }


    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        RequestOptions options = new RequestOptions()
                .centerInside()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_default_image)
                .error(R.drawable.ic_default_image)
                .override(width, height);

        if (path.contains("http:")) {
            Glide.with(activity)
                    .load(path)
                    .apply(options)
                    .into(imageView);
        } else {

            Glide.with(activity)
                    .load(Uri.fromFile(new File(path)))
                    .apply(options)
                    .into(imageView);
        }
    }

    @Override
    public void clearMemoryCache() {
        //这里是清除缓存的方法,根据需要自己实现
    }
}

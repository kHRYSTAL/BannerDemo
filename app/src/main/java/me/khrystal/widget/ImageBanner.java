package me.khrystal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flyco.banner.widget.Banner.base.BaseBanner;

import me.khrystal.imagebanner.R;

/**
 * Created by kHRYSTAL on 16/3/16.
 */
public class ImageBanner extends BaseBanner<Integer,ImageBanner> {

    public ImageBanner(Context context) {
        this(context,null,0);
    }

    public ImageBanner(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImageBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public View onCreateItemView(int position) {
        View inflate = View.inflate(context, R.layout.adapter_image_banner, null);
        ImageView iv = ViewFindUtils.find(inflate, R.id.iv);
        final Integer i = list.get(position);
        int itemWidth = dm.widthPixels;
        int itemHeight = (int) (itemWidth * 360 * 1.0f / 640);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setLayoutParams(new LinearLayout.LayoutParams(itemWidth, itemHeight));
        iv.setImageResource(i);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+i,Toast.LENGTH_SHORT).show();
            }
        });

        return inflate;
    }

    @Override
    public View onCreateIndicator() {
        return null;
    }

    @Override
    public void setCurrentIndicator(int position) {

    }
}

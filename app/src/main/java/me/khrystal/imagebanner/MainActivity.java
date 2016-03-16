package me.khrystal.imagebanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.pageindicator.indicator.RoundCornerIndicaor;

import java.util.ArrayList;

import me.khrystal.widget.ImageBanner;
import me.khrystal.widget.ViewFindUtils;

public class MainActivity extends AppCompatActivity {

    private int[] resIds = {R.mipmap.item1, R.mipmap.item2,
            R.mipmap.item3, R.mipmap.item4};
    private ArrayList<Integer> resList;
    private View decorView;
    private ImageBanner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resList = new ArrayList<>();
        for (int i = 0; i < resIds.length; i++) {
            resList.add(resIds[i]);
        }

        decorView = getWindow().getDecorView();
        banner = ViewFindUtils.find(decorView, R.id.banner_circle);
        banner.setSource(resList).startScroll();
        RoundCornerIndicaor indicator = ViewFindUtils.find(decorView, R.id.indicator_circle);
        indicator.setViewPager(banner.getViewPager(), resList.size());
    }
}

package com.stdio.hue.yoga.common.widgets.slider.library.SliderTypes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.stdio.hue.yoga.common.R;

import org.w3c.dom.Text;

public class TextSliderView extends BaseSliderView{
    public TextSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text,null);
        ImageView target = v.findViewById(R.id.daimajia_slider_image);
        TextView title = v.findViewById(R.id.tv_title);
        TextView typeText = v.findViewById(R.id.tv_typeText);
        title.setText(getTitle());
        typeText.setText(getTypeText());
        bindEventAndShow(v, target);
        return v;
    }
}

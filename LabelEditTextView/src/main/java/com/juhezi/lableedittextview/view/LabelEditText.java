package com.juhezi.lableedittextview.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.juhezi.lableedittextview.R;
import com.juhezi.lableedittextview.adapter.LabelAdapter;

/**
 * Created by qiao1 on 2017/1/4.
 */
public class LabelEditText extends LinearLayout {
    private static String TAG = "LabelEditText";

    private EditText mEditText;
    private RecyclerView mRecyclerView;

    public LabelEditText(Context context) {
        super(context);
        init(context);
    }

    public LabelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 加载布局
     *
     * @param context
     */
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.label_edit_text_layout, this, true);
        mEditText = (EditText) findViewById(R.id.et_field);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_label_list);
    }

}

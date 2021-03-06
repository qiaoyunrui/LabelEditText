package com.juhezi.lableedittextview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.juhezi.lableedittextview.R;
import com.juhezi.lableedittextview.adapter.LabelAdapter;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * Created by qiao1 on 2017/1/4.
 */
public class LabelEditText extends LinearLayout {
    private static String TAG = "LabelEditText";

    private EditText mEditText;
    private RecyclerView mRecyclerView;

    private LabelAdapter mAdapter;
    private int mLabelMaxCount = 10;

    public LabelEditText(Context context) {
        super(context);
        init(context);
    }

    public LabelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.LabelEditText);
        mLabelMaxCount = typedArray
                .getInt(R.styleable.LabelEditText_item_max_count,
                        10);
        typedArray.recycle();
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new LabelAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new Function1<String, Unit>() {
            @Override
            public Unit invoke(String s) {
                mEditText.setText(mEditText.getText() + " " + s);
                mEditText.setSelection(mEditText.getText().length());
                return null;
            }
        });
        mAdapter.setMax_label_count(mLabelMaxCount);
    }

    /**
     * 设置标签数据
     */
    public void setLabels(ArrayList<String> labels) {
        mAdapter.setLabels(labels);
    }

    /**
     * 设置最多显示的标签
     */
    public void setMaxLabelCount(int maxLabelCount) {
        mAdapter.setMax_label_count(maxLabelCount);
    }

    /**
     * 允许设置自己的Adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            mRecyclerView.setAdapter(adapter);
        }
    }
}

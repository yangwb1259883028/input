package cn.linhome.lib.input.stateview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import cn.linhome.lib.input.FEditText;
import cn.linhome.lib.input.R;

public class EditTextClearImageView extends ImageView implements FEditText.StateView
{
    public EditTextClearImageView(Context context)
    {
        super(context);
        init();
    }

    public EditTextClearImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public EditTextClearImageView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private EditText mEditText;
    private OnClickListener mOnClickListener;

    private void init()
    {
        if (getDrawable() == null)
        {
            setImageResource(R.drawable.lib_input_selector_edit_clear);
        }

        super.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mEditText != null)
                {
                    mEditText.setText("");
                }
                if (mOnClickListener != null)
                {
                    mOnClickListener.onClick(v);
                }
            }
        });
    }

    public final EditText getEditText()
    {
        return mEditText;
    }

    @Override
    public void setOnClickListener(OnClickListener l)
    {
        mOnClickListener = l;
    }

    @Override
    public void onStateChanged(FEditText.ChangType type, EditText editText)
    {
        mEditText = editText;

        if (editText.getVisibility() == View.VISIBLE
                && editText.isFocused()
                && editText.isEnabled()
                && editText.getText().length() > 0)
        {
            setVisibility(VISIBLE);
        } else
        {
            setVisibility(GONE);
        }
    }
}

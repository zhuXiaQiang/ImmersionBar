package com.gyf.immersionbar.fragment.dialog;

import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.immersionbar.R;
import com.gyf.immersionbar.activity.DialogActivity;

import butterknife.BindView;

/**
 * 顶部DialogFragment
 *
 * @author geyifeng
 * @date 2017/7/28
 */
public class TopDialogFragment extends BaseDialogFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onStart() {
        super.onStart();
        mWindow.setGravity(Gravity.TOP);
        mWindow.setWindowAnimations(R.style.TopDialog);
        mWindow.setLayout(mWidth, mHeight / 2);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.dialog;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .navigationBarWithKitkatEnable(false)
                .init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((DialogActivity) getActivity()).getActivityImmersionBar().keyboardEnable(true).init();
    }
}

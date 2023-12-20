// Generated by view binder compiler. Do not edit!
package com.krashkrosh748199.shoption.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.krashkrosh748199.shoption.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class FragmentBaseBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  private FragmentBaseBinding(@NonNull FrameLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_base, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBaseBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new FragmentBaseBinding((FrameLayout) rootView);
  }
}

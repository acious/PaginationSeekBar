/*
 * Copyright (c) Jongchan Kim (Acious) 2016.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ssumunity.android.paginationseekbar.internal.compat;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

import com.ssumunity.android.paginationseekbar.internal.drawable.AlmostRippleDrawable;
import com.ssumunity.android.paginationseekbar.internal.drawable.MarkerDrawable;

public class SeekBarCompat {

    public static void setOutlineProvider(View view, final MarkerDrawable markerDrawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SeekBarCompatDontCrash.setOutlineProvider(view, markerDrawable);
        }
    }

    public static Drawable getRipple(ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return SeekBarCompatDontCrash.getRipple(colorStateList);
        } else {
            return new AlmostRippleDrawable(colorStateList);
        }
    }

    public static void setHotspotBounds(Drawable drawable, int left, int top, int right, int bottom) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //We don't want the full size rect, Lollipop ripple would be too big
            int size = (right - left) / 8;
            DrawableCompat.setHotspotBounds(drawable, left + size, top + size, right - size, bottom - size);
        } else {
            drawable.setBounds(left, top, right, bottom);
        }
    }

    @SuppressWarnings("deprecation")
    public static void setBackground(View view, Drawable background) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            SeekBarCompatDontCrash.setBackground(view, background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    public static void setTextDirection(TextView textView, int textDirection) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            SeekBarCompatDontCrash.setTextDirection(textView, textDirection);
        }
    }

    public static boolean isInScrollingContainer(ViewParent p) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return SeekBarCompatDontCrash.isInScrollingContainer(p);
        }
        return false;
    }

    public static boolean isHardwareAccelerated(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return SeekBarCompatDontCrash.isHardwareAccelerated(view);
        }
        return false;
    }
}

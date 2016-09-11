#PaginationSeekBar
[ ![Download](https://api.bintray.com/packages/ace-jckim/maven/pagination-seekbar/images/download.svg)  ](https://bintray.com/ace-jckim/maven/pagination-seekbar/_latestVersion)
![screenshot](https://media.giphy.com/media/26uf55vfqgoEAmlO0/giphy.gif)

PaginationSeekBar is Android UI Library for Easy&Quick Pagination. I recommand that, Use this for Board(List, Grid)UI.

##Gradle Dependency
```gradle
dependencies {
	compile 'com.acious.android:paginationseekbar:1.0.2'
}
```

##Implementation details
This thing runs on minSDK=7 (well, technically could run 4 but can't test since AVDs for api 4 are deprecated and just don't boot).
Obviously some of the subtle animations (navigating with the Keyboard, the Ripple effect, text fade ins/fade outs, etc) are not going to work on APIS lower than 11, but the bubble thing does. And I haven't found a way of improving this with 11-21 APIs, so...

The base SeekBar is pretty simple. Just 3 drawables for the track, progress and thumb. Some touch event logic to drag, some key event logic to move, and that's all.

The bubble thing **DOESN'T USE** [VectorDrawableMagic] . I was not really needed for such a simple morph. It uses instead an [Animatable Drawable] for the animation with a lot of hackery for callbacks, drawing and a bunch of old simple math.

>For this to work (and sync with events, etc) I've written a fair amount of shit questionable code...

The material-floating-thing is composed into the WindowManager (like the typical overflow menus) to be able to show it over other Views without needing to set the SeekBar big enough to account for the (variable) size of he floating thing.

>For this I'm not sure about the amounts of things I've copied from [PopupWindow] and the possible issues.

##Dependencies
It uses **com.android.support:support-v4** as the only dependency.

##Usage

Once imported into your project, you just need to put them into your layous like:
```xml
<com.acious.andorid.paginationseekbar.PaginationSeekBar
	android:id="@+id/test_seek_bar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:psb_pageCountPerOneBoard="5"
    app:psb_thumbTextColor="#ffffff"
/>
```

####Parameters
You can tweak a few things of the PaginationSeekbar:

* **psb_pageCountPerOneBoard**: set Pagecount per OneBoard (Recommand 5 or 10)

####Design
 
* **psb_progressColor**: color/colorStateList for the progress bar and thumb drawable
* **psb_trackColor**: color/colorStateList for the track drawable
* **psb_indicatorTextAppearance**: TextAppearance for the bubble indicator
* **psb_indicatorColor**: color/colorStateList for the bubble shaped drawable
* **psb_indicatorElevation**: related to android:elevation. Will only be used on API level 21+
* **psb_indicatorPrevPageText**: setup text when indicator state is prev
* **psb_indicatorNextPageText**: setup text when indicator state is next
* **psb_rippleColor**: color/colorStateList for the ripple drawable seen when pressing the thumb. (Yes, it does a kind of "ripple" on API levels lower than 21 and a real RippleDrawable for 21+.
* **psb_thumbTextColor**: set text color in thumb

You can also use the attribute **paginationSeekBarStyle** on your themes with a custom Style to be applied to all the PaginationSeekBars on your app/activity/fragment/whatever.

Thanks for [Gustavo Claramunt]'s [DiscreteSeekBar]

##License
```
Copyright 2016 Jongchan Kim (Acious)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[Discrete Slider]:http://www.google.com/design/spec/components/sliders.html#sliders-discrete-slider
[VectorDrawableMagic]:https://developer.android.com/reference/android/graphics/drawable/AnimatedVectorDrawable.html
[Animatable Drawable]:https://developer.android.com/reference/android/graphics/drawable/Animatable.html
[PopupWindow]:https://developer.android.com/reference/android/widget/PopupWindow.html
[Gustavo Claramunt]:https://github.com/AnderWeb
[DiscreteSeekBar]:https://github.com/AnderWeb/discreteSeekBar

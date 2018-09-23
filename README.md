# Bounceview-Android

Customizable bounce animation for any view updation

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Bounceview--Android-green.svg?style=flat)](https://android-arsenal.com/details/1/7148)

<div>
  <img src="http://res.cloudinary.com/ezio/image/upload/v1528468184/2.gif" alt="sample screenshot"/>
</div>

# Getting Started
<h4>In your build.gradle</h4>

```groovy
dependencies {
    implementation 'hari.bounceview:bounceview:0.1.0'
}
```

<h4>Usage</h4>

<h5>Add animations to any views like so:</h5>

```java
Button button = view.findViewById(R.id.button);
BounceView.addAnimTo(button);
```

<h5>Use BounceView with dialogs:</h5>

```java
CustomDialog customDialog = new CustomDialog(getActivity());
//Add animation to custom dialog
BounceView.addAnimTo(customDialog);        //Call before showing the dialog
customDialog.show();

PopupWindow popupWindow;
...
//Add animation to popup window
BounceView.addAnimTo(popupWindow);        //Call before showing the popup
popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);

AlertDialog dialog = builder.create();
//Add animation to alert dialog
BounceView.addAnimTo(dialog);        //Call before showing the dialog
dialog.show();
```

<h5>Some cool animations:</h5>

```java
//Bounce animation
BounceView.addAnimTo(button1)
        .setScaleForPopOutAnim(1.1f, 1.1f);

//Horizontal flip animation
BounceView.addAnimTo(button2)
        .setScaleForPopOutAnim(1f, 0f);

//Vertical flip animation
BounceView.addAnimTo(button3)
        .setScaleForPopOutAnim(0f, 1f);

//Flicker animation
BounceView.addAnimTo(button4)
        .setScaleForPopOutAnim(0f, 0f);
```

<h5>Customize BounceView properties:</h5>

```java
Button button = view.findViewById(R.id.button);
BounceView.addAnimTo(button)
        //Default push in scalex: 0.9f , scaley: 0.9f
        .setScaleForPushInAnim(BounceView.PUSH_IN_SCALE_X, BounceView.PUSH_IN_SCALE_Y)
        //Default pop out scalex: 1.1f, scaley: 1.1f
        .setScaleForPopOutAnim(BounceView.POP_OUT_SCALE_X, BounceView.POP_OUT_SCALE_Y)
        //Default push in anim duration: 100 (in milliseconds)
        .setPushInAnimDuration(BounceView.PUSH_IN_ANIM_DURATION)
        //Default pop out anim duration: 100 (in milliseconds)
        .setPopOutAnimDuration(BounceView.POP_OUT_ANIM_DURATION)
        //Default interpolator: AccelerateDecelerateInterpolator()
        .setInterpolatorPushIn(BounceView.DEFAULT_INTERPOLATOR)
        .setInterpolatorPopOut(BounceView.DEFAULT_INTERPOLATOR);
```

## Credits
Inspired by and thanks to [TheKhaeng's Push Down Animation Click](https://github.com/TheKhaeng/pushdown-anim-click)

## License

Copyright 2018 hariprasanths

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

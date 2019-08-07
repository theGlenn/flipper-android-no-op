# flipper-android-no-op
No-op dependency when using Flipper Android in **release** mode.

[![](https://jitpack.io/v/theGlenn/flipper-android-no-op.svg)](https://jitpack.io/#theGlenn/flipper-android-no-op)
![GitHub](https://img.shields.io/github/license/theglenn/flipper-android-no-op.svg)
[![Contribute](https://img.shields.io/badge/contributions-friendly-b44ac1.svg)](https://egghead.io/series/how-to-contribute-to-an-open-source-project-on-github)

## Getting started

In your `build.gradle`:

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
...

dependencies {
  //The important part
  releaseImplementation 'com.github.theGlenn:flipper-android-no-op:0.2.0'
  debugImplementation 'com.facebook.soloader:soloader:0.5.1'
  debugImplementation 'com.facebook.flipper:flipper:0.23.4'
}
```

In your `Application` class same as [this](https://fbflipper.com/docs/getting-started.html) :
```java
public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    SoLoader.init(this, false);

    if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
      final FlipperClient client = AndroidFlipperClient.getInstance(this);
      client.addPlugin(new InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));
      client.start();
    }
  }
}
```

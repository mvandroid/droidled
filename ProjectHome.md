# Droid LED Demo #

Simple, no-frills application demonstrating how to enable the LED on Motorola's Droid. Unfortunately, this functionality is entirely undocumented (save for the FLASHLIGHT permission) and requires services/classes not exposed in the Android SDK. The actual method used was figured out by working backwards from the bytecode for a popular application that does the same thing.

## How it works ##

Early android builds appear to [expose a number of services](http://mylifewithandroid.blogspot.com/2008/01/using-service-directory.html) outside of what you can get at with the normal getSystemService by using a [ServiceManager](http://groups.google.com/group/android-developers/browse_thread/thread/7ffa8a9505255d3a). Retrieving the "hardware" service gets us an IBinder which can be used to retrieve an [IHardwareService](http://www.androidjavadoc.com/m5-rc15/android/os/IHardwareService.Stub.html) which can _then_ finally be used to turn the LED on and off.

Of course, none of that actually exists in the SDK these days. Knowing a few of the core classes, I was able to piece most of it together via reflection and lots of experimentation. The end result is that you can operate the LED without having to steal bits from earlier android releases or (presumably) fuss around with aidl.

## Note ##

I currently have no plans to release my own flashlight app in the market as there are some perfectly fine free options already available. Curiosity alone drove me to figure this out and share it, not a desire to see the app market flooded with a ton of pointless apps that all do the exact same thing. Please use this code responsibly.
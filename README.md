# AndroidModularReloaded

[AndroidModularSample](https://github.com/RoRoche/AndroidModularSample) reloaded!

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidModularReloaded-brightgreen.svg?style=flat)](https://android-arsenal.com/details/3/6337)

![logo](https://raw.githubusercontent.com/RoRoche/AndroidModularReloaded/master/assets/logo.png)

## Goals

- Use native Android SDK as much as possible (Fragment, ViewModel)
- Support configuration changes

## Opportunities

- [Dagger2 Android support](https://google.github.io/dagger//android.html):
    - Keep in mind that Android framework classes are instantiated by the OS itself
    - The type requesting injection doesn't need to know about its injector anymore
- Android Architecture Components to build _lifecycle-aware_ components
- Unit test `Fragment`(s) from modules with the convenient [DaggerMock](https://github.com/fabioCollini/DaggerMock/) and [FragmentTestRule](https://github.com/21Buttons/FragmentTestRule) libraries

## Steps

1. Providing Proper Back Navigation: <https://developer.android.com/training/implementing-navigation/temporal.html>
2. Set-up Dagger2 for Android
3. Set-up and share EasyFlow though [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html#sharing_data_between_fragments)

## Logo credits

Arrows graphic by <a href="http://www.flaticon.com/authors/roundicons">roundicons</a> from <a href="http://www.flaticon.com/">Flaticon</a> is licensed under <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0">CC BY 3.0</a>. Check out the new logo that I created on <a href="http://logomakr.com" title="Logo Maker">LogoMaker.com</a>

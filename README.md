<<<<<<< HEAD
# react-native-wayne-badge
跨平台角标
=======

# react-native-react-native-wayne-badge

## Getting started

`$ npm install react-native-react-native-wayne-badge --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-wayne-badge`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-wayne-badge` and add `RNReactNativeWayneBadge.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeWayneBadge.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeWayneBadgePackage;` to the imports at the top of the file
  - Add `new RNReactNativeWayneBadgePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-wayne-badge'
  	project(':react-native-react-native-wayne-badge').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-wayne-badge/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-wayne-badge')
  	```


## Usage
```javascript
import RNReactNativeWayneBadge from 'react-native-react-native-wayne-badge';

// TODO: What to do with the module?
RNReactNativeWayneBadge;
```
  
>>>>>>> 9ed245f (first commit)

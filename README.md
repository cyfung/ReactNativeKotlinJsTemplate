# ReactNativeKotlinJsTemplate

A minimalist React Native template for a quick start with Kotlin/JS.

## Setup

1. Init with the template
```sh
npx react-native init MyApp --template https://github.com/cyfung/ReactNativeKotlinJsTemplate
```
2. Enter the App folder `cd Mypp`
3. Build the JS with kotlin `./gradlew copyDevelopment`. Or `gradlew copyDevelopment` if on Windows
4. Enter the react folder `cd react`
5. Run `yarn install` to install all the javascript dependencies.
6. (optional) Init react-native-windows
```sh
npx  react-native-windows-init --overwrite
```

## Run
Update the JS with one of the following gradle tasks in the App folder
```sh
copyDevelopment
copyProduction
cleanCopyDevelopment
cleanCopyProduction
```
The postfix indicates whether it is for development or production

Tasks with prefix `clean` will delete the `react/generated` folder before copying

Depending on your platform, use of the following commands in the `react` folder to start react-native
```sh
npx react-native run-android
npx react-native run-ios
npx react-native run-windows
```

## Continuous Build
You may run the gradle tasks with `-t` on a separate windows for continuous build, e.g.
```sh
gradlew -t copyDevelopment
```

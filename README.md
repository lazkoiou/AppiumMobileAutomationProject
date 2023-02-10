# MobileAutomationProject

(Windows)

<h3>Install Appium from node.js</h3>

Step 1. Install node.js

First, check if node.js is installed on your system
```
node --version
```
Also, check to see if npm is installed on your system
```
npm --version
```
If they are not installed in your system, download and install node.js from https://nodejs.org/en/download

Step 2. Install Appium with node.js

```
npm install -g appium
```
After installing, check if Appium is installed
```
appium --version
```

Step 3. Start Appium from the command line

```
appium
```

<h3>Installing Appium with APPIUM DESKTOP CLIENT</h3>

Go to https://appium.io and click to go to the Download page (https://github.com/appium/appium-desktop/releases/)

<h3>Create a Virtual Device</h3>
A Virtual Device can be created from Android Studio

0. You need to have started an Appium Server up and running before Step #4
1. Go to the "Device Manager" button at the right side of Android Studio, download and create a device
2. Go to the "SDK Manager" button at the right side of Android Studio and check that an SDK is installed (or install one)
3. Go to the SDK folder - relative path: "C:\Users\{User}\AppData\Local\Android\Sdk\platform-tools" where <b>adb.exe</b> is located
4. In the current directory, open a cmd and type <b>adb.exe devices</b> to see the connected devices


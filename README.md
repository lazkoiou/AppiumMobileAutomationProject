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

<h4>Configure APPIUM DESKTOP CLIENT</h4>
Open the application
1. Go to <b>Edit Configurations</b>, in ANDROID_HOME add (example) path: "C:\Users\{User}\AppData\Local\Android\Sdk" and verify JAVA_HOME is set
2. Set <b>Host</b> as <i>localhost</i>
3. Go to <b>Advanced</b> and enable "Allow CORS" 

<h3>Install Appium Inspector</h3>
Start Appium Server, click on <b>InspectorMoved</b> to open the github link, check the Notes, until you reach to <b>Releases</b>. Open it and download the <b>Appium-Inspector-windows-2022.11.1.exe</b>

<h4>Configure Appium Inspector</h4>
1. Set <b>Remote Host</b> as <i>localhost</i>
2. Set <b>Remote path</b> as <i>/wd/hub/</i>
3. In Desired Capabilities
    i.  <b>Name</b> as <i>platformName</i>
    ii. <b>value</b> as <i>Android</i>  
   
<h3>Create a Virtual Device</h3>
A Virtual Device can be created from Android Studio <br>

0. You need to have started an Appium Server up and running before Step #4
1. Go to the "Device Manager" button at the right side of Android Studio, download and create a device
2. Go to the "SDK Manager" button at the right side of Android Studio and check that an SDK is installed (or install one)
3. Go to the SDK folder - example path: "C:\Users\{User}\AppData\Local\Android\Sdk\platform-tools" where <b>adb.exe</b> is located
4. In the current directory, open a cmd and type <b>adb.exe devices</b> to see the connected devices

<h3>Mix everything together</h3>
After all of the above have been completed:
1. Start a Virtual Device from Android Studio
2. Start Appium Server
3. Start Appium Inspector

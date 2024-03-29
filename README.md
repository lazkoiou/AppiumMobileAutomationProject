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
<ol>
   <li>Go to <b>Edit Configurations</b>, in ANDROID_HOME add (example) path: "C:\Users\{User}\AppData\Local\Android\Sdk" and verify JAVA_HOME is set</li>
   <li>Set <b>Host</b> as <i>localhost</i></li>
   <li>Go to <b>Advanced</b> and enable "Allow CORS"</li> 
</ol>
   
<h3>Install Appium Inspector</h3>
Start Appium Server, click on <b>InspectorMoved</b> to open the github link, check the Notes, until you reach to <b>Releases</b>. Open it and download the <b>Appium-Inspector-windows-2022.11.1.exe</b>

<h4>Configure Appium Inspector</h4>
<ol>
   <li>Set <b>Remote Host</b> as <i>localhost</i></li>
   <li>Set <b>Remote path</b> as <i>/wd/hub/</i></li>
   <li>In Desired Capabilities</li>
   <ul>
      <li><b>Name</b> as <i>platformName</i>, <b>value</b> as <i>Android</i></li>
      <li><b>Name</b> as <i>deviceName</i>, <b>value</b> as <i>Nexus 5X API 30</i></li>
      <li><b>Name</b> as <i>platformVersion</i>, <b>value</b> as <i>11.0</i></li>
      <li><b>Name</b> as <i>automationName</i>, <b>value</b> as <i>UiAutomator2</i></li>
      <li><b>Name</b> as <i>app</i>, <b>value</b> as <i>{path to .apk}</i></li>
   </ul>
</ol>
   
<h3>Create a Virtual Device</h3>
A Virtual Device can be created from Android Studio. You need to have started an Appium Server up and running before Step #4
<ol>
   <li>Go to the "Device Manager" button at the right side of Android Studio, download and create a device</li>
   <li>Go to the "SDK Manager" button at the right side of Android Studio and check that an SDK is installed (or install one)</li>
   <li>Go to the SDK folder - example path: "C:\Users\{User}\AppData\Local\Android\Sdk\platform-tools" where <b>adb.exe</b> is located</li>
   <li>In the current directory, open a cmd and type <b>adb.exe devices</b> to see the connected devices</li>
</ol>
   
<h3>Mix everything together</h3>
After all of the above have been completed:
<ol>
   <li>Start a Virtual Device from Android Studio</li>
   <li>Start Appium Server</li>
   <li>Start Appium Inspector</li>
</ol>

<h2>Create a batch to start the Virtual Device automatically</h2>
Go to the path C:\Users\{User}\AppData\Local\Android\Sdk\emulator and get the device name by typing:
```
emulator -list-avds
```
To achieve this we need to make a batch with the following commands:
```
echo Running the Android Virtual Device Nexus_5X_API_30
cd C:\Users\{User}\AppData\Local\Android\Sdk\emulator
emulator -avd Nexus_5X_API_30
```

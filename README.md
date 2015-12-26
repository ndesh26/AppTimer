# AppTimer
AppTimer is a open source library which provides the time spent by the user on each app. AppTimer supports until Android Kitkat. It uses GET_TASKS permission to retrieve the app which is running in the foreground.
AppTimer in 2 steps
-------------------
1. Initialize Library:<br/>
<code>AppTimer.initialize(context);</code><br/><br/>
2. Retrieve Time Stats:<br/>
<code>List<TimeStats> list = AppTimer.getTimeStats(context);</code><br/><br/>

Add AppTimer to your project
----------------------------
AppTimer is available on jcenter. Please ensure that you are using the latest version by [checking here](http://search.maven.org/)<br>

Gradle:
```
    compile 'com.ndesh:app-timer:0.0.1'
```

License
--------

    MIT




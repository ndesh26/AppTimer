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

    Copyright 2015 Nayan Deshmukh.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




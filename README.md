External Broadcaster
======

This is a simple plugin for [Ionic App](http://ionicframework.com/) that fires a broadcast to native code.

### Usage 

* Install the plugin

```
ionic cordova plugin add https://github.com/jeronimonascimento/external-broadcaster.git
```

* Declare variable called cordova bellow your imports:
```
declare var cordova: any;
```

* Use it!

```
cordova.plugins.ExternalBroadcaster.broadcast(function (e, 'Intent name') {});
```
 

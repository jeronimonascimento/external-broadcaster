
var exec = require('cordova/exec');

var PLUGIN_NAME = 'ExternalBroadcaster';

var _ExternalBroadcaster = {

  broadcast: function(cb, intentName){
	exec(cb, null, PLUGIN_NAME, intentName, []);
  }

};

module.exports = ExternalBroadcaster;


var exec = require('cordova/exec');

var PLUGIN_NAME = 'ExternalBroadcaster';

var _ExternalBroadcaster = {

  broadcast: function(cb){
	exec(cb, null, PLUGIN_NAME, 'broadcast', []);
  }

};

module.exports = ExternalBroadcaster;

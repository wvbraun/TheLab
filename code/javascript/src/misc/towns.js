var utils = require('utils');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	},
	clientScripts: ['lib/jquery.min.js'] // inject jquery library, allows use of $
});

casper.start('https://en.wikipedia.org/wiki/List_of_towns_in_Vermont', function() {
		this.echo(this.getTitle());

		// get info on all elements matching this css selector
		var town_info_text = this.evaluate(function() {
			var nodes = document.querySelectorAll('table.sortable.wikitable tbody tr');
			return [].map.call(nodes, function(node) {
				return node.textContent;
			});
		});
 
		// split the array into an array of object literals
		var town_data = town_info_text.map(function(str) {
			var elements = str; //.split("\n");
			/*var data = {
				name  		: elements[2],
				county 		: elements[3],
				population  : elements[4],
				area 		: elements[5]
			};
			return data;
			*/
			return elements;
		});

		// dump the town names array to screen
		utils.dump(town_data);
	});

casper.run();

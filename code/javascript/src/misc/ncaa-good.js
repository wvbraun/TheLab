var utils = require('utils');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

casper.start('http://statsheet.com/mcb/players/stats/points_avg', function() {
		this.echo(this.getTitle());

		var player_info_text = this.evaluate(function() {
			var nodes = document.querySelectorAll('table.sortable.stats tbody tr');
			return [].map.call(nodes, function(node) {
				return node.textContent;
			});
		});

		var player_data = player_info_text.map(function(str) {
			var elements = str.split("\n");
			var data = {
				name  			: elements[2].trim(),
				team 			: elements[7].trim(),
				year 			: elements[3].trim(),
				height          : elements[4].trim(),
				ppg 			: str.substring(str.search(/\./) - 2, str.search(/\./) +2)
			};
			return elements;
		});

		utils.dump(player_data);
	});

casper.run();

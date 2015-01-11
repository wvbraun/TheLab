var utils = require('utils');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

casper.start('http://espn.go.com/mens-college-basketball/statistics/player/_/stat/scoring-per-game', function() {
		this.echo(this.getTitle());

		var player_info_text = this.evaluate(function() {
			var nodes = document.querySelectorAll('table.tablehead tbody tr');
			return [].map.call(nodes, function(node) {
				return node.textContent;
			});
		});

		var player_data = player_info_text.map(function(str) {
			var elements = str;
			/*var data = {
			//	rank 			: elements[1],
				name  			: elements[2],
			//	team 			: elements[3],
			//	year 			: elements[4],
			//	pts 			: elements[11],
			//	ppg 			: elements[12]
			};
			return data;
			*/
			return elements;
		});

		utils.dump(player_data);
	});

casper.run();

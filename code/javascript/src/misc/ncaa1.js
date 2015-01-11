var utils = require('utils');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

casper.start('http://www.ncaa.com/stats/basketball-men/d1/current/individual/136', function() {
		this.echo(this.getTitle());

		var player_info_text = this.evaluate(function() {
			var nodes = document.querySelectorAll('table.table-striped.table-bordered.sticky-enabled.tableheader-processed.sticky-table tbody tr');
			return [].map.call(nodes, function(node) {
				return node.textContent;
			});
		});

		var player_data = player_info_text.map(function(str) {
			var data = {
			//  rank 			: str.substring(0, str.search(/[A-Z]/)),
				name  			: str.substring(str.search(/[A-Z]/), str.search(/[a-z][A-Z]/) + 1), 

			//	team 			: str.substring(str.search(/[a-z][A-Z][a-z]/), str.search(/[A-Z]/)),
			//	year 			: elements[4],
		    	points 			: str.substring(str.length - 8, str.length - 5),
				ppg 			: str.substring(str.length - 5, str.length - 1)
			};
			return data;
		});

		utils.dump(player_data);
	});

casper.run();

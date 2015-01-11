var utils = require('utils');
var fs = require('fs');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

// var save = '/home/brandon/code/js/ncaa.txt';


	
casper.start('http://statsheet.com/mcb/players/stats/points_avg', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2012-2013&min=', info.call()); 
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2011-2012&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2010-2011&min=', info.call()); 
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2009-2010&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2008-2009&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2007-2008&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2006-2007&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2005-2006&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2004-2005&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2003-2004&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2002-2003&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2001-2002&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=2000-2001&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1999-2000&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1998-1999&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1997-1998&min=', info.call());
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1996-1997&min=', info.call());

function info() {
    this.echo(this.getTitle());

	var player_info = this.evaluate(function() {
		var node = document.querySelector('table.sortable.stats tbody tr');
		return node.textContent;
	});

	var stats = player_info.split("\n");
	var data = {
		name 	: stats[2].trim(),
		team 	: stats[7].trim(),
		year 	: stats[3].trim(),
		height 	: stats[4].trim(),
		ppg 	: stats[1].trim().substring(1, 6)
	};

	utils.dump(data);
	//fs.write(save, data, 'w');
	console.log("------------------------------------\n");

}
/*
casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1995-1996&min=', info());
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1994-1995&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1993-1994&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1992-1993&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1991-1992&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1990-1991&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

casper.thenOpen('http://statsheet.com/mcb/players/stats/points_avg?games=1&conf=&season=1989-1990&min=', function() {
		this.echo(this.getTitle());

		var player_info = this.evaluate(function() {
			var node = document.querySelector('table.sortable.stats tbody tr');
			return node.textContent;
		});

		var stats = player_info.split("\n");
		var data = {
			name 	: stats[2].trim(),
			team    : stats[7].trim(),
			year 	: stats[3].trim(),
			height 	: stats[4].trim(),
			ppg 	: stats[1].trim().substring(1,6)
		};

		utils.dump(data);
		console.log("------------------------------------\n");
	});

*/

casper.run();

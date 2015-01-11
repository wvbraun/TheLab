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

var i = 0;
var links = [];
var town_data = [];

function getTownLinks() {
	var links = document.querySelectorAll('table.sortable.wikitable tbody tr td:nth-of-type(2) a');
	return [].map.call(links, function(link) {
		return link.getAttribute('href');
	});
}

function loopThroughTownLinks() {
	if (i < links.length) {
		this.echo('[LINK #' + i + '] ' + links[i]);
		getTownData.call(this, links[i]);
		i++;
		this.run(loopThroughTownLinks);
	}
	else {
		utils.dump(town_data);
		this.exit();
	}
}

function getTownData(link) {
	this.start(link, function() {

		// get name of town from infobox
		var name = this.fetchText('span.fn.org');
		
		// get the elevation text from the info box
		var elevation = this.evaluate(function() {
			return $('th:contains("Elevation") + td').text();
		});

		// add the name & elevation data to the town_data array
		var data = {
			name: name,
			elevation: elevation
		};
		town_data.push(data);

	});
}



casper.start('https://en.wikipedia.org/wiki/List_of_towns_in_Vermont', function() {
		links = this.evaluate(getTownLinks);

		// convert relative links to absolute urls
		for (var i = 0; i < links.length; i++) {
			links[i] = "http://en.wikipedia.org" + links[i];
		}

		utils.dump(links);
	});


casper.run(loopThroughTownLinks);

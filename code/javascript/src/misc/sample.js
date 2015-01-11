
// create a new casper instance
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

// start it and open http://casperjs.org/
// once the page has been loaded, we print its title.
casper.start('http://casperjs.org/', function() {
		this.echo(this.getTitle());
	});

casper.thenOpen('http://phantomjs.org/', function() {
		this.echo(this.getTitle());
	});

casper.run();


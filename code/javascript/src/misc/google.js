var links = [];
var casper = require('casper').create();

function getLinks() {
	var links = document.querySelectorAll('h3.r a');
	return Array.prototype.map.call(links, function(e) {
		return e.getAttribute('href');
	});
}

casper.start('http://google.fr/', function() {
	// search for 'casperjs' from google form
	this.fill('form[action="/search"]', {q: 'casperjs' }, true);
});

casper.then(function() {
	// aggregate results for the 'casperjs' search
	links = this.evaluate(getLinks);
	this.fill('form[action="/search"]', {q: 'phantomjs' }, true);
});

casper.then(function() {
	links = links.concat(this.evaluate(getLinks));
});

casper.run(function() {
	this.echo(links.length + 'links found:');
	this.echo(' - ' + links.join('\n - ')).exit();
});


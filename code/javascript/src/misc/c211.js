var utils = require('utils');
var casper = require('casper').create({
	verbose: true,
	logLevel: 'error',
	pageSettings: {
		loadImages: false,
		loadPlugins: false
	}
});

/*
var url = "http://gradedistribution.registrar.indiana.edu/";

var gradedist = "gradedist.php?";
var dist = "dept=CSCI&subject=&crse=c211&clsnbr=&instrname=&report_selection=gradedist&search_process=go";
var csv "exportToSpreadsheet.php?reportID=";
*/

url = "http://gradedistribution.registrar.indiana.edu/kkgradedist.php?dept=CSCI&subject=&crse=c211&clsnbr=&instrname=&report_selection=gradedist&search_process=go";
dl = "http://gradedistribution.registrar.indiana.edu/exportToSpreadsheet.php?reportID=gradedist&dept=CSCI&crse=C211&search_process=GO&report_selection=gradedist";

casper.start(url, function() {
	this.download(dl, "blah.csv");
});

casper.run();

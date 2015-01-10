
/**
 * Module dependencies.
 */

var express = require('express'),
    routes = require('./routes/index'),
    path = require('path'),
    favicon = require('static-favicon'),
    logger = require('morgan'),
    cookieParser = require('cookie-parser'),
    bodyParser = require('body-parser'),
    users = require('./routes/users'),
    mongo = require('mongoskin'),
    db = mongo.db("mongodb://localhost:27017/nodetest", {native_parser: true});

//var app = module.exports = express.createServer();
var app = express();

// Configuration

app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.bodyParser());
app.use(favicon());
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(cookieParser());
//app.use(express.methodOverride());
//app.use(app.router);
app.use('/', routes);
app.use('/users', users);
app.use(express.static(__dirname + '/public'));

app.use(function(req, res, next) {
	var err = new Error('Not Found');
	err.status = 404;
	next(err);
});

/*
app.configure('development', function(){
  app.use(express.errorHandler({ dumpExceptions: true, showStack: true }));
});

app.configure('production', function(){
  app.use(express.errorHandler());
});

*/

if (app.get('env') === 'development') {
	app.use(function(err, req, res, next) {
		res.status(err.status || 500);
		res.render('error', {
			message: err.message,
			error: err
		});
	});
}

app.use(function(err, req, res, next) {
	res.status(err.status || 500);
	res.render('error', {
		message: err.message,
		error: {}
	});
});


// Routes

app.use(function(req, res, next) {
	req.db = db;
	next();
});
app.use('/', routes);
app.use('/users', users);
//app.get('/', routes.index);

app.listen(3000, function(){
  console.log("Express server listening on port %d in %s mode", app.address().port, app.settings.env);
});

module.exports = app;

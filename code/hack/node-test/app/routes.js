module.exports = function(app) {
	
	//sample api route
	app.get('/api/nerds', function(req, res) {
		Nerd.find(function(err, nerds) {
			if (err) 
				res.send(err);
			res.json(nerds);
		});
	});

	app.get('*', function(req, res) {
		res.sendfile('./public/index.html');
	});
};

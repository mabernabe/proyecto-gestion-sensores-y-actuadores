let restService = angular.module('restService', [ 'ngResource']);


restService.config(function($resourceProvider) { 
	$resourceProvider.defaults.stripTrailingSlashes = false; 
})

restService.service ("RestService",function($q, $location, $resource){
	let self = this;	

    self.restlocation = "http://" + $location.host() + ":" + $location.port() + "/rest/";

	self.get = function (url, params) {	
		console.log("Get resource " + url );	
		let resource = $resource(self.restlocation + url, params);	
		let deferred = $q.defer();
		resource.get().$promise.then(function(response) {
			deferred.resolve(response); 
		}, function(response) {
			deferred.reject(response);
		});
		return deferred.promise ;
	}


	self.post = function (url, data) {
		console.log("Post resource" + url);
		let resource = $resource(self.restlocation + url);	
		let deferred = $q.defer();
		resource.save(data).$promise.then(function(response) {
			deferred.resolve(response); 
		}, function(response) {
			deferred.reject(response);
		});
		return deferred.promise ;
	}

	
	self.patch = function (url, data) {
		console.log("Post resource" + url);
		let resource = $resource(self.restlocation + url, null, {
			   patch: {method: 'PATCH'}
		});	
		let deferred = $q.defer();
		resource.patch(data).$promise.then(function(response) {
			deferred.resolve(response); 
		}, function(response) {
			deferred.reject(response);
		});
		return deferred.promise ;
	}

	self.delete = function (url, data) {
		console.log("Delete resource" + url);
		let resource = $resource(self.restlocation + url);	
		let deferred = $q.defer();
		resource.remove(data).$promise.then(function(response) {
			deferred.resolve(response); 
		}, function(response) {
			deferred.reject(response);
		});
		return deferred.promise ;
	}
});



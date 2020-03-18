/**
 * Task services CRUD ajax calls
 */

"use strict";

app.service('mainService', [ '$http', function($http) {
	this.saveUser = function(user) {

		if (user.userType) {
			return $http.post('worker/create.ajax', user);
		} else {
			return $http.post('client/create.ajax', user);
		}

	};
	
	this.getUserById = function(userId,userType){

		if(userType.indexOf('client') > -1 ){
			alert('client');
			return $http.get('client.ajax',{params:{ clientId : userId }});				
		}
		else{
			alert('worker');
			return $http.get('worker.ajax',{params:{ workerId : userId }});
		}
		
	};
		

} ]);

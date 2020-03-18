/**
 * Main controller
 */
(function() {
    'use strict';
    app.controller("MainController",['$scope',
             						'$rootScope',
             						'$cookies',
            						'userService',
            						'mainService',
            						'$location',
            						'$modal',
            						'dialogs','localStorageService',
                                     function($scope, $rootScope, $cookies, userService, mainService,$location,$modal,dialogs,localStorageService) {

    	console.log('main Controller');
    	$rootScope.userName = $cookies.email;
    	$rootScope.user = {};
    	$rootScope.disable = true;
    	if( $cookies.type){
    		$rootScope.isClient = $cookies.type.indexOf('client') > -1 ? true : false;
    	}
    	
    	$rootScope.login = function(){
			dialogs.create('resources/templates/login.html','UserLoginController',{},{size:'md'});
		};
		
		$rootScope.register = function(){
			dialogs.create('resources/templates/register.html','UserLoginController',{},{size:'md'});
		};
		
		$rootScope.saveUser = function() {
			$rootScope.user.details.userCreationDate = new Date();
			$rootScope.user.details.isActive = true;
			$rootScope.user.workExperience = 0;
			$rootScope.user.workCredibility = 0.5;
			mainService.saveUser($rootScope.user)
			.then(
					function(data) {
						if (data.data) {
							dialogs.notify('Notification','Registeration successfully!',{size:'sm'});
							$rootScope.user = {};
							$scope.userForm.$setPristine();
						} else {
							dialogs.notify('Notification','Error while saving User details!',{size:'sm'});
						}
					});
		};
		
		$rootScope.enableEdit = function(){
			$rootScope.disable = false; 
			dialogs.notify('Notification','Edit Enable!',{size:'sm'});
		};
		
		$rootScope.getUserById = function() {
						
			mainService.getUserById($cookies.get("userId"),$cookies.get("type"))
			.then(
					function(data) {
						if (data.data) {
							dialogs.notify('Notification','Data Retreived successfully!',{size:'sm'});
							$rootScope.user = data.data;
						} else {
							dialogs.notify('Notification','Error while saving User details!',{size:'sm'});
						}
					});
		};
		
				$rootScope.deleteAllCookies = function() {
	    var cookies = document.cookie.split(";");

	    for (var i = 0; i < cookies.length; i++) {
	    	var cookie = cookies[i];
	    	var eqPos = cookie.indexOf("=");
	    	var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
	    	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
	    }
	};
				
}]);

})();
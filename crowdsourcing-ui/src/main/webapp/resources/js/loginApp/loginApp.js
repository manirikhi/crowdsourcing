/**
 * Main blog app js source
 */
	'use strict';
	var loginApp = angular.module('loginApp',['ui.router']);

	loginApp.config(function($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/login');
	
		$stateProvider

		// HOME STATES AND NESTED VIEWS ========================================
		.state('login', {
			url : '/login',
			views:{
				'loginView':{
					templateUrl : 'resources/templates/login.html'
				}
			}
		}).state('register', {
			url : '/register',
			views:{
				'loginView':{
					templateUrl : 'resources/templates/register.html',
					controller : 'LoginController'
				}
			}
		}).state('forget', {
			url : '/forget',
			views:{
				'loginView':{
					templateUrl : 'resources/templates/forget.html'
				}
			}
		});

	}); // closes $routerApp.config()
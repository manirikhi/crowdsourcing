/**
 * Main blog app js source
 */
	'use strict';
	var app = angular.module('app', ['ui.router','ngSanitize','ui.bootstrap','ngCookies',"ngTable",'dialogs.main','angularUtils.directives.dirPagination','LocalStorageModule']);

	app.config(function($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/');
	
		$stateProvider

		// HOME STATES AND NESTED VIEWS ========================================
		.state('index', {
			url : '/',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/index.html',
					controller : 'MainController'
				}
			}
		})
		.state('tasks', {
			url : '/tasks',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/tasks.html',
					controller : 'TaskController'
				}
			}
		})
		.state('userTasks', {
			url : '/userTasks',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/user-tasks.html',
					controller : 'UserTaskController'
				}
			}
		})
		.state('createTask', {
			url : '/createTask',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/task-create.html',
					controller : 'TaskController'
				}
			}
		})
		.state('availableTasks', {
			url : '/availableTasks',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/available-tasks.html',
					controller : 'AvailableTaskController'
				}
			}
		})
		.state('workers', {
			url : '/workers',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/workers.html',
					controller : 'ManageWorkerController'
				}
			}
		})
		.state('aboutUs', {
			url : '/aboutUs',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/aboutUs.html',
					controller : 'MainController'
				}
			}
		})
		.state('profile', {
			url : '/profile',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/profile.html',
					controller : 'MainController'
				}
			}
		}).state('register', {
			url : '/register',
			views:{
				'mainView':{
					templateUrl : 'resources/templates/register.html',
					controller : 'MainController'
				}
			}
		});
	}); // closes $routerApp.config()

	
app.run(function(){
	
});
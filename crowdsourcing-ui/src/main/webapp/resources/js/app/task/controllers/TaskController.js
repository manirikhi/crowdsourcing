/**
 * worker details Modal window controller
 */
'use strict';
app
		.controller(
				"TaskController",
				[
						'$scope',
						'$rootScope',
						'$cookies',
						'taskService',
						'userService',
						'dialogs',
						'NgTableParams',
						'$filter',
						'localStorageService',
						function($scope, $rootScope, $cookies, taskService, userService,dialogs,
								NgTableParams, $filter, localStorageService) {
							$rootScope.tasks = localStorageService.get('task');
							$rootScope.task = {};

							// list of all tasks in system
							$rootScope.tableParams = new NgTableParams(
									{
										page : 1, // show first page
										count : 10, // count per page
										filter : {
										// name: 'M' // initial filter
										},
										sorting : {
											number : 'desc' // initial sorting
										}
									},
									{
										getData : function(params) {
											// ajax request to api
											return taskService
													.taskList()
													.then(
															function(data) {
																if (data.data) {
																	var filteredData = params
																			.filter() ? $filter(
																			'filter')
																			(
																					data.data,
																					params
																							.filter())
																			: data.data;
																	var orderedData = params
																			.sorting() ? $filter(
																			'orderBy')
																			(
																					filteredData,
																					params
																							.orderBy())
																			: data.data;
																	params
																			.total(orderedData.length);
																	var offset = params
																			.page() > 1 ? (params
																			.page() - 1)
																			* params
																					.count()
																			: 0;
																	return orderedData
																			.slice(
																					offset,
																					params
																							.count()
																							+ offset);
																}
															});
										}
									});
														
							$rootScope.createTask = function() {
								
								$scope.task.taskRating = 0.0;
								$scope.task.taskCompleted = false;
								$scope.task.taskAssigned = false;
								$scope.task.clientId = $cookies.get("userId");
								
								taskService.saveTask($scope.task)
								.then(
										function(data) {
											if (data.data) {
												dialogs.notify('Notification','Task created successfully!',{size:'sm'});
												$scope.task = {};
												$scope.task.$setPristine();
											} else {
												dialogs.notify('Notification','Error while creating task!',{size:'sm'});
											}
										});
																																														
							};																			
							
						}]);
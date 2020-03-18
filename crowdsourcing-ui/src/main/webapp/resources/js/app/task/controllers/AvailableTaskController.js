/**
 * worker details Modal window controller
 */
'use strict';
app
		.controller(
				"AvailableTaskController",
				[
						'$scope',
						'$rootScope',
						'$cookies',
						'taskService',												
						'NgTableParams',
						'$filter',
						 'dialogs',
						'localStorageService',
						function($scope, $rootScope, $cookies, taskService,
								NgTableParams, $filter, dialogs,localStorageService) {														
													
							// new coming task for worker
							$rootScope.workerTableParams = new NgTableParams(
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
													.getAvailableTasks($cookies.get("userId"))
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
							
							// worker rejects the task
							$rootScope.rejectTask = function(taskId) {
								var confirmDlg = dialogs.confirm('Confirmation','Are you sure you want to reject the task ?',{size:'sm'});
								confirmDlg.result.then(function(btn){
									taskService
									.rejectTask(taskId,$cookies.get("userId"))
									.then(
											function(data) {
												if (data.data) {
													$rootScope.userList();
													dialogs.notify('Notification','Task rejected successfully!',{size:'sm'});
													
												} else {
													dialogs.notify('Notification','Error while rejecting task!',{size:'sm'});
												}
											});
								});
							};
							
							// worker accepts the task
							$rootScope.acceptTask = function(taskId) {																								
								var confirmDlg = dialogs.confirm('Confirmation','Are you sure you want to accept the task ?',{size:'sm'});
								confirmDlg.result.then(function(btn){
								taskService.acceptTask(taskId,$cookies.get("userId"))
								.then(
										function(data) {
											if (data.data) {
												dialogs.notify('Notification','Task accepted successfully!',{size:'sm'});												
											} else {
												dialogs.notify('Notification','Error while accepting task!',{size:'sm'});
											}
										});
								});																																						
							};
							
						}]);





/**
 * worker details Modal window controller
 */
'use strict';
app
		.controller(
				"UserTaskController",
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
							if($cookies.get("type")){
								if($cookies.get("type").indexOf("client")>-1){
									$rootScope.isClient = true;		
								}
								else{
									$rootScope.isClient = false;
								}
							}

							// task list as per worker id,client id
							$rootScope.userTableParams = new NgTableParams(
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
													.getTasksPerUser($cookies.get("userId"))
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
							
							// worker marks task complete
							$rootScope.markTaskComplete = function(taskId) {
								var confirmDlg = dialogs.confirm('Confirmation','Are you sure you want to mark the task completed?',{size:'sm'});
								confirmDlg.result.then(function(btn){
									taskService
									.markTaskComplete(taskId,$cookies.get("userId"))
									.then(
											function(data) {
												if (data.data) {
													$rootScope.userList();
													dialogs.notify('Notification','Task marked completed successfully!',{size:'sm'});
													
												} else {
													dialogs.notify('Notification','Error while marking the task completed!',{size:'sm'});
												}
											});
								});
							};
							
							// client submit rating
							$rootScope.submitRating = function(rating,taskId) {		
								alert(rating,taskId);
									taskService
									.submitRating(rating,taskId)
									.then(
											function(data) {
												if (data.data) {
													$rootScope.userList();
													dialogs.notify('Notification','Task marked completed successfully!',{size:'sm'});
													
												} else {
													dialogs.notify('Notification','Error while marking the task completed!',{size:'sm'});
												}
											});								
							};
							
							
						}]);
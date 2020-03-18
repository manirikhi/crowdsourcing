/**
 * worker details Modal window controller
 */
'use strict';
app.controller("ManageWorkerController", [ '$scope', '$rootScope','workerService','dialogs','NgTableParams','$filter','localStorageService',
		function($scope, $rootScope,workerService,dialogs,NgTableParams,$filter,localStorageService) {
		$rootScope.workers = 	localStorageService.get('worker');
			
			// ngTable parameter initilization with data.	
			$scope.tableParams = new NgTableParams({
			page: 1,            // show first page
			count: 10,          // count per page
			filter: {
						//name: 'M'       // initial filter
					},
					sorting: {
						number: 'desc'     // initial sorting
					}
			}, {
				getData: function(params) {
			// ajax request to api
			return workerService
			.workerList()
			.then(
					function(data) {
						if (data.data) {
							var filteredData = params.filter() ?
	                                $filter('filter')(data.data, params.filter()) :
	                                data.data;
								var orderedData = params.sorting() ?
	                                $filter('orderBy')(filteredData, params.orderBy()) :
	                                data.data;
								params.total(orderedData.length);	
								var offset = params.page() > 1 ? (params
														.page() - 1)
														* params.count()
														: 0;
								return orderedData.slice(offset,params.count()+offset);
						} 
					});
					}
			}
			);
		} ]);
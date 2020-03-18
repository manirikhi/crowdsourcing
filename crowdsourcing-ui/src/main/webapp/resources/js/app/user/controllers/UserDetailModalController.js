/**
 * User details Modal window controller
 */
'use strict';
app.controller("UserDetailModalController", [ '$scope', '$rootScope',
		'$modalInstance', 'data','userService','dialogs',
		function($scope, $rootScope, $modalInstance, data,userService,dialogs) {
			$scope.user = data;
			$scope.update = function(updatedUser) {
				userService
				.updateUser(updatedUser)
				.then(
						function(data) {
							if (data.data) {
								dialogs.notify('Notification','User updated successfully!',{size:'sm'});
								$rootScope.userList();
							} else {
								dialogs.notify('Notification','Error while saving User details!',{size:'sm'});
							}
							$scope.close();
						});
			};
			
			// save the user details into database with ajax
			// call
			$scope.save = function(newUser) {
				newUser.userCreationDate = new Date();
				userService
						.saveUser(newUser)
						.then(
								function(data) {
									if (data.data) {
										dialogs.notify('Notification','User Registered successfully!',{size:'sm'});
										$rootScope.userList();
									} else {
										dialogs.notify('Notification','Error while saving User details!',{size:'sm'});
									}
								});
			};
			
			//On click of reset clear user data
			$scope.resetUser = function(form){
				if (form) {
				      form.$setPristine();
				    }
				$scope.newUser = {};
			};
			
			$scope.close = function() {
				$modalInstance.dismiss('cancel');
			};
		} ]);
/**
 * compose new post controller
 */
app
		.controller(
				"UserLoginController",
				[
						'$scope',
						'$rootScope',
						'userService',
						'$location',
						'$modal',
						'dialogs','localStorageService',
						function($scope, $rootScope, userService, $location,$modal,dialogs,localStorageService) {
								
							$scope.openUserModal = function(type,data){
								switch(type){
								case 'add':
									dialogs.create('resources/templates/saveUserDetailsModalTemplate.html','UserDetailModalController',{},{size:'md'});
									break;
								case 'edit':
									dialogs.create('resources/templates/editUserDetailsModalTemplate.html','UserDetailModalController',data,{size:'md'});
									break;
								case 'view':
									dialogs.create('resources/templates/userDetailsModalTemplate.html','UserDetailModalController',data,{size:'md'});
									break;
								}
							};

							
							// As user list is fetched from index.jsp which is
							// parent scope so
							// we have to user rootscope to access user list							
							
							$rootScope.userList = function() {
								$scope.pageChanged(1);
							};
							
							// delete the selected user from db
							$scope.deleteUser = function(user) {
								var confirmDlg = dialogs.confirm('Confirmation','Do you want to delete User: '+user.firstName+' '+user.lastName+'?',{size:'sm'});
								confirmDlg.result.then(function(btn){
									userService
									.deleteUser(user.userId)
									.then(
											function(data) {
												if (data.data) {
													$rootScope.userList();
													dialogs.notify('Notification','User Deleted successfully!',{size:'sm'});
													
												} else {
													dialogs.notify('Notification','Error while deleting User!',{size:'sm'});
												}
											});
								});

							};

						} ]);
/**
 * Task services CRUD ajax calls
 */

  "use strict";
        
    app.service('taskService', ['$http', function ($http){       	
        	this.saveTask = function(task) {        		
        			return $http.post('task/create.ajax', 
                    		task);        		        		                        
        	};
        	//get all tasks
        	this.taskList = function(){
        		return $http.get('tasks.ajax');
        	};
        	//get task per user
        	this.getTasksPerUser = function(userId){
        		return $http.get('taskList.ajax',{params:{ userId : userId }});
        	};        	
        	//get available tasks as per worker skills,location etc
        	this.getAvailableTasks = function(workerId){        		
        		return $http.get('worker/tasks.ajax',{params:{workerId : workerId}});
        	}
        	
        	this.deleteTask = function(TaskId){
        		return $http.get('deleteTask.ajax',{params:{ TaskId : TaskId }});
        	};
        	this.updateTask = function(Task) {
                return $http.put('updateTask.ajax', 
                		Task);         		
        	};
        	//worker accepts the task
        	this.acceptTask = function(taskId,workerId) {
                return $http.get('task/accept.ajax',{params:{taskId: taskId,workerId: workerId}});                 		
        	};
        	
        	//worker rejects the task
        	this.rejectTask = function(taskId,workerId) {
                return $http.get('task/reject.ajax',{params:{taskId: taskId,workerId: workerId}});                 		
        	};
        	
        	//worker marks task completed
        	this.markTaskComplete = function(taskId,workerId) {
                return $http.get('task/completed.ajax',{params:{taskId: taskId,workerId: workerId}});                 		
        	};
        	
        	//worker submit task rating
        	this.submitRating = function(rating,taskId) {
        		alert(taskId);
                return $http.get('task/rating.ajax',{params:{rating:rating ,taskId: taskId}});                 		
        	};
         }]);           

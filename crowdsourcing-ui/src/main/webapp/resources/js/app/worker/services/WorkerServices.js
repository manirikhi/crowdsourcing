/**
 * worker services CRUD ajax calls
 */

  "use strict";
        
    app.service('workerService', ['$http', function ($http){       	
        	this.saveWorker = function(worker) {
                return $http.post('saveWorker.ajax', 
                		worker);         		
        	};
        	this.workerList = function(){
        		return $http.get('workers.ajax');
        	};
        	this.deleteWorker = function(workerId){
        		return $http.get('deleteworker.ajax',{params:{ workerId : workerId }});
        	};
        	this.updateWorker = function(worker) {
                return $http.put('updateworker.ajax', 
                		worker);         		
        	};
         }]);           

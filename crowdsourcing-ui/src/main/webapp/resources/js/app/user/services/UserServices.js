/**
 * User services CRUD ajax calls
 */

  "use strict";
        
    app.service('userService', ['$http', function ($http){       	
        	this.saveUser = function(user) {
                return $http.post('saveUser.ajax', 
                		user);         		
        	};
        	this.userList = function(){
        		return $http.get('users.ajax');
        	};
        	this.deleteUser = function(userId){
        		return $http.get('deleteUser.ajax',{params:{ userId : userId }});
        	};
        	this.updateUser = function(user) {
                return $http.put('updateUser.ajax', 
                		user);         		
        	};
        	
        	this.getCookieValue = function(cookieName){
        		
        		var name = cookieName + "=";
        	    var ca = document.cookie.split(';');
        	    alert("cookie size"+ ca.length);
        	    for(var i=0; i<ca.length; i++) {
        	        var c = ca[i];
        	        while (c.charAt(0)==' ') c = c.substring(1);
        	        alert("cookie"+ c);
        	        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
        	    }
        	    return "";
        	    
        	}
        	
         }]);           

angular.module("bucket.controller.goal", [])

.controller("GoalController", function($scope, $http, $location, $cookieStore, $stateParams, SharedInformationServices) {

	/**
	 * Load categories to show on select
	 */
	$scope.categories = SharedInformationServices.loadCategories();
	
	
	
	
	/**
	 * Search the goals from email user
	 */
	$scope.search = function(email){
		
		$http(
				{
					url: "http://localhost:8080/bucketlist/resources/goal", 
					method: "GET",
					params: {email: email}
				}
				
		).then(function(resp) {
			
			SharedInformationServices.setItem(resp.data);
			
			$cookieStore.put("emailSession", resp.data.email);
			
			$location.path("/listGoals");
		});

	}
	
	
	
	/**
	 * Save a new user and his goals
	 */
	$scope.save = function(user){
		
		var arrayComments = [];
		
		user.goals.comments.comentDate = new Date();
		arrayComments.push( user.goals.comments );
		user.goals.comments = arrayComments;
		
		
		var arrayGoals = [];
		arrayGoals.push(user.goals);
		user.goals = arrayGoals;
		
		$http.post("http://localhost:8080/bucketlist/resources/goal", user)
			.then(function(resp) {
				
				if (resp.status == 200) {
					
					SharedInformationServices.setItem(resp.data);
					$cookieStore.put("emailSession", user.email)
					
					$location.path("/listGoals");
				}
		});
	}
	
	
	
	
	
	/**
	 * Show information when make search
	 */
	$scope.showInformationByUser = function(){

		$scope.user = SharedInformationServices.getItem(); 
		$scope.emailSession = $cookieStore.get("emailSession");
		
		if($scope.user.length == 0){
			$scope.emailSession = $cookieStore.get("emailSession");
			getUserByUser( $scope.emailSession );

		}
	}
	
	
	var getUserByUser = function(email){
		
		$http(
				{
					url: "http://localhost:8080/bucketlist/resources/goal", 
					method: "GET",
					params: {email: email}
				}
				
		).then(function(resp) {
			$scope.user = resp.data;
			return resp.data;
			
		});
	}
	
	
	
	
	/**
	 * Send information to page where the user can insert new comments
	 */
	$scope.moveToAddComment = function(idGoal){

		$http.get("http://localhost:8080/bucketlist/resources/goal/goalById?idGoal=" +idGoal)
		.then(function(resp){

			SharedInformationServices.setItem(resp.data);


			$location.path("/comment");			

		});

	}
	
	
	
	
	$scope.loadComments = function() {
		$scope.goal = SharedInformationServices.getItem();
	}
	
	
	
	
	$scope.addPost = function(goal) {
		
		
		$scope.comments.comentDate = new Date();
		goal.comments.push($scope.comments);
		
		$http.post("http://localhost:8080/bucketlist/resources/goal/updatePost", goal)
		.then(function(resp){
			
			SharedInformationServices.setItem(resp.data);
					
			$scope.comments = "";
			
			$location.path("/comment");			
			
		});
	}
	
	
	
	
})
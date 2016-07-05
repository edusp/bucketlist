angular.module("bucket", [ 
	'ngCookies',
	'ui.router',
	
	'bucket.service.sharedProperty',
	'bucket.controller.goal'

]).config([ '$urlRouterProvider', '$stateProvider',	function($urlRouterProvider, $stateProvider) {

					$urlRouterProvider.otherwise("/dashboard");
					$stateProvider

					/** DASHBOARD */
					.state('dashboard', {
						abstract : true,
						views : {
							'dashboard' : {
								templateUrl : "app/views/dashboard.html"
							},
							
						},
					}).state('dashboard.home', {
						url : '/dashboard',
						templateUrl : 'app/views/home.html',
						controller: 'GoalController'
					})

					.state('goal', {
						abstract : true,
						views : {
							'dashboard' : {
								templateUrl :  "app/views/home.html"
							},
						},
					})
					.state('goal.new', {
						url : '/newgoal',
						templateUrl : 'app/views/goal/new-goal.html',
						controller : 'GoalController',
					})
					.state('goal.list', {
						url : '/listGoals',
						templateUrl : 'app/views/goal/list-goals.html',
						controller : 'GoalController',
					})
					.state('goal.isrtcoment', {
						url : '/comment',
						templateUrl : 'app/views/goal/goal-comment.html',
						controller : 'GoalController',
					})
					

				} ]);

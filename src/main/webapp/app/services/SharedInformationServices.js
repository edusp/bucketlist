angular.module('bucket.service.sharedProperty', [])

    .service('SharedInformationServices', function ($http) {
        var property = [];

        return {
            getItem: function () {
                return property;
            },
            
            setItem: function(value) {
            	property = value;
            },
            
            
            loadCategories: function () {
            	return allCategories = [
            	                       {"key":"TRAVEL", "value":"Travel"},
            	                       {"key":"NEW_SKILL", "value":"New Skill"},
            	                       {"key":"HELTH","value":"Helth"},
            	                       {"key":"SPORT", "value":"Sport"}
            	                       ]
                
            }
            
            
        };
    });
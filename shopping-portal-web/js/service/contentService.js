app.service("contentService",function($http){
	var URL = "http://localhost:8083/ContentController/";
	this.findByCategoryId = function(categoryId){
		return $http.get(URL+"findByCategoryId?categoryId="+categoryId);
	}
});
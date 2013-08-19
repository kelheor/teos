var UserAccountController = function ($scope, $http) {

    var serviceUrl = "/register";

    var user = {
        userAccountId: "",
        username: "",
        password: ""
    };

    $scope.showEdit = function () {
        $scope.editableVideo = angular.copy(user);
    };

    $scope.register = function() {
        $http.post(serviceUrl, $scope.user)
            .success(function (user) {
                var data =  angular.toJson(user);
                $scope.push(data);
            });
    };

};
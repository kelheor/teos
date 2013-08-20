var UserAccountController = function ($scope, $http) {

    var serviceUrl = "/register";

    var user = {
        userAccountId: "",
        username: "",
        password: ""
    };

    $scope.register = function() {

        user = $scope.user;
        user.userAccountId = null;

        $http({
            url: serviceUrl,
            method: "POST",
            params: {
                "userAccount": user
            }
        }).success(function(data, status, headers, config) {
                $scope.data = data;
            }).error(function(data, status, headers, config) {
                $scope.status = status;
        });


    };

};
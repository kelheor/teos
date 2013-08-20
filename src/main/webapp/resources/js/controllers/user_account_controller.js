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

        /*$http({
            method: 'POST',
            url: serviceUrl,
            data: $scope.user,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (user) {
                var data =  angular.toJson(user);
                $scope.push(data);
        });*/


        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: $scope.user,
            dataType: 'json',
            success: function() {
                alert("SUCCESS");
            }
        });

/*
        $http.post(serviceUrl, $scope.user)
            .success(function (user) {
                var data =  angular.toJson(user);
                $scope.push(data);
            });*/
    };

};
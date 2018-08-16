<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
</head>
<body>

<div ng-app="myApp" ng-controller="formCtrl">
    <form novalidate>
        First Name:<br>
        <input type="text" ng-model="user.firstName"><br>
        Last Name:<br>
        <input type="text" ng-model="user.lastName">
        <br><br>
        <button ng-click="reset()">RESET</button>
    </form>
    <p>form = {{user}}</p>
    <p>master = {{master}}</p>
</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('formCtrl', function($scope) {
        $scope.master = {firstName: "John", lastName: "Doe"};
        $scope.reset = function() {
            $scope.user = angular.copy($scope.master);
        };
        $scope.reset();
    });
</script>

</body>
</html>
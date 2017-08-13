'use strict';

App.controller('ModalController', ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {
    console.log('from modal');
    console.log($scope.category);
/*
    $scope.recurrence = recurrence;
    $scope.isRecurrent = (recurrence !== null);
    $scope.deleteType = 'this';
    $scope.ok = function () {
        if ($scope.isRecurrent) {
            $uibModalInstance.close($scope.deleteType);
        } else {
            $uibModalInstance.close('all');
        }
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
*/
}]);
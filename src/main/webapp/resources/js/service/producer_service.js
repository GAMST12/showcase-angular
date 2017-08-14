App.factory('Producer', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
        'http://localhost:8080/producer/:id',
        {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        }
    );
}]);

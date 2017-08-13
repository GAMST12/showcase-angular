App.factory('Category', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
        'http://localhost:8080/category/:id',
        {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        }
    );
}]);
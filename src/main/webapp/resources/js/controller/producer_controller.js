'use strict';

App.controller('ProducerController', ['$scope', 'Producer', function($scope, Producer) {
    var self = this;
    self.producer= new Producer();

    self.producers=[];


    self.fetchAllProducers = function(){
        self.producers = Producer.query();
        console.log(self.producers);
    };


    self.createProducer = function(){
        self.producer.$save(function(){
            self.fetchAllProducers();
        });
    };

    self.updateProducer = function(){
        self.producer.$update(function(){
            self.fetchAllProducers();
        });
    };

    self.deleteProducer = function(identity){
        var producer = Producer.get({id:identity}, function() {
            producer.$delete(function(){
                console.log('Deleting producer with id ', identity);
                self.fetchAllProducers();
            });
        });
    };

    self.fetchAllProducers();

    self.submit = function() {
        if(self.producer.id==null){
            console.log('Saving new producer', self.producer);
            self.createProducer();
        }else{
            console.log('Updating producer with id ', self.producer.id);
            self.updateProducer();
            console.log('Producer updated with id ', self.producer.id);
        }
        console.log(self.producer);
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        console.log(self.producer);
        for(var i = 0; i < self.producers.length; i++){
            if(self.producers[i].id === id) {
                self.producer = angular.copy(self.producers[i]);
                console.log(self.producer);
                break;
            }
        }
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.producer.id === id) {
            self.reset();
        }
        self.deleteProducer(id);
    };


    self.reset = function(){
        self.producer = new Producer();
        $scope.myForm.$setPristine();
    };



}]);
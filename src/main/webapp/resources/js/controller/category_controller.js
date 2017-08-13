'use strict';
 
App.controller('CategoryController', ['$scope', '$uibModal', 'Category', function($scope, $uibModal, Category) {
          var self = this;
          self.category= new Category();
           
          self.categories=[];
               
          self.fetchAllCategories = function(){
              self.categories = Category.query();
              console.log(self.categories);
          };
            
          self.createCategory = function(){
              self.category.$save(function(){
                  self.fetchAllCategories();
              });
          };
           
          self.updateCategory = function(){
              self.category.$update(function(){
                  self.fetchAllCategories();
              });
          };
 
         self.deleteCategory = function(identity){
             var category = Category.get({id:identity}, function() {
                  category.$delete(function(){
                      console.log('Deleting category with id ', identity);
                      self.fetchAllCategories();
                  });
             });
          };
 
          self.fetchAllCategories();
 
          self.submit = function() {
              if(self.category.id==null){
                  console.log('Saving New Category', self.category);
                  self.createCategory();
              }else{
                  console.log('Updating category with id ', self.category.id);
                  self.updateCategory();
                  console.log('Category updated with id ', self.category.id);
              }
              self.reset();
          };
               
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.categories.length; i++){
                  if(self.categories[i].id === id) {
                     self.category = angular.copy(self.categories[i]);
                     break;
                  }
              }
          };
               
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.category.id === id) {
                 self.reset();
              }
              self.deleteCategory(id);
          };
 
           
          self.reset = function(){
              self.category = new Category();
              $scope.myForm.$setPristine();
          };


        $scope.openModal = function ($scope) {
            console.log($scope);
            var modalInstance = $uibModal.open({
                templateUrl: '/modal.jsp',
                controller: 'ModalController',
/*
                resolve: {
                    recurrence: function () {
                        return row.recurrence;
                    }
                }
*/
            });
        };

      }]);
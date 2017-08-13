<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Categories</title>
    <style>
      .name.ng-valid {
          background-color: lightgreen;
      }
      .name.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .name.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="CategoryController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Category Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.category.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="cname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.category.name" id="cname" class="categoryname form-control input-sm" placeholder="Enter category name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="mcname">Main category name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.category.mainCategory.name" id="mcname" class="form-control input-sm" placeholder="Enter main category name"/>
                              </div>
                          </div>
                      </div>
 

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.category.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Categories </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr id={{c.id}} category={{c}} ng-repeat="c in ctrl.categories" ng-dblclick="openModal()" >
                              <td><span ng-bind="c.id"></span></td>
                              <td><span ng-bind="c.name"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="<c:url value='/resources/js/lib/angular.min.js' />"></script>
      <script src="<c:url value='/resources/js/lib/angular-resource.min.js' />"></script>
      <script src="<c:url value='/resources/js/lib/ui-bootstrap-custom-tpls-2.5.0.min.js' />"></script>
      <script src="<c:url value='/resources/js/app.js' />"></script>
      <script src="<c:url value='/resources/js/service/category_service.js' />"></script>
      <script src="<c:url value='/resources/js/controller/category_controller.js' />"></script>
      <script src="<c:url value='/resources/js/controller/modal_controller.js' />"></script>

  </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Producers</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ProducerController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Producer Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.producer.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="pname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.producer.name" id="pname" class="producername form-control input-sm" placeholder="Enter producer name" required ng-minlength="1"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="paddress">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.producer.address" id="paddress" class="produceraddress form-control input-sm" placeholder="Enter producer address" required ng-minlength="1"/>
                                  </select>
                              </div>
                          </div>
                      </div>
 

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.producer.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Producers </span></div>
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
                          <tr id={{p.id}} producer={{p}} ng-repeat="p in ctrl.producers" ng-dblclick="ctrl.edit(p.id)" >
                              <td><span ng-bind="p.id"></span></td>
                              <td><span ng-bind="p.name"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.remove(p.id)" class="btn btn-danger custom-width">Remove</button>
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
      <script src="<c:url value='/resources/js/service/producer_service.js' />"></script>
      <script src="<c:url value='/resources/js/controller/producer_controller.js' />"></script>

  </body>
</html>
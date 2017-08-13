<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<div class="modal-header">
    <h3 class="modal-title">Delete this item?</h3>
</div>
<div class="modal-body">
    Are you sure to delete this item?
    <div class="form-group" ng-show="isRecurrent">
        <label>
            <input type="radio" ng-model="deleteType" value="this">
            This occurence
        </label><br />
        <label>
            <input type="radio" ng-model="deleteType" value="future">
            Future occurences
        </label><br />
        <label>
            <input type="radio" ng-model="deleteType" value="all">
            All occurences
        </label><br />
    </div>
</div>
<div class="modal-footer">
    <button class="btn btn-danger" ng-click="ok()">Delete</button>
    <button class="btn btn-default" ng-click="cancel()">Cancel</button>
</div>
</body>
</html>

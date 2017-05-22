<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8">
  <title>Каталог товаров</title>

  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
  <link rel="stylesheet" href="/resources/core/index.css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <jsp:useBean id="category" scope="request" type="java.util.List<ua.com.pb.showcase.dao.entity.Category>"/>
  <jsp:useBean id="producer" scope="request" type="java.util.List<ua.com.pb.showcase.dao.entity.Producer>"/>



</head>
<body>
<h1>Каталог товаров</h1>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="sidebar">
        <!--Sidebar content-->
        <form id="filter-form" class="form-vertical">
          <div class="form-group">
            <div class="col-xs-9">
              <select id="select-category" class="categories form-control">
                <option id="all">Select category</option>
                <c:forEach items="${category}" var="category">
                  <option id="${category.id}" class="category">${category.name}</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-xs-9">
              <select id="select-producer" class="producers form-control">
                <option id="all">Select producer</option>
                <c:forEach items="${producer}" var="producer">
                  <option id="${producer.id}" class="producer">${producer.name}</option>
                </c:forEach>
              </select>
            </div>

            <div class="col-xs-9">
              <input type="number" class="form-control" id="price-from" name="price-from" placeholder="Price from" pattern="[0-9\/]*"  step="1.0"/>
            </div>
            <div class="col-xs-9">
              <input type="number" class="form-control" id="price-to" name="price-to" placeholder="Price to" pattern="[0-9\/]*"  step="1.0"/>
            </div>

            <div class="col-xs-9">
              <input type="checkbox" id="only-available">
              <label for="only-available">Only available</label>
            </div>

          </div>
        </form>

      </div>

      <div class="body">
        <!--Body content-->
        <table class="table table-hover">
          <thead>
          <tr>
            <th>Название</th>
            <th>Производитель</th>
            <th>Подкатегория</th>
            <th>Категория</th>
            <th>Описание</th>
            <th>Цена</th>
            <th>Наличие</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${product}" var="product">
            <tr id="${product.id}">
              <td id="name">${product.name}</td>
              <td id="producer-name">${product.producer.name}</td>
              <td id="main-category-name">${product.category.mainCategory.name}</td>
              <td id="category-name">${product.category.name}</td>
              <td id="description">${product.description}</td>
              <td id="price">${product.price}</td>
              <c:if test="${product.available}">
                <td id="available">Yes</td>
              </c:if>
              <c:if test="${!product.available}">
                <td id="available">No</td>
              </c:if>
            </tr>
          </c:forEach>

          </tbody>
        </table>

      </div>
    </div>
  </div>

<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/core/index.js"></script>

</body>
</html>

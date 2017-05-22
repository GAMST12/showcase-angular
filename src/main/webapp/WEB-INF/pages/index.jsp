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


<%--
  <jsp:useBean id="category" scope="request" type="java.util.List<ua.com.pb.showcase.dao.entity.Category>"/>
  <jsp:useBean id="main-category" scope="request" type="java.util.List<ua.com.pb.showcase.dao.entity.MainCategory>"/>
  <jsp:useBean id="producer" scope="request" type="java.util.List<ua.com.pb.showcase.dao.entity.Producer>"/>
--%>



</head>
<body>
<h1>Каталог товаров</h1>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="sidebar">
        <!--Sidebar content-->
        <p>Hello from sidebar</p>
        <select class="categories">
          <option class="default">Select category</option>
          <c:forEach items="${category}" var="category">
            <option class="${category.id}">${category.name}</option>
          </c:forEach>
        </select>
        <p></p>
        <select class="producers">
          <option class="default">Select producer</option>
          <c:forEach items="${producer}" var="producer">
            <option class="${producer.id}">${producer.name}</option>
          </c:forEach>
        </select>


      </div>
      <div class="body">
        <!--Body content-->
        <p>Hello from body</p>
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

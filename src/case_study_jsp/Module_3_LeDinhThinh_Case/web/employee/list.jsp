<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: ledinhthinh--%>
<%--  Date: 12/17/2020--%>
<%--  Time: 11:29--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Customer Management Application</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1>Customer Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/customer?action=create">Add New Customer</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Customer</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Birthday</th>--%>
<%--            <th>Gender</th>--%>
<%--            <th>Id card</th>--%>
<%--            <th>Phone</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>Address</th>--%>
<%--            <th>Customer type</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="customer" items="${listCus}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${customer.getId()}"/></td>--%>
<%--                <td><c:out value="${customer.getName()}"/></td>--%>
<%--                <td><c:out value="${customer.getBirthday()}"/></td>--%>
<%--                <td><c:out value="${customer.getGender()}"/></td>--%>
<%--                <td><c:out value="${customer.getId_card()}"/></td>--%>
<%--                <td><c:out value="${customer.getPhone()}"/></td>--%>
<%--                <td><c:out value="${customer.getEmail()}"/></td>--%>
<%--                <td><c:out value="${customer.getAddress()}"/></td>--%>
<%--                <td><c:out value="${customer.getCustomer_type_id()}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/customer?action=edit&id=${customer.getId()}">Edit</a>--%>
<%--                    <a href="/customer?action=delete&id=${customer.getId()}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<%--
  Created by IntelliJ IDEA.
  User: ledinhthinh
  Date: 12/17/2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>FURAMA RESORT</title>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<!-- Header -->
<div style="position: fixed;z-index: 9;margin: 0 ;width: 100%">
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <a class="navbar-brand" href="#">
            <img src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png" width="50" height="50"
                 class="d-inline-block align-top" alt="1">
        </a>
        <p style="font-size: 20px ;margin-right: 30px"> Lê Đình Thịnh</p>
    </nav>

    <%--Header-link--%>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <%--    <a class="navbar-brand" href="#">Navbar</a>--%>
        <%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--        <span class="navbar-toggler-icon"></span>--%>
        <%--    </button>--%>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/employee">Employee <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/customer">Customer <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Service <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Contract <span class="sr-only">(current)</span></a>
                </li>
                <%--            <li class="nav-item">--%>
                <%--                <a class="nav-link" href="#">Link</a>--%>
                <%--            </li>--%>
                <%--            <li class="nav-item dropdown">--%>
                <%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--                    Dropdown--%>
                <%--                </a>--%>
                <%--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--                    <a class="dropdown-item" href="#">Action</a>--%>
                <%--                    <a class="dropdown-item" href="#">Another action</a>--%>
                <%--                    <div class="dropdown-divider"></div>--%>
                <%--                    <a class="dropdown-item" href="#">Something else here</a>--%>
                <%--                </div>--%>
                <%--            </li>--%>
                <%--            <li class="nav-item">--%>
                <%--                <a class="nav-link disabled" href="#">Disabled</a>--%>
                <%--            </li>--%>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<%--Body--%>
<div style="position: relative;top: 135px">
    <%--Body-left--%>
    <div class="card" style="width: 18rem;position: absolute;float: left">
        <%--    <img class="card-img-top" src="https://bazantravel.com/cdn/medias/uploads/53/53114-furama-resort-da-nang-11.jpg" alt="Card image cap">--%>
        <div id="myCarousel" class="carousel slide border" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100"
                         src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/08_2019/furama-nha-hang.jpg"
                         alt="1">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/07_2019/phong-ngu-o-furama-resort-da-nang.jpg"
                         alt="2">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/07_2019/phong-ngu-o-furama-resort-da-nang_1.jpg"
                         alt="3">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/08_2019/furama-spa.jpg"
                         alt="3">
                </div>

            </div>
        </div>
        <div class="card-body">
            <h5 class="card-title">Furama Da Nang</h5>
            <p class="card-text">Furama Resort Đà Nẵng là resort 5 sao với những tiêu chuẩn dịch vụ tốt nhất cho du
                khách khi du lịch Đà Nẵng. Những căn phòng tiện nghi, hồ bơi rộng lớn, vị trí tuyệt vời nằm cạnh bãi
                biển và còn nhiều hơn nữa những điều thú vị chờ du khách phá.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <p><img src="https://www.flaticon.com/svg/static/icons/svg/968/968374.svg" width="20px">
                    103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
            </li>
            <li class="list-group-item">
                <p><img src="http://simpleicon.com/wp-content/uploads/phone-1.png" width="20px"> 84-236-3847 333/888</p>
            </li>
            <li class="list-group-item"><img src="https://cdn.icon-icons.com/icons2/2098/PNG/512/mail_icon_128820.png"
                                             width="20px">
                reservation@furamavietnam.com
            </li>
        </ul>
        <div class="card-body" style="text-align: left">
            <a href="https://www.facebook.com/furamaresort" class="card-link">
                <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Facebook_colored_svg_copy-128.png"
                     width="30px">
                /furamaresort
            </a><br><br>
            <a href="https://www.instagram.com/furama_resort_danang/" class="card-link">
                <img src="https://cdn3.iconfinder.com/data/icons/2018-social-media-logotypes/1000/2018_social_media_popular_app_logo_instagram-128.png"
                     width="30px">
                /furama_resort_danang
            </a>
            <br><br>
            <a href="https://www.tripadvisor.com.vn/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html"
               class="card-link">
                <img src="https://www.flaticon.com/premium-icon/icons/svg/2504/2504944.svg" width="30px">
                /furama_resort_danang
            </a>
        </div>
    </div>
    <%--Body right--%>
    <div class="card" style="width: 81%; margin-left: 18rem ; height: 115%">
        <div style="text-align: center;">
            <h1>Employee Management</h1>
        </div>
        <div align="center">
            <caption><h2>List of Employee</h2></caption>
            <table id="tableEmployee" class=" table table-sm table-striped table-bordered">
                <thead>
                <tr class="table-active">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Id card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Education Degree</th>
                    <th>Division</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${listEm}">
                    <tr>
                        <td><c:out value="${employee.getId()}"/></td>
                        <td><c:out value="${employee.getName()}"/></td>
                        <td><c:out value="${employee.getBirthday()}"/></td>
                        <td><c:out value="${employee.getId_card()}"/></td>
                        <td><c:out value="${employee.getSalary()}"/></td>
                        <td><c:out value="${employee.getPhone()}"/></td>
                        <td><c:out value="${employee.getEmail()}"/></td>
                        <td><c:out value="${employee.getAddress()}"/></td>
                        <td><c:out value="${employee.position.position_name}"/></td>
                        <td><c:out value="${employee.education_degree.education_degree_name}"/></td>
                        <td><c:out value="${employee.division.division_name}"/></td>
                        <td>
                            <a href="/employee?action=edit&id=${employee.getId()} "
                               class="btn btn-outline-info">Edit</a>
                            <button type="button" class="btn btn-outline-danger" data-toggle="modal"
                                    data-target="#exampleModal">
                                Delete
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to delete it?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a type="button" href="/employee?action=delete&id=${employee.getId()}"
                                               class="btn btn-outline-danger">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <a href="/employee?action=create" class="btn btn-outline-success btn-sm w-25 ">Add New Employee</a>
        </div>

    </div>
    <%--Footer--%>
    <div class="card" style="margin-top: 0%">
        <div class="card-body" style="text-align: center">
            ©copyright-ledinhthinh
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            dom: 'lrtip',
            lengthChange: false,
            pageLength: 5
        });
    });
</script>
</body>
</html>

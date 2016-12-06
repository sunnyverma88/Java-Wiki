<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:og="http://ogp.me/ns#"
      xmlns:fb="https://www.facebook.com/2008/fbml">

<head>
<meta name="google-site-verification" content="TywsHnOQa4RaVKwZfN664aKLi-DNwW6IajWej0_TpRI" />
<meta name="robots" content="FOLLOW,INDEX" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta property="og:image"  content="http://techieonthenet.com/images/Logo2.JPG" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="/css/bs/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/css/bs/css/bootstrap-theme.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script src="/css/bs/js/bootstrap.min.js"></script>
<script src="/js/ckeditor/ckeditor.js"></script>
<link rel="shortcut icon" href="/images/Logo2.JPG" >
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<!-- <style type="text/css">
   body { background: #EBF5FB; } /* Adding !important forces the browser to overwrite the default style applied by Bootstrap */
</style>  -->
<tilex:useAttribute name="current"/>
<body background="/images/bckground.jpeg">
<div class="container">

<div class="blog-header" align="center">
    <span style="font-family: 'Lucida Bright', Georgia, serif;">
        <span style="color:#008000; font-size:70px;">TECHIE ON THE NET</span></span>
        <p></p>        
 </div>
  
  
<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a  class="navbar-brand" href="/"><span style="font-family: 'Lucida Bright', Georgia, serif;">
        <span style="color:#008000; font-size:20px;">TECHIE ON THE NET</span></span></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active':''}"><a href='<spring:url value="/index"></spring:url>'>Home</a></li>
              <security:authorize access="hasRole('ROLE_ADMIN')">
              <li class="${current == 'users' ? 'active':''}"><a href='<spring:url value="/users"></spring:url>'>Users</a></li>
              <li class="${current == 'unapproved' ? 'active':''}"><a href='<spring:url value="/unapproved"></spring:url>'>Unapproved Blogs</a></li>
                </security:authorize>
             <li class="${current == 'contact' ? 'active':''}"><a href='<spring:url value="/contact"></spring:url>'>Contact</a></li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">TOPICS<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href='<spring:url value="/category/java/1"></spring:url>'>JAVA</a></li>
                <li><a href='<spring:url value="/category/jms/1"></spring:url>'>JMS</a></li>
                <li><a href='<spring:url value="/category/weblogic/1"></spring:url>'>WEBLOGIC</a></li>
                <li><a href='<spring:url value="/category/maven/1"></spring:url>'>MAVEN</a></li>
                <li><a href='<spring:url value="/category/others/1"></spring:url>'>OTHERS</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">SPRING</li>
                <li><a href='<spring:url value="/category/spring-mvc/1"></spring:url>'>SPRING MVC</a></li>
                <li><a href='<spring:url value="/category/spring-core/1"></spring:url>'>SPRING CORE</a></li>
              </ul>
            </li>
             </ul>
             <ul class="nav navbar-nav navbar-right">
             <security:authorize access="! isAuthenticated()">
              <li class="${current == 'register' ? 'active':''}"><a href='<spring:url value="/register"></spring:url>'>Register</a></li>
             <li class="${current == 'login' ? 'active':''}"><a href='<spring:url value="/login"></spring:url>'>Login</a></li>
             </security:authorize>
             <security:authorize access="isAuthenticated()">
             <li><a href='<spring:url value="/logout"></spring:url>'>Logout</a></li>
             </security:authorize>
             <security:authorize access="isAuthenticated()">
             <li class="${current == 'account' ? 'active':''}"><a href='<spring:url value="/account/1"></spring:url>'>My Account</a></li>
             </security:authorize>  
            </ul>
  
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      
 <div id="myCarousel" class="carousel slide carousel-fit" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active" align="center">
           <a href='<spring:url value="/"></spring:url>'><img class="first-slide" src="/images/Logo1.JPG" class="img-responsive" style="height: 150px;" alt="First slide"></a>
          <div class="container">
           <div class="carousel-caption">
            </div>
          </div>
        </div>
        <div class="item" >
           <a href='<spring:url value="/"></spring:url>'><img class="second-slide" src="/images/Logo2.JPG" class="img-responsive" style="height: 150px;" alt="Second slide"></a>
          <div class="container">
            <div class="carousel-caption">
               <security:authorize access="! isAuthenticated()">
      <span style="color:#008000; font-size:18px;font-family: 'Lucida Bright', Georgia, serif;">Being a Techie, Please contribute/share articles which can help professionals.</span>
      <p style="color:#008000; font-size:18px;font-family: 'Lucida Bright', Georgia, serif;"><a href='<spring:url value="/register"></spring:url>'>SignUp/Register to share.</a></p>
      </security:authorize>
       <security:authorize access="isAuthenticated()">
      <span style="color:#008000; font-size:20px;font-family: 'Lucida Bright', Georgia, serif;">A Blog to add interesting technical articles and share with society.</span>
       </security:authorize> 
       </div>
          </div>
        </div>
        <div class="item">
          <a href='<spring:url value="/login"></spring:url>'><img class="third-slide" src="/images/Logo2.JPG"  style="height: 150px;" alt="Third slide"></a>
          <div class="container">
            <div class="carousel-caption">
             <span style="font-family: 'Lucida Bright', Georgia, serif;">
        <span style="color:#008000; font-size:40px;">TECHIE ON THE NET</span></span>
        <p></p>        
         <span style="color:#008000; font-size:20px;">A Blog to add interesting technical articles and share with society.</span>
              </div>
          </div>
        </div>
      </div>
      <!-- <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a> -->
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel --> 
<p></p> 
<form:form action="/search" cssClass="form-horizontal" method="GET">
<div class="row">
  <div class="col-lg-12">
    <div class="input-group">
      <input type="text" name="searchString" class="form-control" placeholder="Search for...">
     
        <input type="submit"  value="Go" class="btn btn-info"/>

   </div><!-- /input-group -->
   </div><!-- /.col-lg-6 -->
   </div><!-- /.row -->
   </form:form> 
  <a href="https://github.com/sunnyverma88" class="btn btn-info pull-right" role="button" target="_blank">Fork Us on GITHUB
  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 
</a>
 <hr>


 
<tiles:insertAttribute name ="body"/>

<center>
<tiles:insertAttribute name="footer"/>
</center>
</div>

</body>
<script>
  (function() {
    var cx = '009108690475782254135:o3hfliqfcvc';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<gcse:search></gcse:search>



</html>
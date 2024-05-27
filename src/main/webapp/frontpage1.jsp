<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%-- <%@ page import="javax.portlet.PortletPreferences" %> --%>
    <%-- <%@ taglib uri="/WEB-INF/tld/liferay-portlet.tld" prefix="portlet" %>
    <portlet:defineObjects /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Online Art Gallery</title>
    <link rel="stylesheet" href="css/frontpage.css">
    	<script type="text/javascript" href="js/frontpage.js"></script>
     -<link rel="shortcut icon" href="favicon.ico">
    <style>

        h1{
             font-size: 2.1rem;
             line-height: 1.4;
             letter-spacing: 0.5rem;
             text-align: center;
             color: white;
             margin-top: 15px;
        }
        .maindiv{
                width: 70%;
                height: 400px;

                left: 50%;
                top: 50%;
                transform: translate(20%, 5%);
                background-image: url('https://i.guim.co.uk/img/media/24b0e2a9f495c9844826afdffe46cafbf2b168f1/0_228_3500_2101/master/3500.jpg?width=700&quality=85&auto=format&fit=max&s=698b616ed07970392754e4032f3d5722');
                background-size: 100% 100%;
                box-shadow: 1px 2px 10px 5px white;
        }
        @keyframes slider{
             0%{ background-image: url('data:image/jpeg;base64,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');}
             35%{background-image: ('https://media.gettyimages.com/id/1218961128/photo/artists-collection-in-a-art-museum.jpg?s=612x612&w=gi&k=20&c=fMLxdU1ShEpqWgPaP2n9C-hDKnOU315abBO70TjLNCs=');}
             75%{background-image: ('https://i.guim.co.uk/img/media/24b0e2a9f495c9844826afdffe46cafbf2b168f1/0_228_3500_2101/master/3500.jpg?width=700&quality=85&auto=format&fit=max&s=698b616ed07970392754e4032f3d5722');}
        }
    </Style>
</head>

<body style="background: linear-gradient(#D66D75,#E29587)">
    <h1>Online Art Gallery<h1>
    <div class="navbar">
      <a href="Sigin.jsp">SignIn</a>
      <a href="Login.jsp">Login</a>
      </div>
    <div class="maindiv">

    </div>

</body>
</html> 

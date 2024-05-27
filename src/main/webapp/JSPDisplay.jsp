<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Painting</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
<style type="text/css">
        .image-grid {
            display: grid;
            grid-template-columns: repeat(4, 1fr); /* Adjust the number of columns as needed */
            grid-gap: 10px;
        }
        .image-item {
            width: 200px; /* Adjust the width as needed */
            height: 200px; /* Adjust the height as needed */
        }
        .image-item img {
            max-width: 100%;
            max-height: 200%;
            object-fit: cover;
        }
    </style>
</head>
<body style="background: linear-gradient(#D66D75,#E29587)">
<h1 align="center" class="mt-5" style="color: white">Art Gallery</h1>
<div class="container mt-5">

   <div class="image-grid">
          <% for (byte[] imageBytes : (List<byte[]>) request.getAttribute("imageList")) { %>
              <div class="image-item">
                  <img src="data:image/jpeg;base64, <%= java.util.Base64.getEncoder().encodeToString(imageBytes) %>" alt="Image">
              </div>
          <% } %>
      </div>
</div>
</body>
</html>









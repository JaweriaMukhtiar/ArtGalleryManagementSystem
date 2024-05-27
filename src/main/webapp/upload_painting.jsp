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
.container{
border: 2px solid #fff;
background: #fff;
border-radius:5px;
width: 50%;
}
h1,label{
font-family: 'Roboto Slab', serif;
}
a{
font-size: 20px;
text-decoration: none;
color: #D66D75;
padding: 10px 10px ;
background-color:#fff;
border-radius:5px;
font-size: larger;
}
button[type=submit] {
background-color: #D66D75;
border-radius:5px;
font-size: larger;
}
</style>
</head>
<body style="background: linear-gradient(#D66D75,#E29587)">
<h1 align="center" class="mt-5" style="color: white">Enter Your Art</h1>
<div class="container mt-5">

 <form action="UploadPainting" method="post" enctype="multipart/form-data">
 <span style="color: #000; font-style: inherit; font-weight: bolder;"><%=(request.getAttribute("success") == null) ? "" : request.getAttribute("success")%></span>
          <div class="mb-3">
             <input type="text" placeholder="Title" name="title" required = "required" class="form__input" />
         </div>

       <div class="mb-3">
                    <input type="text" placeholder="Price" name="price" required = "required" class="form__input" />
        </div>

        <div class="mb-3">
        <select name="ptype" class="form__input" placeholder="ImageUrl" required = "required" >
                  <option value=" ">Please select</option>
                  <option>Abstract</option>
                  <option>Oil painting</option>
                  <option >Watercolour</option>
                  <option >Postercolour</option>
                  <option >Acrylic</option>
                      <option >Pencil sketch</option>
                      <option >Photograph</option>
                      <option >Sculpture</option>
                      <option >Installation</option>
                      <option >Vedio</option>
                      <option >music</option>
                      <option >Opera</option>
                      <option >Ballet</option>
                      <option >Dance</option>

            </select>
                </div>

 <div class="mb-3">
   <label for="exampleFormControlInput1" class="form-label">Picture</label>
   <input type="file"  id="exampleFormControlInput1" placeholder="Enter Pet Name" name="imageFile">
 </div>
 <div class="container text-center">
 <button type="submit" >Submit</button>
 </div>

 </form>
</div>
</body>
</html>
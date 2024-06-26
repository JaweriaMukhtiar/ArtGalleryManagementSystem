<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>Sign-Up</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Online Art Gallery</h2>
  <div class="form">
        <div id="signup">
          <h1>Sign Up for Free</h1>

          <form action="SignupServlet" method="post">

          <!-- <div class="top-row"> -->
            <div class="field-wrap">
              <label>
                Full Name<span class="req">*</span>
              </label>
              <input type="text" name="fullname" pattern="[A-Za-z.\s]{1,}"required autocomplete="off" title="Fullname should only contain letters. e.g. john" />
            </div>
            <div class="field-wrap">
            <label>
              Adhaar no<span class="req">*</span>
            </label>
            <input type="text" name="ArtistId" required autocomplete="off" title="ID pattern =  Adhaar no(10 digit)"/>
          </div>
            <div class="field-wrap">
              <label>
                State in (UK, USA, PAK, INDIA)<span class="req">*</span>
              </label>
              <input type="text" name="state"  pattern="[A-Za-z]{1,}" required autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label>
                City<span class="req">*</span>
              </label>
              <input type="text" name="city"  pattern="[A-Za-z]{1,}" required autocomplete="off" />
            </div>
            <div class="field-wrap">
              <label>
                Pincode<span class="req">*</span>
              </label>
              <input type="text" name="pincode" Pattern= "[0-9]{5}" required autocomplete="off" title="pincode should contain 6 digit " />
            </div>
             <div class="field-wrap">
                <label>
                    Address<span class="req">*</span>
                </label>
                <input type="text" name="address" pattern="[A-Za-z.\s]{1,}"required autocomplete="off" title="Fullname should only contain letters. e.g. john" />
             </div>
            <div class="field-wrap">
              <label>
                Mobile No:<span class="req">*</span>
              </label>
              <input type="text" name="mobileno" required autocomplete="off" title="enter valid mobile no." />
            </div>
            

            <!-- <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text"required autocomplete="off"/>
            </div> -->
            
          <!-- </div> -->
          

          <div class="field-wrap">
            <label>
              emaildemo@gmail.com<span class="req">*</span>
            </label>
            <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required autocomplete="off" title="Enter valid email"/>
          </div>

          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
                      <br><label>Artist</label><br>
                      <input type="radio" name='option' value="Artist"><br>

                       <input type="radio" name='option' value="Customer">
                       <label>Customer</label><br>
          </div>

          <button type="submit" class="button button-block"/>Get Started</button>

          </form>

        </div>

     <!-- tab-content -->

</div> 
<!-- /form -->
<%-- <% /* String passThis = request.getParameter("loginid");
        request.setAttribute("param1",passThis); */
        HttpSession httpSession = request.getSession();
        String id = request.getParameter("email");
        httpSession.setAttribute("login1",id );
        %> --%>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
 
<!doctype html>
<head><title>Welcome to profile page</title>
  <meta charset=utf-8>
  <meta name="viewport" content="width=device-width,intial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/jquery-2.1.4.min.js"></script>
  <script src="resources/js/bootstrap.min.css"></script>
</head>
<style>
</style>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar navbar-header">
        <a class="navbar-brand" href="#">HiBlog</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">friends</a></li>
        <li><a href="#">messages</a></li>
        <li><a href="#">Newsfeed</a></li>
      </ul>
    </div>
  </nav>
  <div class="container">
    <form role="form" method="post" action="blogpost">
      <textarea class="form-control" id="txtarea" name="txtarea" rows="6" placeholder="What are you thinking?"></textarea>
      <div class="row">
      <div class="col-xs-12">
        <button type="submit" class="btn btn-primary"><b>post</b>
        </button>
    </div>
  </div>
  </form>
</div>
<%@ page import com.example.model.update_post %>
<% /*PrintWriter out = response.getWriter(); 
   HttpSession session = request.getSession();
   //String email = session.getAttribute("email");
   String blog = session.getAttribute("blog");
   if(blog!=null){
   out.print(blog);
   }*/
   %>
</body>
</html>


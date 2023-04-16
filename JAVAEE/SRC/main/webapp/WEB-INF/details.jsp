<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>TPE LIBRAIRIE</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4 {font-family:"Lato", sans-serif}
.mySlides {display:none}
.w3-tag, .fa {cursor:pointer}
.w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
</style>
</head>
<body>

<!-- Links (sit on top) -->
<div class="w3-top ">
  <div class="justify-content-center w3-row w3-large w3-light-grey">
    <div class="w3-col s2">
      <a href="#" class="w3-button w3-block"></a>
    </div>
    <div class="w3-col s2">
      <a href="#" class="w3-button w3-block">Home</a>
    </div>
    <div class="w3-col s2">
      <a href="#plans" class="w3-button w3-block">Abonement</a>
    </div>
    <div class="w3-col s2">
      <a href="#about" class="w3-button w3-block">Nos documents</a>
    </div>
    <div class="w3-col s2">
      <a href="#contact" class="w3-button w3-block">Contact</a>
    </div>
    <div class="w3-col s2 w3-light-danger">
      <a href="/JAVA/login" class="w3-button w3-block">Admin</a>
    </div>
  </div>
</div>

<!-- Content -->
<div class="w3-content" style="margin-top:30px;">

  <div class="w3-panel">
    <h1><b>JS LIBRAIRIE</b></h1>
  </div>
  
  <div class="w3-row-padding" id="plans">
    <div class="w3-center w3-padding-64">
      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">DETAIL SUR LE DOCUMENT</span>
    </div>

    <div class="w3-third w3-margin-bottom" style="width:75%;margin-left:12%;height:50%;margin-top:10px;margin-bottom:80px">
      <ul class="w3-ul w3-border w3-center w3-hover-shadow">
        <li class="w3-dark-grey w3-xlarge w3-padding-32"><c:out value="${ document.getLibelle()}"/></li>
        <li class="w3-padding-16"></li>
        <li class="w3-padding-16"><b><c:out value="${ document.getDomaine()}"/></b></li>
        <li class="w3-padding-16"><b><c:out value="${ document.getDescription()}"/></b></li>
        <li class="w3-padding-16"><b><c:out value="${ document.getLibelle()}"/></b></li>
        <li class="w3-padding-16">
       
          
        </li>
        <li class="w3-light-grey w3-padding-24">
          <button class="w3-button w3-green w3-padding-large">Lire le document</button>
        </li>
      </ul>
    </div>
  </div>


  

  <!-- Contact -->

</div>

<!-- Footer -->

<footer class="w3-container w3-padding-32 w3-light-grey w3-center">
  <h4>Footer</h4>
  <a href="#" class="w3-button w3-black w3-margin"><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
  <div class="w3-xlarge w3-section">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
  <p> <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green"></a></p>
</footer>


<script>
// Slideshow
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demodots");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-white";
}
</script>

</body>
</html>
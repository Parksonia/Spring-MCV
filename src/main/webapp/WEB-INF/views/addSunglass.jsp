<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Product</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	
<!--===============================================================================================-->	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/icons/favicon.png">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition" style="animation-duration: 1500ms; opacity: 1;">
	
	<!-- Header -->
	<%@ include file="./inc/header.jsp" %>
	
	
	<!-- add form -->
	
	<form:form modelAttribute ="NewSunglass" method="post" enctype="multipart/form-data" action="./add?${_csrf.parameterName}=${_csrf.token}.jpg" class="bg0 p-t-75 p-b-85">
		<fieldset>
		<div class="container">
			<div class="row">
			
			
					
			<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
					
							<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tbody>
								<tr class="table_row">
											
										<form:input path="imgFile" id="imgFile" class="form-control" type="file" onchange="readURL(this);"  style="border:0px; display:none;"/>
										<img id="preview" />
									<!--<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> -->
									
										<script>
											function readURL(input) {
												if (input.files
														&& input.files[0]) {
													var reader = new FileReader();
													reader.onload = function(e) {
														document
																.getElementById('preview').src = e.target.result;
													};
													reader
															.readAsDataURL(input.files[0]);
												} else {
													document
															.getElementById('preview').src = "";
												}
											}
										</script>
									</tr>
							</tbody>
					</table>
					</div>				
							
							<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="flex-w flex-m m-r-20 m-tb-5">
							
							</div>
							<label for='imgFile' class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">UPLOAD<i class="fa-solid fa-upload fa-lg" style="color: #212529;"></i></label>
						</div>
					
						</div>
					</div>
		
	
				<!-- add item div -->		
				<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">
							Add item
						</h4>

						<div class="flex-w flex-t bor12 ">
							<div class="size-219 p-t-9">
								<span class="font--kr cl2"> 제품명 </span>
							</div>

							<div class="size-209">
								<form:input
									class="font--kr cl2 plh4 size-126 bor13 p-lr-20 m-r-10 m-tb-5"
									type="text" path="name"/>
							</div>
						</div>


						<div class="flex-w flex-t bor12 ">
							<div class="size-219 p-t-9">
								<span class="font--kr cl2"> 가격 </span>
							</div>

							<div class="size-209">
								<form:input
									class="font--kr cl2 plh4 size-126 bor13 p-lr-20 m-r-10 m-tb-5"
									type="text" path="price"/>
							</div>
						</div>
						
						<div class="flex-w flex-t bor12 ">
							<div class="size-219 p-t-9">
								<span class="font--kr cl2"> 색상 </span>
							</div>

							<div class="size-209 rs1-select2 rs2-select2 bg0 m-b-12 m-t-9">
								<form:select  class="form-control" path="color"  >
											<option value=""></option>
											<form:option value="white">White</form:option>
											<form:option value="black">Black</form:option>
											<form:option value="pink">Pink</form:option>
											<form:option value="grey">Grey</form:option>
											<form:option value="brown">Brown</form:option>
											<form:option value="gold">Gold</form:option>
											<form:option value="silver">Silver</form:option>	
										</form:select>
								</div>								
						</div>
						
						<div class="flex-w flex-t bor12 ">
							<div class="size-219 p-t-9">
								<span class="font--kr cl2"> 설명 </span>
							</div>

							<div class="size-209">
								<form:textarea
									class="font--kr-111 cl2 bor13 m-r-10 m-tb-5 plh3 size-120 p-lr-28 p-tb-5"
									type="text" path="description"/>
							</div>
						</div>

						
						
							<div class="flex-w flex-t bor12 ">
							<div class="size-219 p-t-9 p-tb-9">
								<span class="font--kr cl2"> 성별 </span>
							</div>

							<div class="size-209">
							<div class="custom-control custom-radio custom-control-inline p-t-9 p-tb-9">
                            <form:radiobutton class="custom-control-input" id="gender-1" path="gender" value="여자" />
                            <label class="custom-control-label" for="gender-1">여성</label>
                        </div>
                        
                       <div class="custom-control custom-radio custom-control-inline p-t-9 p-tb-9">
                            <form:radiobutton class="custom-control-input" id="gender-2" path="gender" value="남자" />
                            <label class="custom-control-label" for="gender-2">남성</label>
                        </div>
							
							
							</div>
						</div>
											
						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
							</div>
							<div class="size-209 p-t-1">
							
							</div>
						</div>
						<input class="flex-c-m stext-101 cl2  size-116 bg8 bor14 hov-btn3 p-lr-15 trans-04 pointer" type="submit" value="Submit"></input>
						<input 
				</div><!-- add item div end -->
			
			
			</div>
		</div>
		</fieldset>
		</form:form>

	<!-- footer -->
	<%@ include file="./inc/footer.jsp" %>

<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn" style="display: flex;">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

<!--===============================================================================================-->	
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>


</body>
</html>
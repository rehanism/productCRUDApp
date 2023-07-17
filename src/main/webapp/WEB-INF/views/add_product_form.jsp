<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

<style> 
body {
  background-image: url("C:/Users/MREHAN/Pictures/productapp.jpg");
  background-color: #c0c0c0;
}
</style>
</head>
<body>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-centre mb-3">Fill the product details</h1>

				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeholder="Enter the product name here">

					</div>
					<div class="form-group">
						<label for="name">Product Description</label>
						<textarea class="form-control" name="description" id="description"
							rows="5" placeholder="Enter the product description"></textarea>
					</div>
					<div class="form-group">
						<label for="name">Product Price</label> <input type="text"
							class="form-control" id="price" name="price"
							placeholder="Enter product price">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-danger">Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>
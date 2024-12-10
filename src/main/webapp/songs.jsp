<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Songs Page</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/songs" class="nav-link">Home</a>
				</li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Sidebar -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="${pageContext.request.contextPath}/songs" class="brand-link">
				<img
				src="${pageContext.request.contextPath}/resources/img/AdminLTELogo.png"
				alt="Logo" class="brand-image img-circle elevation-3"> <span
				class="brand-text font-weight-light">Songs App</span>
			</a>
		</aside>
		<!-- /.sidebar -->

		<!-- Content Wrapper -->
		<div class="content-wrapper">
			<!-- Content Header -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<jsp:include page="title.jsp" />
						</div>
					</div>
				</div>
			</section>

			<!-- Main Content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Songs List</h3>
									<div class="card-tools">
										<a href="<c:url value='/songs/createSong' />"
											class="btn btn-primary"> <i class="fas fa-plus"></i> Add
											New Song
										</a>
									</div>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="songsTable"
										class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>Title</th>
												<th>Author</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="song" items="${songs}">
												<tr>
													<td><c:out value="${song.id}" /></td>
													<td><c:out value="${song.title}" /></td>
													<td><c:out value="${song.author}" /></td>
													<td><a href="<c:url value='/song?id=${song.id}' />"
														class="btn btn-info btn-sm"> <i class="fas fa-eye"></i>
															Details
													</a> <a href="<c:url value='/songs/edit/${song.id}' />"
														class="btn btn-warning btn-sm"> <i class="fas fa-edit"></i>
															Edit
													</a> <a href="<c:url value='/songs/delete/${song.id}' />"
														class="btn btn-danger btn-sm"> <i class="fas fa-trash"></i>
															Delete
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->

		<!-- Footer -->
		<footer class="main-footer">
			<strong>Copyright &copy; 2024 <a href="#">Your Company</a>.
			</strong> All rights reserved.
		</footer>
	</div>

	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/adminlte.min.js"></script>

	<!-- DataTable Initialization -->
	<script>
		$(function() {
			$("#songsTable").DataTable({
				"responsive" : true,
				"lengthChange" : true,
				"autoWidth" : false
			});
		});
	</script>
</body>
</html>
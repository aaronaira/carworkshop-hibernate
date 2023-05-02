<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="patrials/header.jsp" %>
<div class="container form_login">
    <div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-md-4">
            <form method="post" action="/login">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">No compartiremos tu email con nadie más.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-custom">Enviar</button>
            </form>
        </div>
        </div>
</div>
<%@include file="patrials/footer.jsp" %>
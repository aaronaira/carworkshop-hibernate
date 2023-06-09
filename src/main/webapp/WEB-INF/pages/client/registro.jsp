<%@include file="../../patrials/header.jsp" %>
<%@include file="../../patrials/header-nav.jsp" %>
<div class="container">
    <div class="my-5 d-flex flex-column justify-content-center align-items-center" style="height: 100%;">
        <div class="mb-3 col-md-5">
            <form method="post" action="/registro">
                <div class="mb-3">
                    <label for="fname" class="form-label"><h5>Nombre</h5></label>
                    <input type="text" name="fname" class="form-control" id="fname">
                    <c:choose>
                        <c:when test="${errorsRegistro.containsKey('name_format_error')}">
                            <small class="text-danger">${errorsRegistro.get('name_format_error')}</small>
                        </c:when>
                    </c:choose>

                </div>
                <div class="mb-3">
                    <label for="lname" class="form-label"><h5>Apellidos</h5></label>
                    <input type="text" name="lname" class="form-control" id="lname">
                    <c:choose>
                        <c:when test="${errorsRegistro.containsKey('name_format_error')}">
                            <small class="text-danger">${errorsRegistro.get('name_format_error')}</small>
                        </c:when>
                    </c:choose>
                </div>
                <div class="mb-3">
                    <label for="dni" class="form-label"><h5>Dni</h5></label>
                    <input type="text" name="dni" class="form-control" id="dni">
                    <c:choose>
                        <c:when test="${errorsRegistro.containsKey('dni_format_error')}">
                            <small class="text-danger">${errorsRegistro.get('dni_format_error')}</small>
                        </c:when>
                    </c:choose>
                </div>
                <div class="mb-3">
                    <label><h5>Dirección</h5>
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <label for="address_street" class="form-label">Calle</label>
                            <input type="text" name="address_street" class="form-control" id="address_street">
                        </div>

                        <div class="col-sm-2">
                            <label for="address_street" class="form-label">Nº</label>
                            <input type="text" name="address_number" class="form-control" id="address_number">
                        </div>
                        <div class="col-sm-2">
                            <label for="address_floor" class="form-label">Piso</label>
                            <input type="text" name="address_floor" class="form-control" id="address_floor">
                        </div>
                        <div class="col-sm-2">
                            <label for="address_block" class="form-label">Bloque</label>
                            <input type="text" name="address_block" class="form-control" id="address_block">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label for="address_postalCode" class="form-label">Codigo Postal</label>
                            <input type="text" name="address_postalCode" class="form-control" id="address_postalCode">
                        </div>
                        <div class="col-sm-4">
                            <label for="address_city" class="form-label">Ciudad</label>
                            <input type="text" name="address_city" class="form-control" id="address_city">
                        </div>
                        <div class="col-sm-4">
                            <label for="address_province" class="form-label">Provincia</label>
                            <input type="text" name="address_province" class="form-control" id="address_province">
                        </div>
                        <c:choose>
                            <c:when test="${errorsRegistro.containsKey('name_format_error')}">
                                <small class="text-danger">${errorsRegistro.get('name_format_error')}</small>
                            </c:when>
                        </c:choose>
                    </div>
                    </label>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label"><h5>Email</h5></label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">No compartiremos tu email con nadie más.</div>
                    <c:choose>
                        <c:when test="${errorsRegistro.containsKey('email_format_error')}">
                            <small class="text-danger">${errorsRegistro.get('email_format_error')}</small>
                        </c:when>
                    </c:choose>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label"><h5>Contraseña</h5></label>
                    <input type="password" name="password" class="form-control" id="password">
                    <c:choose>
                        <c:when test="${errorsRegistro.containsKey('password_format_error')}">
                            <small class="text-danger">${errorsRegistro.get('password_format_error')}</small>
                        </c:when>
                        <c:when test="${errorsRegistro.containsKey('password_match')}">
                            <small class="text-danger">${errorsRegistro.get('password_match')}</small>
                        </c:when>
                    </c:choose>
                </div>
                <div class="mb-3">
                    <label for="passwordConfirm" class="form-label"><h5>Confirma contraseña</h5></label>
                    <input type="password" name="passwordConfirm" class="form-control" id="passwordConfirm">
                </div>
                <button type="submit" class="btn btn-custom">Enviar</button>
            </form>
        </div>
    </div>
</div>
<%@include file="../../patrials/footer.jsp" %>
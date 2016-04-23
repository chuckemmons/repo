<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="clearfix">
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div class="well well-sm">
        <form:form class="form-horizontal" method="post" action="login" modelAttribute="user">
          <fieldset>
            <legend class="text-center header">Sign in</legend>
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="email" placeholder="Email Address" class="form-control" />
                <div class="has-error">
                  <form:errors path="email" class="input-help"/>
                </div>
              </div>            
            </div>
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="password" placeholder="Password" class="form-control" />
                <div class="has-error">
                  <form:errors path="password" class="input-help"/>
                </div>
              </div>
            </div>
            
            <div class="form-group">
              <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">Send</button>
              </div>
            </div>
            
          </fieldset>
        </form:form>
      </div>
    </div>
  </div>
</div>
</div>